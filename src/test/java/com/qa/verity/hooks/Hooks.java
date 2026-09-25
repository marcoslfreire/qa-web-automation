package com.qa.verity.hooks;

import com.qa.verity.pages.ProductsPage;
import com.qa.verity.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Scenario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class Hooks {

    private WebDriver driver;

    @Before
    public void iniciarNavegador() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", java.util.Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_leak_detection", false
        ));

        driver = new ChromeDriver(options);

        DriverFactory.setDriver(driver);

        driver.get("https://www.saucedemo.com/");
    }

    @After
    public void fecharNavegador(Scenario scenario) throws IOException{

        if (scenario.isFailed()) {

            Path screenshotDir = Path.of("target", "screenshots");
            Files.createDirectories(screenshotDir);

            Path screenshotPath = screenshotDir.resolve(
                    scenario.getName().replaceAll("[^a-zA-Z0-9-_]", "_") + ".png"
            );

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            scenario.attach(
                    screenshot,
                    "image/png",
                    "Screenshot da falha"
            );

            System.out.println(
                    "Screenshot salvo em: " + screenshotPath.toAbsolutePath()
            );
        }

        driver.quit();
    }
}