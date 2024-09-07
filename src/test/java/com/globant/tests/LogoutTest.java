package com.globant.tests;

import com.globant.pages.HomePage;
import com.globant.utils.dataProvider.DataProviders;
import com.globant.utils.test.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LogoutTest extends BaseTest {

    public static final Logger log = LoggerFactory.getLogger(LogoutTest.class);

    @Test(dataProvider = "persona", dataProviderClass = DataProviders.class)
    public void verifyPurchaseSuccessForOneItem(String name, String lastName, String postalCode) {
        log.info("Login into the home page");
        HomePage homePage = loginPage.returnHomeScreen(getDriver());
        log.info("Verifying that the user is in the home page");
        assertTrue(homePage.isElementVisible(homePage.getBtnReactBurgerMenu(),4));
        assertTrue(homePage.isElementVisible(homePage.getAddToCartButtons().get(0),3));
        homePage.clickElement(homePage.getBtnReactBurgerMenu());
        log.info("Logout button is clickable:{}",homePage.isElementVisible(homePage.getBtnLogout(),2));
        homePage.clickElement(homePage.getBtnLogout());
        log.info("Verifying log out");
        homePage.isElementVisible(loginPage.getLoginBtn(),3);
        log.info("Log out successful");
    }
}
