#language: pt
Funcionalidade: Cadastro Pet

  @cadastro_pet @sanity @smoke @sucesso
  Cenario: Verifico que é possivel cadastrar um novo pet com dados validos
    Dado que preencho os dados minimos do pet como
    | raca    | nome  | status    |
    | Chiuaua | brutus | available |
    Entao valido que o pet foi cadastrado com sucesso