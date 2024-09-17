package com.globant.utils.page;

import com.globant.pages.*;
import io.selenium.utils.ElementContextLocatorFactory;
import io.selenium.utils.FieldContextDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePage {

    private static WebDriver driver;
    public static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new FieldContextDecorator(new ElementContextLocatorFactory(
                driver, Duration.ofSeconds(20), Arrays.asList(StaleElementReferenceException.class,
                ElementNotInteractableException.class))), this);
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public WebDriverWait setUpWait(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    public boolean isElementVisible(WebElement element, long seconds) {
        try {
            setUpWait(seconds).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException | NullPointerException e) {
            log.info("TimeoutException:{}", e.getMessage());
            return false;
        }
        return element.isDisplayed();
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendKeysToField(WebElement element, String keysToSend) {
        try {
            setUpWait(4).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | NotFoundException e) {
            log.info("Element wasn't found{}", e.getMessage());
        }
        element.sendKeys(keysToSend);
    }

    public static List<WebElement> listElementsById(List<WebElement> elementsList) {
        List<WebElement> elementList = new ArrayList<>();
        List<String> buttonIdentifier;
        buttonIdentifier = elementsList.stream().map(p -> p.getAttribute("id")).toList();
        for (String productName : buttonIdentifier) {
            elementList.add(getDriver().findElement(By.id(productName)));
        }
        return elementList;
    }
    public void clickElements(List<WebElement> elements, int quantity) {
        if (elements.size() >= quantity) {
            for (int i = 0; i <= quantity - 1; i++) {
                clickElement(elements.get(i));
            }
        }else{
            log.info("Select a valid quantity there are only {} elements", elements.size());
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static LoginPage returnLoginScreen(WebDriver driver) {
        return new LoginPage(driver);
    }

    public HomePage returnHomeScreen(WebDriver driver) {
        return new HomePage(driver);
    }

    public CartPage returnCartPage(WebDriver driver) {
        return new CartPage(driver);
    }

    public CheckoutYourInfoPage returnCheckoutYourInfoPage(WebDriver driver) {
        return new CheckoutYourInfoPage(driver);
    }

    public CheckoutOverviewPage returnCheckoutOverviewPage() {
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutCompletePage returnCheckoutCompletePage(WebDriver driver) {
        return new CheckoutCompletePage(driver);
    }

}
