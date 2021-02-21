package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HorizontalSlider {

    private static final By slider = By.xpath("//input[@value='0']");
    private static final By rangeText = By.id("range");

    public void sliderMove(String sliderValue) {
        $(slider).setValue(sliderValue);
    }
    public SelenideElement rangeValue() {
        return $(rangeText);
    }
}
