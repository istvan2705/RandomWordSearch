package pages;

public class GooglePageBO {

    private GooglePage googlePage = new GooglePage();

    public void initializeSearch() {
        googlePage.openWebPage();
        googlePage.searchRandomWordResult("src\\main\\resources\\randomWords.txt");
    }

    public String getTitle() {
        return googlePage.getPageTitle();
    }
}
