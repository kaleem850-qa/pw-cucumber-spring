package com.example.config;

import com.microsoft.playwright.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Configuration class for setting up Playwright browser automation components using Spring.
 */
@Configuration
@ComponentScan("com.example") // Scans the specified package for Spring-managed components
public class Config {

    @Value("${browser}") // Injects the browser type from the application properties (e.g., "chromium", "firefox", "webkit")
    private String browserType;

    /**
     * Provides a singleton bean for Playwright, the library used for browser automation.
     *
     * @return Playwright instance
     */
    @Bean
    @Scope("singleton")
    public Playwright playwright() {
        return Playwright.create(); // Creates a single Playwright instance
    }

    /**
     * Configures a singleton bean for the browser instance based on the specified browser type.
     * The browser type is determined by the "browser" property value.
     *
     * @param playwright Playwright instance
     * @return Browser instance (Chromium, Firefox, or Webkit)
     */
    @Bean
    @Scope("singleton")
    public Browser browser(Playwright playwright) {
        Browser browser;
        // Select the browser type based on the injected configuration
        switch (browserType.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setHeadless(false) // Launches Firefox in non-headless mode
                );
                break;
            case "webkit":
                browser = playwright.webkit().launch(
                        new BrowserType.LaunchOptions().setHeadless(false) // Launches Webkit in non-headless mode
                );
                break;
            case "chromium":
            default:
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false) // Default browser: Chromium, launched in non-headless mode
                );
                break;
        }
        return browser; // Returns the initialized browser instance
    }

    /**
     * Configures a new BrowserContext bean.
     * A BrowserContext provides an isolated environment within the browser where cookies, sessions, and caches are not shared.
     *
     * @param browser Browser instance
     * @return BrowserContext instance
     */
    @Bean
    public BrowserContext browserContext(Browser browser) {
        return browser.newContext(); // Creates and returns a new BrowserContext
    }

    /**
     * Configures a new Page bean.
     * A Page represents a tab or a single window in the browser.
     *
     * @param context BrowserContext instance
     * @return Page instance
     */
    @Bean
    public Page page(BrowserContext context) {
        return context.newPage(); // Creates and returns a new Page
    }
}
