package br.com.compras.gustil.controller;


import br.com.compras.gustil.entity.Fornecedor;
import br.com.compras.gustil.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) {
        return fornecedorService.cadastrarFornecedor(fornecedor);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/{cnpj}")
    public Fornecedor buscarFornecedor(@PathVariable("cnpj") Long cnpj) {
        return fornecedorService.buscarFornecedor(cnpj)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }
}
