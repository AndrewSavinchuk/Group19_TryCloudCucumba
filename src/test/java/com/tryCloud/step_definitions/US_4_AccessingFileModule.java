package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilePage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US_4_AccessingFileModule {

    FilePage filePage = new FilePage();

    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String Title) {
        BrowserUtils.titleVerify(Title);
    }

    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        filePage.TopLeftCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        for (WebElement each : filePage.listCheckboxes)
            Assert.assertTrue(each.getAttribute("class").contains("selected"));
    }

}



