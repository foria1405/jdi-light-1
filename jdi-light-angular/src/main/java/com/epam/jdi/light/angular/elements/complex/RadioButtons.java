package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.asserts.generic.SelectedAssert;
import com.epam.jdi.light.asserts.generic.UIMSelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

/**
 * To see an example of RadioButtons web element please visit https://material.angular.io/components/radio/overview.
 */

public class RadioButtons extends UIBaseElement<UIMSelectAssert<?,?>> {

    // TODO wrong implementation
    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void click(String value) {
        getRadioButtonByTagValue(value).click();
    }

    @JDIAction("'{name}' radio button  contain value '{0}'")
    public boolean isChecked(String value) {
        return getRadioButtonByTagValue(value).attr("class").contains("mat-radio-checked");
    }

    private UIElement getRadioButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getRadioButtons()) {
            if (e.find("input").attr("value").equalsIgnoreCase(value)) {
                element = e;
            }
        }
        return element;
    }

    private WebList getRadioButtons() {
        return this.finds(".mat-radio-button");
    }
}

