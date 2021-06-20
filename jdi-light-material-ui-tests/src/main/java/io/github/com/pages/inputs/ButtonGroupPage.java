package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

public class ButtonGroupPage extends WebPage {

    @XPath("(//button[contains(@class, 'MuiButton-root')])[1]")
    public ButtonGroup buttonGroup;

}
