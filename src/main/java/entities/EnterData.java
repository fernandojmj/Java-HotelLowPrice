package entities;

import java.util.ArrayList;
import java.util.List;

public class EnterData {

	private Client typeClient;
	private List<String> datasSolicitadas;

	public EnterData(String param) {

		String[] splitParametros = param.split(":");

		String tipoCliente = splitParametros[0];

		String[] datas = splitParametros[1].split(",");

		if (tipoCliente.equalsIgnoreCase("regular")) {

			typeClient = new ClientRegular();

		} else if (tipoCliente.equalsIgnoreCase("Reward")) {

			typeClient = new ClientReward();
		}

		for (String string : datas) {
			if (datasSolicitadas == null)
				datasSolicitadas = new ArrayList<>();

			datasSolicitadas.add(string);
		}

	}

	public Client getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(Client typeClient) {
		this.typeClient = typeClient;
	}

	public List<String> getDatasSolicitadas() {
		return datasSolicitadas;
	}

	public void setDatasSolicitadas(List<String> datasSolicitadas) {
		this.datasSolicitadas = datasSolicitadas;
	}

}
