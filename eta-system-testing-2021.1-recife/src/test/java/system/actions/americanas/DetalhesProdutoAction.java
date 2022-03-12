package system.actions.americanas;

import org.junit.jupiter.api.Assertions;
import system.pages.americanas.DetalhesProdutoPage;

import static system.helpers.VariaveisGlobais.*;

public class DetalhesProdutoAction extends DetalhesProdutoPage {

    public void validarNomeProduto(){
        Assertions.assertEquals(recuperarValorHash(PRIMEIRO_ITEM_LISTA).toUpperCase(), nomeProduto.getText().toUpperCase());
    }

    public void salvarTextoPrecoProduto(){
        validarNomeProduto();
        adicionarAoHash(PRECO_PRODUTO, precoProduto.getText());
        //adicionarAoHash(PRECO_FRETE, opcaoFreteTexto.getText());
    }

    public void clicarBotaoComprar(){
        botaoComprar.click();
    }

    public void clicarBotaoIrParaCesta(){
        botaoIrParaACesta.click();
    }
}
