package com.qa.verity.utils;

public class TestData {

    public static final String USUARIO_VALIDO = ConfigReader.get("saucedemo.username");
    public static final String SENHA_VALIDA = ConfigReader.get("saucedemo.password");

    public static final String USUARIO_INVALIDO = "usuario_invalido";
    public static final String SENHA_INVALIDA = "senha_invalida";


    public static final String MENSAGEM_ERRO_LOGIN =
            "Epic sadface: Username and password do not match any user in this service";
}