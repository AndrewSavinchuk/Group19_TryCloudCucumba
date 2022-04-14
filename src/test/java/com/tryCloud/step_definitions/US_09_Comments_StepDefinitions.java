package com.tryCloud.step_definitions;

import com.tryCloud.pages.CommentsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_09_Comments_StepDefinitions {

    CommentsPage commentsUS09 = new CommentsPage();


    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        commentsUS09.actionIcon.click();
    }

    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        commentsUS09.comments.click();
        commentsUS09.messageInput.sendKeys("message check");
    }

    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        commentsUS09.submitButton.click();
    }

    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
    String actualMessage = commentsUS09.messageCheck.getText();
    String expectedMessage = "message check";
        Assert.assertEquals(expectedMessage,actualMessage);
    }


}
