package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Estado;
import br.com.bandtec.calculoiptu.presenters.EstadoPresenter;
import br.com.bandtec.calculoiptu.repository.EstadoRepository;
import java.util.ArrayList;
import java.util.List;
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

        List<EstadoPresenter> estadosP = new ArrayList();
        estados.forEach(estado -> {
            estadosP.add(new EstadoPresenter(estado));
        });

        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        EstadoPresenter estadoP = new EstadoPresenter(repository.findOne(id));

        return ResponseEntity.ok(estadoP);
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
