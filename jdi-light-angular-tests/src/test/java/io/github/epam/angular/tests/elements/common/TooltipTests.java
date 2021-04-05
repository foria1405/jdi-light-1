package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TooltipSection.*;
import static io.github.epam.angular.tests.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class TooltipTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        if (tooltip.isDisplayed())
            refresh();
    }

    @Test
    public void basicTooltipTest() {
        basicTooltipButton.hover();
        tooltip.has().text("Petit a petit, l’oiseau fait son nid");
    }

    @Test
    public void delayTooltipTest() {
        int show = 3;
        int hide = 5;

        JAction showAction = () -> tooltip.waitFor().displayed();
        JAction hideAction = () -> tooltip.waitFor().hidden();

        showDelayInput.setValue(String.valueOf(show * 1000));
        hideDelayInput.setValue(String.valueOf(hide * 1000));

        delayTooltipButton.hover();
        duration(show, showAction);

        hideDelayInput.hover();
        duration(hide, hideAction);
    }

    @Test
    public void disabledTooltipTest() {
        disabledCheckbox.click();
        disabledTooltipButton.hover();
        tooltip.is().hidden();

        disabledCheckbox.click();
        disabledTooltipButton.hover();
        tooltip.is().displayed();
    }

    @Test
    public void manualShowHideTooltipTest() {
        showTooltipButton.click();
        tooltip.is().displayed();

        hideTooltipButton.click();
        tooltip.is().hidden();

        toggleTooltipButton.click();
        tooltip.is().displayed();

        toggleTooltipButton.click();
        tooltip.is().hidden();
    }

    @Test
    public void changeMessageTooltipTest() {
        String message = "Test Tooltip Message";

        changeMessageTooltipTextField.setValue(message);

        changeMessageTooltipButton.hover();
        tooltip.has().text(message);
    }

    @Test
    public void autoHideTooltipTest() {
        autoHideTooltipButton.hover();
        tooltip.is().displayed();

        autoHideTooltipContainer.core()
                .jsExecute("scrollTop=arguments[0].scrollHeight");
        autoHideTooltipButton.core()
                .jsExecute("scrollIntoView()");

        autoHideTooltipButton.is().displayed();
        tooltip.is().hidden();
    }
}