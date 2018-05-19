/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.calculoiptu.repository;

import br.com.bandtec.calculoiptu.domain.Faixa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Aluno
 */
public interface FaixaRepository extends CrudRepository<Faixa, Integer> {
    
}
