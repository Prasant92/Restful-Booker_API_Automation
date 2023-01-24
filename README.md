# Restful-Booker_API_Automation

Table of contents
-----------------------------------
Scope of framework/functionalities
Tools & Technologies used
Setup
Execution



Scope of framework/functionalities
----------------------------------
Purely based on the OOPs concepts, BDD framework, Page Object model pattern, Maven based tests, Common api interaction methods and Commonly used test utility classes

Tools & Technologies used
-------------------------
Cucumber-JVM
TestNG
Maven plugins
Maven as build tool
Jackson
Extent Spark reporting feature
Rest Assured framework
Java
Gherkin

Setup
-----
In order to utilise this project you need to have the following installed locally:

Java 8, Maven, Rest Assured dependencies, Cucumber JVM dependencies, TestNG dependencies. Plugins that should be there in pom.xml are compiler, surefire, failsafe.
Clone the project from github repo, import the same into any of the IDEs.. Make sure Java is setup in the system. You can check whether java is installed in your 
system or not using java -version command. Similar check needs to be done for maven as well using maven --version command. 

There are multiple scripts based out of different scenarios where execution is based on different response parameters like response code, time, content type,
response body. 

Execution
---------
To execute the tests you need to first run
mvn clean command to clean the target file, then run mvn test to execute all the test scripts. 

To execute the tests based on feature files, every feature file has been tagged with a meaningful tagname, use
mvn test -Dcucumber.filter.tags="tagname" in case to execute single feature file
mvn test -Dcucumber.filter.tags="tagname1 or tagname2 or..." in case to execute multiple feature files
