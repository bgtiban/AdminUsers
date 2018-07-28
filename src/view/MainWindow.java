package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import control.Coordinator;

public class MainWindow extends JFrame {

	private Coordinator coordinator;

	public MainWindow() {
		this.setSize(462, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		JLabel lblPatrnModeloVista = new JLabel("PATR\u00D3N MODELO VISTA CONTROLADOR");
		lblPatrnModeloVista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPatrnModeloVista.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPatrnModeloVista);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setText(
				"Esta Aplicaci\u00F3n presenta un ejemplo pr\u00E1ctico del patr\u00F3n de dise\u00F1o MVC.\r\n\r\nLa aplicaci\u00F3n permite registrar actualizar buscar y eliminar registros de una tabla persona,\r\ntambi\u00E9n son vinculados algunos de los conceptos de los patrones VO, DAO.");
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		scrollPane.setViewportView(textArea);

		JLabel lblEscojaQueOperacin = new JLabel("Escoja que operaci\u00F3n desea realizar.");
		lblEscojaQueOperacin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscojaQueOperacin.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEscojaQueOperacin);

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistryWindow rw = new RegistryWindow();
				rw.setVisible(true);
			}
		});
		panel.add(btnRegistrar);

		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar);
	}

	public static final Logger LOG = Logger.getLogger(MainWindow.class);

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}
}
