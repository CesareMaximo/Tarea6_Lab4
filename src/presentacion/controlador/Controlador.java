package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.*;

public class Controlador  implements ActionListener{

	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresoPersonas;
	
	private PersonaNegocio pNeg;
	
	public Controlador (VentanaPrincipal Vista, PersonaNegocio pNeg) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = Vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles		
		this.pnlIngresoPersonas = new PanelAgregarPersona();
		
		
		// Evento abrir panel Agregar Persona
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		//Evento Agregar persona
		 this.pnlIngresoPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
	}
	
	
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
	//	ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
		System.out.println("Llegó");
		
	}
	
private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		

		
	
	}
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
