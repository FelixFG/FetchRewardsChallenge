Feature: Login feature

  @fakefinder
  Scenario: Create an algorithm that finds the fake gold bar
    Given Algorithm is on the landing page
    When Algorithm places bar numbers in the boxes and asserts the fake bar group
    Then Algorithm detects the fake bar

