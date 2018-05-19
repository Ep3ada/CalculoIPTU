/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.domain.Cidade;

/**
 *
 * @author KR Costa
 */
public class CidadePresenter {

    private String nome;
    private String estado;

    public CidadePresenter(Cidade c) {
        this.nome = c.getNome();

        if (c.getEstado() != null) {
            this.estado = c.getEstado().getNome();
        } else {
            this.estado = "N/A";
        }
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

}
