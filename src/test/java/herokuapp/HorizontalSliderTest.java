package herokuapp;

import org.junit.jupiter.api.Test;
import pages.herokuapp.HorizontalSlider;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static pages.herokuapp.Commons.BASE_URL;

public class HorizontalSliderTest {
    @Test
    public void sliderCheck() {
        String value = "1.5";
        HorizontalSlider horizontalSlider = open(BASE_URL + "/horizontal_slider", HorizontalSlider.class);
        horizontalSlider.sliderMove(value);
        horizontalSlider.rangeValue().shouldHave(text(value));
    }
}
