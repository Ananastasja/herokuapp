package quandoo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.quandoo.SearchPage;

import static com.codeborne.selenide.Selenide.open;

public class QuandooTest {
    static SearchPage searchPage;

    @BeforeAll
    public static void acceptCockies() {
        searchPage = open("https://www.quandoo.de/en/berlin", SearchPage.class);
        searchPage.acceptCookies();
    }

    @Test
    public void topRatedButton() {
        searchPage.clickOnTopRated();
        searchPage.topRatedBtnAttribute().shouldHave(Condition.attribute("data-state", "active"));
        searchPage.reviewScoreReturn().shouldBe(Condition.exist);
    }

    @Test
    public void cuisineFilter() {
        searchPage.clickOnCuisine();
        searchPage.africanCuisineResult().equals(searchPage.filterResultBrackets());
    }
}
