import driver.Driver;
import pages.GooglePageBO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        GooglePageBO pageBO = new GooglePageBO();
        pageBO.initializeSearch();
        String title = pageBO.getTitle();
        logger.info("The found page's title is: " + title);
        Driver.removeDriver();
    }
}
