package br.com.bandtec.calculoiptu.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalcularIptu {

    public boolean isCidadeValida(String c) {
        if (c.equals("São Paulo")) {
            return true;
        }
        return false;

    }

    private double calculoValorIptu(String cidade, double valor) {
        if (!isCidadeValida(cidade)) {
            throw new IllegalArgumentException("Cidade inexistente na base de dados");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("Digite valor de imóvel válido");
        }

        double resultado = 0;

        if (valor <= 150000) {
            resultado = 0;
        } else if (valor > 150000 && valor <= 300000) {
            resultado = valor * 0.009;
        } else if (valor > 300000 && valor <= 600000) {
            resultado = valor * 0.011;
        } else {
            resultado = valor * 0.013;
        }

        return resultado;
    }

    public double calcularPagaAVista(String cidade, double valor) {
        double resultado = calculoValorIptu(cidade, valor);

        return resultado - (resultado * 0.15);
    }

    public double calcularValor1Parcela(String cidade, double valor) {
        double resultado = calculoValorIptu(cidade, valor);
        return resultado * 0.1;
    }

}
