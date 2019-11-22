package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class InputGroupInputWithLabelAndText extends Section{
    @UI(".input-group-text") public Text text;
    @UI("#basic-url") public TextField input;
}
