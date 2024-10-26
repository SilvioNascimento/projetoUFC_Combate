package br.com.projetoUFC_Combate;

import br.com.projetoUFC_Combate.enums.ArtesMarciais;
import br.com.projetoUFC_Combate.enums.CategoriaPeso;
import br.com.projetoUFC_Combate.enums.Nacionalidade;
import br.com.projetoUFC_Combate.enums.TipoAtaque;

import java.util.*;

public class Lutador {
    private String nome;
    private int idade;
    private double peso;
    private List<ArtesMarciais> artesMarciais;
    private Nacionalidade nacionalidade;
    private CategoriaPeso categoriaPeso;

    private Map<TipoAtaque, Integer> ataques;

    private int vitorias;
    private int derrotas;
    private int empates;

    private int pontosDeVida;

    public Lutador(String nome, int idade, double peso, List<ArtesMarciais> artesMarciais,
                   Nacionalidade nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.artesMarciais = artesMarciais;
        this.nacionalidade = nacionalidade;
        this.categoriaPeso = CategoriaPeso.definirCategoria(peso);
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.pontosDeVida = 100;

        this.ataques = new LinkedHashMap<>();
        ataques.put(TipoAtaque.SOCO, 12);
        ataques.put(TipoAtaque.CHUTE, 15);
        ataques.put(TipoAtaque.FINALIZACAO, 20);
    }

    public void aplicarAtaqueNoOponente(Lutador oponente) {
        // Converte as chaves do mapa (tipos de ataque) em uma lista para sorteio
        List<TipoAtaque> tiposDeAtaque = new ArrayList<>(ataques.keySet());

        Random random = new Random();
        TipoAtaque ataqueSorteado = tiposDeAtaque.get(random.nextInt(tiposDeAtaque.size()));

        int dano = ataques.get(ataqueSorteado);

        oponente.receberDano(dano);

        System.out.println("O lutador " + this.nome + " usou " +
                ataqueSorteado + " e causou " + dano + " de dano em " + oponente.getNome());
    }

    public void receberDano(int dano) {
        this.pontosDeVida -= dano;
        if (this.pontosDeVida < 0) {
            this.pontosDeVida = 0;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<ArtesMarciais> getArtesMarciais() {
        return this.artesMarciais;
    }

    public void setArtesMarciais(List<ArtesMarciais> artesMarciais) {
        this.artesMarciais = artesMarciais;
    }

    public Nacionalidade getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public CategoriaPeso getCategoriaPeso() {
        return this.categoriaPeso;
    }

    public void setCategoriaPeso(CategoriaPeso categoriaPeso) {
        this.categoriaPeso = categoriaPeso;
    }

    public int getVitorias() {
        return this.vitorias;
    }

    public void addVitoria() {
        this.vitorias++;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void addDerrota() {
        this.derrotas++;
    }

    public int getEmpates() {
        return empates;
    }

    public void addEmpate() {
        this.empates++;
    }

    @Override
    public String toString() {
        return "Lutador{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", artesMarciais=" + artesMarciais +
                ", nacionalidade=" + nacionalidade +
                ", categoriaPeso=" + categoriaPeso +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                '}';
    }
}
