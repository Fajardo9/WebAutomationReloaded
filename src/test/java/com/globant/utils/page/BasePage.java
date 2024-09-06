package com.globant.utils.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    private static WebDriver driver;
    public static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public WebDriverWait setUpWait(long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }


    public boolean isElementVisible(WebElement element){
        try{
            setUpWait(4).until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            log.info("TimeoutException:{}",e.getMessage());
            return false;
        }
        return element.isDisplayed();
    }

    public boolean isElementSelected(WebElement element){
        try{
            setUpWait(4).until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException e){
            log.info("TimeoutException:{}",e.getMessage());
            return false;
        }
        return element.isSelected();
    }
    public void clickElement(WebElement element){
        element.click();
    }

    public void sendKeysToField(WebElement element, String keysToSend){
        try {
            setUpWait(4).until(ExpectedConditions.elementToBeClickable(element));
        }catch (TimeoutException | NotFoundException e){
            log.info("Element wasn't found{}", e.getMessage());
        }
        element.sendKeys(keysToSend);
    }

    public List<WebElement> listElementsById(List<WebElement> elementsList) {
        List<WebElement> elementList = new ArrayList<>();
        List<String> buttonIdentifier;
        buttonIdentifier = elementsList.stream().map(p -> p.getAttribute("id")).toList();
        for (String productName : buttonIdentifier) {
            elementList.add(getDriver().findElement(By.id(productName)));
        }
        return elementList;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
