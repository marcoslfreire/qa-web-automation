package com.qa.verity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private By campoUsuario = By.id("user-name");
    private By campoSenha = By.id("password");
    private By botaoLogin = By.id("login-button");
    private By mensagemErro = By.cssSelector("[data-test='error']");
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void informarUsuario(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario))
                .sendKeys(usuario);
    }

    public void informarSenha(String senha) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);

    }

    public void clicarLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();

    }

    public boolean paginaDeLoginEstaVisivel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(campoUsuario)
        ).isDisplayed();
    }

    public boolean mensagemDeErroEstaVisivel() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(mensagemErro)
        ).isDisplayed();
    }

    public String obterMensagemDeErro() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(mensagemErro)
        ).getText();
    }

}
