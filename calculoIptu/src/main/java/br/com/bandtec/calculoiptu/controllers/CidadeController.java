package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.repository.CidadeRepository;
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
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Cidade> cidades = this.repository.findAll();

        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Cidade c = repository.findOne(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Cidade c) {
        this.repository.save(c);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Cidade c) {
        this.repository.save(c);

        return ResponseEntity.ok().build();
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Integer id) {
        repository.delete(id);
        return ResponseEntity.ok().build();
    }*/

}
