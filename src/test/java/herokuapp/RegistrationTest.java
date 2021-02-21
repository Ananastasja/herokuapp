package herokuapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GlovoRegistration;
import pages.GlovoSecondPage;
import pages.ResetPasswordPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.Commons.BASE_URL;
import static pages.Commons.BASE_URL_GLOVO;

public class RegistrationTest {
    GlovoRegistration glovoRegistration;

    @BeforeEach
    public void acceptCookies() {
        glovoRegistration = open(BASE_URL_GLOVO + "/Partners", GlovoRegistration.class);
        glovoRegistration.acceptCookies();
    }

    @Test
    public void registrationCheck() {
        glovoRegistration = open(BASE_URL_GLOVO + "/Partners", GlovoRegistration.class);
        glovoRegistration.selectCountry("Италия");
        glovoRegistration.inputName("Anna");
        glovoRegistration.inputSurname("Petrova");
        glovoRegistration.inputEmail("hjbfbjhbf@mail.ru");
        glovoRegistration.phonePrefix("+49");
        glovoRegistration.phoneInput("15770041153");
        glovoRegistration.chooseType("Ресторан");
        glovoRegistration.numberBranchesInput("5");
        glovoRegistration.setCheckbox();
        GlovoSecondPage secondPage = glovoRegistration.buttonClick();
        secondPage.getPageTitle().should(exist);
    }
}

