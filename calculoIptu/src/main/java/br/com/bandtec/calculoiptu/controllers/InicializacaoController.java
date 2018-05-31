package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.repository.CidadeRepository;
import br.com.bandtec.calculoiptu.repository.ContribuinteRepository;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
import br.com.bandtec.calculoiptu.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicializacaoController {

    @Autowired
    CidadeRepository cidaderepository;

    @Autowired
    ImovelRepository imovelrepository;

    @Autowired
    FaixaRepository faixarepository;

    @Autowired
    ContribuinteRepository contribuinterepository;

    @GetMapping("/inicializar")
    public void inicalizaBase() {
        //instancia obj e salva no banco
    }
}
