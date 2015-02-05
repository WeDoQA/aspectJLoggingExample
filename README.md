AspectJLoggingExample
=====================

The project is created to present an example of logging with aspect oriented programming which could be useful in automated testing.

The project is implemented like an AspectJ Project. The Eclipse IDE needs to include the AspectJ plug-in to get the correct results.

Selenium Framework
  - selenium 2.44.0 is included into the project
  
A simple test case is created which inserts the word “wedoqa” into Google and compares the top result with the name of the company. However this time the accent is on the PageUtils.java class and LoggerAspect.aj aspect. The goal is to every single wait, click and sendChar event be logged by the aspects.