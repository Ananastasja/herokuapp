package herokuapp;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import pages.herokuapp.CheckboxesPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.herokuapp.Commons.BASE_URL;

public class CheckboxTest {
    @Test
    public void checkingBox() {
        CheckboxesPage checkboxesPage = open(BASE_URL + "/checkboxes", CheckboxesPage.class);
        checkboxesPage.clickOnCheckbox();
        checkboxesPage.checkBoxSelect().shouldHave(Condition.attribute("checked"));
    }


}
