package com.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestRunner is the main entry point for executing Cucumber tests using TestNG.
 * It specifies the configuration for Cucumber tests, such as the feature file locations,
 * step definitions, and report generation settings.
 */
@CucumberOptions(
        // Path to the feature files
        features = "./src/test/resources/features/accessibility.feature",

        // Packages containing step definitions and hooks
        glue = {"com.example.stepdefs", "com.example.hooks"},

        // Plugins to format and generate test reports
        plugin = {
                "pretty", // Prints the Gherkin steps in a readable format on the console
                "html:target/reports/index.html" // Generates an HTML report in the specified location
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    /**
     * TestRunner extends AbstractTestNGCucumberTests to integrate Cucumber with TestNG.
     * This allows for running Cucumber tests using TestNG as the test framework.
     *
     * Key Features:
     * - Supports parallel execution of scenarios.
     * - Automatically detects and runs feature files and step definitions based on the configuration.
     */
}
