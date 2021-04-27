Feature: Verify Sconfirm Alter

  Scenario Outline: Verify JSconfirm Altert
    Given open the Application
    When Click on Button <Button>
    Then the Alter Message<AlterMessage> Present
    And Accept or Dismiss the Alert <status>
    And verify Atermessageon page <messageonpage>

    Examples: 
      | Button                           | AlterMessage      | status  | messageonpage                     |
      | //button[@onclick="jsAlert()"]   | I am a JS Alert   | accept  | You successfully clicked an alert |
      | //button[@onclick="jsConfirm()"] | I am a JS Confirm | accept  | You clicked: Ok                   |
      | //button[@onclick="jsPrompt()"]  | I am a JS prompt  | accept  | You entered: Welcome              |
      | //button[@onclick="jsConfirm()"] | I am a JS Confirm | dismiss | You clicked: Cancel               |
      | //button[@onclick="jsPrompt()"]  | I am a JS prompt  | dismiss | You entered: null                 |
