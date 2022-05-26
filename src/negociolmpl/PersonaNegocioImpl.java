package negociolmpl;

import java.util.List;

import entidad.Persona;
import negocio.PersonaNegocio;

import dao.*;
import daolmpl.personaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDAO pdao = new personaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false;
		
		
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
