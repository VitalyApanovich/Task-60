import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LoginPage extends Page{
    private final static String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";
    private static final By USERNAME_INPUT = By.id("mailbox:login");
    private static final By PASSWORD_INPUT = By.id("mailbox:password");
    private static final By LOGIN_BUTTON = By.id("mailbox:submit");

    LoginPage() {
        super(TITLE);
    }

    InboxPage login(String login, String pass) {
        driver.findElement(USERNAME_INPUT).sendKeys(login);
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
        getLoginButton().click();
        Waiter.explicitWait(20);
        return new InboxPage();
    }

    WebElement getLoginButton() {
        return driver.findElement(LOGIN_BUTTON);
    }

}
