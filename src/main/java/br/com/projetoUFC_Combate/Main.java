package br.com.projetoUFC_Combate;

import br.com.projetoUFC_Combate.enums.ArtesMarciais;
import br.com.projetoUFC_Combate.enums.Nacionalidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaLutadores sistema = new SistemaLutadores();
        Scanner scanner = new Scanner(System.in);
        int posicao;
        boolean sair = false;

        while (!sair) {
            System.out.println("Qual destas opções deseja realizar?"+
                    "\n\t[ 1 ] - Cadastrar lutador" +
                    "\n\t[ 2 ] - Pesquisar um lutador" +
                    "\n\t[ 3 ] - Apagar lutador" +
                    "\n\t[ 4 ] - Mostrar todos os lutadores" +
                    "\n\t[ 5 ] - Encerrar programa");
            int opcoes = Integer.parseInt(scanner.nextLine());

            switch (opcoes) {
                case 1:
                    System.out.println("Informe o nome do lutador");
                    String nome = capitalizar(scanner.nextLine());

                    System.out.println("\nInforme a idade do lutador");
                    int idade = scanner.nextInt();

                    System.out.println("\nInforme o peso do lutador");
                    double peso = scanner.nextDouble();

                    int quantidadeArtesMarciais = ArtesMarciais.values().length;
                    List<ArtesMarciais> artesMarciaisLutador = new ArrayList<>();
                    List<ArtesMarciais> artesMarciais = new ArrayList<>();
                    System.out.println("\nInforme até três artes marciais do lutador mostrados abaixo:");
                    for (int i = 0; i < 3; i++) {
                        posicao = 1;
                        artesMarciais.clear();
                        for(ArtesMarciais arte : ArtesMarciais.values()) {
                            System.out.println("[ " + posicao + " ] - " + arte);
                            posicao++;
                            artesMarciais.add(arte);
                        }

                        while (true) {
                            System.out.print("\nInforme a posição da arte marcial: ");
                            int inserirArte = scanner.nextInt();
                            scanner.nextLine();

                            if (inserirArte > 0 && inserirArte <= quantidadeArtesMarciais) {
                                artesMarciaisLutador.add(artesMarciais.get(inserirArte - 1));
                                break;
                            } else {
                                System.out.println("\nCódigo inserido inválido! Tente novamente.");
                            }
                        }
                        if (i < 2) {
                            System.out.println("\nDeseja continuar a cadastrar artes marciais? [sim/não]");
                            String confirmar = scanner.nextLine().toLowerCase();

                            while (!confirmar.equals("sim") && !confirmar.equals("não") && !confirmar.equals("nao")) {
                                System.out.println("\nResposta inválida! Tente novamente.");
                                System.out.println("Deseja continuar a cadastrar artes marciais? [sim/não]");
                                confirmar = scanner.nextLine().toLowerCase();
                            }

                            if (confirmar.equals("nao") || confirmar.equals("não")) {
                                break;
                            }
                        }
                    }

                    List<Nacionalidade> nacionalidades = new ArrayList<>();
                    Nacionalidade nacionalidadeLutador;
                    int quantidadeNacionalidades = Nacionalidade.values().length;
                    posicao = 1;
                    for(Nacionalidade nacionalidade : Nacionalidade.values()) {
                        System.out.println("[ " + posicao + " ] - " + nacionalidade);
                        nacionalidades.add(nacionalidade);
                        posicao++;
                    }
                    while (true) {
                        System.out.println("\nInforma a posição da nacionalidade do lutador:");
                        int opcao = scanner.nextInt();
                        scanner.nextLine();

                        if(0 < opcao && opcao <= quantidadeNacionalidades) {
                            nacionalidadeLutador = nacionalidades.get(opcao - 1);
                            break;
                        } else {
                            System.out.println("\nPosição inválida! Tente novamente");
                        }
                    }
                    Lutador lutador = new Lutador(nome, idade, peso, artesMarciaisLutador, nacionalidadeLutador);
                    sistema.cadastrarLutador(lutador);
                    break;

                case 2:
                    System.out.println("Informe o nome do lutador que deseje pesquisar: ");
                    String nomeAPesquisar = scanner.nextLine();
                    System.out.println(sistema.pesquisarLutador(nomeAPesquisar));
                    break;

                case 3:
                    System.out.println("Informe o nome do lutador que deseje apagar: ");
                    String nomeAApagar = scanner.nextLine();
                    sistema.apagarLutador(nomeAApagar);
                    break;

                case 4:
                    Map<String,Lutador> lutadores = sistema.getLutadores();
                    System.out.println("Listando os nomes dos lutadores:");
                    for(Lutador l : lutadores.values()) {
                        System.out.println("\t" + l);
                    }
                    break;

                case 5:
                    System.out.println("Programa encerrado!");
                    sair = true;
                    break;
            }
        }
        scanner.close();
    }

    public static String capitalizar(String nome) {
        String[] palavras = nome.toLowerCase().split(" ");

        StringBuilder nomeCapitalizado = new StringBuilder();

        for(String palavra : palavras) {
            if(!palavra.isEmpty()) {
                nomeCapitalizado.append(Character.toUpperCase(palavra.charAt(0)))
                        .append(palavra.substring(1))
                        .append(" ");
            }
        }
        return nomeCapitalizado.toString().trim();
    }
}
