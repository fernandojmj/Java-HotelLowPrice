package br.com.dominio.repositories;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import entities.Hotel;
import entities.Model;

public class DAO {

	InterfaceDAO dao;
	
	public static InterfaceDAO getInstanceDAO(Class<?> dao)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

		try {

			// Ultilização de reflection para obeter o metodo getInstace da classe dao
			// passada por paramentro.
			Method method = Class.forName(dao.getName()).getMethod("getInstanceDAO", null);
			Object instance = method.invoke(null, null);
			return (InterfaceDAO) instance;

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		}
		return null;
		
		

	}
	
	public static List<Model> getList(Class<?> model) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException{
		
		return getInstanceDAO(model).getList();
	}

}
