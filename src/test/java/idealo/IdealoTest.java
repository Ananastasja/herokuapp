package idealo;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.herokuapp.EmailSentPage;
import pages.herokuapp.HoversPage;
import pages.idealo.MainPage;
import pages.idealo.ResultsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static pages.herokuapp.Commons.BASE_URL;
import static pages.idealo.Commons.BASE_URL_IDEALO;

public class IdealoTest {
    MainPage mainPage = open(BASE_URL_IDEALO, MainPage.class);


    @BeforeMethod
    public void cookiesAccept() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        mainPage.acceptCookiesBtn();
    }


    @Test
    public void searchForElement() {
        ResultsPage resultsPage = mainPage.enteringInSearchField("ebikes");
        resultsPage.searchTitlePage().shouldHave(text("E-Bikes"));
        resultsPage.clickOnDropdown("maxPrice");
        resultsPage.findFilterHighestPrice().equals(resultsPage.findGoodsHighestPrice());
    }

}
