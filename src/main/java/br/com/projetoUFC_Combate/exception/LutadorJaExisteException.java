package br.com.projetoUFC_Combate.exception;

public class LutadorJaExisteException extends RuntimeException{
    public LutadorJaExisteException(String msg) {
        super(msg);
    }
}
