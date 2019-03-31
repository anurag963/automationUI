package com.app.driverControlsLibrary;

import com.app.utils.GetCaller;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static com.app.driverControlsLibrary.BaseClass.driver;

public class Waits {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();
    WebDriverWait wait;

    public void waitUntilElementIsDisplayed(String locator) {
        element=find.findElement(locator, getCaller.getCallerClass().getName());
         wait=new WebDriverWait(driver, 30);
        WebElement ele= wait.until(ExpectedConditions.visibilityOf(element));


       /* File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\testresults\failed-test.png"));*/



    }

}
