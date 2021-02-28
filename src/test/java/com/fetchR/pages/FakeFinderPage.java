package com.fetchR.pages;

import com.fetchR.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FakeFinderPage {

    public FakeFinderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="left_0")
    public WebElement left0;

    @FindBy(id="left_1")
    public WebElement left1;

    @FindBy(id="left_2")
    public WebElement left2;

    @FindBy(id="right_0")
    public WebElement right0;

    @FindBy(id="right_1")
    public WebElement right1;

    @FindBy(id="right_2")
    public WebElement right2;


    @FindBy(xpath = "//button[@id='reset' and .='Reset']")
    public WebElement reset;


    @FindBy(id="weigh")
    public WebElement weigh;

    @FindBy(id="coin_0")
    public WebElement coin_0;
    @FindBy(id="coin_1")
    public WebElement coin_1;
    @FindBy(id="coin_2")
    public WebElement coin_2;
    @FindBy(id="coin_3")
    public WebElement coin_3;
    @FindBy(id="coin_4")
    public WebElement coin_4;
    @FindBy(id="coin_5")
    public WebElement coin_5;
    @FindBy(id="coin_6")
    public WebElement coin_6;
    @FindBy(id="coin_7")
    public WebElement coin_7;
    @FindBy(id="coin_8")
    public WebElement coin_8;
    @FindBy(id="coin_9")
    public WebElement coin_9;


    @FindBy(xpath = "(//ol/li)[1]")
    public WebElement responseTableRow1;

    @FindBy(xpath = "(//ol/li)[2]")
    public WebElement responseTableRow2;





}
