#language:pt

  Funcionalidade: Realizar ações na Cesta da aplicação da Americas.com

    @Americanas
    Cenario: Adicionar produto a cesta
      Dado que eu acesso aplicacao da americanas
      Quando usando a barra de pesquisa efetuo uma busca por "cama"
      E sao exibidos os resultados para cama
      E seleciono o primeiro produto da lista
      E clico no botao comprar da tela de detalhes do produto
      E clico no botao ir para cesta
      Entao valido o preco e a quantidade do produto na cesta