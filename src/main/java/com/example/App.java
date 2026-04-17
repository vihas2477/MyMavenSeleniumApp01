package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// ✅ Add this
import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        // ✅ Auto setup driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // ✅ MUST for Jenkins/Linux
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);

        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);

        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        // ✅ Print output for Jenkins logs
        System.out.println("Page Title: " + driver.getTitle());

        driver.quit();
    }
}
