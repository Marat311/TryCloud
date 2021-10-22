package com.TryCloud.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static boolean explicitWait(By locator, int timeToWait){
        boolean result = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWait);

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            result=true;
        }catch (TimeoutException e){
            System.out.println("The error message is = "+ e.getMessage());
            System.out.println("We did not see the error message element");
        }
        return result;
    }


    public static List<String> getAlltext(List<WebElement> listOfWebElements){
        List<String>allText = new ArrayList<>();

        for (WebElement eachElement:listOfWebElements){
            allText.add(eachElement.getText());
        }
        return allText;
    }
}
