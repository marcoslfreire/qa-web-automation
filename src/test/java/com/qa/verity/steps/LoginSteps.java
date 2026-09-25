package com.qa.verity.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.qa.verity.pages.LoginPage;
import com.qa.verity.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import com.qa.verity.pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.qa.verity.utils.TestData;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("que estou na página de login")
    public void queEstouNaPaginaDeLogin() {

        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        assertTrue(
                loginPage.paginaDeLoginEstaVisivel(),
                "A página de login não foi exibida"
        );
    }

    @When("informo um usuário válido")
    public void informoUmUsuarioValido() {
        loginPage.informarUsuario(TestData.USUARIO_VALIDO);
        System.out.println(
                "LOG: Usuario informado :" + TestData.USUARIO_VALIDO + " com sucesso!"
        );
    }

    @When("informo uma senha válida")
    public void informoUmaSenhaValida() {
        loginPage.informarSenha(TestData.SENHA_VALIDA);
        System.out.println("LOG: Senha informada com sucesso:");
    }

    @When("clico no botão de login")
    public void clicoNoBotaoDeLogin() {
        loginPage.clicarLogin();
    }

    @Then("devo acessar a página de produtos")
    public void devoAcessarAPaginaDeProdutos() {
        assertTrue(
                productsPage.paginaDeProdutosEstaVisivel(),
                "A página de produtos não foi exibida após o login"
        );
        System.out.println("LOG: Pagina do produto :" + "Swag Labs " + "esta visivel!");
    }

    @When("informo um usuário inválido")
    public void informoUmUsuárioInválido() {
        loginPage.informarUsuario(TestData.USUARIO_INVALIDO);
        System.out.println(
                "LOG: Usuario Invalido informado :" + TestData.USUARIO_INVALIDO + " com sucesso!");


    }

    @When("informo uma senha inválida")
    public void informoUmaSenhaInválida() {
        loginPage.informarSenha(TestData.SENHA_INVALIDA);
        System.out.println("LOG: Senha INVALIDA informada com sucesso:");
    }

    @Then("devo visualizar uma mensagem de erro")
    public void devoVisualizarUmaMensagemDeErro() {
        String mensagemAtual = loginPage.obterMensagemDeErro();
        assertEquals(TestData.MENSAGEM_ERRO_LOGIN, mensagemAtual, "A mensagem de erro não foi exibida");

        System.out.println(
                "LOG: Mensagem de erro validada com sucesso!"
        );
    }
}
