package system.actions.americanas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.pages.americanas.DetalhesProdutoPage;

import static system.helpers.VariaveisGlobais.*;

public class DetalhesProdutoAction extends DetalhesProdutoPage {

    public void validarNomeProduto(){
        Assertions.assertEquals(recuperarValorHash(PRIMEIRO_ITEM_LISTA).toUpperCase(), nomeProduto.getText().toUpperCase());
    }

    public void salvarTextoPrecoProduto(){
        validarNomeProduto();
        adicionarAoHash(PRECO_PRODUTO, precoProduto.getText());
    }

    public void clicarBotaoComprar(){
        botaoComprar.click();
        try{
            wait.until(ExpectedConditions.visibilityOf(continuarBtn));
            continuarBtn.click();
        }catch (Exception e){
            System.out.println();
        }
    }

    public void clicarBotaoIrParaCesta(){
        botaoIrParaACesta.click();
    }

    public void clicarNoBotaoCompartilhar(){
        wait.until(ExpectedConditions.invisibilityOf(cepSplash));
        botaoCompartilhar.click();
    }

    public void escolherFuncaoCompartilhamento(String opcao){
        switch (opcao){
            case "WhatsApp":
                clicaNaOpcaoWhatsApp();
                break;
            case "Pinterest":
                // Função será desenvolvida na próxima release
                break;
            case "Facebook":
                // Função será desenvolvida na próxima release
                break;
            case "Twitter":
                // Função será desenvolvida na próxima release
                break;
        }
    }

    public void clicaNaOpcaoWhatsApp(){
        opcaoCompartilharPorWhatsApp.click();
    }

    public void validarTelaDeCompartilhamentoViaWhatsApp(){
        for(String janela:driver.getWindowHandles()) {
            driver.switchTo().window(janela);
            if(driver.getTitle().contains("WhatsApp"))
                break;
        }

        Assertions.assertAll( "Não é a tela de compartilhamento via WhatsApp",
                () -> Assertions.assertEquals("WHATSAPP WEB", whatsAppSharePageTitle.getText()),
                () -> Assertions.assertEquals("WhatsApp", driver.getTitle()),
                () -> Assertions.assertEquals("WhatsApp", driver.getTitle())
        );

    }

}
