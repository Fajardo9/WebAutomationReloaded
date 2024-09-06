package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    private static final String CHECKOUT_COMPLETE_DIV = "checkout_complete_container";
    private static final String BACK_HOME_BUTTON = "back-to-products";

    @FindBy(className = CHECKOUT_COMPLETE_DIV)
    private WebElement checkoutDiv;
    @FindBy(id = BACK_HOME_BUTTON)
    private WebElement backHomeBtn;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCheckoutDiv() {
        return checkoutDiv;
    }

    public WebElement getBackHomeBtn() {
        return backHomeBtn;
    }
}
