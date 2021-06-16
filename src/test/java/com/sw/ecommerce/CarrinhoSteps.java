package com.sw.ecommerce;

import com.sw.ecommerce.setup.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CarrinhoSteps extends SpringIntegrationTest {
    @Given("^carrinho está vazio$")
    public void usuario_limpa_carrinho() {
        executePost("/api/carrinho/limparCarrinho");
    }

    @When("adicionar {int} do produto {int} no carrinho")
    public void adicionarDoProdutoNoCarrinho(int quantidade, int idDoProduto) {
        Map<String, Object> body = new HashMap<>();
        body.put("quantidade", quantidade);
        body.put("idDoProduto", idDoProduto);
        executePost("/api/carrinho/item", body);
    }

    @And("produto {int} possui promoção {int}")
    public void produtoPossuiPromoção(int idDoProduto, int idDaPromocao) {
        executePut("/api/produto/"+ idDoProduto  +"/promocao/" + idDaPromocao, null);
    }

    @Then("o valor do carrinho deve ser {double}")
    public void oValorDoCarrinhoDeveSer(double valorTotal) {
        double total = executeGet("/api/carrinho/total");

        assertThat(total, equalTo(valorTotal));
    }
}
