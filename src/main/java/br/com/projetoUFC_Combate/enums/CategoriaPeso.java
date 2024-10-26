package br.com.projetoUFC_Combate.enums;

import br.com.projetoUFC_Combate.exception.CategoriaPesoNaoDefinidaException;

public enum CategoriaPeso {
    PESO_PALHA(0, 52.2),
    PESO_MOSCA(52.3, 56.7),
    PESO_GALO(56.8, 61.2),
    PESO_PENA(61.3, 65.8),
    PESO_LEVE(65.9, 70.3),
    PESO_MEIO_MEDIO(70.4, 77.1),
    PESO_MEDIO(77.2, 83.9),
    PESO_MEIO_PESADO(84.0, 93.0),
    PESO_PESADO(93.1, 120.2);

    private final double pesoMinimo;
    private final double pesoMaximo;

    CategoriaPeso(double pesoMinimo, double pesoMaximo) {
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
    }

    public static CategoriaPeso definirCategoria(double peso) {
        for (CategoriaPeso categoria : CategoriaPeso.values()) {
            if(peso >= categoria.pesoMinimo && peso <= categoria.pesoMaximo) {
                return categoria;
            }
        }
        throw new CategoriaPesoNaoDefinidaException("Peso fora da categoria definida!");
    }

    @Override
    public String toString() {
        return name().replace("_", " ").toLowerCase(); // Devo testar depois
    }
}
