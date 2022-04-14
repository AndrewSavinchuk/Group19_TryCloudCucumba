package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilePage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_8_Delete_Files_StepDefs {

    FilePage filePage = new FilePage();
    String fileName;

    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        filePage.triDots.click();

    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {

        fileName = filePage.fileName.getText();

        filePage.deleteFile.click();

    }

    @When("the user clicks the {string} sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side(String string) {
        BrowserUtils.highlight(filePage.deletedFiles);
        filePage.deletedFiles.click();
    }

    @Then("Verify the deleted file is displayed on the page")
    public void verify_the_deleted_file_is_displayed_on_the_page() {


        WebElement element = Driver.getDriver().findElement(By.xpath("(//td//*[.='" + fileName + "'])[1]"));
        BrowserUtils.highlight(element);
        Assert.assertTrue(element.isDisplayed());
        BrowserUtils.highlight(filePage.restoreBtn);
        filePage.restoreBtn.click();
    }


}
