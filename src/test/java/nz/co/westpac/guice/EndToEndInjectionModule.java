package nz.co.westpac.guice;

import com.google.inject.AbstractModule;
import nz.co.westpac.configs.TestAppURLFinder;
import nz.co.westpac.utils.URLFinder;

public class EndToEndInjectionModule
        extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(URLFinder.class).to(TestAppURLFinder.class);
    }
}

