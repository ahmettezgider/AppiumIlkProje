Feature: Open a web sites

  Scenario: Login
    Given user on homepage
    When  user fill the logoin form as follows
      | username | Admin    |
      | password | admin123 |
    And   user clicks submit button
    Then  login should be successfull
    And   driver close

