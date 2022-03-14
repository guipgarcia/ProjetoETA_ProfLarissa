package system.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import system.actions.americanas.*;
import system.base.DriverFactory;

import static system.helpers.VariaveisGlobais.DEFAULT_BROWSER;

public class StepDefinitions {
    public static Scenario scenario;
    private HomeAction americanasHomeAction = new HomeAction();
    private ResultadoBuscaAction resultadoBuscaAction = new ResultadoBuscaAction();
    private DetalhesProdutoAction detalhesProdutoAction = new DetalhesProdutoAction();
    private CestaAction cestaAction = new CestaAction();
    private ProcurarLojasPageAction procurarLojasAction = new ProcurarLojasPageAction();
    private String produtoCama = "cama";

    @Before
    public void before(Scenario currentScenario){
        scenario = currentScenario;
        System.out.println("Scenario Name - " + scenario.getName());
        System.out.println("Executing scenario on: " + DEFAULT_BROWSER);
        System.out.println(" ############## BEFORE ##############");
    }

    @After
    public void after(){
        System.out.println(" ############## AFTER ##############");
        System.out.println("Scenario Name - " + scenario.getName());
        System.out.println("Status - " + scenario.getStatus());
        DriverFactory.quitDriver();
    }

    // ########### SCENARIO'S STEPS ###########

    @Dado("que eu acesso aplicacao da americanas")
    public void queEuAcessoAplicacaoDaAmericanas() {
        americanasHomeAction.acessarAmericas();
    }

    @Quando("eu pesquiso por cama usando a barra de pesquisa")
    public void euPesquisoPorCamaUsandoABarraDePesquisa() {
        americanasHomeAction.buscarProduto(produtoCama);

    }

    @Entao("sao exibidos os resultados para cama")
    public void saoExibidosOsResultadosParaCama() {
        resultadoBuscaAction.validarResultadoBusca(produtoCama);
    }

    @E("seleciono o primeiro produto da lista")
    public void selecionoOPrimeiroProdutoDaLista() {
        resultadoBuscaAction.selecionarPrimeiroItemDaLista();
    }

    @E("clico no botao comprar da tela de detalhes do produto")
    public void clicoNoBotaoComprarDaTelaDeDetalhesDoProduto() {
        detalhesProdutoAction.salvarTextoPrecoProduto();
        detalhesProdutoAction.clicarBotaoComprar();
    }

    @E("clico no botao ir para cesta")
    public void clicoNoBotaoIrParaCesta() {
        detalhesProdutoAction.clicarBotaoIrParaCesta();
    }

    @Entao("valido o preco e a quantidade do produto na cesta")
    public void validoOPrecoEAQuantidadeDoProdutoNaCesta() {
        cestaAction.validarDadosCarrinho();
    }

    @Quando("eu clicar no icone loja do header")
    public void clicarNoIconeLojaDoHeader() {
        procurarLojasAction.clicarNoBotaoBuscarLojas();
    }

    @Quando("digitar um cep")
    public void inserirCep() {
        procurarLojasAction.inserirCep("52040220");

    }

    @Entao("um mapa e exibido com as lojas mais proximas")
    public void MapaExibidoComAsLojasMaisProximas() {
        procurarLojasAction.validarExistenciaDeLojaProxima();

    }

    @Dado("usando a barra de pesquisa efetuo uma busca por {string}")
    public void usandoABarraDePesquisaEfetuoUmaBuscaPor(String produto) {
        americanasHomeAction.buscarProduto(produto);

    }

    @Quando("Clico na opcao de compartilhar via {string}")
    public void clicoNaOpcaoDeCompartilharVia(String opcao) {
        detalhesProdutoAction.clicarNoBotaoCompartilhar();
        if(opcao.contains("WhatsApp")){detalhesProdutoAction.clicaNaOpcaoWhatsApp();}
        if(opcao.contains("Pinterest")){}
        if(opcao.contains("Facebook")){}
        if(opcao.contains("Twitter")){}
    }

    @Entao("E apresentada a Tela da aplicacao de compartilhamento")
    public void eApresentadaATelaDaAplicacaoDeCompartilhamento() {
        detalhesProdutoAction.validarTelaDeCompartilhamentoViaWhatsApp();
    }

}
