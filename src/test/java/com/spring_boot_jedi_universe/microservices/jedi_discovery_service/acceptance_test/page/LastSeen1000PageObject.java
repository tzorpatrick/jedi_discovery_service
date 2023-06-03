package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
public class LastSeen1000PageObject {

    // XPaths for the Last Seen page elements
    private final static String LAST_NEWLY_REGISTERED_TAB_XPATH = "/html/body/div/div[2]/ul/li[2]/a";
    private final static String HEADER1_XPATH = "//html/body/div/h1[1]";
    private final static String HEADER2_XPATH = "//html/body/div/h1[2]";

    // WebElements for the Last Seen page headers
    @FindBy(xpath = HEADER1_XPATH)
    private WebElement firstHeader;
    @FindBy(xpath = HEADER2_XPATH)
    private WebElement secondHeader;

    // WebDriver instance
    private final WebDriver webDriver;

    public LastSeen1000PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    // ExpectedCondition for checking if the Last Seen page has loaded
    public static ExpectedCondition<WebElement> isPageLoad() {
        return ExpectedConditions.presenceOfElementLocated(By.xpath(LAST_NEWLY_REGISTERED_TAB_XPATH));
    }

}