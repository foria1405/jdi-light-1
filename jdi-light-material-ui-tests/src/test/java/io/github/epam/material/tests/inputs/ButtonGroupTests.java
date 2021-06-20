package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.*;
import io.github.com.pages.inputs.ButtonGroupPage.*;

public class ButtonGroupTests extends TestsInit {

    @Test
    public void defaultButtonGroupTest() {
        inputButtonGroupDefaultPage.open();

        buttonGroupPage.buttonGroup.getButtonByIndex(1).click();
        buttonGroupPage.buttonGroup.getButtonByIndex(2).click();
        buttonGroupPage.buttonGroup.getButtonByIndex(3).click();

        buttonGroupPage.buttonGroup.getButtonByText("Three").click();
        buttonGroupPage.buttonGroup.getButtonByText("Two").click();
        buttonGroupPage.buttonGroup.getButtonByText("One").click();

        buttonGroupPage.buttonGroup.getButtonByIndex(1).is().enabled();
        buttonGroupPage.buttonGroup.getButtonByIndex(1).has().text("ONE");
    }

    @Test
    public void disabledButtonGroupTest() {
        inputButtonGroupDisabledPage.open();

        buttonGroupPage.buttonGroup.getButtonByIndex(1).is().disabled();
        buttonGroupPage.buttonGroup.getButtonByText("Two").is().disabled();
    }

    @Test
    public void splitButtonGroupTest() {
        inputButtonGroupSplitPage.open();

        splitButtonGroupFrame.buttonGroup.getMainButton().click();
        splitButtonGroupFrame.buttonGroup.getMainButton()
                .has().text("SQUASH AND MERGE");
        splitButtonGroupFrame.buttonGroup.select("Update project");
        splitButtonGroupFrame.buttonGroup.getMainButton()
                .has().text("UPDATE PROJECT");


    }
}
