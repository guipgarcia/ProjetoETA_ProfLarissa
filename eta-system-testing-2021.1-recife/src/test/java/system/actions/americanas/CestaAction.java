package system.actions.americanas;

import org.junit.jupiter.api.Assertions;
import system.pages.americanas.CestaPage;

import static system.helpers.VariaveisGlobais.PRECO_PRODUTO;
import static system.helpers.VariaveisGlobais.recuperarValorHash;

public class CestaAction extends CestaPage {

    public void validarDadosCarrinho(){
        Assertions.assertEquals(recuperarValorHash(PRECO_PRODUTO), precoProduto.getText());
        Assertions.assertEquals("1", quantidade.getAttribute("value"));
    }
}
