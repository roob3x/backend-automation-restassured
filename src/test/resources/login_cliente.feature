#language: pt
Funcionalidade: Login Cliente

  @login @sanity @smoke @sucesso
  Cenario: Verifico que é possivel logar com usuario valido
    Dado que preencho usuario "mariaassuncao" e senha "12345678"
    Entao valido que o usuario foi logado com sucesso