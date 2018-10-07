package com.app.utils;

public class GetCaller extends SecurityManager {

    public Class getCallerClass(){
        return getClassContext()[2];
    }

}
