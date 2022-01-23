package Lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://google.com");
        Thread.sleep(5000);
        driver1.quit();

    }
}
