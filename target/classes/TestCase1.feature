
@tag
Feature: Check Register a Patient Feature
  I want to Check Register a Patient

  @smoke
  Scenario: Register_a_Patient
    Given Open URL 
    And Login and validate Login is Successful
    When Click on Register a Patient
    And Enter all the relevant patient details
    And Confirm the Details and capture Patient ID
    And Click on Show Contact info and validate the patient details u entered in earlier step
    And Go back to Home page and Click on Find Patient Record
    And Search By Patient ID
    And validate Details are Displayed. Check name, id, age and date of birth
    And Search By Patient Name
    And validate details are correctly displayed. Check name, id, age and date of birth
    Then Display a successful message
  

 