package nativeapp_android.tests;

import nativeapp.android.apidemos.IndexPage;
import nativeapp_android.ApiDemosTestInit;
import org.testng.annotations.Test;

public class ImageLocatorTests extends ApiDemosTestInit {

    @Test
    public void findElementWithImage() {
        IndexPage.contentPage.is().displayed();
    }

    @Test
    public void clickElementWithImage() {
        IndexPage.contentPage.is().enabled();
        IndexPage.contentPage.click();
//        EspressoAppPage.alarmPage.is().displayed();
    }
}


