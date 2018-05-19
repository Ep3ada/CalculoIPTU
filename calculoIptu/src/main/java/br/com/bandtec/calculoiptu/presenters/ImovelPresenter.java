/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.domain.Imovel;

/**
 *
 * @author KR Costa
 */
public class ImovelPresenter {

    private double valorVenal;
    private String cidade;
    private String contribuinte;

    public ImovelPresenter(Imovel i) {
        this.valorVenal = i.getValorVenal();

        if (i.getCidade() != null) {
            this.cidade = i.getCidade().getNome();
        } else {
            this.cidade = "N/A";
        }

        if (i.getContribuinte() != null) {
            this.contribuinte = i.getContribuinte().getNome();
        } else {
            this.contribuinte = "N/A";
        }
    }

    public double getValorVenal() {
        return valorVenal;
    }

    public String getCidade() {
        return cidade;
    }

    public String getContribuinte() {
        return contribuinte;
    }

}
