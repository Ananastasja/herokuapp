package herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;
import pages.ResetPasswordPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.Commons.BASE_URL;

public class CheckboxTest {
    @Test
    public void checkingBox() {
        CheckboxesPage checkboxesPage = open(BASE_URL + "/checkboxes", CheckboxesPage.class);
        checkboxesPage.clickOnCheckbox();
        checkboxesPage.checkBoxSelect().shouldHave(Condition.attribute("checked"));
    }


}
