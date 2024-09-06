package com.globant.utils.test;


import com.globant.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    @Parameters({"url"})
    private void setupDriver(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public LoginPage returnLoginScreen() {
        return new LoginPage(driver);
    }

    public HomePage returnHomeScreen() {
        return new HomePage(driver);
    }

    public CartPage returnCartPage() {
        return new CartPage(driver);
    }

    public CheckoutYourInfoPage returnCheckoutYourInfoPage() {
        return new CheckoutYourInfoPage(driver);
    }

    public CheckoutOverviewPage returnCheckoutOverviewPage() {
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutCompletePage returnCheckoutCompletePage() {
        return new CheckoutCompletePage(driver);
    }

}
