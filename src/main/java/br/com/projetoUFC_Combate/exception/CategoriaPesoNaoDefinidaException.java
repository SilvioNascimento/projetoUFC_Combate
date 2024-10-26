package br.com.projetoUFC_Combate.exception;

public class CategoriaPesoNaoDefinidaException extends IllegalArgumentException{

    public CategoriaPesoNaoDefinidaException(String msg) {
        super(msg);
    }
}