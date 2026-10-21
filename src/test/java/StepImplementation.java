import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class StepImplementation {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeScenario
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
        homePage = new HomePage();
    }


    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        driver.get(url);
    }

    @Step("Enter valid username <username> and password <password>")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Step("Enter invalid username <wrongUsername> and password <wrongPassword>")
    public void enterWrongCredentials(String wrongUsername, String wrongPassword) {
        loginPage.enterUsername(wrongUsername);
        loginPage.enterPassword(wrongPassword);
    }
 
    @Step("Click the login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Step("Verify user is logged in successfully")
    public void verifyLogin() {
        boolean isDisplayed = homePage.getDashboardTitle();
        assertTrue(isDisplayed, "Login failed!");
    }

    @Step("verify error message is displayed")
    public void verifyErrorMessage() {
        boolean ActualErrorMesssage = loginPage.getErrorMessage();
        assertTrue(ActualErrorMesssage, "No error message has appeared");
    }

    @Step("Click on Logout button")
    public void clicklogout() {
        homePage.openProfileMenu();
        homePage.signoutToLoginPage();
        boolean isBackToLogin = loginPage.getLoginTitle();
        assertTrue(isBackToLogin, "Lougut failed!");
    }

    @AfterScenario 
    public void tearDown() {
        driver.quit();
    }

}