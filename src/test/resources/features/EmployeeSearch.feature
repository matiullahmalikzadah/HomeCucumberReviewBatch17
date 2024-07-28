Feature: Employee search

  Background:
    # Given user is navigated to HRMS application
    When user enters admin username and password
    And user click on login button
    Then admin user is successfully logged in
    When user click on PIM option
    And user click on employee List option


  @sprint2 @jan @regression @test13
  Scenario: Search an employee by Id
   # Given user is navigated to HRMS application
    #When user enters admin username and password
   # And user click on login button
   # Then admin user is successfully logged in
   # When user click on PIM option
  #  And user click on employee List option
    When user enters employee id
    And user click on search button
    Then user should be able to see employee details

    @sprint4 @bushra @regression @test
    Scenario: Search an employee by name
     # Given user is navigated to HRMS application
     # When user enters admin username and password
    #  And user click on login button
     # Then admin user is successfully logged in
     # When user click on PIM option
    #  And user click on employee List option
      When user enters valid employee name
      And user click on search button
      Then user should be able to see employee details


