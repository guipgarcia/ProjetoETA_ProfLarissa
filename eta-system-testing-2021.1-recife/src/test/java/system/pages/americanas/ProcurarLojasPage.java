package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class ProcurarLojasPage extends BasePage {
        @FindBy (xpath = "//*[@id='rsyswpsdk']//a[contains(@class, 'StoreLink')]")
        protected  WebElement botaoBuscarLojas;

        @FindBy (css = "input[placeholder*='procure']")
        protected  WebElement caixaDeTextoBuscarCep;

        @FindBy (css = ".sc-bTDOke:first-child" )
        protected WebElement primeiraLojaMaisProxima;
}
