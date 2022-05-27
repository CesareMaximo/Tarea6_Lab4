package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.*;

public class Controlador implements ActionListener {

	private ArrayList<Persona> personasEnTabla;
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersona pnlIngresoPersonas;
	private PanelEliminarPersona pnlEliminarPersona;
	private PanelModificarPersona pnlModificarPersona;

	private PersonaNegocio pNeg;

	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
		// Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.pNeg = pNeg;

		// Instancio los paneles
		this.pnlIngresoPersonas = new PanelAgregarPersona();
		this.pnlEliminarPersona = new PanelEliminarPersona();
		this.pnlModificarPersona = new PanelModificarPersona();

		this.refrescarLista();

		// Eventos abrir paneles
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));

		// Evento Agregar persona
		this.pnlIngresoPersonas.getBtnAceptar()
				.addActionListener(a -> EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		this.pnlIngresoPersonas.getTxtDni().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char num = e.getKeyChar();
				if ((num < '0' || num > '9'))
					e.consume();
			}
		});
		this.pnlIngresoPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}

			}
		});

		this.pnlIngresoPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}
			}
		});
		
		this.pnlModificarPersona.getTxtNombre().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}

			}
		});

		this.pnlModificarPersona.getTxtApellido().addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyChar();

				boolean mayusculas = key >= 65 && key <= 90;
				boolean minusculas = key >= 97 && key <= 122;
				boolean espacio = key == 32;

				if (!(minusculas || mayusculas || espacio)) {
					e.consume();
				}

			}
		});
		

		// Evento ELIMINAR del Panel Eliminar Persona
		this.pnlEliminarPersona.getBtnEliminar()
				.addActionListener(s -> EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));

		// Eventos Modificar

		this.pnlModificarPersona.getList().addListSelectionListener(a -> Seleccion(a));
		this.pnlModificarPersona.getBtnModificar().addActionListener(a -> ModificarPersona(a));

	}


	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlIngresoPersonas);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();

	}

	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent a) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersona);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();
	}

	private void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlModificarPersona);
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

		if (!existe) {
			estado = pNeg.insert(nuevaPersona);
			if (estado == true) {
				mensaje = "Persona agregada con exito";
				this.pnlIngresoPersonas.getTxtApellido().setText("");
				this.pnlIngresoPersonas.getTxtNombre().setText("");
				this.pnlIngresoPersonas.getTxtDni().setText("");
			} else {
				mensaje = "Es necesario completar todos los campos";
				this.pnlIngresoPersonas.getTxtApellido().setText("");
				this.pnlIngresoPersonas.getTxtNombre().setText("");
				this.pnlIngresoPersonas.getTxtDni().setText("");
			}
		} else {
			mensaje = "Persona existente";
		}

		this.ventanaPrincipal.mostrarMensaje(mensaje);
		refrescarLista();
	}

	public void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s) {

		boolean estado = false;
		Persona persona = (Persona) this.pnlEliminarPersona.getJlPersonas().getSelectedValue();

		estado = pNeg.delete(persona);

		if (estado == true) {
			String mensaje = "Persona eliminada con exito";
			this.pnlEliminarPersona.mostrarMensaje(mensaje);
		}

		// this.refrescarTabla();
		this.refrescarLista();
	}

	private void Seleccion(ListSelectionEvent a) {
		if (this.pnlModificarPersona.getList().getSelectedIndex() != -1) {

			Persona pers = (Persona) this.pnlModificarPersona.getList().getSelectedValue();

			this.pnlModificarPersona.getTxtNombre().setText(pers.getNombre());
			this.pnlModificarPersona.getTxtApellido().setText(pers.getApellido());
			this.pnlModificarPersona.getTxtDNI().setText(pers.getDNI());

		}
	}

	private void ModificarPersona(ActionEvent a) {
		if (this.pnlModificarPersona.getList().getSelectedValue() != null) {
			Persona pers = new Persona();

			pers.setNombre(this.pnlModificarPersona.getTxtNombre().getText());
			pers.setApellido(this.pnlModificarPersona.getTxtApellido().getText());
			pers.setDNI(this.pnlModificarPersona.getTxtDNI().getText());

			boolean estado = pNeg.update(pers);
			String mensaje;

			if (estado == true) {
				mensaje = "Persona modificada.";
				this.pnlModificarPersona.getTxtNombre().setText("");
				this.pnlModificarPersona.getTxtApellido().setText("");
				this.pnlModificarPersona.getTxtDNI().setText("");

			} else {
				mensaje = "No se pudo modificar.";
			}

			JOptionPane.showMessageDialog(null, mensaje);
			refrescarLista();
			// refrescarTabla();

		}
	}

	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);
		;
	}

	private void refrescarLista() {
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		DefaultListModel<Persona> dModel = new DefaultListModel<Persona>();
		for (Persona persona : personasEnTabla) {
			dModel.addElement(persona);
		}
		this.pnlEliminarPersona.getJlPersonas().setModel(dModel);
		this.pnlModificarPersona.getList().setModel(dModel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
