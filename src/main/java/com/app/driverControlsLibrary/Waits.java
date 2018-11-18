package com.app.driverControlsLibrary;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.app.driverControlsLibrary.BaseClass.driver;

public class Waits {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();
    WebDriverWait wait;

    public void waitUntilElementIsDisplayed(String locator){
        element=find.findElement(locator, getCaller.getCallerClass().getName());
         wait=new WebDriverWait(driver, 30);
         wait.until(ExpectedConditions.visibilityOf(element));

    }

}
