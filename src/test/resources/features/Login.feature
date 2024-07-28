Feature: Login scenarios


  @sprint1 @regression @test13
  Scenario: Valid admin login
   # Given user is navigated to HRMS application
    When user enters admin username and password
    And user click on login button
    Then admin user is successfully logged in
    #Then user closes the browser

