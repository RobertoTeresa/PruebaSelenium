/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.stepDefinitions;

import java.io.*;

import com.appium.manager.VideoManager;
import com.appium.utils.DriverUtils;
import com.appium.utils.Flags;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static AppiumDriver driver;
    public static final int TIMEOUT = 10;

    @Before
    public void initialize() throws Exception {
        //String browser = Flags.getInstance().getBrowser();
        //driver = DriverUtils.setUpDriver(webDriver, browser, TIMEOUT);
        new VideoManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        //DriverUtils.quitDriver(webDriver);
        new VideoManager().stopRecording(scenario.getName().replace('"',' ').replace(" ",""));
        if(scenario.isFailed()) {
            try {
                FileWriter myWriter = new FileWriter("failedtests.txt",true);
                myWriter.write(scenario.getName());
                myWriter.write(System.getProperty( "line.separator" ));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
}
