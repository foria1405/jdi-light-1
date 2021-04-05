package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.asserts.ProgressAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

public class ProgressBar extends UIBaseElement<ProgressAssert> {
    @JDIAction(value = "Get '{name}' max limit")
    public int max() {
        return getInt(core().attr("aria-valuemax"));
    }

    @JDIAction(value = "Get '{name}' min limit")
    public int min() {
        return getInt(core().attr("aria-valuemin"));
    }

    @JDIAction("Get '{name}' progress value ")
    public int value() {
        return getInt(core().attr("aria-valuenow"));
    }

    public String getValue() {
        return value() + "";
    }

    @JDIAction("Get '{name}' progress buffer value ")
    public double buffer() {
        return getProgress(".mat-progress-bar-buffer");
    }

    @JDIAction("Get '{name}' progress value ")
    public double progress() {
        return getProgress(".mat-progress-bar-primary");
    }
    private double getProgress(String cssClass) {
        UIElement bufferStyleClass = core().find(cssClass);
        String styleString = bufferStyleClass.attr("style");
        Pattern bufferValuePattern = Pattern.compile("\\(([0-9\\.]+)");
        Matcher matcher = bufferValuePattern.matcher(styleString);
        if (matcher.find()) {
            String bufferValue = matcher.group(1);
            return getDouble(bufferValue);
        }
        throw exception("No such expression in style string");
    }
}
