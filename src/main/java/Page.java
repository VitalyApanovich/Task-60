import org.openqa.selenium.WebDriver;

public class Page {

    private final String TITLE;
    WebDriver driver;

    Page(String title) {
        TITLE = title;
        driver = Driver.getDriver().get();
    }

    public boolean isDisplayed() {
        return driver.getTitle().contains(TITLE);
    }
}
