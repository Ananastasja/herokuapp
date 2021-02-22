package pages.idealo;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {

    @FindBy(xpath = "(//select[@class=\"sortBox-formSelect\"])[1]")
    private SelenideElement sortDropDown;

    @FindBy(css = ".offerList-item:nth-child(1) .price")
    private SelenideElement priceEbike;

    @FindBy(name = "priceTo")
    private SelenideElement filterHighestPrice;

    @FindBy(className = "offerList-title")
    private SelenideElement searchTitle;

    public SelenideElement searchTitlePage() {
        return searchTitle;
    }

    public void clickOnDropdown(String value) {
        sortDropDown.selectOptionByValue(value);
    }

    public SelenideElement findFilterHighestPrice() {
        return filterHighestPrice;
    }

    public SelenideElement findGoodsHighestPrice() {
        return priceEbike;
    }
}
