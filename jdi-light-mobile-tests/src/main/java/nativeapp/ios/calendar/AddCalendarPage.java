package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.ios.app.SystemButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AddCalendarPage {
    @MobileFindBy(accessibilityId = "Cancel")
    public static SystemButton cancelButton;
}
