Feature: add employee

  Background:
    When user enters admin username and password
    And user click on login button
    Then admin user is successfully logged in
    When user click on PIM option
    And user click on add employee option
  @addemp @test
  Scenario: Add an employee in hrms system
    # Given user is navigated to HRMS application
    #When user enters admin username and password
    #And user click on login button
   # Then admin user is successfully logged in
    #When user click on PIM option
    And user click on add employee option
    When user enters firtsName midleName and lastName
    And user click on save button
    Then employee added successfully
    # Then user close the browser
@Cucumber
  Scenario: adding one employee using feature file
   # When user enters admin username and password
   # And user click on login button
   # Then admin user is successfully logged in
   # When user click on PIM option
   # And user click on add employee option
    When user enters "BushraM" AND "Bahij" and "Atina"
    And user click on save button
    Then employee added successfully

  @ddt
  Scenario Outline:
    When user enters "<firstName>" AND "<middleName>" and enters "<lastName>"
    And user click on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      |Shan       |ms          |jow       |
      |Cana       |Afghan      |Deo       |
      |Jann       |Khann       |Shann     |

    @excel
    Scenario: adding the multiple employees from excel file
      When user add multiple employees from excel file using "sheet1" and verify them

      @datatable
      Scenario: adding multiple employees from data table
        When user adds multiple employees from data table
          | firstName | middleName | lastName |
          |Shan12       |ms          |jow       |
          |Cana12       |Afghan      |Deo       |
          |Jann12       |Khann       |Shann     |


