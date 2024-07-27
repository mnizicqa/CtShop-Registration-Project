
# CtShop Registration Project

This is a project which I have done to solidify my Selenium testing framework skill. The goal of the project was to automate [CtShop](https://ctshop.rs) website. Tests are written using Selenium framework and Java programming language. As a testing framework I have used TestNG, and tests are organized on the basis of POM (Page Object Model). There are both positive and negative test cases. Principle of data driven testing is used, and test data is fed into tests by using JSON file. Just change the data as per your liking, 

Selenium version 4.20.0 was used for testing. As a reporting tool I have used Allure. Project build tool that I have used to streamline project file organization is Maven. Main browser used for running tests was Google Chrome version 127. Test also works on Microsoft Edge and Mozilla Firefox browsers.

All the dependencies are placed im **pom.xml** file. Just click on the option Load Maven changes when you first open the project, and the dependencies should be loaded and indexed.

In the **Runner.xml** there are two xml files linked for running tests. You can choose in which order do you want to run tests, by changing the order of the files in the **Runner.xml** file. Also, two xml files for running tests are added. There should be 12 tests in total, some using JSON data, and other with already inserted data. 

To use Allure reporting, open the terminal and enter command **allure serve** and the HTML file with report will be generated. 
