package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchWindowToChild() {

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String mainWindowHandle = iterator.next();
        String newTabHandle = iterator.next();
        driver.switchTo().window(newTabHandle);

    }
}
