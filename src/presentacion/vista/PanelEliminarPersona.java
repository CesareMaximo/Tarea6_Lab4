package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class PanelEliminarPersona extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEliminarPersona() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar Usuarios");
		lblEliminarUsuarios.setBounds(178, 11, 94, 14);
		add(lblEliminarUsuarios);
		
		JList list = new JList();
		list.setBounds(130, 49, 169, 197);
		add(list);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(170, 266, 89, 23);
		add(btnEliminar);

	}
}
