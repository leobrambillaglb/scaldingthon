package me.scaldingthon.sharethrough

import com.twitter.scalding._
import java.net.{URISyntaxException, URI, URLDecoder}

class LocationCountingJob(args: Args) extends Job(args) {
  TextLine(args("input"))
    .filter('line) { // Remove all unnecessary data
	  line: String =>
	    line.matches(".*GET /impression\\S*pid="+args("placementId")+".*")
  	}
    .map('line -> 'ploc) { // Extract page location from request
      line: String =>
        val pattern = """GET /impression\S*ploc=(\S*)&""".r
        pattern.findFirstMatchIn(line) match {
          case Some(matchData) => matchData.subgroups(0)
          case None => "http://www.emptyOrNoLocation.com/"
        }
    }
    .map('ploc -> 'hostname) { // Extract hostname from page location
      ploc: String =>
        try {
          val hostname = Option(new URI(URLDecoder.decode(ploc, "UTF-8")).getHost())
          hostname.getOrElse("www.emptyOrNoLocation.com")
        } catch {
          case _: URISyntaxException => "www.badLocation.com"
        }
    }
    .groupBy('hostname) { // Grouping by hostname, summing 
      _.size 
    } 
    .filter('hostname, 'size) { // Beating the impression floor
      fields: (String, Int) => 
        val (hostname, size) = fields
        hostname match {
          case "www.emptyOrNoLocation.com" => true
          case "www.badLocation.com" => true
          case _ => size >= args("impressionFloor").toInt
        }
    }
    .write(Tsv(args("output")))
}