package system.actions.americanas;

import org.openqa.selenium.support.ui.ExpectedConditions;
import system.pages.americanas.HomePage;

import static system.helpers.VariaveisGlobais.AMERICANAS_URL;

public class HomeAction extends HomePage {
    public void acessarAmericas(){
        driver.get(AMERICANAS_URL);
        try{
            wait.until(ExpectedConditions.visibilityOf(aceitarCookies));
            aceitarCookies.click();
        }catch(Exception e){
            System.out.println("O botão de aceitar cookies não foi apresentado durante a execução");
        }
    }

    public void buscarProduto(String produto){
        busqueAquiSeuProduto.sendKeys(produto);
        botaoLupa.click();
    }
}

