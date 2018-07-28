package view;

import org.apache.log4j.Logger;

import control.Coordinator;

import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;

public class SearchWindow extends JDialog {

	private Coordinator coordinator;

	public SearchWindow() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(462, 400);
		getContentPane().setLayout(new GridLayout(6, 1, 0, 0));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JLabel lblAdminisrarPersonas = new JLabel("Adminisrar Personas");
		lblAdminisrarPersonas.setFont(new Font("SansSerif", Font.PLAIN, 25));
		lblAdminisrarPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAdminisrarPersonas);

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		panel.add(lblCdigo);

		textField_4 = new JTextField();
		panel.add(textField_4);
		textField_4.setColumns(10);

		JButton btnOk = new JButton("ok");
		panel.add(btnOk);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);

		JLabel lblNombre = new JLabel("Nombre");
		panel_1.add(lblNombre);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		panel_1.add(lblEdad);

		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);

		JLabel lblProfesin = new JLabel("Profesi\u00F3n");
		panel_2.add(lblProfesin);

		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		panel_2.add(lblTelfono);

		textField_3 = new JTextField();
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);

		JButton btnGuardar = new JButton("Guardar");
		panel_3.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		panel_3.add(btnModificar);

		JButton btnEliminar = new JButton("Eliminar");
		panel_3.add(btnEliminar);

		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);

		JButton btnCancelar = new JButton("Cancelar");
		panel_4.add(btnCancelar);

	}

	public static final Logger LOG = Logger.getLogger(SearchWindow.class);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
