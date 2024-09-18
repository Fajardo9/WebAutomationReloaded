package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInfoPage extends BasePage {

    private static final String PAGE_TITLE = "span.title[data-test='title']";
    private static final String FIRST_NAME_FIELD = "input[placeholder='First Name']";
    private static final String LAST_NAME_FIELD = "input[placeholder='Last Name']";
    private static final String POSTAL_CODE_FIELD = "//*[@id=\"postal-code\"]";
    private static final String SUMMIT_BUTTON = "submit-button";

    @FindBy(css = PAGE_TITLE)
    private WebElement pageTitle;
    @FindBy(css = FIRST_NAME_FIELD)
    private WebElement firstNameField;
    @FindBy(css = LAST_NAME_FIELD)
    private WebElement lastNameField;
    @FindBy(xpath = POSTAL_CODE_FIELD)
    private WebElement postalCodeField;
    @FindBy(className = SUMMIT_BUTTON)
    private WebElement continueBtn;


    public WebElement getPageTitle() {
        return pageTitle;
    }

    public CheckoutYourInfoPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getPostalCodeField() {
        return postalCodeField;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }

}
