package com.spring_boot_jedi_universe.microservices.jedi_discovery_service.acceptance_test.page;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

// This class is used as a configuration class for Cucumber and Spring Boot
@CucumberContextConfiguration

// This annotation is used to start a Spring Boot server with a random port for testing
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

// This annotation is used to auto-configure a mock MVC environment for testing
@AutoConfigureMockMvc
public class CucumberSpringConfiguration {
}