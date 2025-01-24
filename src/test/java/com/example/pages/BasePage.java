package com.example.pages;

import com.microsoft.playwright.Page;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * BasePage is an abstract class that serves as the parent for all page components in the application.
 * It provides a shared Playwright `Page` object that is injected using Spring's dependency injection.
 *
 * Purpose:
 * - Acts as a common base for all pages and components.
 * - Simplifies the sharing of the Playwright `Page` object across all pages.
 */
public abstract class BasePage {

    /**
     * The Playwright `Page` object represents a single browser tab or window.
     * It is injected by Spring's dependency injection mechanism and is available to all classes extending BasePage.
     */
    @Autowired
    protected Page page;

}
