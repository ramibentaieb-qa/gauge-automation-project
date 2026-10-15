package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    
        private By pageTitle = By.cssSelector("h1[data-test='page-title']");
        private By profileMenuButton = By.cssSelector("[data-test='nav-menu']");
        private By signoutButton = By.cssSelector("[data-test='nav-sign-out']");

        public Boolean getPageTitle() {
           return waitForElementToBevisible(pageTitle, 3).isDisplayed();
        }

        public void openProfileMenu() {
            click(profileMenuButton);
        }

        public LoginPage signoutToLoginPage() {
            click(signoutButton);
            return new LoginPage();
        }

}
