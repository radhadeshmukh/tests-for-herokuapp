@tag
Feature: Dynamic loading

  Scenario Outline: Dynamic Loading
    Given Launch the url
    When Verification of Expected1color of <Example> and click
    Then click on start button
    And verify the message1<message1>
    And Helloworldmessage present
    Examples: 
      | Example | message1 |
      | hidden  | h3       |
      |rendered|h3|