Feature: Login into Application

  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome driver
    And Navigate to "https://www.qaclickacademy.com" site
    And Click on Login link in home page to land on sign in page
    When User enters <username> and <password> and logs in
    Then Verify that user is successfully logged in
    And Close browsers

    Examples:
      |username  |password  |
      |test99@gmail.com | 1234567 |
      | Helloo@gmail.com          | Passwowerd123! |
