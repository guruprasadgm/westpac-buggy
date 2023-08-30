package nz.co.westpac.test;

import com.google.inject.Inject;
import com.google.inject.util.Modules;
import nz.co.westpac.guice.EndToEndInjectionModule;
import nz.co.westpac.guice.SampleWebDriverInjectionModule;
import nz.co.westpac.rules.DependencyInjectionRule;
import nz.co.westpac.rules.ScreenshotUponFailureRule;
import nz.co.westpac.rules.TestFinalisingRule;
import nz.co.westpac.utils.WebDriverInjectionModule;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class TestBase
{
    @Inject
    private WebDriver webDriver;

    @Inject
    private DesiredCapabilities cap;

    @Rule
    public RuleChain chain = RuleChain
            .outerRule(new DependencyInjectionRule(this, Modules.override(new WebDriverInjectionModule()).with(new SampleWebDriverInjectionModule()), new EndToEndInjectionModule()))
            .around(new TestFinalisingRule(this::getWebDriver))
            .around(new ScreenshotUponFailureRule(this::getWebDriver));


    private WebDriver getWebDriver()
    {
        return webDriver;
    }
}