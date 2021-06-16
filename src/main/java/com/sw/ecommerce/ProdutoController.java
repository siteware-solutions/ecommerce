package com.sw.ecommerce;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/produto")
public class ProdutoController {

    @PutMapping("/{idDoProduto}/promocao/{idDaPromocao}")
    public void vincularPromocaoAoProduto(@PathVariable int idDoProduto, @PathVariable int idDaPromocao){

    }
}