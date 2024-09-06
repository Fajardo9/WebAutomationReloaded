package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final String USERNAME_FIELD = "[placeholder='Username']";
    private static final String PASSWORD_FIELD = "password";
    private static final String LOGIN_BUTTON = "submit-button";
    @FindBy(css = USERNAME_FIELD)
    private WebElement usernameField;
    @FindBy(id = PASSWORD_FIELD)
    private WebElement passwordField;
    @FindBy(className = LOGIN_BUTTON)
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }
}
