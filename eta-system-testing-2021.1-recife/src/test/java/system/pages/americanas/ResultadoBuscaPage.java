package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class ResultadoBuscaPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'full-grid__Title-sc-19t7jwc-3 jstCvu']")
    protected WebElement textoResultado;

    @FindBy(xpath = "//div[contains(@class, 'src__GridItem')]/div[1]//picture")
    protected WebElement primeiroItemLista;

    @FindBy(xpath = "//div[contains(@class, 'src__GridItem')]/div[1]//h3")
    protected WebElement textoPrimeiroItemLista;
}
