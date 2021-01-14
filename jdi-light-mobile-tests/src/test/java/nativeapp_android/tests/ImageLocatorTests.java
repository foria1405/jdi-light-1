package nativeapp_android.tests;

import io.appium.java_client.MobileBy;
import nativeapp_android.ApiDemosTestInit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.testng.Assert.*;


public class ImageLocatorTests extends ApiDemosTestInit {

    private static final String CONTENT_PAGE = "iVBORw0KGgoAAAANSUhEUgAAAMEAAAAmCAYAAAB9A/+mAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAQ8SURBVHhe7ZnZK29RFMfvHyPiwZQUQoTygiIkJEIkhRCZkimZnowpmeeUIcrwQl6IDHlA5gxlnr2s23fV7/S7nN/ld4eHe/d6+PT7nb3O3uc8rM/ea+/z7e3tjQRBZUQCQXlEAkF5RAJBeUQCQXlEAkF5RAJBeUQCQXlEAkF5RAJBeUQCQXlEAkF5PpXg9PSUVldXaXl5mQ4PD+nl5UX3PkH4VzEpwevrK42MjJCbmxv5+/tTUFAQubq6UnNzMz0/P+v2MZenpyeW6+DgQDf+K2C8s7Mz3Zgg6GFSgrW1NfLz86PJyUlOVqwAi4uL5O3tTUtLS7p9zOXq6op8fHxoYGBAN/4rRERE0MzMjG5MEPQwKUFqaipVVlZ+aK+oqKDi4mLt+uHhgaampqiwsJDq6+vp6OhIi93f31NfXx//dnR0UF5eHs3NzXEMpVVrays5OztTRkYGDQ4Oav0wkzc1NVFRURFNT09rK8/JyQn19/dzX4yHZ87OznIcse7ubvLy8qKCggJ+pz+1Ygn/N7oS3N3dkbW1NY2Pj3+IXVxc0P7+Pv9/fHyktLQ0io2N5TIJSRscHEzr6+vavba2tpSbm0tVVVUskJOTE/X29nIi19TU8HVSUhK1t7dzn52dHQoPD+dEhgihoaFUW1vLMYyL90pISKDq6moqKysjT09PmpiYYPkaGhrIw8ODpRoeHhYJhC+hKwE2wzY2NrSwsPAhZgxm25CQELq5ueFr7CPq6urIxcWFZ39IYGlpSXt7exwDWVlZLAoS9H05hLIrICCASkpK+F60XV5ekru7O48HCSDVysqK9rzGxkaWD9dAyiHBXH4qwfz8/IeYMXFxcZSenq4lLMBJEhJ/d3dXk8C4D1YEJDrKqPcSoKRxcHCg0tJSGhoa0kCJgz0KJHB0dORVxDBeZ2cnZWZmatcigWAuuhLc3t6ShYUFlxl6cQNIYNT5xm3b29uc+FtbW2ZLgFMie3t7SkxM5BLKQE5ODm1ubupK0NXVJRIIv4XJjTFqfdTc79sxS5eXl/N/lCHJyck/1N7Y+FpZWdHx8bHZEmBDjCQfHR39oY8BkUD4G5iUYGNjg0sTHIciyQFmYzs7O60mx6yP+h+/iKOmT0lJ0ZLyMwmwl/D19aW2tjZNpPz8fIqMjOTNOY5lcR8SHWN/RYKYmBgaGxuTj3rClzEpAZIIH8vCwsIoKiqKoqOjeRPc09PDCWm4D6cw+JCGEyJseLOzs+n6+ppjn0mAZ+DkBx/hcCSLOMTAyVBgYCDFx8fzM1taWnjf8RUJcMqE1QWrFU6vDO2CYAqTEhhAomLDCkzNrkhQHFEakt9czs/PWRjjNuxLcBRrbiLjXfCuGFMvLgjv+VQCQfjfEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkExXmj74S+KY8360xxAAAAAElFTkSuQmCC";

//    @Test
//    public void findElementWithImage() {
//        IndexPage.contentPage.is().displayed();
//    }
//
//    @Test
//    public void clickElementWithImage() {
//        IndexPage.contentPage.is().enabled();
//        IndexPage.contentPage.click();
////       EspressoAppPage.alarmPage.is().displayed();
//    }

    private WebElement getContentPage() throws IOException {
        String contentPage = getRefImage("Content");
        List<WebElement> elementsList = getDriver().findElements(MobileBy.image(contentPage));
        return elementsList.get(0);
    }

    @Test
    public void getElement() throws IOException {
        assertTrue(getContentPage().isDisplayed());
    }

    protected String getRefImage(String refImgName) throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" +refImgName + ".png");
        Path path = file.toPath();
        return Base64.getEncoder().encodeToString(Files.readAllBytes(path));
    }
}
