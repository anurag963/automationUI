package com.app.driverControlsLibrary;

import com.app.utils.GetCaller;
import org.openqa.selenium.WebElement;

public class Grab {

    WebElement element;
    Find find=new Find();
    GetCaller getCaller= new GetCaller();

    public String grabText(String xpath){
        element=find.findElement(xpath, getCaller.getCallerClass().getName());
        return element.getText();
    }

}
