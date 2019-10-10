Feature: "Segmentação"

  @createList @segmentacao @teste1_s @Chrome
  Scenario Outline: Create List - Special List's Name
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should check if any message appears

    Examples: 
      | username                         | password   | genero | nomedaLista | atributos                                |
      | carlos.athenesi@spcbrasil.org.br | C@rlos2020 |     11 | vazia       | 1000000000000000000000000000000000000000 |
      | carlos.athenesi@spcbrasil.org.br | C@rlos2020 |     11 | listão      | 1000000000000000000000000000000000000000 |
