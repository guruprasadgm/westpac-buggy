package nz.co.westpac.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import nz.co.westpac.SampleDesiredCapabilitiesBuilder;
import nz.co.westpac.utils.DesiredCapabilitiesBuilderDefault;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class SampleWebDriverInjectionModule
        extends AbstractModule
{

    @Override
    protected void configure()
    {

    }

    @Provides
    DesiredCapabilitiesBuilderDefault providesDefaultDesiredCapilitiesBuilder()
    {
        return new SampleDesiredCapabilitiesBuilder()
                .addIfSystemPropertyExists(BROWSER_NAME);
    }
}