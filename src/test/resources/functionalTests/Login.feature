Feature: "User Login"

    @login	@teste1_l @Chrome 
  Scenario Outline: Reset Password
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I click in reset password button
    And I confirm my email to reset password as "<username>" and "<emailpassword>"
    And I confirm my cpf as "<cpf>"
    And I confirm new password as "<password>"
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    Then I should be logged as "<username>"
    Examples: 
      | username                                 | password      | cpf         | emailpassword  |
      | usertestespc18@hotmail.com						   | 17052019      | 33207560016 | spcjava999     |


  @login	@teste2_l @Chrome
  Scenario Outline: Login with wrong password
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I provide the password as "<password>"
    And I click to login button
    Then I should receive a message as "<message>"

    Examples: 
      | username                                 | password      | message        |
      | usertestespc20@hotmail.com						   | 17052019      | Senha inválida |

  @login	@teste3_l @Chrome
  Scenario Outline: Login with wrong password 3 times
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should receive a message as "<message3>"
    And I provide the password as "<password>"
    And I click to login button
    And I should receive a message as "<message3>"
    And I provide the password as "<password>"
    And I click to login button
    And I should receive a message as "<message>"
    And I provide the password as "<password>"
    And I click to login button
    And I should receive a message as "<message2>"
     Then I should be logged as "<username>"
    Examples: 
      | username               								  | password    | message                                     | message2        | message3       |
      | marilia.gsw.fornecedor@spcbrasil.org.br | Marilia123  | Operador bloqueado por excesso de tentativa | Conta bloqueada | Senha inválida |

  @login @teste4_l @Chrome
  Scenario Outline: Login with right credentials
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
   

    Examples: 
      | username                         				 | password     |
      | usertestespc20@hotmail.com						   | 17052019     |


 @login @teste14_l @Chrome
  Scenario Outline: Login with right credentials teste
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
       Examples: 
      | username                         				 | password     |
      | usertestespc20@hotmail.com						   | 17052019     |
      
  
 @login @teste24_l @Chrome
  Scenario Outline: Login with right credentials teste1
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
       Examples: 
      | username                         				 | password     |
      | usertestespc20@hotmail.com						   | 17052019     |
      
      


  @login	@teste5_l @Chrome
  Scenario Outline: Login with right credentials coming from identity page
    Given I open the IdentityPage
    And I provide the username as "<username>"
    And I click continue button
    And I receive a message that my session is expired
    And I click in access spc button
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    Then I should be logged as "<username>"

    Examples: 
      | username                				 				 | password   |
      | marilia.gsw.fornecedor@spcbrasil.org.br  | C@rlos2019 |

  @login	@teste6_l @Chrome
  Scenario Outline: Login with a not registered username
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    Then I should be redirected to Register Page

    Examples: 
      | username               |
      | jhonny.dutra@gmail.com |
      | amanda.dias@gmail.com  |

  @login @teste7_l @Chrome
  Scenario Outline: Login with a not active username
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    Then I should be redirected to activate message

    Examples: 
      | username               |
      | usertestespc@gmail.com |
      

   @login @teste8_l @Chrome
 Scenario Outline: Login with invalid email
    Given I open the homepage
    And I provide the username as "<username>"
    And I should receive a message as "<message>"

    Examples: 
      | username                | message                           |
      | a										  	| E-mail inválido, tente novamente. |
      
 
      
      
      