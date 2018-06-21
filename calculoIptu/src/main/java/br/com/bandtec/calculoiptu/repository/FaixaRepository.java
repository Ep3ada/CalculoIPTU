package br.com.bandtec.calculoiptu.repository;

import br.com.bandtec.calculoiptu.domain.Cidade;
import br.com.bandtec.calculoiptu.domain.Faixa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface FaixaRepository extends CrudRepository<Faixa, Integer> {

    List<Faixa> findByCidade(Cidade c);

}
