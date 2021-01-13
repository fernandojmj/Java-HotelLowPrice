import br.com.dominio.singleton.BoSales;
import entities.EnterData;
import entities.Hotel;

public class Principal {
	public static void main(String[] args) {
//		//Primeira execução
		try {
			Hotel hotel = BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 16Mar2020(mon), 17Mar2020(tues), 18Mar2020(wed)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
//		
//		//Segunda Execução
		try {
			Hotel hotel = BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 20Mar2020(fri), 21Mar2020(sat), 22Mar2020(sun)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Terceira execução
		try {
			Hotel hotel =  BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Fidelidade: 26Mar2020(thur), 27Mar2020(fri), 28Mar2020(sat)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
