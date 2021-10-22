package com.TryCloud.pages;

import com.TryCloud.utilities.BrowserUtil;
import com.TryCloud.utilities.Driver;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilesPage {

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//a[@class='action action-menu permanent']")
    public WebElement action_icon;

    @FindBy(xpath = "//span[.='Delete file']")
    public WebElement deleteFile;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//span[.='Selenium_methods']")
    public WebElement fileForDelete;

    @FindBy(xpath = "//table[@id='filestable']//label[@for='select_all_files']")
    public WebElement fileCheckbox;

    @FindBy(xpath = "//table[@id='filestable']//label[contains(@for, 'select-files')]")
    public List<WebElement> checkboxes;

    @FindBy(xpath = "(//span[text()='Add to favorites'])[1]")
    public WebElement addToFavorites;

    @FindBy(xpath = "//table[@class='list-container']/tbody//tr")
    public WebElement checkIsFileOnFavoriteFolder;

    @FindBy(xpath = "//*[@id=\"emptycontent\"]/h2")
    public WebElement checkIsFavoritesEmpty;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusSign;

    @FindBy(xpath = "(//span[@class='nametext'])/span[text()='jamesBond.txt']")
    public WebElement fileIsUpload;


    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

   public boolean checkboxIsSelected(){
        List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//table[@id='filestable']//input[@type='checkbox']"));
       for (WebElement checkbox : allCheckboxes) {
           System.out.println("checkbox.isSelected() = " + checkbox.isSelected());
           if(checkbox.isSelected()){
               return true;
           }
       }
               return false;

    }

    public void clickOption(String favoriteOptions){
        BrowserUtil.waitFor(1);
        WebElement options = Driver.getDriver().findElement(By.xpath("//a[text()='"+favoriteOptions+"']"));

       Actions actions = new Actions(Driver.getDriver());
       actions.moveToElement(options).click().perform();

    }

    public void clickAddToFavorite(String addFavorite){
        BrowserUtil.explicitWait(By.xpath("(//span[text()='"+addFavorite+"'])[1]"), 3);
        WebElement addFavoriteBtn = Driver.getDriver().findElement(By.xpath("(//span[text()='"+addFavorite+"'])[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(addFavoriteBtn).click().perform();
       // addFavoriteBtn.click();

    }

    public void uploadFile(String uploadF)throws IOException {

       // Click upload button on target site
        WebElement uploadFileBtn = Driver.getDriver().findElement(By.xpath("//span[text()='"+uploadF+"']"));
        uploadFileBtn.click();

        // Run AutoIt .exe script that uses file path we saved in .txt file
        String command = "C:\\Users\\Marina\\Desktop\\fileUploadScript.exe";
        Runtime.getRuntime().exec(command);

        BrowserUtil.waitFor(3);

    }

    public boolean fileIsDisplayed(String fileName){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtil.waitFor(1);

      //  WebElement file = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])/span[text()='"+fileName+"']"));
          WebElement file = Driver.getDriver().findElement(By.xpath("(//td[@class='filename']//span[@class='nametext'])/span[text()='"+fileName+"']"));

        js.executeScript("arguments[0].scrollIntoView(true);", file);

        return (file.isDisplayed())?true:false;

    }

    public boolean fileIsNotDisplayed(String fileName){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowserUtil.waitFor(1);

          WebElement file = Driver.getDriver().findElement(By.xpath("(//span[@class='nametext'])/span[text()='"+fileName+"']"));
       // WebElement file = Driver.getDriver().findElement(By.xpath("(//td[@class='filename']//span[@class='nametext'])/span[text()='"+fileName+"']"));

        js.executeScript("arguments[0].scrollIntoView(true);", file);

        return (file.isDisplayed())?true:false;

    }



}
