package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.HomePage;
import com.globant.utils.dataProvider.DataProviders;
import com.globant.utils.page.BasePage;
import com.globant.utils.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RemoveProductsFromCartTest extends BaseTest {

    public static final Logger log = LoggerFactory.getLogger(RemoveProductsFromCartTest.class);

    @Test(dataProvider = "persona", dataProviderClass = DataProviders.class)
    public void selectAndRemoveThreeProductsFromCart(String name, String lastName, String postalCode){
        int quantity = 3;
        log.info("Login into the home page");
        HomePage homePage = loginPage.returnHomeScreen(getDriver());
        assertTrue(homePage.isElementVisible(homePage.getBtnReactBurgerMenu(),4));
        homePage.setAddToCartButtonsList(BasePage.listElementsById(homePage.getAddToCartButtons()));
        log.info("The number of products available are: {}", homePage.getListedProductsbyAddtoCartButtons().size());
        Collections.shuffle(homePage.getListedProductsbyAddtoCartButtons());
        for (int i = 0; i <= quantity-1; i++ ){
            homePage.clickElement(homePage.getListedProductsbyAddtoCartButtons().get(i));
        }
        assertEquals(homePage.getCartBtn().getText(), "3");
        log.info("The three products are successfully added to the cart");
        homePage.clickElement(homePage.getCartBtn());
        CartPage cartPage = homePage.returnCartPage(driver);
        log.info("The quantity of products currently in the shopping car is: {}", cartPage.getSelectedProducts().size());
        cartPage.setSelectedProducts(BasePage.listElementsById(cartPage.getRemoveBtnList()));
        log.info("Removing items from the cart");
        for(WebElement productToRemove: cartPage.getSelectedProducts()){
            cartPage.clickElement(productToRemove);
        }
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
