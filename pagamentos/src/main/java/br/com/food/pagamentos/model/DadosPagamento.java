package br.com.food.pagamentos.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record DadosPagamento(
        @NotBlank
        Long id,
        @NotBlank
        String nome,

        @NotBlank
        String numeroCartao,

        @NotBlank
        String expiracaoCartao,

        @NotBlank
        String codigoSegurancaCartao) {

}
