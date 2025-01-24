package com.example.stepdefs;

import com.deque.html.axecore.playwright.AxeBuilder;
import com.deque.html.axecore.results.AxeResults;
import com.example.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * StepDefs class contains step definitions for Cucumber feature files.
 * It interacts with the HomePage and its components to perform actions and validations.
 */
public class StepDefs {

    @Autowired
    HomePage homePage; // Injects the HomePage component

    Scenario scenario; // Holds the current Cucumber scenario
    Logger LOG = Logger.getLogger(StepDefs.class.getName()); // Logger for debugging and logging messages

    /**
     * This method is executed before each scenario to set up the Scenario object for logging or debugging purposes.
     *
     * @param scenario The current Cucumber scenario
     */
    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }

    /**
     * Navigates the user to the booking page (homepage).
     */
    @Given("user is on the booking page")
    public void userIsOnTheBookingPage() {
        homePage.goTo(); // Navigates to the URL defined in HomePage
        LOG.info("Successfully navigated to the URL");
    }

    /**
     * Verifies that the user sees the expected success message on the page.
     *
     * @param successMessage The expected success message
     */
    @Then("user sees the success message {string}")
    public void userSeesTheSuccessMessage(String successMessage) {
        assertThat(homePage.root).containsText(successMessage); // Asserts that the root element contains the success message
    }

    /**
     * Fills in the Contact Us form with valid details provided in the DataTable.
     *
     * @param dataTable A DataTable containing the user inputs for the Contact Us form
     */
    @When("user enters below valid details on contact us form")
    public void userEntersBelowValidDetailsOnContactUsForm(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            // Extract data for each form field
            String name = row.get("name");
            String email = row.get("email");
            String phone = row.get("phone");
            String subject = row.get("subject");
            String description = row.get("description");

            // Fill the Contact Us form
            homePage.contactUsComponent.contactUs(name, email, phone, subject, description);
        }
    }

    /**
     * Fills in the Contact Us form and validates the error or success message for each scenario.
     *
     * @param dataTable A DataTable containing user inputs and expected messages
     */
    @When("user enters below valid details on contact us form and assert the relevant message")
    public void userEntersBelowValidDetailsOnContactUsFormAndAssertTheRelevantMessage(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            // Extract data and replace "<empty>" with an empty string
            String name = "<empty>".equals(row.get("name")) ? "" : row.get("name");
            String email = "<empty>".equals(row.get("email")) ? "" : row.get("email");
            String phone = "<empty>".equals(row.get("phone")) ? "" : row.get("phone");
            String subject = "<empty>".equals(row.get("subject")) ? "" : row.get("subject");
            String description = "<empty>".equals(row.get("description")) ? "" : row.get("description");
            String message = row.get("message");

            // Fill the form and validate the message
            homePage.contactUsComponent.contactUs(name, email, phone, subject, description);
            assertThat(homePage.form).containsText(message);
        }
    }

    /**
     * Fills in the Book Room form with valid details provided in the DataTable.
     *
     * @param dataTable A DataTable containing user inputs for the Book Room form
     */
    @When("user enters below valid details on book room form")
    public void userEntersBelowValidDetailsOnBookRoomForm(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            // Extract data for each form field
            String firstName = row.get("firstName");
            String lastName = row.get("lastName");
            String email = row.get("email");
            String phone = row.get("phone");

            // Fill the Book Room form
            homePage.bookRoomComponent.bookRoom(firstName, lastName, email, phone);
        }
    }

    /**
     * Verifies that the user sees the expected message on the page.
     *
     * @param message The expected message
     */
    @Then("user sees the message {string}")
    public void userSeesTheMessage(String message) {
        assertThat(homePage.root).containsText(message); // Asserts that the root element contains the message
    }

    /**
     * Fills in the Book Room form and validates the error or success message for each scenario.
     *
     * @param dataTable A DataTable containing user inputs and expected messages
     */
    @When("user enters below valid details on book room form and assert the relevant messages")
    public void userEntersBelowValidDetailsOnBookRoomFormAndAssertTheRelevantMessages(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : data) {
            // Extract data and replace "<empty>" with an empty string
            String firstName = "<empty>".equals(row.get("firstName")) ? "" : row.get("firstName");
            String lastName = "<empty>".equals(row.get("lastName")) ? "" : row.get("lastName");
            String email = "<empty>".equals(row.get("email")) ? "" : row.get("email");
            String phone = "<empty>".equals(row.get("phone")) ? "" : row.get("phone");
            String message = row.get("message");

            // Fill the form and validate the message
            homePage.bookRoomComponent.bookRoom(firstName, lastName, email, phone);
            assertThat(homePage.root).containsText(message);
        }
    }

    /**
     * Selects a room to book by clicking the appropriate button on the Book Room component.
     */
    @When("user selects the room to book")
    public void userSelectsTheRoomToBook() {
        homePage.bookRoomComponent.selectRoom(); // Clicks the 'Book this room' button
    }

    /**
     * This method validates that the current page complies with accessibility standards.
     * It performs an accessibility scan using the Axe framework and asserts that no violations are found.
     */
    @Then("user see no issues as per accessibility standards")
    public void userSeeNoIssuesAsPerAccessibilityStandards() {
        // Perform an accessibility scan on the current page using Axe.
        // `homePage.getPage()` retrieves the current Playwright page instance.
        AxeResults accessibilityScanResults = new AxeBuilder(homePage.getPage()).analyze();

        // Log the total number of accessibility violations detected during the scan.
        // This provides visibility into the issues found (if any) for debugging purposes.
        LOG.info(String.valueOf("Total number of violations: " + accessibilityScanResults.getViolations().size()));

        // Assert that the list of violations is empty.
        // If violations are present, the test will fail, highlighting the accessibility issues.
        assertEquals(accessibilityScanResults.getViolations(), Collections.emptyList());
    }

}
