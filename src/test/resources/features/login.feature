Feature: Login

  Como usuário da aplicação
  Quero realizar login
  Para acessar a área autenticada

  Scenario: Login com credenciais válidas
    Given que estou na página de login
    When informo um usuário válido
    And informo uma senha válida
    And clico no botão de login
    Then devo acessar a página de produtos

#  Scenario: Login com credenciais inválidas
#    Given que estou na página de login
#    When informo um usuário inválido
#    And informo uma senha inválida
#    And clico no botão de login
#    Then devo visualizar uma mensagem de erro