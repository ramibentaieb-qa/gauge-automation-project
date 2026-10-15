package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("input[data-test='login-submit']");
    private By errorMessage = By.cssSelector("div[data-test='login-error']");
    


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

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    
    
}
