Feature: Verify OpenMRS Application

  Scenario Outline: Create Appointment Block
    Given User is on OpenMRS login page
    When User enters username "<username>" and password "<password>"
    And pick any location "<location>" and click on login button
    Then User verify dashboard page is displayed or not
    When User click on register patient menu
    And User enters details of demo graphics firstname "<firstName>", familyname "<familyName>" and select gender "<gender>"
    And User enters birthdate "<birthDate>", select birthmonth "<birthMonth>" and birthyear "<birthYear>"
    And User enters address "<address>" city "<city>",state "<state>",country "<country>" and postalcode "<postalcode>"
    And User enters phonenumber "<phoneNumber>"
    And User select relationship "<relationship>" and enters personname "<personName>"
    Then User verify details populated correctly
    When User click confirm button
    And User click on Home icon
    Then User verify home page is displayed
    When User click on appointment scheduling
    Then User verify appointment scheduling page is displayed
    When User click on ManageServiceTypes and click on NewServiceType
    And User enters servicename "<serviceName>" ,duration "<duration>", description "<description>" and click save button
    Then User verify service type added in the table
    When User click on Appointment Scheduling link and click on ManageProviderSchedules
    Then User Verify Appointment block is displayed or not
    When User Select the current date in the calendar
    Then User Verify create appointment block is displayed
    When User select the location "<location>" and user enters provider "<personName>"
    And User click on Home icon
    And User click on FindPatientRecord and search the patient record by patient id

    Examples: 
      | username | password | location          | firstName | familyName | gender | birthDate | birthMonth | birthYear | address       | city       | state      | country | postalcode | phoneNumber | relationship | personName | serviceName          | duration | description |
      | Admin    | Admin123 | Registration Desk | Mary      | Mark       | Female |        02 | April      |      1992 | Wilson Street | Coimbatore | Tamil Nadu | India   |     641010 |  8989898989 | Doctor       | Jake Smith | Z General Treatement |       25 | Test        |
