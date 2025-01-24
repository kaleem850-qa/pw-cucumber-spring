# Feature: Validate the book room form is working
# This feature ensures that the Book Room form is functioning as expected.
# It verifies successful form submission with valid inputs and checks error messages for invalid inputs.

Feature: Validate the book room form is working
  # As a user, when I enter all the required details to book a room,
  # I should see the appropriate success or error messages.

  # Scenario 1: Validate the success message
  # This scenario tests that the user can successfully book a room when all the required details are entered correctly.
  Scenario: Validate the Success message on book room form
    # Precondition: The user navigates to the booking page.
    Given user is on the booking page

    # Action: The user selects a room to book.
    When user selects the room to book

    # Action: The user enters valid details in the Book Room form.
    And user enters below valid details on book room form
      | firstName | lastName | email         | phone          |
      | Test      | User     | test@test.com | 08765438765498 |

    # Verification: The user sees the expected success message.
    Then user sees the message "must not be null"

  # Scenario 2: Validate error messages for invalid inputs
  # This scenario tests various invalid input combinations on the Book Room form
  # and ensures the relevant error messages are displayed.

  Scenario: Validate the error messages on book room form
    # Precondition: The user navigates to the booking page.
    Given user is on the booking page

    # Action: The user selects a room to book.
    When user selects the room to book

    # Action: The user enters invalid details and asserts the displayed error messages.
    And user enters below valid details on book room form and assert the relevant messages
      # The following table contains test cases for various invalid inputs.
      # Each row represents an input combination and the expected error message.

      # Case 1: First name is missing.
      | firstName | lastName | email         | phone          | message                             |
      | <empty>   | User     | test@test.com | 08765438765498 | Firstname should not be blank       |

      # Case 2: First name is too short (less than 3 characters).
      | Hi        | User     | test@test.com | 08765438765498 | size must be between 3 and 18       |

      # Case 3: Last name is missing.
      | Test      | <empty>  | test@test.com | 08765438765498 | Lastname should not be blank        |

      # Case 4: Last name is too short (less than 3 characters).
      | Test      | Hi       | test@test.com | 08765438765498 | size must be between 3 and 30       |

      # Case 5: Email address is missing.
      | Test      | User     | <empty>       | 08765438765498 | must not be empty                   |

      # Case 6: Email address is not properly formatted.
      | Test      | User     | test          | 08765438765498 | must be a well-formed email address |

      # Case 7: Phone number is too short (less than 11 characters).
      | Test      | User     | test@test.com | 0876           | size must be between 11 and 21      |

      # Case 8: Phone number is missing.
      | Test      | User     | test@test.com | <empty>        | must not be empty                   |
