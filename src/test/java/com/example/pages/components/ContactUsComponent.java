package com.example.pages.components;

import com.example.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * ContactUsComponent is a Spring-managed component representing the 'Contact Us' form on the web page.
 * It extends BasePage and provides methods to interact with the form elements such as entering contact details
 * and submitting the form.
 */
@Component // Marks this class as a Spring-managed component
public class ContactUsComponent extends BasePage {

    // Locators for the 'Contact Us' form fields and buttons
    Locator txtName; // Locator for the 'Name' input field
    Locator txtEmail; // Locator for the 'Email' input field
    Locator txtPhone; // Locator for the 'Phone' input field
    Locator txtSubject; // Locator for the 'Subject' input field
    Locator txtMessage; // Locator for the 'Message/Description' text area
    Locator btnSubmit; // Locator for the 'Submit' button

    /**
     * Initializes all the locators for the 'Contact Us' form.
     * This method is called after the component is fully initialized using @PostConstruct annotation.
     */
    @PostConstruct
    public void setUp() {
        // Locate the 'Name' input field using its test ID
        txtName = page.getByTestId("ContactName");

        // Locate the 'Email' input field using its test ID
        txtEmail = page.getByTestId("ContactEmail");

        // Locate the 'Phone' input field using its test ID
        txtPhone = page.getByTestId("ContactPhone");

        // Locate the 'Subject' input field using its test ID
        txtSubject = page.getByTestId("ContactSubject");

        // Locate the 'Message/Description' text area using its test ID
        txtMessage = page.getByTestId("ContactDescription");

        // Locate the 'Submit' button using its role and name
        btnSubmit = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
    }

    /**
     * Method to fill in the 'Contact Us' form and submit it.
     *
     * @param name        The name of the user
     * @param email       The email address of the user
     * @param phone       The phone number of the user
     * @param subject     The subject of the message
     * @param description The message or description provided by the user
     */
    public void contactUs(String name, String email, String phone, String subject, String description) {
        // Fill the 'Name' field with the provided value
        txtName.fill(name);

        // Fill the 'Email' field with the provided value
        txtEmail.fill(email);

        // Fill the 'Phone' field with the provided value
        txtPhone.fill(phone);

        // Fill the 'Subject' field with the provided value
        txtSubject.fill(subject);

        // Fill the 'Message/Description' text area with the provided value
        txtMessage.fill(description);

        // Click the 'Submit' button to submit the form
        btnSubmit.click();
    }
}
