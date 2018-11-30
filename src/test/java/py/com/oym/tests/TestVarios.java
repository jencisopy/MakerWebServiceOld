package py.com.oym.tests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JORGE
 */
public class TestVarios {
    
    public TestVarios() {
    }
    
    @Test
    public void test1() {
        String caracter = "0";
        int veces = 3;
        String dato = " 1";
        String expRes = "001";
        veces = veces - dato.trim().length();
        String result = dato.trim();
        for (int i = 0;i < veces;i++){
            result = caracter + result;
        }
        assertEquals(expRes, result);
        Integer toInteger = new Integer(result);
        assertEquals(new Integer(1), toInteger);
    }
}
