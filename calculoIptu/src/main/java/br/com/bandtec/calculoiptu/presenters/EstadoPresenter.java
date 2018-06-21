package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.domain.Estado;

public class EstadoPresenter {
    private String nome;

    public EstadoPresenter(Estado e) {
        this.nome = e.getNome();
        
    }

    public String getNome() {
        return nome;
    }
    
}
