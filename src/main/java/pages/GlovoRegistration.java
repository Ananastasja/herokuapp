package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static pages.Commons.BASE_URL_GLOVO;

public class GlovoRegistration {
    private static final String GLOVO_URL = BASE_URL_GLOVO + "/Partners";

    @FindBy(id = "onetrust-accept-btn-handler")
    SelenideElement cookies;

    @FindBy(xpath = "//div/div/p")
    private SelenideElement dropdownCountry;

    @FindBy(id = "countrySpan")
    private ElementsCollection countryList;

    @FindBy(xpath = "//div[2]/input")
    private SelenideElement firstNameInput;

    @FindBy(xpath = "//div[3]/input")
    private SelenideElement lastNameInput;

    @FindBy(xpath = "//input[@type='email']")
    private SelenideElement emailInput;

    @FindBy(css = ".multiselect__select")
    private SelenideElement dropdownCodeCountryTel;

    @FindBy(css = ".multiselect__option")
    private ElementsCollection listCodeCountry;

    @FindBy(name = "phone")
    private SelenideElement telInput;

    @FindBy(xpath = "//div[6]/div/p")
    private SelenideElement dropdownType;

    @FindBy(css = ".active > li")
    private ElementsCollection listOfTypes;

    @FindBy(name="numberBranches")
    private SelenideElement inputNumberBranches;

    @FindBy(css = ".label-icon")
    private SelenideElement checkBox;

    @FindBy(css = ".btn-primary")
    private SelenideElement nextButton;

    public void acceptCookies() {
        cookies.click();
    }

    public void selectCountry(String country) {
        dropdownCountry.click();
        countryList.findBy(text(country)).click();
    }

    public void inputName(String name) {
        firstNameInput.setValue(name);
    }

    public void inputSurname(String surname) {
        lastNameInput.setValue(surname);
    }

    public void inputEmail(String email) {
        emailInput.setValue(email);
    }

    public void phonePrefix(String phone) {
        dropdownCodeCountryTel.click();
        listCodeCountry.findBy(text(phone)).click();
    }

    public void phoneInput(String phoneNumber) {
        telInput.setValue(phoneNumber);
    }

    public void chooseType(String typeEstablishment) {
        dropdownType.click();
        listOfTypes.findBy(text(typeEstablishment)).click();
    }

    public void numberBranchesInput(String branches) {
        inputNumberBranches.setValue(branches);
    }

    public void setCheckbox() {
        checkBox.click();
    }

    public GlovoSecondPage buttonClick() {
        nextButton.click();
        return page(GlovoSecondPage.class);
    }




}
