package com.app.driverControls;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;

public class Click {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();

    public void clickElement(String xpath){
        element=find.findElement(xpath, getCaller.getCallerClass().getName());
        element.click();
    }


}
