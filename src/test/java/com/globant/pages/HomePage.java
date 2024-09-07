package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HomePage extends BasePage {

    private List<WebElement> addToCartButtonsList;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "react-burger-menu-btn")
    private WebElement btnReactBurgerMenu;

    @FindBy(css = "a#logout_sidebar_link")
    private WebElement btnLogout;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
    private WebElement cart;

    @FindBy(css = "button[data-test='checkout']")
    private WebElement checkoutBtn;

    private WebElement selectedProduct;
    public WebElement getBtnReactBurgerMenu() {
        return btnReactBurgerMenu;
    }

    public WebElement getBtnLogout() {
        return btnLogout;
    }

    public List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public WebElement getCartBtn() {
        return cart;
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }

    public List<WebElement> getListOfAddToCartButtons() {
        return addToCartButtonsList;
    }

    public void setAddToCartButtonsList(List<WebElement> addToCartButtonsList) {
        this.addToCartButtonsList = addToCartButtonsList;
    }

    public WebElement getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(WebElement selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public int selectRandomProduct(){
        isElementVisible(getAddToCartButtons().get(0),4);
        return ThreadLocalRandom.current().nextInt(getAddToCartButtons().size());
    }

}
