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

            if (input == null) {
                throw new IllegalStateException(
                        "Arquivo config/test.properties não encontrado."
                );
            }

            PROPERTIES.load(input);

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

        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Propriedade não configurada: " + key
            );
        }

        return value;
    }
}