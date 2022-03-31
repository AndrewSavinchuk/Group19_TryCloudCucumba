package com.tryCloud.step_definitions;

import com.tryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    //@Before


    @After
    public void tearDown(Scenario scenario){
// scenario.isFailed --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        System.out.println("====Setting up browser user cucumber @After====");
//        System.out.println("====Scenario ended / if failed take a screenshot====");

    }



}
