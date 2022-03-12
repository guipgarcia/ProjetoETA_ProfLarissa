package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class DetalhesProdutoPage extends BasePage {
    @FindBy(xpath = "//h1[contains(@class, 'product-title')]")
    protected WebElement nomeProduto;

    @FindBy(xpath = "//div[contains(@class, 'priceSales')]")
    protected WebElement precoProduto;

    @FindBy(xpath = "//span[contains(@class, 'freight-option-price')]")
    protected WebElement opcaoFreteTexto;

    @FindBy(xpath = "//span[text() = 'comprar']/ancestor::a")
    protected WebElement botaoComprar;

    @FindBy(xpath = "//a[text() = 'ir para cesta']")
    protected WebElement botaoIrParaACesta;
}
