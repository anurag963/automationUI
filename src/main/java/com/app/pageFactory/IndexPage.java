package com.app.pageFactory;

import com.app.driverControls.Click;
import com.app.driverControls.Waits;

public class IndexPage {

    Waits waits= new Waits();
    Click click=new Click();

    public  void clickSignInBtn(){
        waits.waitUntilElementIsDisplayed("indexPage_SignInBtn");
        click.clickElement("indexPage_SignInBtn");
    }

}
