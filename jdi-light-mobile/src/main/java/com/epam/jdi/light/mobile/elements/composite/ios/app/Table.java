package com.epam.jdi.light.mobile.elements.composite.ios.app;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.ios.Slider;
import com.epam.jdi.light.mobile.elements.common.app.ios.Switch;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;

import static com.epam.jdi.light.mobile.MobileUtils.GET_BUTTON;

public class Table extends BaseTable {

    private Object pageObject = this;

    @JDIAction(value = "Perform tap on '{name}' {0} button")
    public void tapButton(String buttonName) {
        HasTouchActions button = GET_BUTTON.execute(pageObject, buttonName);
        button.tap();
    }

    public void switchToggleToOn(Switch toggle) {
        toggle.setToOn();
    }

    public void switchToggleToOff(Switch toggle) {
        toggle.setToOff();
    }

    public boolean switchIsOn(Switch toggle) {
        return toggle.isOn();
    }

    public void setSliderValue(Slider slider, String value) {
        slider.setSliderValue(value);
    }

    public void setMinimumValue(Slider slider) {
        slider.setMinimumValue();
    }

    public void setMaximumValue(Slider slider) {
        slider.setMaximumValue();
    }


}
