Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM link
    And I click on  Add Employee link

  @smoke
  Scenario Outline: Add Job
   When I click on admin dropdwon
    And I click on job
    And I click on jobtitle
    And I click on addJobTitle
    And I enter text to job title field
    And I enter text to job description
    And I add files"<file>"
    Then I see employee is added successfully

    Examples: 
      | file | 
      | Jane      |
      | James  |   
      | Jackie |   

  @regression
  Scenario: Add Employee and Create Login Details
    When I click on admin dropdwon
    And I click on job
    And I click on jobtitle
    And I click on addJobTitle
    And I enter text to job title field
    And I enter text to job description
    Then I see employee is added successfully

  @regression @temp
  Scenario: Add Employee Labels Verification
    Then I see following labels
      | First Names          |
      | Middle Name          |
      | Last Name            |
      | Employee Id          |
      | Location             |
      | Create Login Details |
