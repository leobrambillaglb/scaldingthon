scaldingthon
============

A quick start with Scalding.

I wanted to take a look at Scalding and Scala in general of course. Then I decided to do my own Scalding Hackathon to see how hard it is and if I will like it.

Tools
=====
I'll try to enumerate here the tools I came across during this hackathon.

SBT : http://www.scala-sbt.org/
The build tool for Scala. I've been told about this and also is the first thing you see when going into the "Getting started" section at Scalding site.

Installed SBT following manual installation at http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html
(Despite the sbt script comes with scalding project when you clone it from gitHub)

Sent to run "./sbt update" in my laptop (oldie Thinkpad X61 4Gb Ram, Core 2 Duo) took 14 minutes!!! Jeez, beware of the clock! --> My bad, my home folder is encrypted and its performance really sucks.
Note: there were some Warnings about deprecated Scalding functions like 'readAtSubmitter'.

The first attempt to run "./sbt test" failed due a missing 'javac'. Is way out of scope of this hackaton but let's say that to solve this I ran the following command: 
'sudo update-alternatives --install /usr/bin/javac javac /opt/java/jdk1.7.0_51/bin/javac 100'

The test phase went Ok, it took 5 minutes to run. 

SBT Eclipse plugin : https://github.com/typesafehub/sbteclipse

Tried to use this Eclipse's plugin but I couldn't. Filed the following issue to see if someone can help me, https://github.com/typesafehub/sbteclipse/issues/198

----

Mix of Tutorials
================

Followed the next tutorials to see how things work
@ Sharethrough
Page : http://engineering.sharethrough.com/blog/2013/10/17/getting-started-with-scalding-and-amazon-elastic-mapreduce/
Code: https://github.com/sharethrough/scalding-emr-tutorial




