package com.app.driverControlsLibrary;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;

public class Click {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();

    public void clickElement(String locator){
        element=find.findElement(locator, getCaller.getCallerClass().getName());
        element.click();
    }


}
