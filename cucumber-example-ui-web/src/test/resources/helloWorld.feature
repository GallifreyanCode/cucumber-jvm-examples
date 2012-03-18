Feature: Hello World

  Scenario: Say Hello to the world
    Given I have a skeleton web application
    When I open the home page
    Then the page heading should be "Hello World!"
