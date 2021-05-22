package utilities;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitUtil {



    private WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public int getExplicitTimeout() {
        //Gets the predefined explicit wait from the config.reader & then returns the same in integer format
        return Integer.parseInt(ConfigReader.get("explicit.wait"));
    }

    public int getImplicitTimeout() {
        //Gets the predefined implicit wait from the config.reader & then returns the same in integer format
        return Integer.parseInt(ConfigReader.get("implicit.wait"));
    }

    public int getPollTime() {
        //Gets the predefined pollTime wait from the config.reader & then returns the same in integer format
        return Integer.parseInt(ConfigReader.get("poll.time"));
    }    