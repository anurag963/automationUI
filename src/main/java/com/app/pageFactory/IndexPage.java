package com.app.pageFactory;

import com.app.driverControls.Click;

public class IndexPage {

    Click click=new Click();

    public  void clickSignInBtn(){
        click.clickElement("indexPage_SignInBtn");
    }

}
