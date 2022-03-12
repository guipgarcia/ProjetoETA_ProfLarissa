package system.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import system.actions.americanas.CestaAction;
import system.actions.americanas.DetalhesProdutoAction;
import system.actions.americanas.HomeAction;
import system.actions.americanas.ResultadoBuscaAction;
import system.actions.demo_selenium_easy.SeleniumEasyHomeAction;
import system.actions.demo_selenium_easy.TableSortAndSearchDemoAction;
import system.base.DriverFactory;

import static system.helpers.VariaveisGlobais.DEFAULT_BROWSER;

public class StepDefinitions {
    public static Scenario scenario;
    private SeleniumEasyHomeAction sEHomeAction = new SeleniumEasyHomeAction();
    private TableSortAndSearchDemoAction tableSortAndSearchDemoAction = new TableSortAndSearchDemoAction();
    private HomeAction americanasHomeAction = new HomeAction();
    private ResultadoBuscaAction resultadoBuscaAction = new ResultadoBuscaAction();
    private DetalhesProdutoAction detalhesProdutoAction = new DetalhesProdutoAction();
    private CestaAction cestaAction = new CestaAction();
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
    @Given("that I access demo selenium easy application")
    public void that_i_access_demo_selenium_easy_application() {
        sEHomeAction.accessApplication();
    }
    @When("I select the {string} and {string}")
    public void i_select_the_and(String menuItem, String submenuItem) {
        sEHomeAction.selectHomeOption(menuItem, submenuItem);
    }
    @When("I change name position")
    public void i_change_name_position() {
        tableSortAndSearchDemoAction.changeNamePosition();
    }
    @Then("The {string} position was changed")
    public void the_position_was_changed(String name) {
        tableSortAndSearchDemoAction.isNameChangePosition(name);
    }


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
}
