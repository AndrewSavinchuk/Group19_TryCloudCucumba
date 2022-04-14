package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewFolderPage {
    public NewFolderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addNewFileButton;

    @FindBy (xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement submitUploading;

    @FindBy(xpath = "//a[.='All files']")
    public WebElement allFilesButton;
}
