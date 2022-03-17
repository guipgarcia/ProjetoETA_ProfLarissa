#language:pt

  Funcionalidade: Compartilhamento de produtos da aplicação Americanas.com

    @Americanas
    Cenario: Compartilhar atraves de WhatsApp o produto pesquisado
      Dado que eu acesso aplicacao da americanas
      E usando a barra de pesquisa efetuo uma busca por "Tdd com Python"
      E seleciono o primeiro produto da lista
      Quando Clico na opcao de compartilhar via "WhatsApp"
      Entao E apresentada a Tela da aplicacao de compartilhamento
