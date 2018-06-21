package br.com.bandtec.calculoiptu.utils;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.repository.CidadeRepository;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class CalcularIptu {

    public Double getPorcentagem(int cidade, double valor, FaixaRepository f) {
        List<Faixa> faixas = f.findByCidade(new Cidade(cidade));

        Double percent = 0.0;

        for (int i = 0; i < faixas.size(); i++) {
            if (i == (faixas.size() - 1)) {
                percent = faixas.get(i).getPorcentagem();
            } else if (valor >= faixas.get(i).getLimiteInferior()
                    && valor < faixas.get(i).getLimiteSuperior()) {
                percent = faixas.get(i).getPorcentagem();
            }
        }

        return percent;
    }

    private double calculoValorIptu(int cidade, double valor, FaixaRepository f) {
        if (valor < 0) {
            throw new IllegalArgumentException("Digite valor de imóvel válido");
        }

        Double percent = getPorcentagem(cidade, valor, f);

        return valor * percent;

        /*if (valor <= 150000) {
            resultado = 0;
        } else if (valor > 150000 && valor <= 300000) {
            resultado = valor * 0.009;
        } else if (valor > 300000 && valor <= 600000) {
            resultado = valor * 0.011;
        } else {
            resultado = valor * 0.013;
        }

        return resultado;*/
    }

    public double calcularPagaAVista(int cidade, double valor, FaixaRepository f) {
        double resultado = calculoValorIptu(cidade, valor, f);

        return resultado - (resultado * 0.15);
    }

    public double calcularValor1Parcela(int cidade, double valor, FaixaRepository f) {
        double resultado = calculoValorIptu(cidade, valor, f);
        return resultado * 0.1;
    }

}
