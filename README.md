# westpac-buggy #westpacAssessment

Note: * All the tests were created and tested on a Mac OS Monterey version 12.6

pre-requesites
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

1. Clone the solution from following repo:
2. Chrome browser Version 116.0.5845.110 (Official Build) (64-bit) should be installed.
   ChromeDriver 116.0.5845.96 (already uploaded with the solution incase not able to download should be downloaded separately and location to be provided as mentioned below)
3. Firefox 107.0 (64-bit) should be installed.
   Gecko driver version v0.33.0  (already uploaded with the solution incase not able to download should be downloaded separately and location to be provided as mentioned below)
4. need to have java 8 installed on the execution machine

Steps to execute the test: Run the below commands in terminal (mac)
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

1. mac: ./gradlew clean

   win: gradlew clean
2. mac:  ./gradlew build

   win:   gradlew build
3. To run tests on Chrome:

   mac: ./gradlew test -Drun.test=true -DbrowserName="chrome" -Dwebdriver.chrome.driver="./src/test/resources/chromedriver" -DtargetAppURL="https://buggy.justtestit.org/" --info

   win: gradlew test -Drun.test=true -DbrowserName="chrome" -Dwebdriver.chrome.driver="src/test/resources/chromedriverwin.exe" -DtargetAppURL="https://buggy.justtestit.org/" --info

   (Note: in case the chrome driver was downloaded separately the location path should be provided for -Dwebdriver.chrome.driver)
4. To run the tests on Firefox:

   mac: ./gradlew test -Drun.test=true -DbrowserName="firefox" -Dwebdriver.gecko.driver="./src/test/resources/geckodriver" -DtargetAppURL="https://buggy.justtestit.org/" --info

   win: gradlew test -Drun.test=true -DbrowserName="firefox" -Dwebdriver.gecko.driver="src/test/resources/geckodriverwin.exe" -DtargetAppURL="https://buggy.justtestit.org/" --info

   (Note: in case the gecko driver was downloaded separately the location path should be provided for -Dwebdriver.gecko.driver)
