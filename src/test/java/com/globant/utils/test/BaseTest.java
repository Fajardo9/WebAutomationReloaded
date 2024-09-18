package com.globant.utils.test;


import com.globant.pages.*;
import com.globant.utils.page.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    @Parameters({"url"})
    public void setupDriver(String url) {
        WebDriverManager.chromedriver().setup();
        System.setProperty("suite", "E2E");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    @BeforeTest(dependsOnMethods = "setupDriver")
    @Parameters({"user","password"})
    public void setUp(String user, String password) {
        loginPage = BasePage.returnLoginScreen(driver);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.getLoginBtn()));
        loginPage.sendKeysToField(loginPage.getUsernameField(), user);
        loginPage.sendKeysToField(loginPage.getPasswordField(), password);
        loginPage.clickElement(loginPage.getLoginBtn());
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
