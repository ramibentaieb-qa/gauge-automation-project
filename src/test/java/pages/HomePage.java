package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    
        private By dashboardTitle = By.cssSelector(".oxd-topbar-header-title h6");
        private By profileMenuButton = By.cssSelector(".oxd-topbar-header-userarea i");
        private By signoutButton = By.cssSelector("[href='/web/index.php/auth/logout']");

        public Boolean getDashboardTitle() {
           return waitForElementToBevisible(dashboardTitle, 3).isDisplayed();
        }

        public void openProfileMenu() {
            click(profileMenuButton);
        }

        public LoginPage signoutToLoginPage() {
            click(signoutButton);
            return new LoginPage();
        }

}
