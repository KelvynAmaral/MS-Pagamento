package br.com.food.pagamentos.repository;

import br.com.food.pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public class PagamentoRepository implements JpaRepository<Pagamento, Long> {

}
