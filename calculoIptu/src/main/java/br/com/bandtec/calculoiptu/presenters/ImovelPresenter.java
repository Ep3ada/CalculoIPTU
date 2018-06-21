package br.com.bandtec.calculoiptu.presenters;

import br.com.bandtec.calculoiptu.CalculoIptuApiApplication;
import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.domain.Imovel;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
import br.com.bandtec.calculoiptu.utils.CalcularIptu;
import java.util.List;

public class ImovelPresenter {

    private double valorVenal;
    private double valoraParcela;
    private double valorAVista;
    private String cidade;
    private String contribuinte;

    public ImovelPresenter(Imovel i, List<Faixa> f) {
        this.valorVenal = i.getValorVenal();

        CalcularIptu calculadora = new CalcularIptu();

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

        valoraParcela = calculadora.
                calcularValor1Parcela(valorVenal, f);
        valorAVista = calculadora.
                calcularPagaAVista(valorVenal, f);

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

    public double getValoraParcela() {
        return valoraParcela;
    }

    public double getValorAVista() {
        return valorAVista;
    }

}
