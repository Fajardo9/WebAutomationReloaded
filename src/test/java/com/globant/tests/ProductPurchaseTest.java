package com.globant.tests;

import com.globant.pages.*;
import com.globant.utils.dataProvider.DataProviders;
import com.globant.utils.test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductPurchaseTest extends BaseTest {

    public static final Logger log = LogManager.getLogger(ProductPurchaseTest.class);

    @Test(dataProvider = "persona", dataProviderClass = DataProviders.class)
    public void verifyPurchaseSuccessForOneItem(String name, String lastName, String postalCode) {
        log.info("Login into the home page");
        HomePage homePage = loginPage.returnHomeScreen(getDriver());
        assertTrue(homePage.isElementVisible(homePage.getBtnReactBurgerMenu(),4));
        log.info("Adding product to cart");
        homePage.setAddToCartButtonsList(homePage.getAddToCartButtons());
        homePage.setSelectedProduct(homePage.getListedProductsbyAddtoCartButtons().get(homePage.selectRandomProduct()));
        homePage.clickElement(homePage.getSelectedProduct());
        String productName = homePage.getSelectedProduct().getAttribute("id").replace("remove-", "");
        log.info("Verifying that the product was added to cart");
        assertEquals(homePage.getCartBtn().getText(),"1");
        homePage.clickElement(homePage.getCartBtn());
        CartPage cartPage = homePage.returnCartPage(driver);
        assertEquals(cartPage.getPageTitle().getText(),"Your Cart");
        assertEquals(cartPage.getSelectedProducts().size(), 1,
                "The number of items in the cart does not match with the quantity selected by the user");
        assertTrue(cartPage.getRemoveBtnList().get(0).getDomAttribute("id").contains(productName),
                "The product int the cart does not match with the product selected by user");
        log.info("Starting Checkout verification");
        cartPage.clickElement(cartPage.getCheckoutBtn());
        log.info("Entering user data");
        CheckoutYourInfoPage checkoutYourInfoPage = cartPage.returnCheckoutYourInfoPage(driver);
        assertEquals(checkoutYourInfoPage.getPageTitle().getText(),"Checkout: Your Information");
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getFirstNameField(),name);
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getLastNameField(),lastName);
        checkoutYourInfoPage.sendKeysToField(checkoutYourInfoPage.getPostalCodeField(),postalCode);
        checkoutYourInfoPage.clickElement(checkoutYourInfoPage.getContinueBtn());
        log.info("Verifying information in the overview page");
        CheckoutOverviewPage checkoutOverviewPage = checkoutYourInfoPage.returnCheckoutOverviewPage(getDriver());
        assertEquals(checkoutOverviewPage.getPageTitle().getText(),"Checkout: Overview");
        assertEquals(checkoutOverviewPage.getPurchasedItems().size(), 1,
                "The number of items in the cart does not match with the quantity selected by the user");
        assertTrue(checkoutOverviewPage.getPurchasedItems().get(0).getText().toLowerCase().replaceAll("[^a-z0-9 ]", " ")
                        .contains(productName.replaceAll("[^a-z0-9 ]", " ")),
                "The product int the cart does not match with the product selected by user");
        checkoutOverviewPage.clickElement(checkoutOverviewPage.getFinishBtn());
        log.info("Verifying successful purchase");
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.returnCheckoutCompletePage(driver);
        assertTrue(checkoutYourInfoPage.isElementVisible(checkoutCompletePage.getCheckoutDiv(),4));
        assertTrue(checkoutYourInfoPage.isElementVisible(checkoutCompletePage.getBackHomeBtn(),4));
        log.info("Successful purchase, returning to the home page");
        checkoutCompletePage.clickElement(checkoutCompletePage.getBackHomeBtn());
        homePage.isElementVisible(homePage.getAddToCartButtons().get(0),3);
        log.info("Successful return to the home page, Ending test");
    }

}