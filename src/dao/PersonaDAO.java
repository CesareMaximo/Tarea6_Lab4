package dao;
import java.util.List;

import entidad.*;

public interface PersonaDAO {

	public boolean insert(Persona per);
	public boolean delete(Persona perDelete);
	public List<Persona> readAll();
	public boolean exists(String dni);
	public boolean update(Persona persona_a_modificar);
}
