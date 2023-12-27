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
         can open this link to observe the browserstack 
  https://automate.browserstack.com/dashboard/v2/public-build/a2ZEQXVsMnFKSnZTNVNiYjhNb2duMjhTZmNHUnJzSnZZMGdDSm5wWFFrQ2UwMDdXL3I0T3RLNjcxak9CYnZKcGF5Z1NZN0pTL3pqeHhiVnFSdkFiUlE9PS0tWUVxQ1haUnh1ZUpWbjM3THJOTExMZz09--29795a7f3370a408e56b316c1593a4009f535baa
   
![image](https://github.com/Mohamed-Ishak/WebApp/assets/81917166/1d2464af-742c-47c8-aee1-60a5b98d66d0)
![image](https://github.com/Mohamed-Ishak/WebApp/assets/81917166/a32140fa-0043-4883-b0f1-15bbe79b3eb0)
