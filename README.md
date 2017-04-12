# brkr
### Barker - a Twitter-like web app

Barker is built using Spring framework's Spring MVC module. The application embeds a Jetty HTTP server & servlet container, and so can be built into a standalone runnable JAR and run as a web application.

### Usage:
1. Build using maven
    * `mvn clean package`
1. Run using maven exec plugin or java
    * `mvn exec:java -Dexec.mainClass=brkr.webserver.EmbeddedJetty`
    * `java -jar brkr-1.0-SNAPSHOT-jar-with-dependencies.jar`
