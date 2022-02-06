package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class kpPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public kpPage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    private final static String SEARCH_RESULT_LOCATOR ="//a [@href=\"/film/251733/sr/2/?from_suggest=251733\"]";
    @FindBy(xpath = "//input [@placeholder =\"Фильмы, сериалы, персоны\"]")
    public WebElement searchField;
    @FindBy(xpath = "//a [@href=\"/film/251733/sr/2/?from_suggest=251733\"]")
    public WebElement suggestSelection;
    @FindBy(xpath = "//a [@href=\"/media/article/4004747/\"]")
    public WebElement newsSelection;
    @FindBy(xpath = "//*[.=\"«Терминатора»\"]")
    public WebElement movieSelection;
    @FindBy(xpath = "//button [@data-tid=\"f1f187d8\"]")
    public WebElement trailerPlayButton;

    public kpPage fillSearch (String search){
        searchField.sendKeys("Avatar");
        return this;
    }

    public kpPage clickSuggestSelection(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_RESULT_LOCATOR)));
        suggestSelection.click();
        return this;
    }
    public void scrollAndClickMovieNews (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4273)");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@href=\"/media/article/4004747/\"]")));
        newsSelection.click();
//        return new String("https://www.kinopoisk.ru/media/article/4004747/");

    }
//    public void movieSelectionClick (){
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"«Терминатора»\"]")));
//        movieSelection.click();
//        trailerPlayButton.click();
//
//    }
}

