package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class DashboardPageObject {

    // XPaths for the Dashboard page elements
    private  final static String HEADER1_XPATH = "//html/body/div/h1[1]";
    private  final static String HEADER2_XPATH = "//html/body/div/h1[2]";
    private  final static String HEADER3_XPATH = "//html/body/div/h1[3]";
    private  final static String LAST_N_MENU_XPATH = "//a[@href='/dashboard/lastn']";

    // WebElements for the Dashboard page headers and Last Seen menu
    @FindBy(xpath = HEADER1_XPATH)
    private WebElement firstHeader;
    @FindBy(xpath = HEADER2_XPATH)
    private WebElement secondHeader;
    @FindBy(xpath = HEADER3_XPATH)
    private WebElement thirdHeader;
    @FindBy(xpath = LAST_N_MENU_XPATH)
    private WebElement last1000SeenMenu;

    // WebDriver instance
    private final WebDriver webDriver;

    public DashboardPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // Clicks on the Last Seen menu and waits for the Last Seen page to load
    public LastSeen1000PageObject clickOnLastSeen100Menu(int timeoutInSeconds) {
        last1000SeenMenu.click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(LastSeen1000PageObject.isPageLoad());
        return new LastSeen1000PageObject(webDriver);
    }

    // ExpectedCondition for checking if the Dashboard page has loaded
    public static ExpectedCondition<WebElement> isPageLoad(){
        return ExpectedConditions.presenceOfElementLocated(By.xpath(HEADER1_XPATH));
    }
}