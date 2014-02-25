resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.4.0")

// Allow us to create fat JARs with all of our dependencies [taken from ShareThrough tutorial]
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.9.2")