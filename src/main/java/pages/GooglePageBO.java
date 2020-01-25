package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageBO {

    WebDriver driver = new ChromeDriver();
    private GooglePage googlePage = new GooglePage(driver);

    public void initializeSearch() {
        googlePage.openWebPage();
        googlePage.searchRandomWordResult("src\\main\\resources\\randomWords.txt");
    }

    public String getTitle() {
        return googlePage.getPageTitle();
    }

    public void quitDriver() {
        googlePage.removeDriver();
    }
}
