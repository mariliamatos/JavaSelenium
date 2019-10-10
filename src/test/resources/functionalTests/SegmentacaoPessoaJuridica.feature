Feature: "Segmentacao - Pessoa Jurídica"

  
  @createList @segmentacao  @segmentacaopj @teste1_spj @Chrome
  Scenario Outline: Quantity of Cnpj to zero -  PJ 
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes changing quantity to zero using attibutes as "<atributos>"

  Examples: 
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista        	    |  atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus      	    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaCnpj          	    | CNPJ=1:5000                                                                                                              |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaRazaoSocial  	    | CNPJ=1:5000,Razao Social=1:5000                                                                                          |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaDataFundacao       | CNPJ=1:5000,Data Fundacao=1:5000                                                                                         |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaNomeFantasia       | CNPJ=1:5000,Nome Fantasia=1:5000                                                                                         |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaEmail				      | CNPJ=1:5000,E-mail=1:5000                                                                                                |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo1      | CNPJ=1:5000,Telefone Fixo 1=1:5000                                                                                       |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo2      | CNPJ=1:5000,Telefone Fixo 2=1:5000                                                                                       |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo3      | CNPJ=1:5000,Telefone Fixo 3=1:5000                                                                                       |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo4      | CNPJ=1:5000,Telefone Fixo 4=1:5000                                                                                       |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo5  		| CNPJ=1:5000,Telefone Fixo 5=1:5000                                                                                       |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular1   | CNPJ=1:5000,Telefone Celular 1=1:5000                                                                                    |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular2   | CNPJ=1:5000,Telefone Celular 2=1:5000                                                                                    |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular3   | CNPJ=1:5000,Telefone Celular 3=1:5000                                                                                    |            3  |        2 |            0 |
  		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular4   | CNPJ=1:5000,Telefone Celular 4=1:5000                                                                                    |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular5   | CNPJ=1:5000,Telefone Celular 5=1:5000                                                                                    |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaCnae							  | CNPJ=1:5000,CNAE=1:5000                                                                                                  |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPorte						  | CNPJ=1:5000,Porte=1:5000                                                                                                 |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaNumeroFuncionarios | CNPJ=1:5000,Numero Funcionarios=1:5000                                                                                   |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio1						  | CNPJ=1:5000,Socio 1=1:5000                                                                                               |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio2						  | CNPJ=1:5000,Socio 2=1:5000                                                                                               |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio3						  | CNPJ=1:5000,Socio 3=1:5000                                                                                               |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio3						  | CNPJ=1:5000,Socio 3=1:5000                                                                                               |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaRestricaoFinanceira| CNPJ=1:5000,Restricao Financeira=1:5000                                                                                  |            3  |        2 |            0 |
   		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaEndereco					  | CNPJ=1:5000,Endereco=1:5000                                                                                              |            3  |        2 |            0 |
   
   
  @createList @segmentacao @segmentacaopj @teste2_spj @Chrome
  Scenario Outline: Quantity of Cnpj to zero -  PJ - LVM
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should click to list view
    And I should choose the type of my list as "<typeList>"
    And I should change the quantity of my attribute to zero in list view mode using "<atributos>"
  Examples: 
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
    

  @createList @segmentacao @segmentacaopj @teste3_spj @Chrome
  Scenario Outline: Quantity of Cnpj to zero - On cart- PJ
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should change the quantity of my attribute to zero

  Examples: 
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
    

  @createList @segmentacao @segmentacaopj  @teste4_spj @Chrome
  Scenario Outline: Create List - PJ
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
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
  	  | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
      

 @createList @segmentacao @segmentacaopj @teste5_spj @Chrome
  Scenario Outline: Create List - PJ - List view mode
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should click to list view
    And I should choose the attributes as "<atributos>" and "<combinedBase>" in list view mode
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
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
     
  
   @createList @segmentacao @segmentacaopj @teste6_spj @Chrome
  Scenario Outline: Create List - PJ - uncheck attributes
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
  	And I should uncheck attributes
   Examples: 
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
    

      
   @createList @segmentacao @segmentacaopj @teste7_spj @Chrome
  Scenario Outline: Create List - PJ - Changing quantity
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
    And I should choose filter localizationPJ as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter faturamento  as  "<faturamento>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter atividades as "<atividades>"
    And I should choose filter data de abertura as "<datadeabertura>"
    And I should choose filter funcionarios as "<funcionarios>"
    And I should choose filter Porte da Empresa as  "<porteEmpresa>"
    And I should choose filter Natureza Júridica as  "<naturezaJuridica>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes changing quantity using attibutes as "<atributos>"
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
      | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista        	    |  atributos                                                                                                               |  typeDownload | typeList | combinedBase |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaCnpj          	    | CNPJ=1:5000                                                                                                              |            3  |        2 |            0 |
    	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaRazaoSocial  	    | CNPJ=1:5000,Razao Social=1:5000                                                                                          |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaDataFundacao       | CNPJ=1:5000,Data Fundacao=1:5000                                                                                         |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaNomeFantasia       | CNPJ=1:5000,Nome Fantasia=1:5000                                                                                         |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaEmail				      | CNPJ=1:5000,E-mail=1:5000                                                                                                |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo1      | CNPJ=1:5000,Telefone Fixo 1=1:5000                                                                                       |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo2      | CNPJ=1:5000,Telefone Fixo 2=1:5000                                                                                       |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo3      | CNPJ=1:5000,Telefone Fixo 3=1:5000                                                                                       |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo4      | CNPJ=1:5000,Telefone Fixo 4=1:5000                                                                                       |            3  |        2 |            0 |
    #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneFixo5  		| CNPJ=1:5000,Telefone Fixo 5=1:5000                                                                                       |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular1   | CNPJ=1:5000,Telefone Celular 1=1:5000                                                                                    |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular2   | CNPJ=1:5000,Telefone Celular 2=1:5000                                                                                    |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular3   | CNPJ=1:5000,Telefone Celular 3=1:5000                                                                                    |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular4   | CNPJ=1:5000,Telefone Celular 4=1:5000                                                                                    |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaTelefoneCelular5   | CNPJ=1:5000,Telefone Celular 5=1:5000                                                                                    |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaCnae							  | CNPJ=1:5000,CNAE=1:5000                                                                                                  |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPorte						  | CNPJ=1:5000,Porte=1:5000                                                                                                 |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaNumeroFuncionarios | CNPJ=1:5000,Numero Funcionarios=1:5000                                                                                   |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio1						  | CNPJ=1:5000,Socio 1=1:5000                                                                                               |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio2						  | CNPJ=1:5000,Socio 2=1:5000                                                                                               |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio3						  | CNPJ=1:5000,Socio 3=1:5000                                                                                               |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaSocio3						  | CNPJ=1:5000,Socio 3=1:5000                                                                                               |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaRestricaoFinanceira| CNPJ=1:5000,Restricao Financeira=1:5000                                                                                  |            3  |        2 |            0 |
   #		| augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaEndereco					  | CNPJ=1:5000,Endereco=1:5000                                                                                              |            3  |        2 |            0 |
   #
 

@createList @segmentacao @segmentacaopj @teste8_spj @Chrome
  Scenario Outline: Create List - PJ - one filter
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should to choose Empresa as filter
    And I should choose filter status as "<status>"
		And verify two filters message
		
 	Examples: 
 		  | username                             | password           | status      | atividades                            | faturamento | datadeabertura | funcionarios         | restricao | porteEmpresa                                 | state | city | neighborhood | naturezaJuridica                                             | nomedaLista      | atributos                                                                                                               |  typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		  | 001111000   |                                       |      000000 |              0 |                      |         2 |                                              |       |      |              |                                                              | ListaPJStatus    | CNPJ=1:90000,Razao Social=1:60000,		Situação RF=1:30000, Data Fundacao=1:20000 ,Nome Fantasia=1:15000                  |            3  |        2 |            0 |
    

      
      
      
      
      
      