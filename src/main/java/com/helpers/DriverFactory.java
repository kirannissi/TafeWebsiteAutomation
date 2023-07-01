package com.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /*
    * This method initialize the thread local driver based on browser
    * */
    public WebDriver initDriver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    /*
    * this is used to get driver with thread local
    * */

    public static WebDriver getDriver(){
        return tlDriver.get();
    }

}
