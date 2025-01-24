# Test Automation Excercise

## Overview

This project is a test automation framework using Java, Spring Boot, Playwright, and Cucumber. It is designed to automate web application testing with a focus on maintainability and scalability.

## Features

- **Java**: The primary programming language used for the test scripts.
- **Spring Boot**: Manages the dependency injection and configuration.
- **Playwright**: Provides browser automation capabilities.
- **Cucumber**: Supports behavior-driven development (BDD) with Gherkin syntax.
- **TestNG**: Used as the test runner.
- **Java Util Logger**: Logging framework for better traceability.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK)**: Version 17 or later.
- **Maven**: For managing project dependencies and building the project.
- **IntelliJ IDEA**: Recommended IDE for development.
- **Git**: Version control system.

## Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/kaleem850-qa/pw-cucumber-spring.git
    cd pw-cucumber-spring
    ```

2. **Install dependencies**:
    ```sh
    mvn clean install
    ```

3. **Configure the properties**:
    - Open the `src/test/resources/application.properties` file.
    - Set the `url` and `browser` properties as needed:
      ```properties
      url=https://automationintesting.online
      browser=chromium
      ```

## Running Tests

1. **Run tests using Maven**:
    ```sh
    mvn test
    ```

2. **Run tests using TestNG**:
    - Open the `TestRunner` class in your IDE.
    - Right-click and select `Run 'TestRunner'`.

## Logging

The project uses Java Util Logger for logging. Logs are generated for key actions and events, providing better traceability and debugging capabilities.

## Reports
This project generates default HTML cucumber reports under the `target/reports`