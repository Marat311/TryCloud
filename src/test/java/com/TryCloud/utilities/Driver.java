package com.TryCloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    private Driver(){ }

    public static WebDriver getDriver(){
        //read the browser type you want to lunch from properties files
        String browserName = ConfigReader.read("browser");

      //  if (driver==null) {
        if(driverPool.get()==null){

            switch (browserName.toLowerCase()){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                   // driver=new ChromeDriver();
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    //driver=new FirefoxDriver();
                    driverPool.set(new FirefoxDriver());
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                   // driver=new SafariDriver();
                    driverPool.set(new SafariDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                  //  driver=new EdgeDriver();
                    driverPool.set(new EdgeDriver());
                    break;
                default:
                 //   driver=null;
                    driverPool.set(null);
                    System.out.println("UNKNOWN BROWSER TYPE!!! "+browserName);
            }
           // return driver;
        return driverPool.get();
        }else {
           // return driver;
        return driverPool.get();
        }
    }


    public static void closeBrowser(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.set(null);
        }
    }

}
