package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isw.dao.OperadorDao;
import com.isw.model.Operador;

public class Pruebas {

	private static ApplicationContext appContext;

	public static void main(String[] args) {
		appContext = new ClassPathXmlApplicationContext("com/isw/spring/springMain.xml");
		OperadorDao operadorDao = (OperadorDao) appContext.getBean("operadorDao");
		
		Operador op = new Operador();
		
		op.setApellidoM("asas");
		op.setApllidoP("wqe");
		op.setNombre("rer");
		op.setPass("xz");
		op.setUsuario("wqewqewq");
		
		operadorDao.create(op);

	}

}
