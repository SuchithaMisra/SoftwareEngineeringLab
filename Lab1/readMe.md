To run this lab, navigate to Lab1 folder:

1. 
Building Maven project:
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

2. 
mvn package

3. 
Running App.java:
mvn exec:java -Dexec.mainClass="com.mycompany.app.App"

Running TestMe.java
mvn exec:java -Dexec.mainClass="com.mycompany.app.TestMe"