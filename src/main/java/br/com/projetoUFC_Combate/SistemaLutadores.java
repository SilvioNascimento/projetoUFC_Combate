package br.com.projetoUFC_Combate;

import br.com.projetoUFC_Combate.exception.LutadorInexistenteException;
import br.com.projetoUFC_Combate.exception.LutadorJaExisteException;
import br.com.projetoUFC_Combate.interfaces.SistemaLutadoresInterface;

import java.util.LinkedHashMap;
import java.util.Map;

public class SistemaLutadores implements SistemaLutadoresInterface {
    private Map<String, Lutador> lutadores;

    public SistemaLutadores() {
        this.lutadores = new LinkedHashMap<>();
    }

    public void cadastrarLutador(Lutador lutador) throws LutadorJaExisteException{
        if(lutadores.containsKey(lutador.getNome())) {
            throw new LutadorJaExisteException("Lutador " + lutador.getNome() + " já existe!");
        }
        this.lutadores.put(lutador.getNome(), lutador);
        System.out.println("Lutador " + lutador.getNome() + " foi cadastrado com sucesso!");
    }

    public Lutador pesquisarLutador(String nome) throws LutadorInexistenteException{
        if(!lutadores.containsKey(nome)) {
            throw new LutadorInexistenteException("Lutador " + nome + " não existe!");
        }
        return lutadores.get(nome);
    }

    public void apagarLutador(String nome) throws LutadorInexistenteException{
        if(!lutadores.containsKey(nome)) {
            throw new LutadorInexistenteException("Lutador " + nome + " não existe!");
        }
        lutadores.remove(nome);
        System.out.println("Lutador " + nome + " foi removido das lutas para sempre.");
    }


}