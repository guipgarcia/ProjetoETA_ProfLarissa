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

    @FindBy(xpath = "//span[text() = 'sim, continuar']")
    protected WebElement continuarBtn;

    @FindBy(xpath = "//a[text() = 'ir para cesta']")
    protected WebElement botaoIrParaACesta;

    @FindBy(css = "div:nth-child(2) p[class*='src__Title']")
    protected WebElement botaoCompartilhar;

    @FindBy(css = "button[value='whatsapp']")
    protected WebElement opcaoCompartilharPorWhatsApp;

    @FindBy(css = "p[class*='cep-tooltip']")
    protected WebElement cepSplash;

    @FindBy(css = ".landing-header svg")
    protected WebElement whatsAppIcon;

    @FindBy(css = ".landing-headerTitle")
    protected WebElement whatsAppSharePageTitle;




}
