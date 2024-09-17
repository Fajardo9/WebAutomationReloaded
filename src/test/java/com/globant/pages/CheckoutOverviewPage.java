package com.globant.pages;

import com.globant.utils.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    private static final String PAGE_TITLE = "span.title[data-test='title']";
    private static final String FINISH_BUTTON = "finish";
    private static final String PURCHASED_ITEMS = "inventory_item_name";


    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = PAGE_TITLE)
    private WebElement pageTitle;
    @FindBy(id = FINISH_BUTTON)
    private WebElement finishBtn;
    @FindBy(className = PURCHASED_ITEMS)
    private List<WebElement> purchasedItems;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getFinishBtn() {
        return finishBtn;
    }

    public List<WebElement> getPurchasedItems() {
        return purchasedItems;
    }
}
