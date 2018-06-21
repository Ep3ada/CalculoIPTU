/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.domain.Faixa;

/**
 *
 * @author KR Costa
 */
public class FaixaPresenter {

    private String cidade;
    private double limiteSup;
    private double limiteInf;
    private double porcentagem;

    public FaixaPresenter(Faixa f) {
        this.limiteSup = f.getLimiteSuperior();
        this.limiteInf = f.getLimiteInferior();
        this.porcentagem = f.getPorcentagem();
        
        if (f.getCidade() != null) {
            this.cidade = f.getCidade().getNome();
        } else {
            this.cidade = "N/A";
        }
    }

    public String getCidade() {
        return cidade;
    }

    public Double getLimiteSup() {
        return limiteSup;
    }

    public Double getLimiteInf() {
        return limiteInf;
    }

}
