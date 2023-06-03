# Jedi Discovery Service

The Jedi Discovery Service is a microservice that provides service discovery and registration capabilities using Eureka. The service is built using Java and Spring Boot.

## Features

- Service discovery and registration using Eureka
- Acceptance testing using Cucumber
- Functional testing using Selenium

## Installation

To install and run the Jedi Discovery Service, follow these steps:

1. Clone the repository:
   git clone https://github.com/tzorpatrick/jedi_discovery_service.git

2. Navigate to the project directory:
`cd jedi_discovery_service`

3. Build the project:
   `./mvnw clean install`

4. Please make sure you install selenuim web driver in your environment and add it in the OS PATH Variable
5. Run the service:
  `java -jar target/jedi_discovery_service.jar`
5. Access to the dashboard in  your browser using this URL:
`http://localhost:2222'

## Functional Testing

The functional tests use Selenium to test the web interface of the service. The tests cover the following scenarios:

- Access to Dashboard using the web interface
- Access to Last 1000 seen instances page using the web interface

Our test are automated using:
- Cucumber to automate acceptance test.
- Selenuim to emulate the navigation on the registry service web interface


## Author

This microservice was created by NGANSOP PATRICK TZORNEU.

## Contributions

Contributions to this project are welcome. Please fork the repository and submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Value Proposition

The Jedi Discovery Service provides a lightweight and scalable solution for service discovery and registration using Eureka. The use of Cucumber for acceptance testing and Selenium for functional testing ensures that the service is reliable and functions as expected.