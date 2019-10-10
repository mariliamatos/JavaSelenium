$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/gsw.mariliam/eclipse-workspace/testes-automatizados2/src/test/resources/functionalTests/Enriquecimento.feature");
formatter.feature({
  "line": 1,
  "name": "\"Enriquecimento\"",
  "description": "",
  "id": "\"enriquecimento\"",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 132,
  "name": "Qualify List - Special Files",
  "description": "",
  "id": "\"enriquecimento\";qualify-list---special-files",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 131,
      "name": "@createList"
    },
    {
      "line": 131,
      "name": "@enrich"
    },
    {
      "line": 131,
      "name": "@teste6_e"
    },
    {
      "line": 131,
      "name": "@Chrome"
    }
  ]
});
formatter.step({
  "line": 133,
  "name": "I open the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 134,
  "name": "I provide the username as \"\u003cusername\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 135,
  "name": "I click continue button",
  "keyword": "And "
});
formatter.step({
  "line": 136,
  "name": "I verify if the username exists as \"\u003cusername\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 137,
  "name": "I provide the password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 138,
  "name": "I click to login button",
  "keyword": "And "
});
formatter.step({
  "line": 139,
  "name": "I click on Qualificar Button",
  "keyword": "And "
});
formatter.step({
  "line": 140,
  "name": "I choose the list type as \u003ctypeList\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 141,
  "name": "I should choose the type of my list as \"\u003ctypeList\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 142,
  "name": "I click on Upload File button",
  "keyword": "And "
});
formatter.step({
  "line": 143,
  "name": "I verify if file is empty",
  "keyword": "And "
});
formatter.examples({
  "line": 144,
  "name": "",
  "description": "",
  "id": "\"enriquecimento\";qualify-list---special-files;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "nomedaLista",
        "atributos",
        "typeDownload",
        "typeList"
      ],
      "line": 145,
      "id": "\"enriquecimento\";qualify-list---special-files;;1"
    },
    {
      "cells": [
        "augusto.menin@spcbrasil.org.br",
        "spcdados@2019",
        "qualificarPF",
        "CPF\u003d1:2,Nome\u003d1:2",
        "1",
        "3"
      ],
      "line": 146,
      "id": "\"enriquecimento\";qualify-list---special-files;;2"
    },
    {
      "cells": [
        "augusto.menin@spcbrasil.org.br",
        "spcdados@2019",
        "qualificarPJ",
        "CNPJ\u003d1:2,Razao Social\u003d1:2",
        "1",
        "4"
      ],
      "line": 147,
      "id": "\"enriquecimento\";qualify-list---special-files;;3"
    },
    {
      "cells": [
        "augusto.menin@spcbrasil.org.br",
        "spcdados@2019",
        "qualificarPJ",
        "CNPJ\u003d1:2,Razao Social\u003d1:2",
        "1",
        "5"
      ],
      "line": 148,
      "id": "\"enriquecimento\";qualify-list---special-files;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 166891,
  "status": "passed"
});
formatter.before({
  "duration": 5829865000,
  "status": "passed"
});
formatter.before({
  "duration": 120448,
  "status": "passed"
});
formatter.before({
  "duration": 52484,
  "status": "passed"
});
formatter.before({
  "duration": 51351,
  "status": "passed"
});
formatter.before({
  "duration": 79292,
  "status": "passed"
});
formatter.before({
  "duration": 78914,
  "status": "passed"
});
formatter.before({
  "duration": 77781,
  "status": "passed"
});
formatter.scenario({
  "line": 146,
  "name": "Qualify List - Special Files",
  "description": "",
  "id": "\"enriquecimento\";qualify-list---special-files;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 131,
      "name": "@teste6_e"
    },
    {
      "line": 131,
      "name": "@Chrome"
    },
    {
      "line": 131,
      "name": "@enrich"
    },
    {
      "line": 131,
      "name": "@createList"
    }
  ]
});
formatter.step({
  "line": 133,
  "name": "I open the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 134,
  "name": "I provide the username as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 135,
  "name": "I click continue button",
  "keyword": "And "
});
formatter.step({
  "line": 136,
  "name": "I verify if the username exists as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 137,
  "name": "I provide the password as \"spcdados@2019\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 138,
  "name": "I click to login button",
  "keyword": "And "
});
formatter.step({
  "line": 139,
  "name": "I click on Qualificar Button",
  "keyword": "And "
});
formatter.step({
  "line": 140,
  "name": "I choose the list type as 3",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 141,
  "name": "I should choose the type of my list as \"3\"",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 142,
  "name": "I click on Upload File button",
  "keyword": "And "
});
formatter.step({
  "line": 143,
  "name": "I verify if file is empty",
  "keyword": "And "
});
formatter.match({
  "location": "StepsHomePage.i_open_the_homepage()"
});
formatter.result({
  "duration": 7324217520,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_username_as(String)"
});
formatter.result({
  "duration": 897791075,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_continue_button()"
});
formatter.result({
  "duration": 1285993858,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 36
    }
  ],
  "location": "StepsLogin.i_verify_if_the_username_exists_as(String)"
});
formatter.result({
  "duration": 15125148483,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "spcdados@2019",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_wrong_password_as(String)"
});
formatter.result({
  "duration": 338817447,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_to_login_button()"
});
formatter.result({
  "duration": 850432972,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Qualificar_Button()"
});
formatter.result({
  "duration": 29487200757,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 26
    }
  ],
  "location": "StepsEnrich.i_choose_the_list_type_as(int)"
});
formatter.result({
  "duration": 651607853,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 40
    }
  ],
  "location": "StepsSegmentation.i_should_choose_the_type_of_my_list_as(String)"
});
formatter.result({
  "duration": 6295408,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Upload_File_button()"
});
formatter.result({
  "duration": 7781418708,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_verify_if_file_is_empty()"
});
formatter.result({
  "duration": 3377920873,
  "status": "passed"
});
formatter.after({
  "duration": 4736605502,
  "status": "passed"
});
formatter.before({
  "duration": 49464,
  "status": "passed"
});
formatter.before({
  "duration": 4674166811,
  "status": "passed"
});
formatter.before({
  "duration": 55127,
  "status": "passed"
});
formatter.before({
  "duration": 24921,
  "status": "passed"
});
formatter.before({
  "duration": 24165,
  "status": "passed"
});
formatter.before({
  "duration": 33604,
  "status": "passed"
});
formatter.before({
  "duration": 31339,
  "status": "passed"
});
formatter.before({
  "duration": 26053,
  "status": "passed"
});
formatter.scenario({
  "line": 147,
  "name": "Qualify List - Special Files",
  "description": "",
  "id": "\"enriquecimento\";qualify-list---special-files;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 131,
      "name": "@teste6_e"
    },
    {
      "line": 131,
      "name": "@Chrome"
    },
    {
      "line": 131,
      "name": "@enrich"
    },
    {
      "line": 131,
      "name": "@createList"
    }
  ]
});
formatter.step({
  "line": 133,
  "name": "I open the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 134,
  "name": "I provide the username as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 135,
  "name": "I click continue button",
  "keyword": "And "
});
formatter.step({
  "line": 136,
  "name": "I verify if the username exists as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 137,
  "name": "I provide the password as \"spcdados@2019\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 138,
  "name": "I click to login button",
  "keyword": "And "
});
formatter.step({
  "line": 139,
  "name": "I click on Qualificar Button",
  "keyword": "And "
});
formatter.step({
  "line": 140,
  "name": "I choose the list type as 4",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 141,
  "name": "I should choose the type of my list as \"4\"",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 142,
  "name": "I click on Upload File button",
  "keyword": "And "
});
formatter.step({
  "line": 143,
  "name": "I verify if file is empty",
  "keyword": "And "
});
formatter.match({
  "location": "StepsHomePage.i_open_the_homepage()"
});
formatter.result({
  "duration": 6979932322,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_username_as(String)"
});
formatter.result({
  "duration": 876430938,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_continue_button()"
});
formatter.result({
  "duration": 1127994690,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 36
    }
  ],
  "location": "StepsLogin.i_verify_if_the_username_exists_as(String)"
});
formatter.result({
  "duration": 15094275569,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "spcdados@2019",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_wrong_password_as(String)"
});
formatter.result({
  "duration": 250650761,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_to_login_button()"
});
formatter.result({
  "duration": 803604993,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Qualificar_Button()"
});
formatter.result({
  "duration": 26967127794,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 26
    }
  ],
  "location": "StepsEnrich.i_choose_the_list_type_as(int)"
});
formatter.result({
  "duration": 590139547,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 40
    }
  ],
  "location": "StepsSegmentation.i_should_choose_the_type_of_my_list_as(String)"
});
formatter.result({
  "duration": 1386100,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Upload_File_button()"
});
formatter.result({
  "duration": 7660818188,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_verify_if_file_is_empty()"
});
formatter.result({
  "duration": 3380852790,
  "status": "passed"
});
formatter.after({
  "duration": 4658105268,
  "status": "passed"
});
formatter.before({
  "duration": 33605,
  "status": "passed"
});
formatter.before({
  "duration": 4706431867,
  "status": "passed"
});
formatter.before({
  "duration": 34360,
  "status": "passed"
});
formatter.before({
  "duration": 26808,
  "status": "passed"
});
formatter.before({
  "duration": 19256,
  "status": "passed"
});
formatter.before({
  "duration": 19257,
  "status": "passed"
});
formatter.before({
  "duration": 19635,
  "status": "passed"
});
formatter.before({
  "duration": 27564,
  "status": "passed"
});
formatter.scenario({
  "line": 148,
  "name": "Qualify List - Special Files",
  "description": "",
  "id": "\"enriquecimento\";qualify-list---special-files;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 131,
      "name": "@teste6_e"
    },
    {
      "line": 131,
      "name": "@Chrome"
    },
    {
      "line": 131,
      "name": "@enrich"
    },
    {
      "line": 131,
      "name": "@createList"
    }
  ]
});
formatter.step({
  "line": 133,
  "name": "I open the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 134,
  "name": "I provide the username as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 135,
  "name": "I click continue button",
  "keyword": "And "
});
formatter.step({
  "line": 136,
  "name": "I verify if the username exists as \"augusto.menin@spcbrasil.org.br\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 137,
  "name": "I provide the password as \"spcdados@2019\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 138,
  "name": "I click to login button",
  "keyword": "And "
});
formatter.step({
  "line": 139,
  "name": "I click on Qualificar Button",
  "keyword": "And "
});
formatter.step({
  "line": 140,
  "name": "I choose the list type as 5",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 141,
  "name": "I should choose the type of my list as \"5\"",
  "matchedColumns": [
    5
  ],
  "keyword": "And "
});
formatter.step({
  "line": 142,
  "name": "I click on Upload File button",
  "keyword": "And "
});
formatter.step({
  "line": 143,
  "name": "I verify if file is empty",
  "keyword": "And "
});
formatter.match({
  "location": "StepsHomePage.i_open_the_homepage()"
});
formatter.result({
  "duration": 6800528463,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_username_as(String)"
});
formatter.result({
  "duration": 1373492980,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_continue_button()"
});
formatter.result({
  "duration": 1417256889,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "augusto.menin@spcbrasil.org.br",
      "offset": 36
    }
  ],
  "location": "StepsLogin.i_verify_if_the_username_exists_as(String)"
});
formatter.result({
  "duration": 15111006564,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "spcdados@2019",
      "offset": 27
    }
  ],
  "location": "StepsLogin.i_provide_the_wrong_password_as(String)"
});
formatter.result({
  "duration": 312569145,
  "status": "passed"
});
formatter.match({
  "location": "StepsLogin.i_click_to_login_button()"
});
formatter.result({
  "duration": 865137866,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Qualificar_Button()"
});
formatter.result({
  "duration": 25413626070,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 26
    }
  ],
  "location": "StepsEnrich.i_choose_the_list_type_as(int)"
});
formatter.result({
  "duration": 574360057,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "5",
      "offset": 40
    }
  ],
  "location": "StepsSegmentation.i_should_choose_the_type_of_my_list_as(String)"
});
formatter.result({
  "duration": 1308696,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_click_on_Upload_File_button()"
});
formatter.result({
  "duration": 7675264061,
  "status": "passed"
});
formatter.match({
  "location": "StepsEnrich.i_verify_if_file_is_empty()"
});
formatter.result({
  "duration": 3347991910,
  "status": "passed"
});
formatter.after({
  "duration": 4417060169,
  "status": "passed"
});
});