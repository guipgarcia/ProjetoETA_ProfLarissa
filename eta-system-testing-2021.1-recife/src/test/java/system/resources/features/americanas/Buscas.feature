#language: pt

  Funcionalidade: Realizar buscas na aplicacao Americanas.com

  @Americanas
  Cenario: Buscar por cama usando a barra de pesquisa
    Dado que eu acesso aplicacao da americanas
    Quando usando a barra de pesquisa efetuo uma busca por "cama"
    Entao sao exibidos os resultados para cama

  @Americanas
  Cenario: Buscar uma loja Americanas mais proxima
    Dado que eu acesso aplicacao da americanas
    Quando eu clicar no icone loja do header
    E digitar um cep
    Entao um mapa e exibido com as lojas mais proximas

