Feature: Create an user on Reqres.in
  I want create an user


  Scenario Outline: Creation User
    When you create an user with name <name> and job <job>
    Then I should see that user created
    Examples:
      | name   | job  |
      | daniel | java |