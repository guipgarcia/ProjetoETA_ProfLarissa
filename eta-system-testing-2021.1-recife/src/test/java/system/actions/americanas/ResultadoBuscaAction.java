package system.actions.americanas;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import system.helpers.VariaveisGlobais;
import system.pages.americanas.ResultadoBuscaPage;

import static system.helpers.VariaveisGlobais.PRIMEIRO_ITEM_LISTA;
import static system.helpers.VariaveisGlobais.adicionarAoHash;

public class ResultadoBuscaAction extends ResultadoBuscaPage {
    public void validarResultadoBusca(String produto){
        Assertions.assertTrue(textoResultado.getText().contains(produto));
    }

    public void selecionarPrimeiroItemDaLista(){
        adicionarAoHash(PRIMEIRO_ITEM_LISTA,textoPrimeiroItemLista.getText());
        wait.until(ExpectedConditions.elementToBeClickable(primeiroItemLista));
        primeiroItemLista.click();
    }
}
