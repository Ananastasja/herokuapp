package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class GlovoSecondPage {

    @FindBy(className = "title")
    private SelenideElement pageTitle;

    public SelenideElement getPageTitle() {
        return pageTitle;
    }
}
