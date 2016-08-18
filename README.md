Jetty Gradle Microservice
=====

This is a simple quick template for a <a href="https://github.com/benkauffman/java-gradle-jetty-webservice">Jetty Gradle Microservice</a>

Gradle Build
-----
Windows run `.\gradlew ` followed by the gradle command <br>
Unix run `./gradlew ` followed by the gradle command

`clean build` will package the source into <b>/build/libs/</b> which can be deployed through a web server
`jettyRun` will spin up a jetty webserver that you can hit locally 

You can run them together with `.\gradlew clean build jettyRun`

Microservice
------------
The default template endpoint is <i>http://localhost:8080/api/test/hello</i>
The resource code can be referenced and modified <a href="https://github.com/benkauffman/java-gradle-jetty-webservice/blob/master/src/main/java/com/krashidbuilt/jetty/resource/TemplateResource.java">here</a>
