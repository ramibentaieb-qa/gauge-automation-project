import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class StepImplementation {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected HomePage homePage;

    private String url = "https://practicesoftwaretesting.com/auth/login";


    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);


        basePage = new BasePage();
        basePage.setDriver(driver);
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Step("Enter valid username <email> and password <password>")
    public void enterCredentials(String email, String password) {
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @Step("Enter invalid username <wrongEmail> and password <wrongPassword>")
    public void enterWrongCredentials(String wrongEmail, String wrongPassword) {
        try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
        loginPage.enterEmail(wrongEmail);
        loginPage.enterPassword(wrongPassword);
    }
 
    @Step("Click the login button")
    public void clickLogin() {
        // driver.findElement(By.cssSelector("input[data-test='login-submit']")).click();
        loginPage.clickLoginButton();
    }

    @Step("Verify user is logged in successfully")
    public void verifyLogin() {
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        // boolean isDisplayed = driver.findElement(By.cssSelector("h1[data-test='page-title']")).isDisplayed();
        boolean isDisplayed = homePage.getPageTitle();
        assertTrue(isDisplayed, "Login failed!");
        driver.quit();
    }

    @Step("verify error message is displayed")
    public void verifyErrorMessage() {
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        String ExptectedErrorMessage = "Invalid email or password";
        String ActualErrorMesssage = loginPage.getErrorMessage();
        assertEquals(ExptectedErrorMessage, ActualErrorMesssage);
    }

    @Step("Click on Logout button")
    public void clicklogout() {
        homePage.openProfileMenu();
        homePage.signoutToLoginPage();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        boolean isBackToLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='login-submit']"))).isDisplayed();
        assertTrue(isBackToLogin, "Lougut failed!");
        driver.quit();
    }

}