package com.example.hooks;

import com.example.config.Config;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * TestHooks class handles setup and teardown operations for Cucumber tests.
 * It integrates Spring with Cucumber and manages browser resources provided by the Config class.
 */
@CucumberContextConfiguration // Ensures proper configuration for Cucumber-Spring integration
@ContextConfiguration(classes = {Config.class}) // Loads the Spring configuration class
public class TestHooks {

    // Inject the Browser bean from Spring configuration
    @Autowired
    private Browser browser;

    // Inject the BrowserContext bean from Spring configuration
    @Autowired
    private BrowserContext context;

    // Inject the Page bean from Spring configuration
    @Autowired
    private Page page;

    /**
     * This method is executed after every Cucumber scenario.
     * It performs teardown activities, such as capturing screenshots if the scenario fails.
     *
     * @param scenario The current Cucumber scenario being executed
     */
    @After
    public void tearDown(Scenario scenario) {
        // Check if the scenario has failed
        if (scenario.isFailed()) {
            // Capture a screenshot of the failed state and attach it to the Cucumber report
            scenario.attach(
                    page.screenshot(new Page.ScreenshotOptions().setFullPage(true)), // Capture a full-page screenshot
                    "image/png", // Define the attachment type as a PNG image
                    "failed.png" // Set the attachment name
            );
        }
    }
}
