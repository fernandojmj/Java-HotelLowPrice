package br.com.dominio.repositories;

import java.util.List;

import entities.Hotel;
import entities.Model;

public abstract class DAO implements InterfaceDAO {

	public DAO() {
	}

	public abstract DAO getInstance();

	public List<Model> getList;

	public static DAO getIntanceDAO(Model model) {

		if (model instanceof Hotel) {
			return new DaoHoteis().getInstance();
		}
		return null;

	}

}
