package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxesPage {

    private static final By CHECKBOX1 = By.xpath("//form/input[1]");

    public void clickOnCheckbox() {
        checkBoxSelect().click();
    }

    public SelenideElement checkBoxSelect() {
        return $(CHECKBOX1);
    }
}
