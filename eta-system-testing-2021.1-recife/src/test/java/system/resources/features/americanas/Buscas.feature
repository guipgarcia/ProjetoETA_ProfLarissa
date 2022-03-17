#language: pt

  Funcionalidade: Realizar buscas na aplicacao Americanas.com

  @Americanas
  Cenario: Buscar por cama usando a barra de pesquisa
    Dado que eu acesso aplicacao da americanas
    Quando eu pesquiso por cama usando a barra de pesquisa
    Entao sao exibidos os resultados para cama

  @Americanas
  Cenario: Adicionar produto a cesta
    Dado que eu acesso aplicacao da americanas
    Quando eu pesquiso por cama usando a barra de pesquisa
    E sao exibidos os resultados para cama
    E seleciono o primeiro produto da lista
    E clico no botao comprar da tela de detalhes do produto
    E clico no botao ir para cesta
    Entao valido o preco e a quantidade do produto na cesta
    Entao valido o preco e a quantidade do produto na cesta

  @Americanas
  Cenario: Procurar uma loja Americanas mais proxima
    Dado que eu acesso aplicacao da americanas
    Quando eu clicar no icone loja do header
    E digitar um cep
    Entao um mapa e exibido com as lojas mais proximas

  @Americanas
  Cenario: Compartilhar atraves de WhatsApp o produto pesquisado
    Dado que eu acesso aplicacao da americanas
    E usando a barra de pesquisa efetuo uma busca por "Tdd com Python"
    E seleciono o primeiro produto da lista
    Quando Clico na opcao de compartilhar via "WhatsApp"
    Entao E apresentada a Tela da aplicacao de compartilhamento
