package daolmpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import dao.PersonaDAO;

import entidad.Persona;

public class personaDaoImpl implements PersonaDAO{

	
	private static final String insert = "INSERT INTO personas(Dni, Nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE Dni = ?";
	private static final String readall = "SELECT * FROM personas";
	
	
	@Override
	public boolean insert(Persona per) {
		
		
		
		return false;
	}
	

	@Override
	public boolean delete(Persona perDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
