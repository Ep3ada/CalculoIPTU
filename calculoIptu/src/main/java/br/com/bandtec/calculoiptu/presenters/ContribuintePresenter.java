package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.domain.Contribuinte;

public class ContribuintePresenter {

    private String nome;
    private String cpf;

    public ContribuintePresenter(Contribuinte c) {
        this.nome = c.getNome();
        this.cpf = c.getCpf().toString();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}
