package br.com.dominio.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.dominio.builder.HotelBuilder;
import entities.Model;

public  class HotelDAO implements InterfaceDAO {


	private static HotelDAO instaceDao;
	private  List<Model> hoteis;
	
	
	public HotelDAO() {
		super();
	}

	public List<Model> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Model> hoteis) {
		this.hoteis = hoteis;
	}



	@Override
	public List<Model> getList() {

		if(hoteis==null) {
			System.out.println("Hoteis Null");
			hoteis = new ArrayList<Model>();
			hoteis.add(new HotelBuilder().setName("Lakewood").setClassificacao(3).setClientReward(80,80).setClientRegular(110, 90).builder());
			hoteis.add(new HotelBuilder().setName("Bridgewood").setClassificacao(4).setClientReward(110, 50).setClientRegular(160, 60).builder());
			hoteis.add(new HotelBuilder().setName("Ridgewood").setClassificacao(5).setClientReward(100, 40).setClientRegular(220, 150).builder());
			
		}
 
		return hoteis;
	}

	
	public static InterfaceDAO getInstanceDAO() {
		
		if(instaceDao==null) {
			instaceDao = new HotelDAO();
		}
		
		return instaceDao;
	}



	
	
	
	
	
	
}
