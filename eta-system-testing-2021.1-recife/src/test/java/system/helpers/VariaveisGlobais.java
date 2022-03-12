package system.helpers;

import java.util.HashMap;

final public class VariaveisGlobais {

    private VariaveisGlobais(){}

    static final public String CHROME_DRIVER_PATH = "src/test/resources/chromedriver";
    static final public String DEFAULT_BROWSER = "chrome";
    static final public String SELENIUM_EASY_URL = "https://demo.seleniumeasy.com/";
    static final public String AMERICANAS_URL = "https://www.americanas.com.br/";
    static final public String PRIMEIRO_ITEM_LISTA = "PRIMEIRO_ITEM_LISTA";
    static final public String PRECO_PRODUTO = "PRECO_PRODUTO";
    static final public String PRECO_FRETE = "PRECO_FRETE";


    private static HashMap<String,String> salvarValores = new HashMap<>();

    public static void adicionarAoHash(String chave, String valor){
        salvarValores.put(chave,valor);
    }

    public static String recuperarValorHash(String chave){
        String valor = null;
        if(salvarValores.containsKey(chave)){
            valor =salvarValores.get(chave);
        }
        return valor;
    }

    public static void limparHash(){
        salvarValores.clear();
    }
}