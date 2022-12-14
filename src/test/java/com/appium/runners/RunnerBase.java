
package com.appium.runners;

import com.appium.manager.EmailManager;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;
import com.appium.manager.DriverManager;
import com.appium.manager.GlobalParams;
import com.appium.manager.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RunnerBase {
	private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

	public static TestNGCucumberRunner getRunner() {
		return testNGCucumberRunner.get();
	}

	private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1) {
		testNGCucumberRunner.set(testNGCucumberRunner1);
	}

	@Parameters({ "platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "wdaLocalPort",
			"webkitDebugProxyPort" })
	@BeforeClass(alwaysRun = true)
	public void setUpClass(String platformName, String udid, String deviceName, @Optional("Android") String systemPort,
			@Optional("Android") String chromeDriverPort, @Optional("iOS") String wdaLocalPort,
			@Optional("iOS") String webkitDebugProxyPort) throws Exception {

		ThreadContext.put("ROUTINGKEY", platformName + "_" + deviceName);

		GlobalParams params = new GlobalParams();
		params.setPlatformName(platformName);
		params.setUDID(udid);
		params.setDeviceName(deviceName);

		switch (platformName) {
		case "Android":
			params.setSystemPort(systemPort);
			params.setChromeDriverPort(chromeDriverPort);
			break;
		case "iOS":
			params.setWdaLocalPort(wdaLocalPort);
			params.setWebkitDebugProxyPort(webkitDebugProxyPort);
			break;
		}

		new ServerManager().startServer();
		new DriverManager().initializeDriver();

		setRunner(new TestNGCucumberRunner(this.getClass()));
	}


	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		getRunner().runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return getRunner().provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		DriverManager driverManager = new DriverManager();
		if (driverManager.getDriver() != null) {
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager = new ServerManager();
		if (serverManager.getServer() != null) {
			serverManager.getServer().stop();
		}
		if (testNGCucumberRunner != null) {
			getRunner().finish();
		}

	}

	@BeforeTest
	public void createFailedTestFile() throws IOException {
		Path path = Paths.get("failedtests.txt");
		try {
			Files.deleteIfExists(path);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File myObj = new File("failedtests.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@AfterTest
	public void mail(){
		EmailManager.sendMail();
	}

}
