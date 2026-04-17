package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

    public static void main(String[] args) throws InterruptedException {

        // Auto download driver
        WebDriverManager.chromedriver().setup();

        // Headless mode for Jenkins (IMPORTANT)
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            Thread.sleep(2000);

            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(2000);

            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);

            System.out.println("Login test executed successfully!");

        } finally {
            driver.quit();
        }
    }
}
