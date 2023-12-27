# WebApp
Automation Practice Web Application

Environment Setup
I have used different Technologies in building the Web framework and Install the following on my local machine
1) Java JDK 11
2) Apache Maven
3) Eclipse IDE
                                                     ================================

I have created Th web framework based on Page Object Model To separate the Pages from The Test Cases
and I used The BDD concepts and apply it using Cucumber tool to write the Scenarios in English to be clear for non technical Persons
So I define the Project into Parts:
  1- Pages 
  2- tests
  3- runner 
  4- features 
  5- resources

  So I have Base page class that all pages can inheret it's Constructor to receive the driver and make it live 

  We can Execute the Project from the TestRunner Class 

  For the Parallel Execution I have Provide 2 ways in the project 
     1 ) The testng.xml file 
         Running this file as TestNG Suite
     2 ) The BrowserStack platform  
         Make some configurations like 
         define a browserstack.yml file and add browserstack dependency and plugin in the Pom.xml file
         
  
   
