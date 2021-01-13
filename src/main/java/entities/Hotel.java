package entities;

public class Hotel extends Model {

	public String name;
	public Integer classificacao;
	public ClientFidelidade clietFidelidade;
	public ClientRegular clientRegular;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClientFidelidade getClietFidelidade() {
		return clietFidelidade;
	}
	public void setClietFidelidade(ClientFidelidade clietFidelidade) {
		this.clietFidelidade = clietFidelidade;
	}
	public ClientRegular getClientRegular() {
		return clientRegular;
	}
	public void setClientRegular(ClientRegular clientRegular) {
		this.clientRegular = clientRegular;
	}
	public Integer getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}
	
	
	
	
	
	
	
	
	
}
