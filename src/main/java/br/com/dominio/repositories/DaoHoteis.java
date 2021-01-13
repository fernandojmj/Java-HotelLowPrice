package br.com.dominio.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.dominio.builder.HotelBuilder;
import entities.Hotel;
import entities.Model;

public  class DaoHoteis extends DAO  {


	private static DaoHoteis daoHoteis;
	private  List<Model> hoteis;
	
	
	public DaoHoteis() {
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
		hoteis = new ArrayList<>();
		
		hoteis.add(new HotelBuilder().setName("Parque das flores").setClassificacao(3).setClientFidelidade(80,80).setClientRegular(110, 90).builder());
		hoteis.add(new HotelBuilder().setName("Jardim Botânico").setClassificacao(4).setClientFidelidade(110, 50).setClientRegular(160, 60).builder());
		hoteis.add(new HotelBuilder().setName("Mar Atlântico").setClassificacao(5).setClientFidelidade(100, 40).setClientRegular(220, 150).builder());
 
		return hoteis;
	}

	@Override
	public DAO getInstance() {
		if(daoHoteis==null) {
			daoHoteis = new DaoHoteis();
		}
		
		return daoHoteis;
	}


	
	
	
	
	
	
}
