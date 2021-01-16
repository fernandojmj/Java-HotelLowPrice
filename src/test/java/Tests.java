import org.junit.Test;

import br.com.dominio.repositories.DAO;
import br.com.dominio.repositories.HotelDAO;
import br.com.dominio.singleton.BoSales;
import entities.EnterData;
import entities.Hotel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
	@Test
	public void testThatFails() {
		assertTrue("This should fail", true);
	}

	@Test
	public void testHotelPrecoMaisBaixo() {
		try {
			assertEquals(BoSales.getInstaceBoSales()
					.getHotelLowPrice(new EnterData("Regular: 16Mar2020(mon), 17Mar2020(tues), 18Mar2020(wed)"))
					.getName(), "Lakewood");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue("This should fail", false);
		}
	}

	@Test
	public void testHotelPrecoMaisBaixo2() {
		try {
			assertEquals(BoSales.getInstaceBoSales()
					.getHotelLowPrice(new EnterData("Regular: 20Mar2020(fri), 21Mar2020(sat), 22Mar2020(sun)"))
					.getName(), "Bridgewood");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue("This should fail", false);
		}
	}

	@Test
	public void testHotelPrecoMaisBaixo3() {
		try {
			assertEquals(BoSales.getInstaceBoSales()
					.getHotelLowPrice(new EnterData("Reward: 26Mar2020(thur), 27Mar2020(fri), 28Mar2020(sat)"))
					.getName(), "Ridgewood");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue("This should fail", false);
		}
	}

	@Test
	public void testReflection() {
		try {
			assertTrue(DAO.getInstanceDAO(HotelDAO.class) instanceof HotelDAO);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue("This should fail", false);
		}
	}

}
