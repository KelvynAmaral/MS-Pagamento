package br.com.food.pagamentos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//define que o campo é auto incremento no banco de dados
    private Long id;

    @NotNull//define que o campo não pode ser nulo
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 19)
    private String numeroCartao;

    @NotBlank//define que o campo não pode ser vazio
    @Size(max = 7)//define o tamanho da data de expiração do cartão
    private String expiracaoCartao;

    @NotBlank
    @Size(min = 3, max = 3) //define o tamanho do código de segurança do cartão
    private String codigoSegurancaCartao;

    @NotNull
    @Enumerated(EnumType.STRING)//define que o campo é um enum
    private Status status;
    private Long pedidoId;
    private Long formaPagamentoId;



}
