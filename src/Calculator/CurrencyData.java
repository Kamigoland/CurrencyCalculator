/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author amiid
 */
public class CurrencyData {
    
    private static final String CurrencyFile = "eurofxref-daily.xml";
    
    private HashMap<String, Float> currencies = new HashMap<String, Float>();
    
    public CurrencyData() throws ParserConfigurationException{
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try {
            
            // to avoid attacks by XML
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(new File(CurrencyFile));
            
            doc.getDocumentElement().normalize();
            
            NodeList list = doc.getElementsByTagName("Cube");
            
            for(int i = 2; i<list.getLength(); i++){
                
                Node node = list.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element element = (Element) node;
                    
                    currencies.put(element.getAttribute("currency"), Float.parseFloat(element.getAttribute("rate")));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
          e.printStackTrace();
      }
    }
    public static void main(String[] args) throws ParserConfigurationException {
        CurrencyData c = new CurrencyData();
    }
}
