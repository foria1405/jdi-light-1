package io.github.epam;

import io.github.com.StaticSite;
import io.github.epam.testng.TestNGListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static com.epam.jdi.light.settings.JDISettings.DRIVER;
import static com.epam.jdi.light.settings.WebSettings.logger;

@Listeners(TestNGListener.class)
public class TestsInit {

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        killAllSeleniumDrivers();
        openSite(StaticSite.class);
        logger.toLog("Run Tests");
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown() {
        killAllSeleniumDrivers();
    }

    @AfterMethod
    public static void refreshPageOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            reload();
        }
    }

    public boolean isFireFox() {
        String ffName = "firefox";
        logger.info("Browser %s is used. isFirefox=%s", DRIVER.name, ffName.equalsIgnoreCase(DRIVER.name));
        return ffName.equalsIgnoreCase(DRIVER.name);
    }

    public void skipForFirefox() {
        if (isFireFox()) {
            throw new SkipException("Test is skipped for Firefox browser");
        }
    }

    public void skip() {
        throw new SkipException("Test is skipped for Firefox browser");
    }
}
