package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.domain.Contribuinte;
import br.com.bandtec.calculoiptu.domain.Estado;
import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.domain.Imovel;
import br.com.bandtec.calculoiptu.repository.CidadeRepository;
import br.com.bandtec.calculoiptu.repository.ContribuinteRepository;
import br.com.bandtec.calculoiptu.repository.EstadoRepository;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
import br.com.bandtec.calculoiptu.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banco")
public class InicializacaoController {

    @Autowired
    private EstadoRepository estadorepository;

    @Autowired
    private CidadeRepository cidaderepository;

    @Autowired
    private ImovelRepository imovelrepository;

    @Autowired
    private FaixaRepository faixarepository;

    @Autowired
    private ContribuinteRepository contribuinterepository;

    @GetMapping("/inicializar")
    public ResponseEntity inicalizaBase() {
        Estado e1 = new Estado();
        e1.setNome("SP");
        Estado e2 = new Estado();
        e2.setNome("RJ");

        Contribuinte cb1 = new Contribuinte();
        cb1.setNome("João");
        cb1.setCpf("11122233344");
        Contribuinte cb2 = new Contribuinte();
        cb2.setNome("Maria");
        cb2.setCpf("44455566677");
        Contribuinte cb3 = new Contribuinte();
        cb3.setNome("Mário");
        cb3.setCpf("77788899900");

        Cidade cd1 = new Cidade();
        cd1.setNome("São Paulo");
        cd1.setEstado(e1);
        Cidade cd2 = new Cidade();
        cd2.setNome("Rio de Janeiro");
        cd2.setEstado(e2);

        Faixa f1c1 = new Faixa();
        f1c1.setCidade(cd1);
        f1c1.setNumFaixa(1);
        f1c1.setPorcentagem(0.009);
        f1c1.setLimiteInferior(0.0);
        f1c1.setLimiteSuperior(50000.0);

        Faixa f2c1 = new Faixa();
        f2c1.setCidade(cd1);
        f2c1.setNumFaixa(2);
        f2c1.setPorcentagem(0.012);
        f2c1.setLimiteInferior(50000.0);
        f2c1.setLimiteSuperior(150000.0);

        Faixa f3c1 = new Faixa();
        f3c1.setCidade(cd1);
        f3c1.setNumFaixa(3);
        f3c1.setPorcentagem(0.015);
        f3c1.setLimiteInferior(150000.0);
        f3c1.setLimiteSuperior(0.0);

        Faixa f1c2 = new Faixa();
        f1c2.setCidade(cd2);
        f1c2.setNumFaixa(1);
        f1c2.setLimiteInferior(0.005);
        f1c2.setLimiteSuperior(100000.0);

        Faixa f2c2 = new Faixa();
        f2c2.setCidade(cd2);
        f2c2.setNumFaixa(2);
        f2c2.setPorcentagem(0.020);
        f2c2.setLimiteInferior(100000.0);
        f2c2.setLimiteSuperior(0.0);

        Imovel i1c1 = new Imovel();
        i1c1.setContribuinte(cb1);
        i1c1.setCidade(cd1);
        i1c1.setValorVenal(100000.0);

        Imovel i2c2 = new Imovel();
        i2c2.setContribuinte(cb2);
        i2c2.setCidade(cd2);
        i2c2.setValorVenal(500000.0);

        estadorepository.save(e1);
        estadorepository.save(e2);

        cidaderepository.save(cd1);
        cidaderepository.save(cd2);

        contribuinterepository.save(cb1);
        contribuinterepository.save(cb2);

        faixarepository.save(f1c1);
        faixarepository.save(f2c1);
        faixarepository.save(f3c1);

        faixarepository.save(f1c2);
        faixarepository.save(f2c2);

        imovelrepository.save(i1c1);
        imovelrepository.save(i2c2);

        return ResponseEntity.ok().build();
    }

}
