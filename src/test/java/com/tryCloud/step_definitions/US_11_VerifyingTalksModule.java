package com.tryCloud.step_definitions;

import com.tryCloud.pages.TalksPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US_11_VerifyingTalksModule {
    TalksPage talksPage = new TalksPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @When("user clicks to submit button")
    public void user_clicks_to_submit_button() {
        BrowserUtils.highlight(talksPage.submitButton);
        talksPage.submitButton.click();
    }

    @When("user search {string} user from the search box")
    public void user_search_user_from_the_search_box(String user) {
        BrowserUtils.highlight(talksPage.searchBox);
        talksPage.searchBox.sendKeys(user+ Keys.ENTER);
        WebElement conversation = Driver.getDriver().findElement(By.xpath("//a[@aria-label='Conversation, " +user+"']"));
        BrowserUtils.highlight(conversation);
        conversation.click();
    }

    @Then("the user should be able to see the {string} message is displayed on the conversation log")
    public void the_user_should_be_able_to_see_the_message_is_displayed_on_the_conversation_log(String string) {
        WebElement writtenMessageBox = Driver.getDriver().findElement(By.xpath("//*[.='"+string+"']"));
        wait.until(ExpectedConditions.visibilityOf(writtenMessageBox));
        System.out.println(writtenMessageBox.getText());
        Assert.assertTrue(writtenMessageBox.isDisplayed());
    }

    @And("user writes  {string} in the message box")
    public void userWritesInTheMessageBox(String string) {
        BrowserUtils.highlight(talksPage.messageBox);
        talksPage.messageBox.sendKeys(string);
    }
}

