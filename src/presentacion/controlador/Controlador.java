package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.*;

public class Controlador  implements ActionListener{

	private ArrayList<Persona> personasEnTabla;
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresoPersonas;
	private PanelEliminarPersona pnlEliminarPersona;
	
	private PersonaNegocio pNeg;
	
	public Controlador (VentanaPrincipal vista, PersonaNegocio pNeg) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles		
		this.pnlIngresoPersonas = new PanelAgregarPersona();
		this.pnlEliminarPersona = new PanelEliminarPersona();
		
		this.refrescarLista();
		
		// Evento abrir panel Agregar Persona
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		
		//Evento Agregar persona
		this.pnlIngresoPersonas.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		this.pnlIngresoPersonas.getTxtDni().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if((num < '0' || num > '9'))
					e.consume();
			}
		});
		this.pnlIngresoPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isLetter(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		this.pnlIngresoPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				if (!Character.isLetter(e.getKeyChar())) {
					e.consume();
				}
			}
		});
		
		
		// Evento ELIMINAR del Panel Eliminar Persona
		this.pnlEliminarPersona.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
	}
	
	
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a){		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
		
	}
	
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a)
	{		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}
	
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		String apellido = this.pnlIngresoPersonas.getTxtApellido().getText();
		String nombre = this.pnlIngresoPersonas.getTxtNombre().getText();
		String dni = this.pnlIngresoPersonas.getTxtDni().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		
		boolean existe = pNeg.exists(dni);
		boolean estado;
		String mensaje;
		
		if(!existe) {
			estado = pNeg.insert(nuevaPersona);			
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				this.pnlIngresoPersonas.getTxtApellido().setText("");
				this.pnlIngresoPersonas.getTxtNombre().setText("");
				this.pnlIngresoPersonas.getTxtDni().setText("");
			}
			else {
				mensaje="Es necesario completar todos los campos";
				this.pnlIngresoPersonas.getTxtApellido().setText("");
				this.pnlIngresoPersonas.getTxtNombre().setText("");
				this.pnlIngresoPersonas.getTxtDni().setText("");
			}
		}
		else {
			mensaje="Persona existente";
		}
				
		this.ventanaPrincipal.mostrarMensaje(mensaje);
	}
	
	public void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s) {
		
		boolean estado=false;
		Persona persona = (Persona) this.pnlEliminarPersona.getJlPersonas().getSelectedValue();
		
			estado = pNeg.delete(persona);
			
			if(estado==true)
			{
				String mensaje="Persona eliminada con exito";
				this.pnlEliminarPersona.mostrarMensaje(mensaje);
			}

		//this.refrescarTabla();
		this.refrescarLista();
	}
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	private void refrescarLista() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		DefaultListModel<Persona> dModel = new DefaultListModel<Persona>();
		for (Persona persona : personasEnTabla) {
			dModel.addElement(persona);
		}
		this.pnlEliminarPersona.getJlPersonas().setModel(dModel);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
