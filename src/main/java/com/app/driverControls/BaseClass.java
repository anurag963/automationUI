package com.app.driverControls;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
            driver= new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/main/resources/drivers/geckodriver.exe");
            driver= new FirefoxDriver();
        }


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
