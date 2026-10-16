import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    private String url = "https://practicesoftwaretesting.com/auth/login";

    @BeforeScenario
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        String ciEnv = System.getenv("CI");
            if (ciEnv != null && ciEnv.equalsIgnoreCase("true")) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");
        }

        driver = new ChromeDriver(options);
        if (ciEnv == null || !ciEnv.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
        homePage = new HomePage();
    }


    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        driver.get(url);  

        if (driver.getTitle().contains("Just a moment")) {
        throw new IllegalStateException(
            "Cloudflare challenge detected; login page did not load."
        );
    }

        WebDriverWait wait = new WebDriverWait(
            driver, Duration.ofSeconds(20)
        );

         wait.until(d ->
        ((org.openqa.selenium.JavascriptExecutor) d)
            .executeScript("return document.readyState")
            .equals("complete")
    );

    System.out.println("Current URL: " + driver.getCurrentUrl());
    System.out.println("Page title: " + driver.getTitle());
     System.out.println(
        "Email field exists: " +
        !driver.findElements(By.id("email")).isEmpty()
    );

    }

    @Step("Enter valid username <email> and password <password>")
    public void enterCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Step("Enter invalid username <wrongEmail> and password <wrongPassword>")
    public void enterWrongCredentials(String wrongEmail, String wrongPassword) {
        loginPage.enterEmail(wrongEmail);
        loginPage.enterPassword(wrongPassword);
    }
 
    @Step("Click the login button")
    public void clickLogin() {
        loginPage.clickLoginButton();
    }

    @Step("Verify user is logged in successfully")
    public void verifyLogin() {
        boolean isDisplayed = homePage.getPageTitle();
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