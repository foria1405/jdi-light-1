package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ProgressBarSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class ProgressBarUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void isDisplayedTest() {
        assertTrue(progressBar.isDisplayed());
        assertTrue(matProgressBarQuery.isDisplayed());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isDisplayed());
        showBufferProgressBarButton.click();
        assertTrue(progressBarBuffer.isDisplayed());
        assertTrue(matProgressBarConfigurable.isDisplayed());
    }

    @Test
    public void isVisibleTest() {
        progressBar.show();
        assertTrue(progressBar.isVisible());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isVisible());
        showBufferProgressBarButton.click();
        assertTrue(progressBarBuffer.isVisible());
        matProgressBarQuery.show();
        assertTrue(matProgressBarQuery.isVisible());
        matProgressBarConfigurable.show();
        assertTrue(matProgressBarConfigurable.isVisible());
    }

    @Test
    public void verifyDisappearTest() {
        refresh();
        assertFalse(matProgressBarIndeterminate.isDisplayed());
        showIndeterminateProgressBarButton.click();
        assertTrue(matProgressBarIndeterminate.isDisplayed());
        matProgressBarIndeterminate.is().disappear(5);
        assertTrue(matProgressBarIndeterminate.isHidden());
        showBufferProgressBarButton.click();
        assertTrue(progressBarBuffer.isDisplayed());
        progressBarBuffer.is().disappear(5);
        assertTrue(progressBarBuffer.isHidden());
    }

    @Test
    public void verifyValuesTest() {
        assertEquals(progressBar.value(), 40);
        showBufferProgressBarButton.click();
        assertEquals(progressBarBuffer.buffer(), 0.0);
        assertEquals(progressBarBuffer.value(), 0);
        assertEquals(matProgressBarConfigurable.value(), 50);
    }

    @Test
    public void verifyMinValuesTest() {
        assertEquals(progressBar.min(), 0);
        showBufferProgressBarButton.click();
        assertEquals(progressBarBuffer.min(), 0);
        assertEquals(progressBarBuffer.min(), 0);
        showIndeterminateProgressBarButton.click();
        assertEquals(matProgressBarIndeterminate.min(), 0);
        assertEquals(matProgressBarQuery.min(), 0);
        assertEquals(matProgressBarConfigurable.min(), 0);
    }

    @Test
    public void verifyMaxValuesTest() {
        assertEquals(progressBar.max(), 100);
        showBufferProgressBarButton.click();
        assertEquals(progressBarBuffer.max(), 100);
        assertEquals(progressBarBuffer.max(), 100);
        showIndeterminateProgressBarButton.click();
        assertEquals(matProgressBarIndeterminate.max(), 100);
        assertEquals(matProgressBarQuery.max(), 100);
        assertEquals(matProgressBarConfigurable.max(), 100);
    }
}
