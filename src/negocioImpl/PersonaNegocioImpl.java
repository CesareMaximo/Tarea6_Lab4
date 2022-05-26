package negocioImpl;

import java.util.List;

import entidad.Persona;
import negocio.PersonaNegocio;

import dao.*;
import daoImpl.personaDaoImpl;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDAO pdao = new personaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		boolean estado=false;
		if(persona.getDNI().trim().length()>0 && persona.getNombre().trim().length()>0 && persona.getApellido().trim().length()>0)
		{
			estado=pdao.insert(persona);
		}
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

	@Override
	public boolean exists(String dni) {
		boolean estado = false;
		if(pdao.exists(dni) )
		{
			estado = true;
		}
		return estado;
	}

	
}
