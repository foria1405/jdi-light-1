package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TooltipSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class TooltipUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        if(tooltip.isDisplayed()) {
            refresh();
        }
    }

    @Test
    public void textTooltipTest() {
        String message = "New Test Tooltip Message";
        changeMessageTooltipTextField.setValue(message);
        changeMessageTooltipButton.hover();
        assertEquals(tooltip.text(), message);
    }

}
