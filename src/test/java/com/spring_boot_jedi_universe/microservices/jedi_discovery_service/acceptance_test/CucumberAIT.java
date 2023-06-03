package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// This class is used to run the Cucumber acceptance tests
@RunWith(Cucumber.class)

// This annotation is used to specify options for Cucumber, such as the location of the feature files
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty", "html:target/html-cucumber-report" },

// This option is used to specify the package(s) containing the step definitions for the Cucumber tests
        glue = {"com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test"})
public class CucumberAIT {
}