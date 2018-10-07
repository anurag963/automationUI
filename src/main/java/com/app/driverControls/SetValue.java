package com.app.driverControls;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;

public class SetValue {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();

    public void setValueUSingSendKey(String xpath, String value){
        element=find.findElement(xpath, getCaller.getCallerClass().getName());
        element.sendKeys(value);
    }

    public void clearAndSetValueUSingSendKey(String xpath, String value){
        element=find.findElement(xpath, getCaller.getCallerClass().getName());
        element.clear();
        element.sendKeys(value);
    }


}
