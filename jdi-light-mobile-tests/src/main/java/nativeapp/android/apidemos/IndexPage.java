package nativeapp.android.apidemos;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class IndexPage {

    @MobileFindBy(accessibilityId = "Animation")
    public static Button animationPage;

    @MobileFindBy(accessibilityId = "Views")
    public static Button viewsPage;

    @MobileFindBy(accessibilityId = "App")
    public static Button appPage;

    @MobileFindBy(accessibilityId = "Progress Bar")
    public static Button goToProgressBarPageStageOne;

    @MobileFindBy(accessibilityId = "1. Incremental")
    public static Button goToProgressBarPageStageTwo;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Progress Bar']")
    public static Button goToProgressBarPageStageThree;

    @MobileFindBy(accessibilityId = "Popup Menu")
    public static Button popUpMenu;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    public static Button goToViewPage;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Popup Menu']")
    public static Button goToPopupMenuPage;

    @MobileFindBy(xpath = "//android.widget.TextView[@content-desc='Rating Bar']")
    public static Button goToRatingBar;

    @MobileFindBy(image = "iVBORw0KGgoAAAANSUhEUgAAAMEAAAAmCAYAAAB9A/+mAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAQ8SURBVHhe7ZnZK29RFMfvHyPiwZQUQoTygiIkJEIkhRCZkimZnowpmeeUIcrwQl6IDHlA5gxlnr2s23fV7/S7nN/ld4eHe/d6+PT7nb3O3uc8rM/ea+/z7e3tjQRBZUQCQXlEAkF5RAJBeUQCQXlEAkF5RAJBeUQCQXlEAkF5RAJBeUQCQXlEAkF5PpXg9PSUVldXaXl5mQ4PD+nl5UX3PkH4VzEpwevrK42MjJCbmxv5+/tTUFAQubq6UnNzMz0/P+v2MZenpyeW6+DgQDf+K2C8s7Mz3Zgg6GFSgrW1NfLz86PJyUlOVqwAi4uL5O3tTUtLS7p9zOXq6op8fHxoYGBAN/4rRERE0MzMjG5MEPQwKUFqaipVVlZ+aK+oqKDi4mLt+uHhgaampqiwsJDq6+vp6OhIi93f31NfXx//dnR0UF5eHs3NzXEMpVVrays5OztTRkYGDQ4Oav0wkzc1NVFRURFNT09rK8/JyQn19/dzX4yHZ87OznIcse7ubvLy8qKCggJ+pz+1Ygn/N7oS3N3dkbW1NY2Pj3+IXVxc0P7+Pv9/fHyktLQ0io2N5TIJSRscHEzr6+vavba2tpSbm0tVVVUskJOTE/X29nIi19TU8HVSUhK1t7dzn52dHQoPD+dEhgihoaFUW1vLMYyL90pISKDq6moqKysjT09PmpiYYPkaGhrIw8ODpRoeHhYJhC+hKwE2wzY2NrSwsPAhZgxm25CQELq5ueFr7CPq6urIxcWFZ39IYGlpSXt7exwDWVlZLAoS9H05hLIrICCASkpK+F60XV5ekru7O48HCSDVysqK9rzGxkaWD9dAyiHBXH4qwfz8/IeYMXFxcZSenq4lLMBJEhJ/d3dXk8C4D1YEJDrKqPcSoKRxcHCg0tJSGhoa0kCJgz0KJHB0dORVxDBeZ2cnZWZmatcigWAuuhLc3t6ShYUFlxl6cQNIYNT5xm3b29uc+FtbW2ZLgFMie3t7SkxM5BLKQE5ODm1ubupK0NXVJRIIv4XJjTFqfdTc79sxS5eXl/N/lCHJyck/1N7Y+FpZWdHx8bHZEmBDjCQfHR39oY8BkUD4G5iUYGNjg0sTHIciyQFmYzs7O60mx6yP+h+/iKOmT0lJ0ZLyMwmwl/D19aW2tjZNpPz8fIqMjOTNOY5lcR8SHWN/RYKYmBgaGxuTj3rClzEpAZIIH8vCwsIoKiqKoqOjeRPc09PDCWm4D6cw+JCGEyJseLOzs+n6+ppjn0mAZ+DkBx/hcCSLOMTAyVBgYCDFx8fzM1taWnjf8RUJcMqE1QWrFU6vDO2CYAqTEhhAomLDCkzNrkhQHFEakt9czs/PWRjjNuxLcBRrbiLjXfCuGFMvLgjv+VQCQfjfEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkE5REJBOURCQTlEQkExXmj74S+KY8360xxAAAAAElFTkSuQmCC")
    public static Button contentPage;

    @MobileFindBy(image = "iVBORw0KGgoAAAANSUhEUgAAAIkAAAAmCAYAAADwbrjyAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAFiUAABYlAUlSJPAAAAP/SURBVHhe7ZjJK/VhFMffv0UpUoYszFNYCQtDCZEhmRYolCJskCljpmRYSIbYiIWEjcwWFqbITOb5br5v59T95V6XJ/d17/u+dRaffvf5nd/z/G49n3uec+4vnU4HQfgKkURQIpIISkQSQYlIIigRSQQlIomgRCQRlIgkghKRRFAikghKRBJBiUgiKPnnJHl+fsbW1hYeHx9NxgXr821JxsfH0dzcjLu7O5Nx2uCWlhbMz8+bjKs4OzuDq6srdnZ2eDw8PIzu7m68vr5+eFawDt+WpKioCDY2Nujt7TUZLy0t5TiJZCquwliSgYEB9Pf3iyR/EbMk8fPzQ1BQEG5ubgxi19fX8PT0hL29/QdJnp6ecHt7a/IYeXl54cz08PCA09NTA0loHh1B75+ne/T8/f29yGMFzJKkoqICvr6+WFhYMIh1dHQgNjYWbm5umiRvb2+Ynp5GQkICUlNTERcXx5mBxKD4wcEB0tLSEBkZieTkZF77vSRNTU2oqqrSZFhcXERSUhIyMzN5rZycHJyfn3NMsAxmSdLa2soSVFZWavevrq4QEBCAwcFBeHt7a5Ksr6/Dzs4OMzMzPF5eXoajoyNWV1c5Q6SnpyMqKornU5aprq42kITel5GRwVLRUUQCDg0Ncezi4gIeHh5ob2/nsWAZzJKksbERm5ubfOTof8VUqJIkJycn8PLy0iQhkbKysrRMQJmFNp2KW9pkmrO2tqatf3x8/KkkdBxRYUxXWocko8xTXl6uzRd+HrMkqaur43ogJiYGPT09vGG0UV1dXVwrUF2ilyQ/P59FoGNIT2BgIGpqaviocXBwMKhTjAvX95LQe0jOkpISXtPHxwfOzs4oKyvT5gs/j1mS1NbW8ueRkRGEh4dje3sbwcHBfDWWpKCggLPJxsaGAYeHh4yTkxMXvPr1v5Jkd3cX7u7u3BZTgUuZiDKJSGJZ/kgS6lYoK+Tm5iIxMZEzgrEkDQ0NCA0N5fv6NS4vLzkTUR0SEhKCqakpzhIUI9E+k4QKYFtbWz7SKEZdDkkokliWP5KEoNqC/heZmJjgsbEk+/v7XMjm5eVhaWkJY2NjCAsL4y6F6pS2tjb4+/tzVpqcnER8fPynkuzt7XERTPdmZ2dRWFgIFxcXFBcXa99H+Hm+LUlnZyd3MPox/fJpE6mYpDFds7OzMTo6qj1DxS3VEREREdwKU6ejzxy0+X19fYiOjuYWeGVlhVvio6MjjlOdU19frxW+1C2lpKRwy0zfZW5ujjsi/buEn+fbkpgLSUHHEUlhKk5Hx2cxY+g5U3/KCZbBapII/y8iiaBEJBGUiCSCEpFEUCKSCEpEEkGJSCIoEUkEJSKJoEQkEZSIJIICHX4DT0yURfM44IYAAAAASUVORK5CYII=")
    public static Button mediaPage;
}
