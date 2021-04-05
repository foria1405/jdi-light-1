package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/checkbox/overview.
 */

public class Checkbox extends com.epam.jdi.light.ui.html.elements.common.Checkbox implements HasLabel, HasClick, HasCheck, CanBeSelected {
    @Override @JDIAction("Is '{name}' selected")
    public boolean isSelected() {
        return hasClass("mat-checkbox-checked")
            || hasAttribute("aria-checked")
                && attr("aria-checked").equals("true")
            || super.isSelected();
    }

    @Override @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return !hasClass("mat-checkbox-disabled") && super.isEnabled();
    }
}
