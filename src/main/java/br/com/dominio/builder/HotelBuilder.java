package br.com.dominio.builder;
import entities.ClientFidelidade;
import entities.ClientRegular;
import entities.Hotel;

public class HotelBuilder {

	private Hotel instance;

	public HotelBuilder() {
		this.instance = new Hotel();
	}

	public HotelBuilder setName(String name) {
		instance.setName(name);
		return this;
	}
	
	public HotelBuilder setClassificacao(Integer classificacao) {
		instance.setClassificacao(classificacao);
		return this;
	}

	public HotelBuilder setClientRegular(double valorDiaDeSemanaRegular, double valorFimDeSemanaRegular) {

		ClientRegular client = new ClientRegular();

		client.setValorDiaDeSemana(valorDiaDeSemanaRegular);
		client.setValorFimDeSemana(valorFimDeSemanaRegular);

		instance.setClientRegular(client);
		return this;
	}

	public HotelBuilder setClientFidelidade(double valorDiaDeSemanaFidelidade, double valorFimDeSemanaFidelidade) {

		ClientFidelidade client = new ClientFidelidade();

		client.setValorDiaDeSemana(valorDiaDeSemanaFidelidade);
		client.setValorFimDeSemana(valorFimDeSemanaFidelidade);

		instance.setClietFidelidade(client);
		return this;
	}
	
	
	public Hotel builder() {
		return instance;
	}

}
