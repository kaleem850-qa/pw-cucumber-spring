# Feature: Validate the Contact Us form
# This feature ensures that the Contact Us form is working as expected.
# It verifies both successful submissions and error message scenarios.

Feature: Validate the Contact us form is working
  # As a user, when I enter all the details of an enquiry, I should be able to see the relevant message.

  # Scenario 1: Validate the success message
  # This scenario tests that when the user fills in all required fields correctly on the Contact Us form,
  # the success message "Thanks for getting in touch" is displayed.

  Scenario: Validate the Success message on Contact us form
    # Precondition: Navigate to the booking page where the Contact Us form is located.
    Given user is on the booking page
    # Action: The user enters valid details in the Contact Us form.
    When user enters below valid details on contact us form
      | name      | email         | phone          | subject                    | description                                                                                                                                              |
      | Test User | test@test.com | 07999999999999 | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options |
    # Verification: Check if the success message is displayed.
    Then user sees the success message "Thanks for getting in touch"

  # Scenario 2: Validate error messages
  # This scenario tests various invalid inputs on the Contact Us form and ensures the relevant error messages are displayed.

  Scenario: Validate the error message on Contact us form
    # Precondition: Navigate to the booking page where the Contact Us form is located.
    Given user is on the booking page
    # Action: The user enters different combinations of invalid details and asserts the error messages.
    When user enters below valid details on contact us form and assert the relevant message
      # The following table includes various combinations of invalid inputs and their corresponding expected error messages.
      # Each row represents a test case with the form inputs and the expected error message.

      # Case 1: Phone number is too short.
      | name      | email         | phone             | subject                    | description                                                                                                                                              | message                                         |
      | Test User | test@test.com | 07999             | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Phone must be between 11 and 21 characters      |

      # Case 2: Name is empty.
      | <empty>   | test@test.com | 07999999999123999 | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Name may not be blank                           |

      # Case 3: Email is empty.
      | Test User | <empty>       | 07999999999123999 | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Email may not be blank                          |

      # Case 4: Phone number is empty.
      | Test User | test@test.com | <empty>           | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Phone may not be blank                          |

      # Case 5: Phone number is invalid (too short).
      | Test User | test@test.com | 123456            | Regarding the room enquiry | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Phone must be between 11 and 21 characters.     |

      # Case 6: Subject is empty.
      | Test User | test@test.com | 07999999999123999 | <empty>                    | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Subject may not be blank                        |

      # Case 7: Subject is too short (less than 5 characters).
      | Test User | test@test.com | 07999999999123999 | Hi                         | I am interested in Single Bed Room with TV, WiFi and with Safe. I want this booking to be on coming month 2nd to 10th. Let me know the available options | Subject must be between 5 and 100 characters.   |

      # Case 8: Description is empty.
      | Test User | test@test.com | 07999999999123999 | Regarding the room enquiry | <empty>                                                                                                                                                  | Message may not be blank                        |

      # Case 9: Description is too short (less than 20 characters).
      | Test User | test@test.com | 07999999999123999 | Regarding the room enquiry | I am interested                                                                                                                                          | Message must be between 20 and 2000 characters. |
