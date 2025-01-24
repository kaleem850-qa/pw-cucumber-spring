# This feature file is designed to test accessibility compliance using Playwright.
# Accessibility testing ensures that the application conforms to standard guidelines,
# providing an inclusive experience for all users, including those with disabilities.

Feature: Accessibility testing using Playwright
  # This feature focuses on verifying the absence of accessibility violations on the booking page.

  Scenario: Check for accessibility violations
    # This scenario is intended to validate that the booking page adheres to accessibility standards
    # by checking for any issues such as missing ARIA roles, improper color contrast, or other violations.

    Given user is on the booking page
      # The user navigates to the booking page of the application.
      # This step involves launching the browser, navigating to the correct URL,
      # and ensuring that the page is fully loaded before proceeding.

    Then user see no issues as per accessibility standards
      # This step runs an accessibility audit on the booking page using an automation tool (e.g., Axe).
      # It verifies that there are no critical, serious, or moderate accessibility issues,
      # such as improper ARIA attributes, invalid HTML semantics, or poor contrast ratios.
      # The result of the audit should show zero violations for this step to pass.
