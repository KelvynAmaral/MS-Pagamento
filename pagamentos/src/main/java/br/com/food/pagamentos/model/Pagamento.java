package br.com.food.pagamentos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Pagamento {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numeroCartao;
    private String expiracaoCartao;
    private String codigoSegurancaCartao;
    private Status status;
    private Long pedidoId;
    private Long formaPagamentoId;



}
