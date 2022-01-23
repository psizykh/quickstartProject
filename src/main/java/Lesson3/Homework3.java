package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kinopoisk.ru/");
//        WebElement searchField = driver.findElement(By.xpath("//input [@placeholder =\"Фильмы, сериалы, персоны\"]"));
//        searchField.click();
        driver.findElement(By.xpath("//input [@placeholder =\"Фильмы, сериалы, персоны\"]")).click();
        driver.findElement(By.xpath("//input [@placeholder =\"Фильмы, сериалы, персоны\"]")).sendKeys("Avatar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a [@href=\"/film/251733/sr/2/?from_suggest=251733\"]")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4273)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a [@href=\"/media/article/4004747/\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[.=\"«Терминатора»\"]")).click();
        driver.findElement(By.xpath("//button [@data-tid=\"f1f187d8\"]")).click();
        Thread.sleep(90600);
        driver.quit();

    }
}
