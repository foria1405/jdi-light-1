package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.SliderAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import org.apache.commons.lang3.NotImplementedException;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;

/**
 * To see an example of Slider web element please visit
 * https://material.angular.io/components/slider/overview
 */

public class Slider extends UIBaseElement<SliderAssert> implements HasLabel, SetValue {

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public double min() {
        return getDouble("aria-valuemin", core(), 0);
    }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public double max() {
        return getDouble("aria-valuemax", core(), 100);
    }

    @JDIAction(value = "Get '{name}' value", level = DEBUG)
    public double value() {
        return getDouble("aria-valuenow", core(), 0);
    }

    @JDIAction(value = "drag & drop based on percentage length of '{name}'", level = DEBUG)
    public void slide(double percentage) {
        int xOffset = (int) Math.round(percentage * getStepInPixels(core()));
        core().find(".mat-slider-thumb").dragAndDropTo(xOffset, 0);
    }

    private Double getStepInPixels(UIElement uiElement) {
        return uiElement.getSize().width / 100.0;
    }

    @JDIAction("Is '{name} disabled")
    @Override
    public boolean isEnabled() {
        return !core().attr("aria-disabled").equals("true");
    }

    @Override
    public String getValue() {
        return value() + "";
    }

    @Override
    public SliderAssert is() {
        return new SliderAssert().set(this);
    }

    public void setValue(String value) {
        throw new NotImplementedException();
    }
}
