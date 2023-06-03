Feature: Access to Dashboard
  Scenario: As an admin, I should access to dashboard page
    Given the dashboard endpoint as "/dashboard"
    When I have get the endpoint with an HTTP Request waiting not up to 10 seconds
    Then I will get the dashboard Page with the title "Eureka"
    And Dashboard page should have a header with "System Status", a header with "DS Replicas", a header with "Instances currently registered with Eureka"
