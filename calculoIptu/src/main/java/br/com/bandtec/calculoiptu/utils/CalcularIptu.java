package br.com.bandtec.calculoiptu.utils;

import br.com.bandtec.calculoiptu.domain.Faixa;
import java.util.List;

public class CalcularIptu {

    public Double getPorcentagem(double valor, List<Faixa> faixas) {
        Double percent = 0.0;

        for (int i = 0; i < faixas.size(); i++) {
            Faixa f = faixas.get(i);

            if (valor < f.getLimiteInferior()) {
                percent = 0.0;
            } else if (valor >= f.getLimiteInferior()
                    && (valor <= f.getLimiteSuperior()
                    || f.getLimiteSuperior() == 0.0)) {
                return f.getPorcentagem();
            }

            /*if (f.getLimiteInferior() == 0.0) {
                return percent = 0.0;
            } else if (valor >= f.getLimiteInferior()
                    && (valor < f.getLimiteSuperior() || f.getLimiteSuperior() == 0.0)) {
                percent = f.getPorcentagem();
            }*/
        }

        return percent;
    }

    private double calculoValorIptu(double valor, List<Faixa> f) {
        if (valor < 0) {
            throw new IllegalArgumentException("Digite valor de imóvel válido");
        }

        Double percent = getPorcentagem(valor, f);

        return valor * percent;
    }

    public double calcularPagaAVista(double valor, List<Faixa> f) {
        double resultado = calculoValorIptu(valor, f);
        return resultado - (resultado * 0.15);
    }

    public double calcularValor1Parcela(double valor, List<Faixa> f) {
        double resultado = calculoValorIptu(valor, f);
        return resultado * 0.1;
    }

}
