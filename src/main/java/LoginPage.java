import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPage extends Page{
    private final static String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";
    @FindBy(id = "mailbox:login")
    private WebElement usernameInput;
    @FindBy(id = "mailbox:password")
    private WebElement passwordInput;
    @FindBy(id = "mailbox:submit")
    private WebElement loginButton;

    LoginPage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    InboxPage login(String login, String pass) {
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(pass);
        getLoginButton().click();
        Waiter.explicitWait(20);
        return new InboxPage();
    }

    WebElement getLoginButton() {
        return loginButton;
    }

}
