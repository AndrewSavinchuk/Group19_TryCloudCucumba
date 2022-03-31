package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilePage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import com.tryCloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Base_Steps {

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        TryCloudUtils.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String pageName) {
        TryCloudUtils.navigateTo(pageName);
    }

    @When("user click the {string} sub-module")
    public void user_click_the_sub_module_on_the_left_side(String module) {
        FilePage.clickSubModule(module);
    }

    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(10);
    }
}
