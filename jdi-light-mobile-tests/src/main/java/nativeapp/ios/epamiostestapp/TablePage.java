package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.ios.Switch;
import com.epam.jdi.light.mobile.elements.composite.ios.app.Table;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TablePage {

    @MobileFindBy(accessibilityId = "Table")
    public static Table table;

    @MobileFindBy(accessibilityId = "ToggleId")
    public static Switch aSwitch;
}
