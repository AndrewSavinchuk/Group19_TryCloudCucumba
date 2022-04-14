package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalksPage {

    public TalksPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@placeholder='Search conversations or users']") public WebElement searchBox;
    @FindBy (xpath = "//div[@class='new-message-form__advancedinput']") public WebElement messageBox;
    @FindBy (xpath = "//button[@type='submit']") public WebElement submitButton;
}
