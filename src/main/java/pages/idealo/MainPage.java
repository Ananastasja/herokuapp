package pages.idealo;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private static final By BODY = By.cssSelector("body");
    private static final By OK_BTN = By.cssSelector(".btn-accept-all");

    @FindBy(id = "i-search-input")
    private SelenideElement searchField;

    @FindBy(css = "body > div > iframe")
    private SelenideElement iframe;

    public ResultsPage enteringInSearchField(String searchElement) {
        searchField.setValue("ebike").pressEnter();
        return page(ResultsPage.class);
    }

    public void acceptCookiesBtn() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        WebElement frame = driver.switchTo().frame(iframe).findElement(BODY);
        frame.findElement(OK_BTN).click();
        driver.switchTo().parentFrame();
    }
}
