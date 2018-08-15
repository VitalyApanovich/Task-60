import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class InboxPage extends Page{
    private final static String TITLE = "Входящие - Почта Mail.Ru";
    private static final By LOGOUT_LINK = By.id("PH_logoutLink");

    InboxPage() {
        super(TITLE);
    }

    LoginPage logout() {
        getLogoutLink().click();
        return new LoginPage();
    }

    WebElement getLogoutLink() {
        return driver.findElement(LOGOUT_LINK);
    }

}
