package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.repository.CidadeRepository;
import br.com.bandtec.calculoiptu.repository.EstadoRepository;
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
    private CidadeRepository repoCidade;
    @Autowired
    private EstadoRepository repoEstado;

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Cidade> cidades = this.repoCidade.findAll();

        return ResponseEntity.ok(cidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Cidade c = repoCidade.findOne(id);
        if (c != null) {
            return ResponseEntity.ok(c);
        }

        return ResponseEntity.badRequest().body("Cidade já existente!");

    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Cidade c) {

        try {
            this.repoCidade.save(c);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Estado inválido!");
        }

    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Cidade c) {

        try {
            this.repoCidade.save(c);
            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Estado inválido!");
        }

    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable("id") Integer id) {
        repository.delete(id);
        return ResponseEntity.ok().build();
    }*/
}
