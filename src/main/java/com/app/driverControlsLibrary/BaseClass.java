package com.app.driverControlsLibrary;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    RemoteWebDriver driver1;
    public String browser;
    public String url;

    public Properties propertiesData;
    public File propFile;
    public FileInputStream propFis;


    static{
        Calendar calender= Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
    }

    @BeforeClass
    public void init() throws IOException
    {
        loadProperties();
        getBrowser(propertiesData.getProperty("browser"));
        loadProperties();
        String url= propertiesData.getProperty("url");
        System.out.println(url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    public void getBrowser(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {

            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe");
           // driver= new ChromeDriver();

            // We could use any driver for our tests...
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // ... but only if it supports javascript
            capabilities.setJavascriptEnabled(true);

            // Get a handle to the driver. This will throw an exception
            // if a matching driver cannot be located
            WebDriver driver = new RemoteWebDriver(capabilities);

            // Query the driver to find out more information
            Capabilities actualCapabilities = ((RemoteWebDriver) driver).getCapabilities();

        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
            driver= new FirefoxDriver();



        }


    }

    public static WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
        String locatorType = split[0];
        String locatorValue = split[1];

        if (locatorType.toLowerCase().equals("id"))
            return driver.findElement(By.id(locatorValue));
        else if (locatorType.toLowerCase().equals("name"))
            return driver.findElement(By.name(locatorValue));
        else if ((locatorType.toLowerCase().equals("classname"))
                || (locatorType.toLowerCase().equals("class")))
            return driver.findElement(By.className(locatorValue));
        else if ((locatorType.toLowerCase().equals("tagname"))
                || (locatorType.toLowerCase().equals("tag")))
            return driver.findElement(By.className(locatorValue));
        else if ((locatorType.toLowerCase().equals("linktext"))
                || (locatorType.toLowerCase().equals("link")))
            return driver.findElement(By.linkText(locatorValue));
        else if (locatorType.toLowerCase().equals("partiallinktext"))
            return driver.findElement(By.partialLinkText(locatorValue));
        else if ((locatorType.toLowerCase().equals("cssselector"))
                || (locatorType.toLowerCase().equals("css")))
            return driver.findElement(By.cssSelector(locatorValue));
        else if (locatorType.toLowerCase().equals("xpath"))
            return driver.findElement(By.xpath(locatorValue));
        else
            throw new Exception("Unknown locator type '" + locatorType + "'");
    }



    public void loadProperties() throws IOException
    {
        propertiesData= new Properties();
        File propFile= new File(System.getProperty("user.dir")+"/src/main/resources/configs/config.properties");
        FileInputStream propFis= new FileInputStream(propFile);
        propertiesData.load(propFis);

    }


    @BeforeTest
    public void initializeExtentReport(){

    }

    public void getScreenshot(String imageName) throws IOException
    {
        if(imageName.equals(null) || imageName.equals("")) {
            imageName = "blank";
        }

        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String imageSavePath= System.getProperty("user.dir")+"/screenshots/";

        Calendar calender= Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String actualImage= imageSavePath+imageName+formater.format(calender.getTime())+".png";
        File desctFile= new File(actualImage);

        FileUtils.copyFile(image, desctFile);

    }

    @AfterTest
    public void finishExtentReport(){

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
