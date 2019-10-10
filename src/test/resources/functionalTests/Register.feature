Feature: "User Login"

  @register @teste1_r @Chrome
  Scenario Outline: Register with new credentials by Login
    Given I open the homepage
    And I provide a new username by login as "<username>"
    And I click continue button
    And I provide a new cpf
    And I provide data de nascimeto as "<datanascimento>"
    And I click on next page button
    And I provide the operator name
    And I provide a new password as "<password>"
    And I clik on register button
    And I should be registered as "<username>" and "<emailpassword>"
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    Then I should be logged as "<username>"

    Examples: 
      | username                  | password   | datanascimento |		emailpassword		|
      | usertestespc6@outlook.com | spcjava999 | 12/06/1980     |		spcjava999			|

  @register @teste2_r @Chrome
  Scenario Outline: Register with new credentials by Register
    Given I open the homepage
    And I navigate to register menu
    And I provide a new username by register as "<username>"
    And I provide a new cpf
    And I provide data de nascimeto as "<datanascimento>"
    And I click on next page button
    And I provide the operator name
    And I provide a new password as "<password>"
    And I clik on register button
    And I should be registered as "<username>" and "<emailpassword>"
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    Then I should be logged as "<username>"

    Examples: 
      | username                  | password   | datanascimento |emailpassword		|
      | usertestespc5@hotmail.com | spcjava999 | 12/06/1985     |spcjava999			  | 

  @register @teste3_r @Chrome
  Scenario Outline: Register with invalid email
    Given I open the homepage
    And I navigate to register menu
    And I provide a new username by register as "<username>"
    And I provide a new cpf
    And I click on next page button
    And I should receive a message as "<message>"

    Examples: 
      | username      | message                          |
      | usertestescp5 | Email inválido, tente novamente. |

  @register @teste4_r @Chrome
  Scenario Outline: Register with invalid cpf
    Given I open the homepage
    And I navigate to register menu
    And I provide a new username by register as "<username>"
    And I provide a new cpf as "<cpf>"
    And I click on next page button
    And I should receive a message as "<message>"

    Examples: 
      | username                | cpf     | message                        |
      | usertestescp8@gmail.com | 1212222 | CPF inválido, tente novamente. |

   @register @teste5_r @Chrome
  Scenario Outline: Update User Email
    Given I open the homepage
    And I navigate to register menu
    And I provide a new username by register as "<username>"
    And I provide a new cpf as "<cpf>"
    And I provide data de nascimeto as "<datanascimento>"
    And I click on next page button
    And I click on update user button
    And I provide an new email as "<newusername>"
    And I provide an operator as "<operador>"
    And I provide a new password as "<password>"
    And I click on update email button
    Then I should be registered as "<newusername>" and "<emailpassword>"
    Given I open the homepage
    And I provide the username as "<newusername>"
    And I click continue button
    And I verify if the username exists as "<newusername>"
    And I provide the password as "<password>"
    And I click to login button
    Then I should be logged as "<newusername>"

    Examples: 
      |			newusername                  								        |     username                                   |	password       |  operador    	|	 datanascimento   |  emailpassword  |cpf         |
      | mariliagpm@hotmail.com									 		            | 	marilia.gsw.fornecedor@spcbrasil.org.br 	   |  Marilia123     |   7694216	  	|	 12/06/1985       |		marilia2  	  |33207560016 |
      | marilia.gsw.fornecedor@spcbrasil.org.br 		            |   mariliagpm@hotmail.com									     |  Marilia123     |   7694216	  	|	 12/06/1985       |		&MG7694216	  |33207560016 |
      
      
