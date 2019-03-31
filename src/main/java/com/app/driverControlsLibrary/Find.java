package com.app.driverControlsLibrary;

import com.app.utils.ValueFinder;
import org.openqa.selenium.WebElement;

public class Find extends BaseClass{
    ValueFinder valueFinder=new ValueFinder();
    String locatorValue;
    WebElement element=null;

    public WebElement findElement (String locator, String className){

        try{
            locatorValue=valueFinder.findValue(locator, className);
            element= getLocator(locatorValue);
            return element;
        }catch(Exception e){
            e.printStackTrace();
        }
        return element;
    }

}
