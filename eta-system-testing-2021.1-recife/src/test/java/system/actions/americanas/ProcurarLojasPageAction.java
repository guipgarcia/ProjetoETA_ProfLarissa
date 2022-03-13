package system.actions.americanas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import system.pages.americanas.ProcurarLojasPage;

public class ProcurarLojasPageAction extends ProcurarLojasPage {

    public void  clicarNoBotaoBuscarLojas(){

        botaoBuscarLojas.click();

    }
    public void clicarNoBotaoLupa(){

        botaoLupa.click();

    }
    public void inserirCep(String cep){
        caixaDeTextoBuscarCep.sendKeys(cep);
        caixaDeTextoBuscarCep.sendKeys(Keys.ENTER);
    }
    public  void validarExistenciaDeLojaProxima(){
       Assertions.assertTrue(primeiraLojaMaisProxima.isDisplayed());


    }


}
