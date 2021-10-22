package com.TryCloud.pages;

import com.TryCloud.utilities.BrowserUtil;
import com.TryCloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModulesPage {

    public ModulesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tr[@data-file='JamesBond']//a[@class='action action-menu permanent']")
    private WebElement actionIcon;

    @FindBy(xpath = "//span[.='Details']")
    private WebElement detailsBtn;

    @FindBy(xpath = "//span[@class='app-sidebar-tabs__tab-icon icon-comment']")
    private WebElement commentBtn;

    @FindBy(xpath = "//div[@data-placeholder='New comment …']")
    private WebElement addCommentLine;

    @FindBy(xpath = "//input[@class='submit icon-confirm has-tooltip']")
    private WebElement submitBtn;


    public void clickActionIcon() {
        BrowserUtil.explicitWait(By.xpath("//tr[@data-file='JamesBond']//a[@class='action action-menu permanent']"), 3);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(actionIcon).click().perform();
      //  actionIcon.click();


    }

    public void clickDetailsBtn(){
        detailsBtn.click();
    }

    public String clickCommentBtn(String message){
        commentBtn.click();
        addCommentLine.sendKeys(message);
        return message;

    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }

    public  boolean messageIsDisplayed(String messageText){
        WebElement messageIsDisplayed = Driver.getDriver().findElement(By.xpath("//div[text()='"+messageText+"']"));
        return (messageIsDisplayed.getText().equals(messageText))? true:false;
    }

}
