package br.com.dominio.singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.dominio.repositories.DAO;
import br.com.dominio.repositories.DaoHoteis;
import br.com.dominio.repositories.InterfaceDAO;
import entities.ClientFidelidade;
import entities.ClientRegular;
import entities.EnterData;
import entities.Hotel;
import entities.Model;

public class BoSales {

	private static BoSales boSales;

	private BoSales() {

	}

	public static BoSales getInstaceBoSales() {

		if (boSales == null) {
			boSales = new BoSales();
		}

		return boSales;
	}

	public Hotel getHotelLowPrice(EnterData param) throws Exception {

		HashMap<Hotel, Double> somaHotel = new HashMap<>();
		
		//Buscando Lista de hoteis
		InterfaceDAO dao = DAO.getIntanceDAO(new Hotel());
		List<Model> listaHoteis = dao.getList(); 

		for (String data : param.getDatasSolicitadas()) {

			System.out.println("============================: " + data);
			
			
			for (Model model : listaHoteis) {
				
				Hotel hotel = (Hotel)model; 
				
				boolean isFimDeSemana = data.contains("sun") || data.contains("sat");

				if (somaHotel.get(hotel) == null) {
					somaHotel.put(hotel, 0.0);
				}

				if (param.typeClient instanceof ClientRegular) {

					getSomaRegular(somaHotel, hotel, isFimDeSemana);

				}
				if (param.typeClient instanceof ClientFidelidade) {
					getSomaFidelidade(somaHotel, hotel, isFimDeSemana);
				}

				System.out.println("Soma  - " + hotel.getName() + " Total: " + somaHotel.get(hotel).doubleValue());
			}

		}

		
		//interando a soma dos hoteis para verificar o hotel com menor valor
		Map.Entry<Hotel, Double> hotelLowPrice = null;
		hotelLowPrice = getLowPriceHotel(somaHotel, hotelLowPrice);

		if (hotelLowPrice != null) {
			return hotelLowPrice.getKey();
		} else {
			throw new Exception("Não existe hoteis disponiveis");
		}

	}

	private Map.Entry<Hotel, Double> getLowPriceHotel(HashMap<Hotel, Double> somaHotel,
			Map.Entry<Hotel, Double> hotelLowPrice) {
		for (Map.Entry<Hotel, Double> hotel : somaHotel.entrySet()) {
			if (hotelLowPrice == null) {
				hotelLowPrice = hotel;
			}
			// Obtem o Menor valor do entre os hoteis
			if (hotelLowPrice.getValue() > hotel.getValue()) {
				hotelLowPrice = hotel;
			} else if (hotelLowPrice.getValue().equals(hotel.getValue())) {

				// Caso valor seja igual entre os hoteis retornado o hotel com melhor
				// classificação.
				if (hotel.getKey().getClassificacao() > hotelLowPrice.getKey().getClassificacao()) {
					hotelLowPrice = hotel;
				}
			}


		}
		return hotelLowPrice;
	}

	private void getSomaFidelidade(HashMap<Hotel, Double> somaHotel, Hotel hotel, boolean isFinalDeSemana) {
		if (isFinalDeSemana) {
			double soma = somaHotel.get(hotel).doubleValue() + hotel.getClietFidelidade().getValorFimDeSemana();
			somaHotel.remove(hotel, soma);
			somaHotel.put(hotel, soma);
		} else {

			double soma = somaHotel.get(hotel).doubleValue() + hotel.getClietFidelidade().getValorDiaDeSemana();
			somaHotel.remove(hotel, soma);
			somaHotel.put(hotel, soma);
		}
	}

	private void getSomaRegular(HashMap<Hotel, Double> somaHotel, Hotel hotel, boolean isFinalDeSemana) {
		if (isFinalDeSemana) {
			double soma = somaHotel.get(hotel).doubleValue() + hotel.getClientRegular().getValorFimDeSemana();
			somaHotel.remove(hotel);
			somaHotel.put(hotel, soma);
		} else {
			double soma = somaHotel.get(hotel).doubleValue() + hotel.getClientRegular().getValorDiaDeSemana();
			somaHotel.remove(hotel);
			somaHotel.put(hotel, soma);
		}
	}

}
