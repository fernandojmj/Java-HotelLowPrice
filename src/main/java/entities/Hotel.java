package entities;

public class Hotel extends Model {

	public String name;
	public Integer classificacao;
	public ClientReward clietReward;
	public ClientRegular clientRegular;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClientReward getClietReward() {
		return clietReward;
	}
	public void setClietReward(ClientReward clietFidelidade) {
		this.clietReward = clietFidelidade;
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
