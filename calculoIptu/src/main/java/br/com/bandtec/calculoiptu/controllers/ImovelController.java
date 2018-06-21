package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.domain.Imovel;
import br.com.bandtec.calculoiptu.presenters.ImovelPresenter;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
import br.com.bandtec.calculoiptu.repository.ImovelRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelRepository repoImovel;

    @Autowired
    private FaixaRepository repoFaixa;

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Imovel> imoveis = this.repoImovel.findAll();

        List<ImovelPresenter> imoveisP = new ArrayList<>();
        imoveis.forEach(imovel -> {
            List<Faixa> faixas = repoFaixa.findByCidade(imovel.getCidade());
            imoveisP.add(new ImovelPresenter(imovel, faixas));
        });

        return ResponseEntity.ok(imoveisP);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Imovel imovel = repoImovel.findOne(id);
        List<Faixa> faixas = repoFaixa.findByCidade(imovel.getCidade());
        ImovelPresenter imovelP = new ImovelPresenter(imovel, faixas);

        return ResponseEntity.ok(imovelP);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Imovel imovel) {
        this.repoImovel.save(imovel);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Imovel i) {
        this.repoImovel.save(i);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Integer id) {
        repoImovel.delete(id);

        return ResponseEntity.ok().build();
    }
}
