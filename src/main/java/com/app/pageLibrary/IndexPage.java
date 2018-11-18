package com.app.pageLibrary;

import com.app.driverControlsLibrary.Click;
import com.app.driverControlsLibrary.Waits;

public class IndexPage {

    Waits waits= new Waits();
    Click click=new Click();

    public  void clickSignInBtn(){
        waits.waitUntilElementIsDisplayed("indexPage_SignInBtn");
        click.clickElement("indexPage_SignInBtn");
    }

}
