package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test;

// This interface defines the steps that will be used for the acceptance test
// The purpose here is to reuse this steps with not only cucumber library
public interface EurekaDashboardStep  {

    // Sets the endpoint URL for the Eureka Dashboard
    public void gotDashboardEndpoint(String dashboardEndpoint) ;

    // Loads the Dashboard page and waits for it to load completely
    public void givenTheDashboardPage(String dashboardUrl, int waitTimeInSecond);

    // Clicks on the Last Seen menu and waits for the Last Seen page to load
    public void whenClickingOnLastSeenMenu(int timeoutInSeconds);

    // Accesses the Dashboard page and waits for it to load completely
    public void accessToDashboardPage(int timeoutInSeconds) ;

    // Verifies that the Last Seen page has the expected title
    public void verifyLastSeen1000PageTitle(String pageTitle) ;

    // Verifies that the Last Seen page has the expected headers
    public void verifyHeaderOneAndTwoForLastSeenPage(String header1, String header2);

    // Verifies that the Dashboard page has the expected title
    public void verifyDashBoardPageTitle(String title);

    // Verifies that the Dashboard page has the expected headers
    public void verifyDashboardPageHeader(String section1, String section2, String section3);
}