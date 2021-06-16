package com.sw.ecommerce;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private static List<Produto> _produto = Arrays.asList(
            new Produto( 1, "PS5", 50d),
            new Produto(2, "TV do Edi 32 polegadas (Modelo 2002)", 30d),
            new Produto(3, "Sanfona do Buxin", 10d)
    );

    @PostMapping("/item")
    public void adicionarItem(@RequestBody Item item) {
    }

    @PostMapping("/limparCarrinho")
    public void limparCarrinho() {
    }

    @GetMapping("total")
    public double obterTotalDoCarrinho() {
        return 0;
    }
}


class Produto {
    private int id;
    private String nome;
    private Double preco;

    public Produto(int id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}

class Item {
    private int idDoProduto;
    private int quantidade;

    public Item(int idDoProduto, int quantidade) {
        this.idDoProduto = idDoProduto;
        this.quantidade = quantidade;
    }

    public int getIdDoProduto() {
        return idDoProduto;
    }

    public void setIdDoProduto(int idDoProduto) {
        this.idDoProduto = idDoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}