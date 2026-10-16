package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By errorMessage = By.cssSelector("div[data-test='login-error']");
    private By loginTitle = By.cssSelector(".container h3");
    


    public void enterEmail(String email) {
        set(emailField, email);
    }

    public void enterPassword(String password) {
        set(passwordField, password);
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage();
    }

    public boolean getErrorMessage() {
        return waitForElementToBevisible(errorMessage, 2).isDisplayed();
    }

    public boolean getLoginTitle() {
        return waitForElementToBevisible(loginTitle, 2).isDisplayed();
    }

    
    
}
