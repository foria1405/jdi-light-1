package com.epam.jdi.light.mobile.elements.composite.ios.app;

import io.appium.java_client.MobileBy;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public abstract class BaseTable extends Menu {

    private static String selector = "type == 'XCUIElementTypeCell'";

    public static int size() {
        return getDriver().findElements(MobileBy.iOSNsPredicateString(selector)).size();
    }

    public static List<String> getNamesOfCells() {
        return getDriver().findElements(MobileBy.iOSNsPredicateString(selector))
                .stream()
                .map(p -> p.getText())
                .collect(Collectors.toList());
    }
}