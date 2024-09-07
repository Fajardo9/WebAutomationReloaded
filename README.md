# WebAutomationReloaded
Web automation exercise to imporve practices when implementing the page object model(POM) design patter and gaining a deeper understanding of the web automation process using Selenium Webdriver and TestNG to create the three test cases.
- Page: [saucedemo](https://www.saucedemo.com/)
.
## Requires
- JDK 11 or higher (JDK 17 is already configured inside the `POM.xml` file)
- Maven
### Environment used
- Windows 11
- Chrome v 128.0.66
## Installation Instructions
1. Clone this repository into your local machine
2. Navigate to the root directory where was cloned the repository (e.g. *C:\users\documents\WebAutomationReloaded*)
3. Run the following command:
   `mvn install`
### Execution Instructions
1. Execute one of the suites inside the root directory of the project `src/test/resources`
- To execute the log out test: suiteLogOutTest.xml
- To execute the purchase of one item: suiteProductPurchaseTest.xml
- To execute the removal of products from the shopping cart test: suiteRemoveProductsFromTheCartTest
2. Verify the results of the test selected and its corresponding logs

# License 
-This project is distribuited under the e.g. "globant" license
