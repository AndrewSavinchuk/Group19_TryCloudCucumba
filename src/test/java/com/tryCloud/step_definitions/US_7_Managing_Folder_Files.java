package com.tryCloud.step_definitions;

import com.tryCloud.pages.FilesPage;
import com.tryCloud.pages.LoginPage;
import com.tryCloud.pages.NewFolderPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.Driver;
import com.tryCloud.utilities.TryCloudUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class US_7_Managing_Folder_Files {
    /**
     * US 7 - As a User, I should be able to manage the files
     * CY19-150 As a user, I should be able to add the folder.
     * Background condition is already defined:
     * USER SHOULD BE ON A DASHBOARD PAGE.
     */
    //POM pages, that will be used in this US TC
    LoginPage loginPage = new LoginPage();
    FilesPage filesPage = new FilesPage();
    NewFolderPage newFolderPage = new NewFolderPage();
    Actions actions = new Actions(Driver.getDriver());

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    //new folder's name
    String name = "Developer";

    //when User clicks Files module (top line menu), it should be redirected to the Files page
    //when user clicks "+" button user should be able to add new files/folders/documents
    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        filesPage.addButton.click();
    }

    //when user clicks "New Folder" button, he should be able to type a new folder's name
    @When("user click \"new folder”")
    public void user_click_new_folder() {
        filesPage.newFolderButton.click();
    }

    //when user typed folder's name, then user should be able to submit his new folder with submit button
    @When("user write a folder name")
    public void user_write_a_folder_name() {
        BrowserUtils.sleep(4);

        filesPage.inputNewFolderName.sendKeys(name);
    }

    //user click the button with "-->" sign
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        BrowserUtils.sleep(3);
        filesPage.submitButton.click();
    }

    //the folder should be displayed on the page
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtils.sleep(3);
        WebElement newFolder = Driver.getDriver().findElement(By.xpath("//span/span[.='" + name + "']"));
        Assert.assertTrue(newFolder.isDisplayed());

    }

    /**
     * US 7 - As a User, I should be able to manage the files
     * CY19-151 As a user, I should be able to upload a file inside a folder.
     * Background condition is already defined:
     * USER SHOULD BE ON A DASHBOARD PAGE
     */

    //after verifying that new folder has been created, user clicking on it
    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        WebElement newFolder = Driver.getDriver().findElement(By.xpath("//span/span[.='" + name + "']"));
        newFolder.click();
    }

    //user clicks "+" button on a top menu
    @When("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {
        BrowserUtils.sleep(3);
        newFolderPage.addNewFileButton.click();
        BrowserUtils.sleep(4);
        String path = "C:\\Users\\Yuliia Starovoit\\Downloads\\SET_OPERATOR.pdf";
        newFolderPage.submitUploading.sendKeys(path);


    }

    //verifying that correct file  is uploaded
    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

        WebElement uploadedFile = Driver.getDriver().findElement(By.xpath("//span[@class = 'innernametext' and .='" +"SET_OPERATOR"+ "']"));
        wait.until(ExpectedConditions.visibilityOf(uploadedFile));
        BrowserUtils.sleep(3);
        Assert.assertTrue(uploadedFile.isDisplayed());

        //deleting folder, next time we run @US19-172 it will not give an error with the folder of
        //same name "Developer"
        newFolderPage.allFilesButton.click();

        WebElement developerFolder = Driver.getDriver().findElement(By.xpath("//span[@class='innernametext' and .='"+name+"']"));

        actions.contextClick(developerFolder).perform();
        filesPage.deleteFolder.click();
    }
}
