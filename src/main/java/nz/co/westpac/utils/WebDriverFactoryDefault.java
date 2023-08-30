package nz.co.westpac.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactoryDefault
        implements WebDriverFactory
{
    @Override
    public WebDriver create(DesiredCapabilities capabilities)
    {
        return new LocalWebDriverProvider(capabilities).createLocalWebDriver();
    }
}