package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	

	private JMenuBar menuBar;
	
	private JMenu mnPersona;
	
	private JMenuItem mntmAgregar;
	
	private JMenuItem mntmModificar;
	
	 private JMenuItem mntmEliminar;
	 
	 private JMenuItem mntmListar;

	public VentanaPrincipal() {
		
		
		 menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		 mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		 mntmAgregar = new JMenuItem("Agregar");
		mnPersona.add(mntmAgregar);
		
		 mntmModificar = new JMenuItem("Modificar");
		mnPersona.add(mntmModificar);
		
		 mntmEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mntmEliminar);
		
		 mntmListar = new JMenuItem("Listar");
		mnPersona.add(mntmListar);

		
	}

	
	/*
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	*/

	public JMenu getMnPersona() {
		return mnPersona;
	}

	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}

	public JMenuItem getMntmAgregar() {
		return mntmAgregar;
	}

	public void setMntmAgregar(JMenuItem mntmAgregar) {
		this.mntmAgregar = mntmAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmEliminar() {
		return mntmEliminar;
	}

	public void setMntmEliminar(JMenuItem mntmEliminar) {
		this.mntmEliminar = mntmEliminar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}
}
