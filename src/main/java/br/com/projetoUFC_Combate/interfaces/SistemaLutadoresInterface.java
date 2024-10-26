package br.com.projetoUFC_Combate.interfaces;

import br.com.projetoUFC_Combate.Lutador;
import br.com.projetoUFC_Combate.exception.LutadorInexistenteException;
import br.com.projetoUFC_Combate.exception.LutadorJaExisteException;

public interface SistemaLutadoresInterface {
    void cadastrarLutador(Lutador lutador) throws LutadorJaExisteException;
    Lutador pesquisarLutador(String nome) throws LutadorInexistenteException;
    void apagarLutador(String nome) throws LutadorInexistenteException;
}
