package com.tryCloud.step_definitions;

import com.tryCloud.pages.CommentsPage;
import com.tryCloud.pages.FilePage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US_05_FavoriteStepDefs {
    CommentsPage commentsUS09 = new CommentsPage();
    FilePage filePage = new FilePage();
    String chosenFileName;

    @When("the user clicks action-icon from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.hover(filePage.actionIcon);
        filePage.actionIcon.click();
    }

    @And("user choose the {string} option")
    public void user_choose_the_option(String option) {

        if (option.contains("favorites") && !filePage.addToFavOpt.getText().equals(option)) {
            filePage.addToFavOpt.click();
            BrowserUtils.waitForClickablility(filePage.actionIcon, 5);
            filePage.actionIcon.click();
            BrowserUtils.sleep(2);
            chosenFileName = filePage.currentFileName.getText();
            filePage.addToFavOpt.click();
        }else if(option.contains("Details")){
              commentsUS09.details.click();
        } else {
            chosenFileName = filePage.currentFileName.getText();
            filePage.addToFavOpt.click();
            BrowserUtils.sleep(2);
        }
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        BrowserUtils.sleep(1);
//        System.out.println("expected: " + chosenFileName);
//        System.out.println("actual: " + filePage.chosenFileName.getText());
        Assert.assertEquals(chosenFileName, filePage.chosenFileName.getText());
    }

}

