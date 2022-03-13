package system.pages.americanas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import system.base.BasePage;

public class ProcurarLojasPage extends BasePage {
        @FindBy (xpath = "//*[@id=\'rsyswpsdk\']/div/header/div[1]/div[1]/div/div[3]/a[1]")
        protected  WebElement botaoBuscarLojas;

        @FindBy (css = "input[placeholder*='procure']")
        protected  WebElement caixaDeTextoBuscarCep;

        @FindBy (css = "input[placeholder*='procure'] + img")
        protected  WebElement botaoLupa;

        @FindBy (css = ".sc-bTDOke:first-child" )
        protected WebElement primeiraLojaMaisProxima;
}
