import org.junit.Test;

import br.com.dominio.singleton.BoSales;
import entities.EnterData;

import static org.junit.Assert.*;

public class FailingTest {
   @Test
   public void testThatFails() {
       assertTrue("This should fail", true);
   }
   
   
   @Test
   public void testHotelPrecoMaisBaixo() {
       try {
		assertEquals(BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 16Mar2020(mon), 17Mar2020(tues), 18Mar2020(wed)")).getName(), "Lakewood");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 assertTrue("This should fail", false);
	}
   }
   
   @Test
   public void testHotelPrecoMaisBaixo2() {
       try {
		assertEquals( BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 20Mar2020(fri), 21Mar2020(sat), 22Mar2020(sun)")).getName(), "Bridgewood");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 assertTrue("This should fail", false);
	}
   }
   
   @Test
   public void testHotelPrecoMaisBaixo3() {
       try {
		assertEquals(BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Fidelidade: 26Mar2020(thur), 27Mar2020(fri), 28Mar2020(sat)")).getName(), "Ridgewood");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 assertTrue("This should fail", false);
	}
   }
  
   
}
