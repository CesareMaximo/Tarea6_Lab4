package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelEliminarPersona extends JPanel {

	private JLabel lblSeleccioneLaPersona;
	private JList jlPersonas;
	private JButton btnEliminar;
	private DefaultListModel listModel;
	private JScrollPane scrollPane;
	
	public PanelEliminarPersona() {
		setLayout(null);
		
		lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea eliminar:");
		lblSeleccioneLaPersona.setBounds(88, 11, 255, 14);
		lblSeleccioneLaPersona.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblSeleccioneLaPersona);
		
				
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(165, 174, 89, 23);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 42, 369, 115);
		add(scrollPane);
		
		jlPersonas = new JList();
		scrollPane.setViewportView(jlPersonas);

	}

	public JLabel getLblSeleccioneLaPersona() {
		return lblSeleccioneLaPersona;
	}

	public void setLblSeleccioneLaPersona(JLabel lblSeleccioneLaPersona) {
		this.lblSeleccioneLaPersona = lblSeleccioneLaPersona;
	}

	public JList getJlPersonas() {
		return jlPersonas;
	}

	public void setJlPersonas(JList jlPersonas) {
		this.jlPersonas = jlPersonas;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
