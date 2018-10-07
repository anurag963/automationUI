package com.app.utils;

public class ValueFinder {
    String filename;
    PropertyFileUtil propertyFileUtil= new PropertyFileUtil();

    public String findValue(String key, String classname){
        String xPathValue=propertyFileUtil.propertyFileReader(key,"/identifierValues/"+fileNameMapper(classname) );
        return xPathValue;
    }

    public String fileNameMapper(String classname){
        filename= classname.substring(classname.lastIndexOf('.')+1)+".properties";
        return filename;
    }

}
