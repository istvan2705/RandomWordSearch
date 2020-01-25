package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class GooglePage {
    private static final String URL = "https://www.google.com.ua";
    private WebDriver driver;
    @FindBy(css = "input[class ='gLFyf gsfi']")
    private WebElement searchField;
    @FindBy(css = "input[class ='gNO89b']")
    private WebElement searchButton;

    GooglePage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    void openWebPage() {
        driver.get(URL);
    }

    void searchRandomWordResult(String file) {
        String randomWord = getRandomWord(file);
        searchField.sendKeys(randomWord);
        getPageTitle();
        searchButton.click();
    }

    String getPageTitle() {
        return driver.getTitle();
    }

    private String getRandomWord(String file) {
        List<String> allWords = new ArrayList<>();
        Random randomWord = new Random();
        String searchedWord = null;
        int place;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file))) {
            allWords = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        int amountOfWords = allWords.size();
        for (int i = 0; i < amountOfWords; i++) {
            place = randomWord.nextInt(amountOfWords);
            searchedWord = allWords.get(place);
        }
        return searchedWord;
    }

    public void removeDriver() {
        driver.quit();
    }
}


