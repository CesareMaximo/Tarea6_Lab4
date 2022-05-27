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
		boolean estado=false;
		if(pdao.exists(persona_a_eliminar.getDNI()))
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
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
