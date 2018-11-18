package com.app.driverControlsLibrary;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;

public class SetValue {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();

    public void setValueUSingSendKey(String locator, String value){
        element=find.findElement(locator, getCaller.getCallerClass().getName());
        element.sendKeys(value);
    }

    public void clearAndSetValueUSingSendKey(String locator, String value){
        element=find.findElement(locator, getCaller.getCallerClass().getName());
        element.clear();
        element.sendKeys(value);
    }


}
