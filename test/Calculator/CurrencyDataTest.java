/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amiid
 */
public class CurrencyDataTest {
    
    CurrencyData cd = new CurrencyData();
    
    public CurrencyDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getCurrency method, of class CurrencyData.
     */
    @Test
    public void testGetCurrency() {
        System.out.println("getCurrency");
        assertNotNull(cd.getCurrency());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getResult method, of class CurrencyData.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        try {
            cd.readFromFile();
        } catch (ParserConfigurationException ex) {
            fail("could not read XML file");
        }
        for (float i = 1; i < 1000000; i*=2) {
            assertTrue(Float.parseFloat(cd.getResult(i, "USD"))>=0);
        }
    }
    
}
