package main;

import negociolmpl.*;
import negocio.PersonaNegocio;

import presentacion.controlador.Controlador;
import presentacion.vista.PanelAgregarPersona;
import presentacion.vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		VentanaPrincipal Vista= new VentanaPrincipal();
		
		PanelAgregarPersona pan = new PanelAgregarPersona();
		
		
		
		PersonaNegocio negocio = new negociolmpl.PersonaNegocioImpl();
		Controlador controlador = new Controlador(Vista, negocio);
		controlador.inicializar();
		
		
	}

}
