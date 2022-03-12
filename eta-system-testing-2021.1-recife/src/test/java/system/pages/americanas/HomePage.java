package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class HomePage extends BasePage {
    @FindBy(name = "conteudo")
    protected WebElement busqueAquiSeuProduto;

    @FindBy(xpath = "//h1[@class = 'full-grid__Title-sc-19t7jwc-3 jstCvu']")
    protected WebElement resultadoParaProduto;

    @FindBy(xpath = "//form[@action = '/busca']//button")
    protected WebElement botaoLupa;

    @FindBy(xpath = "//button[text() = 'continuar e fechar']")
    protected WebElement aceitarCookies;
}
