package br.com.bandtec.calculoiptu.repository;

import br.com.bandtec.calculoiptu.domain.Cidade;
import org.springframework.data.repository.CrudRepository;

public interface CidadeRepository extends
          CrudRepository<Cidade, Integer> {

}
