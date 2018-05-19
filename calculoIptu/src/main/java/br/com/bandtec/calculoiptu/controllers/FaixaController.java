package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Faixa;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
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

        return ResponseEntity.ok(faixas);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Faixa f = repository.findOne(id);
        return ResponseEntity.ok(f);
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

}
