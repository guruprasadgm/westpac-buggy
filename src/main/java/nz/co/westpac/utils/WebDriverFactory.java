package nz.co.westpac.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface WebDriverFactory
{
    WebDriver create(DesiredCapabilities capabilities);
}
