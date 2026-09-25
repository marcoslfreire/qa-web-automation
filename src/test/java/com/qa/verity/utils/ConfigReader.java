package com.qa.verity.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config/test.properties")) {

            if (input != null) {
                PROPERTIES.load(input);
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Erro ao carregar o arquivo config/test.properties.",
                    e
            );
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {

        String envKey = obterNomeVariavelAmbiente(key);

        if (envKey != null) {
            String envValue = System.getenv(envKey);

            if (envValue != null && !envValue.isBlank()) {
                return envValue;
            }
        }

        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Propriedade não configurada: " + key
            );
        }

        return value;
    }

    private static String obterNomeVariavelAmbiente(String key) {

        return switch (key) {
            case "saucedemo.username" -> "SAUCEDEMO_USERNAME";
            case "saucedemo.password" -> "SAUCEDEMO_PASSWORD";
            default -> null;
        };
    }
}