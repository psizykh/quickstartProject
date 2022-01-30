package com.geekbrains.Lesson5;

import com.google.gson.annotations.Until;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.Duration;

public class KinopoiskTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private static final String KP_URL = "https://hd.kinopoisk.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.manage().window().maximize();
    }

    @Test
    void loginTest() throws InterruptedException {
        driver.get(KP_URL);
        driver.findElement(By.xpath("//div[@class=\"Header__profile-menu-wrapper--p679x\"]//div [@data-tid=\"b669aa9c 9881f1d5\"] [@data-tid-prop=\"b669aa9c 9881f1d5\"]")).click();
        driver.findElement(By.xpath("//input [@placeholder='Телефон или почта']")).sendKeys("yndx-pavelsizykh-capcxh");
        driver.findElement(By.xpath("//button [@data-t=\"button:action:passp:sign-in\"]")).click();
        //driver.findElement(By.xpath("//span [@class=\"Textinput Textinput_iconRight Textinput_view_big-input Textinput_size_l\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@type=\"password\"]")));
        driver.findElement(By.xpath("//input [@type=\"password\"]")).sendKeys("gen1559\n");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@type=\"password\"]")));
        driver.findElement(By.xpath("//input [@type=\"password\"]")).click();
        Thread.sleep(3000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div [@data-t=\"phone_skip\"]")));
        driver.findElement(By.xpath("//div [@data-t=\"phone_skip\"]")).click();
    }

    @Test
    void ozonTest() throws InterruptedException {
        driver.get("https://www.ozon.ru/");
        actions.click(driver.findElement(By.xpath("//a [@href=\"/highlight/globalpromo/\"] [@class=\"fv9 pa9a aqa1 aq0a aaq\"]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@href=\"/product/elektricheskaya-zubnaya-shchetka-oral-b-pro-1-790-chernyy-198819346/\"] / div [@class=\"co5\"]")));
        actions.click(driver.findElement(By.xpath("//a [@href=\"/product/elektricheskaya-zubnaya-shchetka-oral-b-pro-1-790-chernyy-198819346/\"] / div [@class=\"co5\"]")));
        actions.click(driver.findElement(By.xpath("//img [@alt=\"Ozon\"]")));
        driver.findElement(By.xpath("//span [@title=\"Везде\"]")).click();
        //actions.click(driver.findElement(By.xpath("//span [@title=\"Везде\"]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img [@src=\"https://cdn1.ozone.ru/graphics/categories_icons/2019icons/grocery-new.svg\"]")));
        actions.click(driver.findElement(By.xpath("//img [@src=\"https://cdn1.ozone.ru/graphics/categories_icons/2019icons/grocery-new.svg\"]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@placeholder=\"Искать в Категории\"]")));
        driver.findElement(By.xpath("//input [@placeholder=\"Искать в Категории\"]")).sendKeys("Яблоки");
        Thread.sleep(3000);
    }
// Сделал второй вариант без actions. потому что непонятно как он работает, такое ощущение что ничего не просиходит и постоянные проблемы с поиском элементов,
// не совсем понимаю почему не работет и чем actions лучше стандартного варианта? Буду очень благодарен если укажите на мом ошибки при использовании actions и в целом зачем использовать их
    @Test
    void ozonTest2() throws InterruptedException {
        driver.get("https://www.ozon.ru/");
        driver.findElement(By.xpath("//a [@href=\"/highlight/globalpromo/\"] [@class=\"fv9 pa9a aqa1 aq0a aaq\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@href=\"/product/elektricheskaya-zubnaya-shchetka-oral-b-pro-1-790-chernyy-198819346/\"] / div [@class=\"co5\"]")));
        driver.findElement(By.xpath("//a [@href=\"/product/elektricheskaya-zubnaya-shchetka-oral-b-pro-1-790-chernyy-198819346/\"] / div [@class=\"co5\"]")).click();
        driver.findElement((By.xpath("//img [@alt=\"Ozon\"]"))).click();
        driver.findElement(By.xpath("//span [@title=\"Везде\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img [@src=\"https://cdn1.ozone.ru/graphics/categories_icons/2019icons/grocery-new.svg\"]")));
        driver.findElement(By.xpath("//img [@src=\"https://cdn1.ozone.ru/graphics/categories_icons/2019icons/grocery-new.svg\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input [@placeholder=\"Искать в Категории\"]")));
        driver.findElement(By.xpath("//input [@placeholder=\"Искать в Категории\"]")).sendKeys("Яблоки");
        Thread.sleep(3000);

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
