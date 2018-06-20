package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Estado;
import br.com.bandtec.calculoiptu.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Estado> estados = this.repository.findAll();

        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Estado e = repository.findOne(id);
        return ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Estado e) {
        this.repository.save(e);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Estado e) {
        this.repository.save(e);

        return ResponseEntity.ok().build();
    }

}
