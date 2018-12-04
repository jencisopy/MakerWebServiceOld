package py.com.oym.tests;

import java.util.Calendar;
import java.util.Date;
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
    
    @Test
    public void testMinDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, 1900);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        
        System.out.println(calendar.getTime());
    }
    
}
