package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    private static final String PAGE_TITLE = "span.title[data-test='title']";
    private static final String CHECKOUT_BUTTON = "button[data-test='checkout']";
    private static final String CONTINUE_SHOPPING_BUTTON = "continue-shopping";
    private static final String REMOVE_FROM_CART_BUTTON = "cart_button";

    @FindBy(css = PAGE_TITLE)
    private WebElement pageTitle;
    @FindBy(css = CHECKOUT_BUTTON)
    private WebElement checkoutBtn;
    @FindBy(id = CONTINUE_SHOPPING_BUTTON)
    private WebElement continueShoppingBtn;
    @FindBy(className = REMOVE_FROM_CART_BUTTON)
    private List<WebElement> removeBtnList;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }

    public WebElement getContinueShoppingBtn() {
        return continueShoppingBtn;
    }

    public List<WebElement> getRemoveBtnList() {
        return removeBtnList;
    }
}
