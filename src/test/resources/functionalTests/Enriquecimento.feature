Feature: "Enriquecimento"

  @createList @enrich @teste1_e @Chrome
  Scenario Outline: Qualify List
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I click on Upload File button
    And I click on Enrich button
    And I should choose the type of my list as "<typeList>"
    And I choose attributes to enrich as "<atributos>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should click create list button
    And I should go to history
    Then I should verify is list was created as "<nomedaLista>"
    And I should download my list as <typeDownload>
    And I should copy my file
    And I should unzip my file
    Then I should read my file as <typeList> after download my list as <typeDownload>

    Examples: 
      | username                             | password         | nomedaLista  | atributos                                      | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:20,Nome=1:20,Situacao RF=1:20      		  |            1 |       1   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2,Data Fundacao=1:2    |            1 |       2   |


  @createList @enrich @teste2_e @Chrome
  Scenario Outline: Qualify List - List Mode view
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I click on Upload File button
    And I click on Enrich button
    And I should choose the type of my list as "<typeList>"
    And I should click list mode view button
    And I should choose my attributes as "<atributos>" in list view mode
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should click create list button
    And I should go to history
    Then I should verify is list was created as "<nomedaLista>"
    And I should download my list as <typeDownload>
    And I should copy my file
    And I should unzip my file
    Then I should read my file as <typeList> after download my list as <typeDownload>
  Examples: 
      | username                             | password         | nomedaLista  | atributos                                      | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:20,Nome=1:20,Situacao RF=1:20      		  |            1 |       1   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2,Data Fundacao=1:2    |            1 |       2   |

  @createList @enrich @teste3_e @Chrome
  Scenario Outline: Qualify List - Quantity to 0 - LM
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I click on Upload File button
    And I click on Enrich button
    And I should choose the type of my list as "<typeList>"
    And I should click list mode view button
    And I should change the quantity of my attribute that I will enrich to zero in list view mode using "<atributos>"
    Examples: 
      | username                             | password         | nomedaLista  | atributos                                      | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:20,Nome=1:20,Situacao RF=1:20      		  |            1 |       1   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2,Data Fundacao=1:2    |            1 |       2   |

  @createList @enrich @teste4_e @Chrome
  Scenario Outline: Qualify List - Changing quantity
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I click on Upload File button
    And I click on Enrich button
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes to enrich and changing quantity using attibutes as "<atributos>"
    #And I should click menu Create List
    #And I should create a list as "<nomedaLista>"
    #And I should click create list button
    #And I should go to history
    #Then I should verify is list was created as "<nomedaLista>"
    #And I should download my list as <typeDownload>
    #And I should copy my file
    #And I should unzip my file
    #Then I should read my file as <typeList> after download my list as <typeDownload>

    Examples: 
      | username                             | password         | nomedaLista  | atributos                                      | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:20,Nome=1:20,Situacao RF=1:20      		  |            1 |       1   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2,Data Fundacao=1:2    |            1 |       2   |

  @createList @enrich @teste5_e @Chrome
  Scenario Outline: Qualify List - Changing quantity to 0
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I click on Upload File button
    And I click on Enrich button
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes to enrich and changing quantity to zero using attibutes as "<atributos>"

       Examples: 
      | username                             | password         | nomedaLista  | atributos                                      | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:20,Nome=1:20,Situacao RF=1:20      		  |            1 |       1   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2,Data Fundacao=1:2    |            1 |       2   |

  @createList @enrich @teste6_e @Chrome
  Scenario Outline: Qualify List - Special Files
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I click on Qualificar Button
    And I choose the list type as <typeList>
    And I should choose the type of my list as "<typeList>"
    And I click on Upload File button
    And I verify if file is empty
    Examples: 
      | username                             | password         | nomedaLista  | atributos                                | typeDownload | typeList  |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPF | CPF=1:2,Nome=1:2   		   								|            1 |       3   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2                |            1 |       4   |
      |  augusto.menin@spcbrasil.org.br  	   | spcdados@2019    | qualificarPJ | CNPJ=1:2,Razao Social=1:2                |            1 |       5   |
   
    
 
      

      
      
      
      
      
      
      
      
      
      