package com.tryCloud.step_definitions;

import com.tryCloud.pages.BaseConst;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class US_14_Search {

    BaseConst baseConst = new BaseConst();

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        BrowserUtils.highlight(baseConst.searchBtn);
        baseConst.searchBtn.click();
    }

    @When("users search any existing {string} file_folder_user name")
    public void users_search_any_existing_file_folder_user_name(String search) {
        BrowserUtils.highlight(baseConst.searchInput);
        baseConst.searchInput.sendKeys(search+ Keys.ENTER);
    }

    @Then("verify the app displays {string} the expected result option")
    public void verify_the_app_displays_the_expected_result_option(String result) {
        WebElement displayedResult = Driver.getDriver().findElement(By.xpath("//*[.='"+result+"']"));
        BrowserUtils.highlight(displayedResult);
        Assert.assertTrue(displayedResult.isDisplayed());
    }
}
