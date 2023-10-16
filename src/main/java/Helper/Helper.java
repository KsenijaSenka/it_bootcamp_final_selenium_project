package Helper;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Helper {
    public static void captureScreenshot(WebDriver driver, String path) {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(f, new File(path));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
