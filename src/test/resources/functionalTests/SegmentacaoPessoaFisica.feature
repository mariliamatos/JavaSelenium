Feature: "Segmentação - Pessoa Física"

  @createList @segmentacao @segmentacaopf @teste1_spf @Chrome
  Scenario Outline: Create List - PF
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose filter localizationPF as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter profissao as "<profissao>"
    And I should choose filter renda as  "<renda>"
    And I should choose filter escolaridade as "<escolaridade>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter bens as  "<bens>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should click create list button
    And I should go to history
    #And I should verify is list was created as "<nomedaLista>"
    #And I should download my list as <typeDownload>
    #And I should copy my file
    #And I should unzip my file
    #Then I should read my file as <typeList> after download my list as <typeDownload>
    Examples: 
      |    username                 	       |   password      							          | genero  | faixaetaria              | renda  | escolaridade  | restricao | bens | state        | city                          | neighborhood                 | profissao  				                            |  nomedaLista                       | atributos                                 														               | typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | cpf						                     | CPF=1:5000                                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePf                             | CPF=1:5000,Nome=1:5000                                                              |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | situacaoRf                         | CPF=1:5000,Situacao RF=1:5000                                                       |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | endereco                           | CPF=1:5000,Endereco=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | dataNascimento                     | CPF=1:5000,Data Nascimento=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | genero                             | CPF=1:5000,Genero=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | escolaridade                       | CPF=1:5000,Escolaridade=1:5000                                                      |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePai                            | CPF=1:5000,Nome Pai=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomeMae                            | CPF=1:5000,Nome Mae=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | profissao                          | CPF=1:5000,Profissão=1:5000                                                         |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | email                              | CPF=1:5000,E-mail=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo1                      | CPF=1:5000,Telefone Fixo 1=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo2                      | CPF=1:5000,Telefone Fixo 2=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo3                      | CPF=1:5000,Telefone Fixo 3=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo4                      | CPF=1:5000,Telefone Fixo 4=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo5                   	 | CPF=1:5000,Telefone Fixo 5=1:5000                                                   |            1 |        1 |            0 |
		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular1                   | CPF=1:5000,Telefone Celular 1=1:5000                                                |            1 |        1 |            0 | 
 	  #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular2                   | CPF=1:5000,Telefone Celular 2=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular3                   | CPF=1:5000,Telefone Celular 3=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular4                   | CPF=1:5000,Telefone Celular 4=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular5                   | CPF=1:5000,Telefone Celular 5=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | veiculo					                   | CPF=1:5000,Veiculo=1:5000                                                           |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | obito					                     | CPF=1:5000,Obito=1:5000                                                             |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | estadoCivil					               | CPF=1:5000,Estado Civil=1:5000                                                      |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | restricaoFinanceira					       | CPF=1:5000,Restrição Financeira=1:5000                                              |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | rg				                         | CPF=1:5000,RG=1:5000                                                                |            1 |        1 |            0 | 
 
    # | usertestespc5@hotmail.com 	   | 10062019 	    	|     01  |   020070                 | 000000 | 1111111111111 |         2 |    2 |                |                        		     	  |                                                  |                                                | feminino                    | CPF=1:1100,Nome=1:1000																																																																																																																																																																																																																																																																																																	                  	                                                            |            1 |        1 |           0  |
    # | usertestespc20@hotmail.com 	   | 17052019  	    	|     10  |   020070                 | 000000 | 0000000000000 |         2 |    2 |                |                        		     	  |                                                  |                                                | masculino 					        | CPF=1:1100,Nome=1:1000,Situacao RF=1:900, Genero=1:800,Endereco=1:700,Profissão=1:600, E-mail=1:500, Data Nascimento=1:400																																																																																																																																																																																																																																																																																																																								                  	              |            1 |        1 |           0  |
    # | usertestespc20@hotmail.com 	   | 17052019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | femininotelefonefixo2			 | CPF=1:150,Telefone Fixo 2=1:100																																																																																																																																																																																																																																																																																																																												                  			|            1 |        1 |            0 |
    # | usertestespc5@hotmail.com 	   | 10062019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | femininotelefonefixo3       | CPF=1:150,Telefone Fixo 3=1:100																																																																																																																																																																																																																																																																																																																											                  	|            1 |        1 |            0 |
    # | usertestespc20@hotmail.com 	   | 17052019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | femininotelefonefixo4  		 | CPF=1:150,Telefone Fixo 4=1:100																																																																																																																																																																																																																																																																																																																												                  			|            1 |        1 |            0 |
    # | usertestespc5@hotmail.com 	   | 10062019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | femininotelefonefixo5       | CPF=1:150,Telefone Fixo 5=1:100																																																																																																																																																																																																																																																																																																																											                  	|            1 |        1 |            0 |
    # | usertestespc5@hotmail.com 	   | 10062019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | feminino1     | CPF=1:150,Nome Mae=1:100, Telefone Fixo 2=1:100,Telefone Fixo 3=1:100, Telefone Fixo 4=1:100, Telefone Fixo 5=1:100																																																																																																																																																																																																																																																																																																																											                  	|            1 |        1 |            0 |
    # | usertestespc5@hotmail.com 	   | 10062019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | feminino1     | CPF=1, Nome=1, Situacao RF=1, Endereco=1, Data Nascimento=1, Genero=1,Escolaridade=1, Nome Pai=1, Nome Mae=1, Profissão=1, E-mail=1, Telefone Fixo 1=1, Telefone Fixo 2=1,Telefone Fixo 3=1, Telefone Fixo 4=1, Telefone Fixo 5=1, Telefone Celular 1=1, Telefone Celular 2=1,Telefone Celular 3=1, Telefone Celular 4=1, Telefone Celular 5=1, WahtasApp Celular 1=1,WahtasApp Celular 2=1, WahtasApp Celular 3=1, WahtasApp Celular 4=1, WahtasApp Celular 5=1,Veiculo=1, Renda Presumida=1, Obito=1, Bolsa Familia=1, Estado Civil=1, Funcionario CLT=1,Classe Social=1, Restrição Financeira=1, Consignado=1, Título de Eleitor=1, RG=1, PIS=1,Carteira Profissional=1, Conselho Profissional=1|            1 |        1 |            0 |     #| usertestespc5@hotmail.com 	   | 10062019 		   	|     01 |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | feminino1     | CPF=1, Nome=1, Situacao RF=1, Endereco=1, Data Nascimento=1, Genero=1,Escolaridade=1, Nome Pai=1, Nome Mae=1, Profissão=1, E-mail=1, Telefone Fixo 1=1, Telefone Fixo 2=1,Telefone Fixo 3=1, Telefone Fixo 4=1, Telefone Fixo 5=1, Telefone Celular 1=1, Telefone Celular 2=1,Telefone Celular 3=1, Telefone Celular 4=1, Telefone Celular 5=1, WahtasApp Celular 1=1,WahtasApp Celular 2=1, WahtasApp Celular 3=1, WahtasApp Celular 4=1, WahtasApp Celular 5=1,Veiculo=1, Renda Presumida=1, Obito=1, Bolsa Familia=1, Estado Civil=1, Funcionario CLT=1,Classe Social=1, Restrição Financeira=1, Consignado=1, Título de Eleitor=1, RG=1, PIS=1,Carteira Profissional=1, Conselho Profissional=1|            1 |        1 |            0 |
    # | usertestespc5@hotmail.com 	   | 10062019 		   	|     01  |   020045			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                               | feminino1     | CPF=1, Nome=1, Situacao RF=1, Endereco=1, Data Nascimento=1,Data Nascimento=1,Genero=1,Escolaridade=1, Nome Pai=1, Nome Mae=1, Profissão=1, E-mail=1, Telefone Fixo 1=1           |            1 |        1 |            0 |
      
     
  @createList @segmentacao @segmentacaopf @teste2_spf @Chrome
  Scenario Outline: Create List - PF - List view mode
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista20>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose filter localizationPF as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter profissao as "<profissao>"
    And I should choose filter renda as  "<renda>"
    And I should choose filter escolaridade as "<escolaridade>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter bens as  "<bens>"
    And I should choose the type of my list as "<typeList>"
    And I should click to list view
    And I should choose the attributes as "<atributos>" and "<combinedBase>" in list view mode
    #And I should click menu Create List
    #And I should create a list as "<nomedaLista>"
    #And I should click create list button
    #And I should go to history
    #And I should verify is list was created as "<nomedaLista>"
    #And I should download my list as <typeDownload>
    #And I should copy my file
    #And I should unzip my file
    #Then I should read my file as <typeList> after download my list as <typeDownload>
    Examples: 
      Examples: 
      |    username                        	 |   password                           	| genero  | faixaetaria              | renda  | escolaridade  | restricao | bens | state        | city                          | neighborhood                 | profissao  				                            |  nomedaLista                       | atributos                                             															 | typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | cpf						                     | CPF=1:5000                                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePf                             | CPF=1:5000,Nome=1:5000                                                              |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | situacaoRf                         | CPF=1:5000,Situacao RF=1:5000                                                       |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | endereco                           | CPF=1:5000,Endereco=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | dataNascimento                     | CPF=1:5000,Data Nascimento=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | genero                             | CPF=1:5000,Genero=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | escolaridade                       | CPF=1:5000,Escolaridade=1:5000                                                      |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePai                            | CPF=1:5000,Nome Pai=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomeMae                            | CPF=1:5000,Nome Mae=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | profissao                          | CPF=1:5000,Profissão=1:5000                                                         |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | email                              | CPF=1:5000,E-mail=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo1                      | CPF=1:5000,Telefone Fixo 1=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo2                      | CPF=1:5000,Telefone Fixo 2=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo3                      | CPF=1:5000,Telefone Fixo 3=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo4                      | CPF=1:5000,Telefone Fixo 4=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo5                   	 | CPF=1:5000,Telefone Fixo 5=1:5000                                                   |            1 |        1 |            0 |
		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular1                   | CPF=1:5000,Telefone Celular 1=1:5000                                                |            1 |        1 |            0 | 
 	  #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular2                   | CPF=1:5000,Telefone Celular 2=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular3                   | CPF=1:5000,Telefone Celular 3=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular4                   | CPF=1:5000,Telefone Celular 4=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular5                   | CPF=1:5000,Telefone Celular 5=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | veiculo					                   | CPF=1:5000,Veiculo=1:5000                                                           |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | obito					                     | CPF=1:5000,Obito=1:5000                                                             |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | estadoCivil					               | CPF=1:5000,Estado Civil=1:5000                                                      |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | restricaoFinanceira					       | CPF=1:5000,Restrição Financeira=1:5000                                              |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | rg				                         | CPF=1:5000,RG=1:5000                                                                |            1 |        1 |            0 | 
 

  @createList @segmentacao @segmentacaopf @teste3_spf @Chrome
  Scenario Outline: Quantity of Cpf to zero -  PF  - LVM
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose the type of my list as "<typeList>"
    And I should click to list view
    And I should change the quantity of my attribute to zero in list view mode using "<atributos>"

   Examples: 
      |    username                       	 |   password      	                      | genero  |  faixaetaria             | renda  | escolaridade  | restricao | bens | state        | city                          | neighborhood                 | profissao                                      |  nomedaLista                       | atributos                                 														               | typeDownload | typeList | combinedBase |
      | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | cpf						                     | CPF=1:5000                                                                          |            1 |        1 |            0 |
    
  @createList @segmentacao @segmentacaopf @teste4_spf @Chrome
  Scenario Outline: Create List - Changing quantity - PF
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose filter localizationPF as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter profissao as "<profissao>"
    And I should choose filter renda as  "<renda>"
    And I should choose filter escolaridade as "<escolaridade>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter bens as  "<bens>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes changing quantity using attibutes as "<atributos>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should click create list button
    And I should go to history
    And I should verify is list was created as "<nomedaLista>"
    And I should download my list as <typeDownload>
    And I should copy my file
    And I should unzip my file
    Then I should read my file as <typeList> after download my list as <typeDownload>

  Examples: 
      |    username                        	 |   password                           	| genero  | faixaetaria              | renda  | escolaridade  | restricao | bens | state        | city                          | neighborhood                 | profissao                                      |  nomedaLista                       | atributos                                 														               | typeDownload | typeList | combinedBase |
   	  | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | cpf						                     | CPF=1:5000                                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePf                             | CPF=1:5000,Nome=1:5000                                                              |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | situacaoRf                         | CPF=1:5000,Situacao RF=1:5000                                                       |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | endereco                           | CPF=1:5000,Endereco=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | dataNascimento                     | CPF=1:5000,Data Nascimento=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | genero                             | CPF=1:5000,Genero=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | escolaridade                       | CPF=1:5000,Escolaridade=1:5000                                                      |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomePai                            | CPF=1:5000,Nome Pai=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | nomeMae                            | CPF=1:5000,Nome Mae=1:5000                                                          |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | profissao                          | CPF=1:5000,Profissão=1:5000                                                         |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | email                              | CPF=1:5000,E-mail=1:5000                                                            |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo1                      | CPF=1:5000,Telefone Fixo 1=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo2                      | CPF=1:5000,Telefone Fixo 2=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo3                      | CPF=1:5000,Telefone Fixo 3=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo4                      | CPF=1:5000,Telefone Fixo 4=1:5000                                                   |            1 |        1 |            0 |
    # | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefonefixo5                   	 | CPF=1:5000,Telefone Fixo 5=1:5000                                                   |            1 |        1 |            0 |
		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular1                   | CPF=1:5000,Telefone Celular 1=1:5000                                                |            1 |        1 |            0 | 
 	  #	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular2                   | CPF=1:5000,Telefone Celular 2=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular3                   | CPF=1:5000,Telefone Celular 3=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular4                   | CPF=1:5000,Telefone Celular 4=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | telefoneCelular5                   | CPF=1:5000,Telefone Celular 5=1:5000                                                |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | veiculo					                   | CPF=1:5000,Veiculo=1:5000                                                           |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | obito					                     | CPF=1:5000,Obito=1:5000                                                             |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | estadoCivil					               | CPF=1:5000,Estado Civil=1:5000                                                      |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | restricaoFinanceira					       | CPF=1:5000,Restrição Financeira=1:5000                                              |            1 |        1 |            0 | 
 		#	| augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | rg				                         | CPF=1:5000,RG=1:5000                                                                |            1 |        1 |            0 | 


  @createList @segmentacao @segmentacaopf @teste5_spf @Chrome
  Scenario Outline: Quantity of Cpf to zero -  PF
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes changing quantity to zero using attibutes as "<atributos>"

  Examples: 
      |    username                        	 |   password                           	| genero  | faixaetaria              | renda  | escolaridade  | restricao | bens | state        | city                          | neighborhood                 | profissao                                      |  nomedaLista                           | atributos																																			              		 | typeDownload | typeList | combinedBase |
   	  | augusto.menin@spcbrasil.org.br  	   | spcdados@2019                  		   	|     11  |   020080			           | 000000 | 0000000000000 |         2 |    2 |              |                   		     	  |                              |                                                | cpfNome						                     | CPF=1:5000,Nome=1:5000                                                                            |            1 |        1 |            0 |
    
  @createList @segmentacao @segmentacaopf @teste6_spf @Chrome
  Scenario Outline: Quantity of Cpf to zero - On cart- PF
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>  "
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should change the quantity of my attribute to zero

   Examples: 
      |    username  				               	 |   password		      	| genero | faixaetaria             | renda  | escolaridade  | restricao | bens | state        | city   | neighborhood                 | profissao          |  nomedaLista  | atributos                                 														                                                                                                             																																																																																																																																																																																																																																																									| typeDownload | typeList | combinedBase |
   	  | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		   	|     11 |   020080		             | 000000 | 0000000000000 |         2 |    2 |              |        |                              |                    | feminino1     | CPF=1:5000,Nome=1:5000,Situacao RF=1:5000                                                                        |            1 |        1 |            0 |
    
       
  @createList @segmentacao @segmentacaopf @teste7_spf @Chrome
  Scenario Outline: Create List - PF - one filter
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And verify two filters message 
  Examples: 
      |    username  				               	 |   password		      	| genero | faixaetaria             | renda  | escolaridade  | restricao | bens | state        | city   | neighborhood                 | profissao          |  nomedaLista  | atributos                                 														                                            | typeDownload | typeList | combinedBase |
   	  | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		   	|     11 |   020080		             | 000000 | 0000000000000 |         2 |    2 |              |        |                              |                    | feminino1     | CPF=1:5000,Nome=1:5000,Situacao RF=1:5000                                                                        |            1 |        1 |            0 |
     
      
  @createList @segmentacao @segmentacaopf @teste8_spf @Chrome
  Scenario Outline: Create List - PF - uncheck attributes
    Given I open the homepage
    And I provide the username as "<username>"
    And I click continue button
    And I verify if the username exists as "<username>"
    And I provide the password as "<password>"
    And I click to login button
    And I should start choosing my filter to create my list as "<nomedaLista>"
    And I should choose filter gender as "<genero>"
    And I should choose filter faixetaria as "<faixaetaria>"
    And I should choose filter localizationPF as "<state>" and "<city>" and "<neighborhood>"
    And I should choose filter profissao as "<profissao>"
    And I should choose filter renda as  "<renda>"
    And I should choose filter escolaridade as "<escolaridade>"
    And I should choose filter restricao as  "<restricao>"
    And I should choose filter bens as  "<bens>"
    And I should choose the type of my list as "<typeList>"
    And I should choose the attributes as "<atributos>" and "<combinedBase>"
    And I should click menu Create List
    And I should create a list as "<nomedaLista>"
    And I should uncheck attributes
    Examples: 
      |    username  				               	 |   password		      	| genero | faixaetaria             | renda  | escolaridade  | restricao | bens | state        | city   | neighborhood                 | profissao          |  nomedaLista  | atributos                                 														                                            | typeDownload | typeList | combinedBase |
   	  | augusto.menin@spcbrasil.org.br  	   | spcdados@2019		   	|     11 |   020080		             | 000000 | 0000000000000 |         2 |    2 |              |        |                              |                    | feminino1     | CPF=1:5000,Nome=1:5000,Situacao RF=1:5000                                                                        |            1 |        1 |            0 |
     
      
  