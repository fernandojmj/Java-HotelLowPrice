import br.com.dominio.singleton.BoSales;
import entities.EnterData;
import entities.Hotel;

public class Principal {
	public static void main(String[] args) {
//		//Primeira execução
		try {
			Hotel hotel = BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
//		
//		//Segunda Execução
		try {
			Hotel hotel = BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// Terceira execução
		try {
			Hotel hotel =  BoSales.getInstaceBoSales().getHotelLowPrice(new EnterData("Reward: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)"));
			
			if(hotel!=null) {
				System.out.println("--------------------------------------------> Hotel Com Menor valor: "+ hotel.getName());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
