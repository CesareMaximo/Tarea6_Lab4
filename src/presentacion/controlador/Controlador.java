package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.*;

public class Controlador  implements ActionListener{

	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresoPersonas;
	
	private PersonaNegocio pNeg;
	
	public Controlador (VentanaPrincipal vista, PersonaNegocio pNeg) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;
		
		//Instancio los paneles		
		this.pnlIngresoPersonas = new PanelAgregarPersona();
		
		
		// Evento abrir panel Agregar Persona
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
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
	}
	
	
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a){		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
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
	
	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
