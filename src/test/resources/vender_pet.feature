#language: pt
Funcionalidade: Venda de Pet

  @venda_pet @sanity @smoke @sucesso
  Cenario: Verifico que é possivel realizar venda de pet cadastrado e disponivel
    Dado que preencho os dados para a venda
    Entao valido que o pet foi vendido com sucesso