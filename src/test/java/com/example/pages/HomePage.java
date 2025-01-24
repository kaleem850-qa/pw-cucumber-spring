package com.example.pages;

import com.example.pages.components.BookRoomComponent;
import com.example.pages.components.ContactUsComponent;
import com.microsoft.playwright.Locator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * HomePage class represents the main homepage of the application.
 * It extends BasePage and acts as a centralized entry point for interacting with various components on the homepage,
 * such as the Contact Us form and Book Room functionality.
 */
@Component // Marks this class as a Spring-managed component
@PropertySource("classpath:application.properties") // Specifies the properties file containing application configurations
public class HomePage extends BasePage {

    /**
     * URL of the homepage, injected from the application.properties file.
     */
    @Value("${url}")
    private String url;

    /**
     * ContactUsComponent is a Spring-managed component for handling the 'Contact Us' form functionality.
     */
    @Autowired
    public ContactUsComponent contactUsComponent;

    /**
     * BookRoomComponent is a Spring-managed component for handling the room booking functionality.
     */
    @Autowired
    public BookRoomComponent bookRoomComponent;

    // Locators for common elements on the homepage
    public Locator root; // Locator for the root element of the homepage
    public Locator form; // Locator for a form element on the homepage

    /**
     * Initializes the locators for the homepage.
     * This method is executed after the Spring component is fully initialized using @PostConstruct.
     */
    @PostConstruct
    public void setUp() {
        // Locate the root element of the homepage
        root = page.locator("#root");

        // Locate a form element on the homepage
        form = page.locator("form");
    }

    /**
     * Navigates to the homepage URL.
     * This method uses the Playwright `Page` object to navigate to the URL specified in the properties file.
     */
    public void goTo() {
        page.navigate(url); // Navigate to the homepage URL
    }
}
