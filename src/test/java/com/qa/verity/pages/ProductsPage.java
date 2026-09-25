package com.qa.verity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class ProductsPage {
    private ProductsPage productsPage;
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean paginaDeProdutosEstaVisivel() {
//        return driver.getTitle().equals("Swag Labs");
        return wait.until(
                ExpectedConditions.titleIs("Swag Labs")
        );
    }
}