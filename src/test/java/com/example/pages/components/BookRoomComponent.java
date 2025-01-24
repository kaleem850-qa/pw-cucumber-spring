package com.example.pages.components;

import com.example.pages.BasePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 * BookRoomComponent is a Spring-managed component representing the 'Book a Room' functionality on the web page.
 * It extends BasePage, providing reusable methods for booking a room and interacting with related elements.
 */
@Component // Marks this class as a Spring component to be managed by the Spring container
public class BookRoomComponent extends BasePage {

    // Locators for the UI elements on the 'Book a Room' component
    Locator btnBookThisRoom; // Button to initiate the room booking process
    Locator txtFirstName; // Text field for entering the first name
    Locator txtLastName; // Text field for entering the last name
    Locator txtEmail; // Text field for entering the email address
    Locator txtPhone; // Text field for entering the phone number
    Locator btnBook; // Button to confirm the booking
    Locator btnCancel; // Button to cancel the booking process

    /**
     * The setUp method is executed after the component's initialization (PostConstruct).
     * It initializes all locators for the UI elements of the 'Book a Room' component.
     */
    @PostConstruct // Ensures the method is executed after the component is fully initialized
    public void setUp() {
        // Locate the 'Book this room' button
        btnBookThisRoom = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book this room")).first();
        // Locate the text field for first name
        txtFirstName = page.getByPlaceholder("Firstname").first();
        // Locate the text field for last name
        txtLastName = page.getByPlaceholder("Lastname").first();
        // Locate the text field for email address
        txtEmail = page.locator("input[name='email']").first();
        // Locate the text field for phone number
        txtPhone = page.locator("input[name='phone']").first();
        // Locate the 'Book' button with exact matching name
        btnBook = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book").setExact(true)).first();
        // Locate the 'Cancel' button
        btnCancel = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel"));
    }

    /**
     * Method to book a room by filling in the required details and clicking the 'Book' button.
     *
     * @param firstName The first name of the user
     * @param lastName  The last name of the user
     * @param email     The email address of the user
     * @param phone     The phone number of the user
     */
    public void bookRoom(String firstName, String lastName, String email, String phone) {
        // Clear and fill the first name field
        txtFirstName.clear();
        txtFirstName.fill(firstName);

        // Clear and fill the last name field
        txtLastName.clear();
        txtLastName.fill(lastName);

        // Clear and fill the email field
        txtEmail.clear();
        txtEmail.fill(email);

        // Clear and fill the phone field
        txtPhone.clear();
        txtPhone.fill(phone);

        // Click the 'Book' button to confirm the booking
        btnBook.click();
    }

    /**
     * Method to select a room by clicking the 'Book this room' button.
     * This initiates the room booking process.
     */
    public void selectRoom() {
        btnBookThisRoom.click();
    }
}
