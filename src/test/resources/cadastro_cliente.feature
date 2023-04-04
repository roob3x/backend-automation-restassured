#language: pt
Funcionalidade: Cadastrar novo cliente

  @cadastro @sanity @smoke @sucesso
  Cenario: Verifico que é possivel cadastrar novo usuario ainda nao cadastrado
    Dado que preencho os dados minimos
      | username   | firstName   | lastName | email                   | password  | phone       | userStatus |
      | robertoqa  | Roberto     | Assunçao | mariadobairro@gmail.com | 12345678  | 81988117158 | 1          |
    Entao valido que o usuario foi cadastrado com sucesso