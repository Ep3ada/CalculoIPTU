package br.com.bandtec.calculoiptu.controllers;

import br.com.bandtec.calculoiptu.domain.Contribuinte;
import br.com.bandtec.calculoiptu.presenters.ContribuintePresenter;
import br.com.bandtec.calculoiptu.repository.ContribuinteRepository;
import br.com.bandtec.calculoiptu.repository.FaixaRepository;
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
@RequestMapping("/contribuinte")
public class ContribuinteController {

    @Autowired
    private ContribuinteRepository repository;
    

    @GetMapping
    public ResponseEntity getTodos() {
        Iterable<Contribuinte> contribs = this.repository.findAll();

        List<ContribuintePresenter> contribsP = new ArrayList<>();
        contribs.forEach(contrib -> {
            contribsP.add(new ContribuintePresenter(contrib));
        });

        return ResponseEntity.ok(contribsP);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUm(@PathVariable("id") Integer id) {
        Contribuinte c = repository.findOne(id);
        return ResponseEntity.ok(c);
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Contribuinte contribuinte) {
        this.repository.save(contribuinte);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody Contribuinte c) {
        this.repository.save(c);

        return ResponseEntity.ok().build();
    }

}
