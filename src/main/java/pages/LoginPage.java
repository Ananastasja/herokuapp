package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private static final String LOGIN_URL = BASE_URL + "/login";
    private static final By userName = By.id("username");
    private static final By password = By.id("password");
    private static final By loginBtn = By.className("radius");
    private static final By flashes = By.id("flash");

    public void goToLoginPage() {
        driver.navigate().to(LOGIN_URL);
    }

    public void insertCredentials(String userNameValue, String passwordValue) {

        driver.findElement(userName).sendKeys(userNameValue);
        driver.findElement(password).sendKeys(passwordValue);
    }

    public SecureArea clickLogin() {
        driver.findElement(loginBtn).click();
        return new SecureArea(driver);
    }

    public String flashes() {
        return driver.findElement(flashes).getText();
    }
}
