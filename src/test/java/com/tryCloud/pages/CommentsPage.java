package com.tryCloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentsPage extends BaseConst {

    @FindBy(xpath = "//ul[@id='appmenu']/li[2]/a")
    public WebElement filesLink;

    @FindBy(xpath = "//span[@class='fileactions']/a[2]")
    public WebElement actionIcon;

    @FindBy(xpath = "//span[.='Details']")
    public WebElement details;


    @FindBy(xpath = "//a[@id='commentsTabView']/span")
    public WebElement comments;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement messageInput;

    @FindBy(xpath = "//input[@class='submit icon-confirm has-tooltip']")
    public WebElement submitButton;

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement messageCheck;



}
