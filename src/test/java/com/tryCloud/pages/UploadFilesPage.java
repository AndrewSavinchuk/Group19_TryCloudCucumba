package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilesPage {

    public UploadFilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='testing']") public WebElement file3Name;
    @FindBy (xpath = "//span[.='testing' and @class='innernametext']/../..//a[@class='action action-menu permanent']") public WebElement file3row;
}
