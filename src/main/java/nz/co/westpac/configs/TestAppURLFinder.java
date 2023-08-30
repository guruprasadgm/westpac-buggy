package nz.co.westpac.configs;

import nz.co.westpac.utils.URLFinder;
import org.apache.commons.lang3.StringUtils;

public class TestAppURLFinder
        implements URLFinder
{
    @Override
    public String getBaseURL()
    {
        String applicationUnderTest = System.getProperty("targetAppURL");

        if (StringUtils.isNotBlank(applicationUnderTest))
        {
            return applicationUnderTest;
        }

        return "https://buggy.justtestit.org/";
    }
}
