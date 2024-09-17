package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    private static final String PAGE_TITLE = "span.title[data-test='title']";
    private static final String SHOPPING_CART_BUTTON = "//*[@id=\"shopping_cart_container\"]";
    private static final String SELECTED_PRODUCTS = "inventory_item_name";
    private static final String CHECKOUT_BUTTON = "button[data-test='checkout']";
    private static final String CONTINUE_SHOPPING_BUTTON = "continue-shopping";
    private static final String REMOVE_FROM_CART_BUTTON = "cart_button";

    @FindBy(css = PAGE_TITLE)
    private WebElement pageTitle;
    @FindBy(xpath = SHOPPING_CART_BUTTON)
    private WebElement cartBtn;
    @FindBy(className = SELECTED_PRODUCTS)
    private List<WebElement> selectedProducts;
    @FindBy(css = CHECKOUT_BUTTON)
    private WebElement checkoutBtn;
    @FindBy(id = CONTINUE_SHOPPING_BUTTON)
    private WebElement continueShoppingBtn;
    @FindBy(className = REMOVE_FROM_CART_BUTTON)
    private List<WebElement> removeBtnList;
    private final By cartBtnLocator = By.xpath(SHOPPING_CART_BUTTON);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getCartBtn() {
        return cartBtn;
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

    public List<WebElement> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<WebElement> selectedProduct) {
        selectedProducts = selectedProduct;
    }

    public By getCartBtnLocator() {
        return cartBtnLocator;
    }

    public void clickAllElementsInList(@NotNull List<WebElement> elements) {
        for (WebElement element : elements) {
            clickElement(element);
        }
    }
}
