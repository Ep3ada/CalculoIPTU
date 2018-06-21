package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.presenters.FaixaPresenter;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
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
@RequestMapping("/faixa")
public class FaixaController {

    @Autowired
    private FaixaRepository repository;

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Faixa> faixas = this.repository.findAll();

        List<FaixaPresenter> faixasP = new ArrayList<>();
        faixas.forEach(faixa -> {
            faixasP.add(new FaixaPresenter(faixa));
        });

        return ResponseEntity.ok(faixasP);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        FaixaPresenter faixaP = new FaixaPresenter(repository.findOne(id));
        return ResponseEntity.ok(faixaP);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Faixa faixa) {
        this.repository.save(faixa);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Faixa f) {
        this.repository.save(f);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Integer id) {
        repository.delete(id);
        return ResponseEntity.ok().build();
    }

    /*@GetMapping("/cidade/{id}")
    public ResponseEntity getFaixasPorCidade(@PathVariable("id") Integer id) {
        Iterable<Faixa> faixas = repository.findByCidade(id);

        List<FaixaPresenter> faixasP = new ArrayList<>();
        faixas.forEach(faixa -> {
            faixasP.add(new FaixaPresenter(faixa));
        });

        return ResponseEntity.ok(faixasP);

    }*/
}
