package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {

    public FilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@class='button new']") public WebElement addNewFileBtn;
    @FindBy (xpath = "//input[@id='file_upload_start']") public WebElement upload;
    @FindBy (xpath = "//div[@id='app-settings-content']//input[@type='checkbox']//following-sibling::label") public List<WebElement> settingsCheckboxesBtn;
    @FindBy (xpath = "//div[@id='app-settings-content']//input[@type='checkbox']") public List<WebElement> settingsCheckboxes;
    @FindBy (xpath = "//p[contains(text(),'used')]") public WebElement storageStatus;
    @FindBy (xpath = "//div[@id='uploadprogressbar']") public WebElement uploadBar;
    @FindBy (xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span") public WebElement notEnoughSpaceBtn;

    @FindBy (xpath = "//li[@class=' action-delete-container']/a") public WebElement optionDelete;

    @FindBy(xpath ="//*[@for='select_all_files']" ) public WebElement TopLeftCheckbox;
    @FindBy (xpath = "//tbody/tr") public List<WebElement> listCheckboxes;

    public static void clickSubModule(String module){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@id='app-navigation']//*[normalize-space(.)='"+module+"']"));
        BrowserUtils.highlight(element);
        element.click();
        BrowserUtils.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
    }
}
