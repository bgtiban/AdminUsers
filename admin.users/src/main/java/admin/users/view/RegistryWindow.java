package admin.users.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.log4j.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import admin.users.control.Coordinator;
import admin.users.exception.PersonaDAOException;
import admin.users.model.PersonaVO;

public class RegistryWindow extends JDialog {

	private Coordinator coordinator;

	public RegistryWindow() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(462, 400);
		getContentPane().setLayout(new GridLayout(5, 1, 0, 0));

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);

		JLabel lblRegistroDePersonar = new JLabel("Registro de Personas");
		lblRegistroDePersonar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_1.add(lblRegistroDePersonar);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_2);

		JLabel label = new JLabel("C\u00F3digo");
		panel_2.add(label);

		cod = new JTextField();
		cod.setColumns(10);
		panel_2.add(cod);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_3);

		JLabel lblNombre = new JLabel("Nombre");
		panel_3.add(lblNombre);

		name = new JTextField();
		panel_3.add(name);
		name.setColumns(10);

		JLabel lblEdad = new JLabel("Edad");
		panel_3.add(lblEdad);

		edad = new JTextField();
		panel_3.add(edad);
		edad.setColumns(10);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		getContentPane().add(panel_4);

		JLabel lblProfesin = new JLabel("Profesi\u00F3n");
		panel_4.add(lblProfesin);

		profesion = new JTextField();
		panel_4.add(profesion);
		profesion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");
		panel_4.add(lblTelefono);

		telefono = new JTextField();
		panel_4.add(telefono);
		telefono.setColumns(10);

		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonaVO persona = new PersonaVO();
				persona.setId(Integer.parseInt(cod.getText().trim()));
				persona.setNombre(name.getText().trim());
				persona.setEdad(Integer.parseInt(edad.getText().trim()));
				persona.setProfesion(profesion.getText().trim());
				persona.setTelefono(telefono.getText().trim());

				try {
					coordinator.registry(persona);
				} catch (PersonaDAOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_5.add(btnRegistrar);

		JButton btnCancelar = new JButton("Cancelar");
		panel_5.add(btnCancelar);
	}

	public static final Logger LOG = Logger.getLogger(RegistryWindow.class);
	private JTextField name;
	private JTextField edad;
	private JTextField profesion;
	private JTextField telefono;
	private JTextField cod;

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
