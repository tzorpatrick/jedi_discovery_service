package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test;

import com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test.page.DashboardPageObject;
import com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test.page.LastSeen1000PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EurekaDashboardCucumberStep implements EurekaDashboardStep {

    // Fields
    @LocalServerPort
    private Integer port;
    private WebDriver webDriver = null;
    private String baseUrl;
    private String endPointUrl;
    private DashboardPageObject dashboardPageObject;
    private LastSeen1000PageObject lastSeen1000Page;

    // Methods

    @Before
    public void beforeEachScenario() {
        this.setUpWebDriver();
    }

    @After
    public void afterEachScenario() throws InterruptedException {
        // Quit the web driver
        Thread thread = new Thread(() -> {
            if (webDriver != null) {
                webDriver.quit();
            }
        });
        thread.start();
        thread.join();
    }

    public void setUpWebDriver() {
        // Set up the web driver
        this.baseUrl = "http://localhost:" + port;
        webDriver = new FirefoxDriver();
    }

    public void quitWebDriver() {
        // Quit the web driver
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Given("the dashboard endpoint as {string}")
    public void gotDashboardEndpoint(String dashboardEndpoint) {
        // Set the endpoint URL
        this.endPointUrl = this.baseUrl + dashboardEndpoint;
    }

    @Given("the Dashboard Page from {string} by waiting no more than {int} seconds")
    public void givenTheDashboardPage(String dashboardUrl, int timeoutInSeconds) {
        // Set the endpoint URL and load the Dashboard page
        this.endPointUrl = this.baseUrl + dashboardUrl;
        webDriver.get(this.endPointUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(DashboardPageObject.isPageLoad());
        this.dashboardPageObject = new DashboardPageObject(webDriver);
    }

    @When("clicking on the last seen menu not waiting no more than {int} seconds")
    public void whenClickingOnLastSeenMenu(int timeoutInSeconds) {
        // Click on the Last Seen menu and wait for the Last Seen page to load
        this.lastSeen1000Page = dashboardPageObject.clickOnLastSeen100Menu(timeoutInSeconds);
    }

    @When("I have get the endpoint with an HTTP Request waiting not up to {int} seconds")
    public void accessToDashboardPage(int timeoutInSeconds) {
        // Access the Dashboard page and wait for it to load
        webDriver.get(this.endPointUrl);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(DashboardPageObject.isPageLoad());
        this.dashboardPageObject = new DashboardPageObject(webDriver);
    }

    @Then("I will get the last seen page with the title {string}")
    public void verifyLastSeen1000PageTitle(String pageTitle) {
        // Verify that the Last Seen page has the expected title
        assertThat(webDriver.getTitle()).isEqualTo(pageTitle);
    }

    @And("the last seen page should have a header with {string} And Dashboard should also have a header with {string}")
    public void verifyHeaderOneAndTwoForLastSeenPage(String header1, String header2) {
        // Verify that the Last Seen page has the expected headers
        assertThat(lastSeen1000Page.getFirstHeader().getText().equals(header1) &&
                lastSeen1000Page.getSecondHeader().getText().equals(header2));
    }

    @Then("I will get the dashboard Page with the title {string}")
    public void verifyDashBoardPageTitle(String title) {
        // Verify that the Dashboard page has the expected title
        assertThat(webDriver.getTitle().equals(title));
    }

    @And("Dashboard page should have a header with {string}, a header with {string}, a header with {string}")
    public void verifyDashboardPageHeader(String section1, String section2, String section3) {
        // Verify that the Dashboard page has the expected headers
        assertThat(this.dashboardPageObject.getFirstHeader().getText().equals(section1) &&
                this.dashboardPageObject.getSecondHeader().getText().equals(section2) &&
                this.dashboardPageObject.getThirdHeader().getText().equals(section3));
    }
}