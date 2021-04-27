Feature: Login Functionality
  typeRegistry.defineDataTableType(
    new DataTableType(
        Double.class,
        (TableCellTransformer<Double>) value ->
            (!value.isEmpty()) ? (Double.parseDouble(value)) : (null)));

  @tag1
  Scenario Outline: login
    Given Login to Application
    When Enter <username> and <Password>
    Then Click on submit
    And verify the title <title>
    And Verify the <url>
    And Logout Button is Displayed and Enabled with Expectedmessage <Expectedmessage>

    Examples: 
      | username                    | Password                       | title        | url                                       | Expectedmessage                |
      | tomsmith                    | SuperSecretPassword!           | The Internet | https://the-internet.herokuapp.com/secure | You logged into a secure area! |
      | tomsmith_Incorrectlogintest | SuperSecretPassword!           | The Internet | https://the-internet.herokuapp.com/login  | Your username is invalid!      |
      | tomsmith                    | SuperSecretPassword!_Incorrect | The Internet | https://the-internet.herokuapp.com/login  | Your password is invalid!      |
      | tomsmith_Incorrectlogintest | SuperSecretPassword!_Incorrect | The Internet | https://the-internet.herokuapp.com/login  | Your username is invalid!      |
      | tomsmith                    | @#$%^&*()                      | The Internet | https://the-internet.herokuapp.com/login  | Your password is invalid!      |
      | @#$%^&*()                   | SuperSecretPassword!           | The Internet | https://the-internet.herokuapp.com/login  | Your username is invalid!      |
      | @#$%^&*()                   | @#$%^&*()                      | The Internet | https://the-internet.herokuapp.com/login  | Your username is invalid!      |
