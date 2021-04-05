package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.ProgressBarSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class ProgressBarTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyProgressBarTest() throws Exception {
        progressBar.shouldBe().displayed();
        progressBar.show();
        progressBar.shouldBe().visible();
        progressBar.has().value(40);
        progressBar.has().max(100);
        progressBar.has().min(0);
        progressBar.has().color(BLUE);
    }

    @Test
    public void verifyQueryProgressBarTest() {
        matProgressBarQuery.shouldBe().displayed();
        matProgressBarQuery.show();
        matProgressBarQuery.shouldBe().visible();
        matProgressBarQuery.has().max(100);
        matProgressBarQuery.has().min(0);
        matProgressBarQuery.has().color(BLUE);
    }

    @Test
    public void verifyBufferProgressBarTest() throws Exception {
        showBufferProgressBarButton.click();
        progressBarBuffer.shouldBe().displayed();
        progressBarBuffer.show();
        progressBarBuffer.shouldBe().visible();
        progressBarBuffer.has().value(0);
        progressBarBuffer.has().buffer(0.0);
        progressBarBuffer.has().max(100);
        progressBarBuffer.has().min(0);
        progressBarBuffer.has().color(BLUE);
        progressBarBuffer.is().disappear(5);
    }

    @Test
    public void verifyConfigurableProgressBarColorTransformationsTest() {
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsAccentColorRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(YELLOW);
        progressBar.has().color(BLUE);
        matProgressBarQuery.has().color(BLUE);
        progressBarsWarnColorRadio.click();
        matProgressBarConfigurable.has().color(RED);
        progressBarsIndeterminateModeRadio.click();
        matProgressBarConfigurable.has().color(RED);
        progressBarsPrimaryColorRadio.click();
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsDeterminateModeRadio.click();
    }

    @Test
    public void verifyConfiguredProgressBarModeTransformationsTest() throws Exception {
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsQueryModeRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsIndeterminateModeRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.is().visible();
        matProgressBarConfigurable.has().color(BLUE);
        progressBarsBufferModeRadio.click();
        matProgressBarConfigurable.is().displayed();
        matProgressBarConfigurable.show();
        matProgressBarConfigurable.has().color(BLUE);
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().buffer(0.75);
    }

    @Test
    public void verifyDeterminateModeValuesTransformation() throws Exception {
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        // TODO using Keys is unstable for CI
        // moveRight();
        // matProgressBarConfigurable.has().value(51);
        // while (!matProgressBarConfigurable.getValue().equals("100")) {
        //     moveRight();
        // }
        // matProgressBarConfigurable.has().value(100);
        // while (!matProgressBarConfigurable.getValue().equals("0")) {
        //     moveLeft();
        // }
        // matProgressBarConfigurable.has().value(0);
        // while (!matProgressBarConfigurable.getValue().equals("50")) {
        //     moveRight();
        // }
    }

    @Test
    public void verifyBufferModeValuesTransformation() throws Exception {
        progressBarsBufferModeRadio.click();
        matProgressBarConfigurable.has().value(50);
        matProgressBarConfigurable.has().buffer(0.75);
        matProgressBarConfigurable.has().max(100);
        matProgressBarConfigurable.has().min(0);
        // TODO using Keys is unstable for CI
        // moveRight();
        // matProgressBarConfigurable.has().value(51);
        // while (!matProgressBarConfigurable.getValue().equals("25")) {
        //     moveLeft();
        // }
        // matProgressBarConfigurable.has().value(25);
        // matProgressBarConfigurable.has().progress(0.25);
        // while (matProgressBarConfigurable.buffer() != 0.95) {
        //     moveRight();
        // }
        // matProgressBarConfigurable.has().buffer(0.95);
        // while (matProgressBarConfigurable.buffer() != 0.75) {
        //     moveLeft();
        // }
        // matProgressBarConfigurable.has().buffer(0.75);
        // while (!matProgressBarConfigurable.getValue().equals("50")) {
        //     moveRight();
        // }
        // matProgressBarConfigurable.has().value(50);
    }
}
