package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.HomePage;
import com.globant.utils.page.BasePage;
import com.globant.utils.test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveProductsFromCartTest extends BaseTest {

    public static final Logger log = LogManager.getLogger(RemoveProductsFromCartTest.class);

    @Test
    public void selectAndRemoveThreeProductsFromCart(){
        int quantity = 3;
        log.info("Login into the home page");
        HomePage homePage = loginPage.returnHomeScreen(getDriver());
        assertTrue(homePage.isElementVisible(homePage.getBtnReactBurgerMenu(),4));
        homePage.setAddToCartButtonsList(BasePage.listElementsById(homePage.getAddToCartButtons()));
        log.info("The number of products available are: {}", homePage.getListedProductsbyAddtoCartButtons().size());
        Collections.shuffle(homePage.getListedProductsbyAddtoCartButtons());
        homePage.clickElements(homePage.getListedProductsbyAddtoCartButtons(),quantity);
        assertEquals(homePage.getCartBtn().getText(), "3");
        log.info("The three products are successfully added to the cart");
        homePage.clickElement(homePage.getCartBtn());
        CartPage cartPage = homePage.returnCartPage(driver);
        log.info("The quantity of products currently in the shopping car is: {}", cartPage.getSelectedProducts().size());
        cartPage.setSelectedProducts(BasePage.listElementsById(cartPage.getRemoveBtnList()));
        log.info("Removing items from the cart");
        cartPage.clickAllElementsInList(cartPage.getSelectedProducts());
        wait.until(ExpectedConditions.textToBe(cartPage.getCartBtnLocator(), ""));
        assertEquals(cartPage.getCartBtn().getText(), "");
        assertEquals(cartPage.getRemoveBtnList().size(),0);
        log.info("The three products were removed from the cart successfully");
        log.info("Returning to the home page");
        cartPage.clickElement(cartPage.getContinueShoppingBtn());
        homePage.isElementVisible(homePage.getAddToCartButtons().get(0),3);
        log.info("Successful return to the home page, Ending test");
    }
}
