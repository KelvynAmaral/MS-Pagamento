package br.com.food.pagamentos.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DadosPagamento{
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
