package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWLesson6 {
    WebDriver driver;
    private final static String KINOPOISK_URL = "https://www.kinopoisk.ru/";
//    private final static String NEWS_URL = "https://www.kinopoisk.ru/media/article/4004747/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get(KINOPOISK_URL);

    }

    @Test
    void kinopoiskTest() throws InterruptedException {
        kpPage kpPage = new kpPage(driver);
        kpPage.fillSearch("Avatar").clickSuggestSelection().scrollAndClickMovieNews();


    }

    @AfterEach
    void killDriver() {
        driver.quit();
    }
}

