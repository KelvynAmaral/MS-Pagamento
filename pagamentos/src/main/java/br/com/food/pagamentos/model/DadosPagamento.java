package br.com.food.pagamentos.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record DadosPagamento(

        @NotBlank
        String nome,
        String numeroCartao,
        String expiracaoCartao,
        String codigoSegurancaCartao,
        String valor,
        String pedidoId,
        String formaPagamentoId
) {
}
