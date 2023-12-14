package br.com.food.pagamentos.controller;

import br.com.food.pagamentos.model.DadosPagamento;
import br.com.food.pagamentos.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public Page<DadosPagamento> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPagamento> detalhar(@PathVariable @NotNull Long id) {
        DadosPagamento dadosPagamento = service.obterPorId(id);

        return ResponseEntity.ok(dadosPagamento);
    }

    @PostMapping
    public ResponseEntity<DadosPagamento> cadastrar (@RequestBody @Valid DadosPagamento dadosPagamento, UriComponentsBuilder uriBuilder) {
        DadosPagamento pagamento= service.criarPagamento(dadosPagamento);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(endereco).body(pagamento);
    }
    @PutMapping
    public ResponseEntity<DadosPagamento> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid DadosPagamento dadosPagamento) {
        DadosPagamento atualizado = service.atualizarPagamento(id, dadosPagamento);


        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DadosPagamento> deletar(@PathVariable @NotNull Long id) {
        service.excluirPagamento(id);

        return ResponseEntity.noContent().build();
    }

}
