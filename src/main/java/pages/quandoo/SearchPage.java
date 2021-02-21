package pages.quandoo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

    @FindBy(xpath = "//button[@data-qa='filter-button-top-rated']")
    private SelenideElement topRatedBtn;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    private SelenideElement okBtn;

    @FindBy(xpath = "//span[contains(.,'Review score: 4-6')]")
    private SelenideElement reviewScore;

    @FindBy(xpath = "(//i[@class=\"apti0f-5 ulye33-4 fESons\"])[1]")
    private SelenideElement africanCuisine;

    @FindBy(xpath = "//div[@data-qa=\"results-count\"]")
    private SelenideElement resultsNumber;

    @FindBy(xpath = "(//span[@class='ulye33-6 hZxYrh'])[1]")
    private SelenideElement filterNumber;

    public void clickOnTopRated() {
        topRatedBtn.click();
    }

    public void clickOnCuisine() {
        africanCuisine.click();
    }

    public SelenideElement africanCuisineResult() {
        return resultsNumber;
    }

    public SelenideElement filterResultBrackets() {
        return filterNumber;
    }

    public SelenideElement topRatedBtnAttribute() {
        return topRatedBtn;
    }

    public void acceptCookies() {
        okBtn.click();
    }

    public SelenideElement reviewScoreReturn() {
        return reviewScore;
    }



}
