package com.app.utils.xmlsManager;

import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

public class XMLs {
    XMLValueExtractor xMLValueExtractor= new XMLValueExtractor();

    public void updateFirstYear(String xmlType, String value ) throws XPathExpressionException, TransformerException {
        updateXML("testXML", "(//year)[1]", value);

    }

    public void updateFirstMake(){


    }

    public void updateFirstModel(){


    }

    public void updateFirstColor(){


    }

    public  void updateXML(String xmlType, String xPathExpression, String value) throws XPathExpressionException, TransformerException {
        xMLValueExtractor.updateXMLValue("F:/Workspace/automationUI/src/main/resources/data/"+xmlType+".xml" , xPathExpression, value);


    }


}
