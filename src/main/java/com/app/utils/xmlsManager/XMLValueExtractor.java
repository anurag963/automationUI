package com.app.utils.xmlsManager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import  org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;

public class XMLValueExtractor {

    DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
    Document document;



    public  String updateXMLValue(String filePath, String xPathExpression, String value) throws XPathExpressionException, TransformerException {

        document= documentBuilder(filePath);
        XPath xPath= XPathFactory.newInstance().newXPath();
        Node startDateNode=(Node) xPath.compile(xPathExpression).evaluate(document, XPathConstants.NODE);
        startDateNode.setTextContent(value);
        Transformer tf= TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "Yes");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        tf.setOutputProperty("{http://xml.apache.org/xslt}intent-amount", "4");
        DOMSource domSource= new DOMSource(document);
        StreamResult sr= new StreamResult(new File(filePath));
        tf.transform(domSource,sr);
        return filePath;
    }


    private Document documentBuilder(String filePath){

        DocumentBuilder db= null;

        try{
            db= dbf.newDocumentBuilder();
            document= db.parse(new ByteArrayInputStream(Files.readAllBytes(new File(filePath).toPath())));

        }catch (Exception e){

        }
        return document;

    }

}
