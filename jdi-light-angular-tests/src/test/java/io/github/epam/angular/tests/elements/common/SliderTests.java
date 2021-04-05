package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.elements.common.Keyboard;
import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SliderSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.Keys.ARROW_LEFT;
import static org.openqa.selenium.Keys.ARROW_RIGHT;

public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        // skip(); // not stable in CI. Sometimes setValue("anything") keeps focus on the field and nothing changes
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        setupValue(matSliderBasic, 0.0);
        setupValue(matSliderFormatting, 1.0);
        sliderConfigurableValue.setValue("0");
        sliderConfigurableMin.setValue("0");
        sliderConfigurableMax.setValue("100");
        sliderConfigurableStep.setValue("1");
    }

    @Test
    public void minTest() {
        matSliderBasic.show();
        matSliderBasic.is().minValue(0.0);

        matSliderFormatting.show();
        matSliderFormatting.is().minValue(1.0);

        matSliderConfigurable.show();
        matSliderConfigurable.is().minValue(0.0);
        sliderConfigurableMin.setValue("10");
        matSliderConfigurable.is().minValue(10.0);
    }

    @Test
    public void maxTest() {
        matSliderBasic.show();
        matSliderBasic.is().maxValue(100.0);

        matSliderFormatting.show();
        matSliderFormatting.is().maxValue(100000.0);

        matSliderConfigurable.show();
        matSliderConfigurable.is().maxValue(100.0);
        sliderConfigurableMax.setValue("1000");
        matSliderConfigurable.is().maxValue(1000.0);
    }

    @Test
    public void currentValueTest() {
        matSliderConfigurable.show();
        sliderConfigurableThumbLabel.check();
        sliderConfigurableValue.setValue("62");
        matSliderConfigurable.has().value(62.0);

        sliderConfigurableValue.setValue("100");
        matSliderConfigurable.has().value(100.0);

        sliderConfigurableValue.setValue("80.5");
        matSliderConfigurable.has().value(80.5);

        sliderConfigurableValue.setValue("0");
        matSliderConfigurable.has().value(0.0);
    }

    @Test
    public void stepValueTest() {
        matSliderConfigurable.show();
        sliderConfigurableStep.setValue("5");
        sliderConfigurableThumbLabel.check();
        sliderConfigurableValue.setValue("0");
        matSliderConfigurable.has().value(0.0);
        // TODO using Keys is unstable for CI
        // moveRight();
        // matSliderConfigurable.has().value(5.0);
        // moveRight();
        // moveRight();
        // moveRight();
        // matSliderConfigurable.has().value(20.0);
        // moveLeft();
        // matSliderConfigurable.has().value(15.0);
    }

    @Test
    public void sliderBasicGetValueTest() {
        matSliderBasic.show();
        matSliderBasic.has().value(0.0);
        setupValue(matSliderBasic, 30);
        matSliderBasic.has().value(30.0);
    }

    @Test
    public void sliderFormattingGetValueTest() {
        matSliderFormatting.has().value(1.0);
        matSliderFormatting.show();
        setupValue(matSliderFormatting, 2000);
        matSliderFormatting.has().value(2000.0);
    }

    @Test
    public void sliderConfigurableGetValueTest() {
        matSliderConfigurable.has().value(0.0);
        matSliderConfigurable.show();
        setupValue(matSliderConfigurable, 60);
        matSliderConfigurable.has().value(60.0);
    }

    @Test
    public void sliderBasicSetupValueTest() {
        matSliderBasic.show();
        setupValue(matSliderBasic, 15);
        matSliderBasic.has().value(15.0);
    }

    @Test
    public void sliderFormattingSetupValueTest() {
        matSliderFormatting.show();
        setupValue(matSliderFormatting, 650);
        matSliderFormatting.has().value(650.0);
    }

    @Test
    public void sliderConfigurableSetupValueTest() {
        matSliderConfigurable.show();
        setupValue(matSliderConfigurable, 35.5);
        matSliderConfigurable.has().value(35.5);
    }

    @Test
    public void sliderBasicValidationTest() {
        matSliderBasic.show();
        setupValue(matSliderBasic, 65);
        matSliderBasic.is().enabled();
        matSliderBasic.is().displayed();
        matSliderBasic.has().value(greaterThanOrEqualTo(0.0));
        matSliderBasic.has().value(lessThanOrEqualTo(100.0));
        matSliderBasic.has().value(65.0);
    }

    @Test
    public void sliderFormattingValidationTest() {
        matSliderFormatting.show();
        setupValue(matSliderFormatting, 8500);
        matSliderFormatting.is().enabled();
        matSliderFormatting.is().displayed();
        matSliderFormatting.has().value(greaterThanOrEqualTo(1.0));
        matSliderFormatting.has().value(lessThanOrEqualTo(100000.0));
        matSliderFormatting.has().value(equalTo(8500.0));
    }

    @Test
    public void sliderConfigurableValidationTest() {
        matSliderConfigurable.show();
        setupValue(matSliderConfigurable, 75);
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();
        matSliderConfigurable.has().value(greaterThanOrEqualTo(0.0));
        matSliderConfigurable.has().value(lessThanOrEqualTo(100.0));
        matSliderConfigurable.has().value(equalTo(75.0));
        setupValue(matSliderConfigurable, 0);
    }

    @Test
    public void isDisabledTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();

        sliderConfigurableDisabled.check();
        matSliderConfigurable.is().disabled();
        matSliderConfigurable.is().displayed();

        sliderConfigurableDisabled.uncheck();
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();
    }

    public static void moveRight() {
        Keyboard.press(ARROW_RIGHT);
    }

    public static void moveLeft() {
        Keyboard.press(ARROW_LEFT);
    }
    public static void setupValue(Slider slider, double value) {
        slider.core().setAttribute("aria-valuenow", value + "");

        UIElement trackBackground = slider.core().find(".mat-slider-track-background");
        UIElement trackFill = slider.core().find(".mat-slider-track-fill");
        UIElement thumbContainer = slider.core().find(".mat-slider-thumb-container");

        reflectSliderChangeOnUI(value, slider.max(), trackBackground, trackFill, thumbContainer);
    }
    public static void reflectSliderChangeOnUI(double value, double max,
             UIElement trackBackground, UIElement trackFill, UIElement thumbContainer) {
        String currentTrackBackground = trackBackground.attr("style");
        String currentTrackFill = trackFill.attr("style");
        String currentThumbContainer = thumbContainer.attr("style");

        String newTrackBackgroundValue = (1 - (value / max)) + "";
        String newTrackFillValue = value / max + "";
        String newThumbValue = (int) ((1 - (value / max)) * 100) + "";

        int backgroundStartPoint = currentTrackBackground.indexOf("3d(");
        int backgroundEndPoint = currentTrackBackground.indexOf(",");
        int fillStartPoint = currentTrackFill.indexOf("3d(");
        int fillEndPoint = currentTrackFill.indexOf(",");
        int thumbStartPoint = currentThumbContainer.indexOf("-");
        int thumbEndPoint = currentThumbContainer.indexOf("%");

        String newTrackBackground = currentTrackBackground.substring(0, backgroundStartPoint + 3) + newTrackBackgroundValue + currentTrackBackground.substring(backgroundEndPoint);
        String newTrackFill = currentTrackFill.substring(0, fillStartPoint + 3) + newTrackFillValue + currentTrackFill.substring(fillEndPoint).replace("display: none;", "");
        String newThumbContainer = currentThumbContainer.substring(0, thumbStartPoint) + "-" + newThumbValue + currentThumbContainer.substring(thumbEndPoint);

        trackBackground.setAttribute("style", newTrackBackground);
        trackFill.setAttribute("style", newTrackFill);
        thumbContainer.setAttribute("style", newThumbContainer);
    }


}
