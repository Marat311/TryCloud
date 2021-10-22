package com.TryCloud.step_definitions;

import com.TryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setupDriver(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }


    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
           byte[] screenShot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image.png", "Failed scenario");

        }
        Driver.closeBrowser();

    }
}
