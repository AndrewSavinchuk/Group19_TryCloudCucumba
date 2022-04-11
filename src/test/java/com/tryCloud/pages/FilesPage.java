package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {
    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Files")
    public WebElement filesButton;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addButton;

    @FindBy(xpath = "(//a[@class='menuitem'])[1]")
    public WebElement newFolderButton;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement inputNewFolderName;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement submitButton;

    @FindBy (xpath = "//span[@class='icon icon icon-delete']")
    public WebElement deleteFolder;
}
