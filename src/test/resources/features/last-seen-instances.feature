Feature: Access to Last 1000 seen instances page
  Scenario: As an admin, I should see latest 1000 instances since startup
    Given the Dashboard Page from "/dashboard" by waiting no more than 10 seconds
    When clicking on the last seen menu not waiting no more than 10 seconds
    Then I will get the last seen page with the title "Eureka - Last N events"
    And the last seen page should have a header with "System Status" And Dashboard should also have a header with "DS Replicas"