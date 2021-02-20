package herokuapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HoversPage;
import pages.LoginPage;
import pages.SecureArea;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    LoginPage loginPage;
    SecureArea secureArea;
    private ChromeDriver driver;

    @BeforeEach
    public void initPageObjects() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        secureArea = new SecureArea(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void successfulLogin() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tomsmith", "SuperSecretPassword!");
        loginPage.clickLogin();

        Assertions.assertEquals(secureArea.successfulText(), "You logged into a secure area!\n×");
    }

    @Test
    public void invalidUsername() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tom", "SuperSecretPassword!");
        loginPage.clickLogin();

        Assertions.assertEquals(loginPage.flashes(), "Your username is invalid!\n×");
    }

    @Test
    public void invalidPassword() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tomsmith", "abc");
        loginPage.clickLogin();

        Assertions.assertEquals(loginPage.flashes(), "Your password is invalid!\n×");
    }

    @Test
    public void successfulLogout() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tomsmith", "SuperSecretPassword!");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        secureArea.clickLogout();

        Assertions.assertEquals(loginPage.flashes(), "You logged out of the secure area!\n×");
    }
}
