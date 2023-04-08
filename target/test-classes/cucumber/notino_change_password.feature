Feature: Change Password

  Scenario: Change Password
    Given Homepage of the website "https://www.notino.ro/"
    Then Click account icon
    Then Click email
    Then Complete email with value
    Then Click password
    Then Complete password with value
    Then Click login button
    Then Click tab contact details
    Then Click text change password
    Then Complete password with old password
    Then Complete new password
    Then Confirm new password
    Then Click button confirm
