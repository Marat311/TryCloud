package com.TryCloud.pages;

import com.TryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommonArea {
    @FindBy(xpath = "(//li[@data-id='dashboard'])[1]")
    public WebElement dashboardModule;

    @FindBy(xpath = "(//a[@aria-label = 'Files'])[1]")
    public WebElement filesModule;

    @FindBy(xpath = "(//a[@aria-label='Photos'])[1]")
    public WebElement photosModule;

    @FindBy(xpath = "(//a[@aria-label='Activity'])[1]")
    public WebElement activityModule;

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkModule;

    @FindBy(xpath = "(//a[@aria-label='Contacts'])[1]")
    public WebElement contactsModule;

    @FindBy(xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendarModule;

    @FindBy(xpath = "(//a[@aria-label='Deck'])[1]")
    public WebElement deckModule;

    public CommonArea() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickModule(String moduleName){
        WebElement modules = Driver.getDriver().findElement(By.xpath("(//a[@aria-label = '"+moduleName+"'])[1]"));
        modules.click();
    }

    public boolean mainModulesIsDisplayed(String moduleName){

        WebElement module = Driver.getDriver().findElement(By.xpath("(//a[@aria-label = '"+moduleName+"'])[1]"));
        return module.isDisplayed();
    }

//    public String getMainModuleText(String moduleName){
//      moduleName = moduleName.toLowerCase();
//        WebElement module = Driver.getDriver().findElement(By.xpath("//li[@data-id='"+moduleName+"']"));
//        return module.getAttribute("value");
//    }

}
