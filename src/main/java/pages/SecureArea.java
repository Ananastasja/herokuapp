package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea extends Page{
    public SecureArea(WebDriver driver) {
        super(driver);
    }

    private static final By logoutBtn = By.xpath("//i[contains(.,'Logout')]");
    private static final By flashes = By.id("flash");


    public String successfulText() {
        return driver.findElement(flashes).getText();
    }

    public LoginPage clickLogout() {
        driver.findElement(logoutBtn).click();
        return new LoginPage(driver);
    }
}
