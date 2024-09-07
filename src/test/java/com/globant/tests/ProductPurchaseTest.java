package com.globant.tests;

import com.globant.pages.*;
import com.globant.utils.dataProvider.DataProviders;
import com.globant.utils.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPurchaseTest extends BaseTest {

    @Test(dataProvider = "persona", dataProviderClass = DataProviders.class,dependsOnMethods = "setUp")
    public void verifyPurchaseSuccessForOneItem(String name, String lastName, String postalCode) {
        log.info("Login into the home page");
        HomePage homePage = loginPage.returnHomeScreen(getDriver());
        Assert.assertTrue(homePage.isElementVisible(homePage.getBtnReactBurgerMenu(),4));
        log.info("Adding product to cart");
        homePage.setAddToCartButtonsList(homePage.getAddToCartButtons());
        WebElement selectedProduct = homePage.getListOfAddToCartButtons().get(homePage.selectRandomProduct());
        homePage.clickElement(selectedProduct);
        log.info("Verifying that the product was added to cart");
        Assert.assertEquals(homePage.getCartBtn().getText(),"1");
        homePage.clickElement(homePage.getCartBtn());
        CartPage cartPage = homePage.returnCartPage();
        Assert.assertEquals(cartPage.getPageTitle().getText(),"Your Cart");
        log.info("Starting Checkout verification");
        cartPage.clickElement(cartPage.getCheckoutBtn());
        log.info("Entering user data");
        CheckoutYourInfoPage checkoutYourInfoPage = cartPage.returnCheckoutYourInfoPage(driver);
        Assert.assertEquals(checkoutYourInfoPage.getPageTitle().getText(),"Checkout: Your Information");
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getFirstNameField(),name);
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getLastNameField(),lastName);
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getPostalCodeField(),postalCode);
        checkoutYourInfoPage.clickElement(checkoutYourInfoPage.getContinueBtn());
        log.info("Verifying overview page");
        CheckoutOverviewPage checkoutOverviewPage = checkoutYourInfoPage.returnCheckoutOverviewPage();
        Assert.assertEquals(checkoutOverviewPage.getPageTitle().getText(),"Checkout: Overview");
        checkoutOverviewPage.clickElement(checkoutOverviewPage.getFinishBtn());
        log.info("Verifying successful purchase");
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.returnCheckoutCompletePage(driver);
        Assert.assertTrue(checkoutYourInfoPage.isElementVisible(checkoutCompletePage.getCheckoutDiv(),4));
        Assert.assertTrue(checkoutYourInfoPage.isElementVisible(checkoutCompletePage.getBackHomeBtn(),4));

    }

    //@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}