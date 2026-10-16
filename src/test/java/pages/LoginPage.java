package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private By loginTitle = By.cssSelector(".orangehrm-login-title");
    


    public void enterUsername(String email) {
        set(usernameField, email);
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
