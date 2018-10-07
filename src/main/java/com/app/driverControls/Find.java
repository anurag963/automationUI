package com.app.driverControls;

import com.app.utils.ValueFinder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Find extends BaseClass{
    ValueFinder valueFinder=new ValueFinder();
    String xpathValue;
    WebElement element;

    public WebElement findElement (String xpath, String className){
        xpathValue=valueFinder.findValue(xpath, className);
        element= driver.findElement(By.xpath(xpathValue));
        return element;
    }

}
