package prueba;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ventana {

	private JFrame frmSoftwareMaster;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana window = new ventana();
					window.frmSoftwareMaster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSoftwareMaster = new JFrame();
		frmSoftwareMaster.setIconImage(Toolkit.getDefaultToolkit().getImage("src/prueba/SF.ico.jpg"));
		frmSoftwareMaster.setTitle("SOFTWARE MASTER");
		frmSoftwareMaster.setBounds(50, 50, 1250, 650);
		frmSoftwareMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSoftwareMaster.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1234, 611);
		frmSoftwareMaster.getContentPane().add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("INGRESO", null, panel, null);
		panel.setLayout(new CardLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, "name_29389248862256");
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(845, 11, 72, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_1.setBounds(845, 36, 90, 14);
		panel_1.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(945, 8, 145, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(945, 33, 145, 20);
		panel_1.add(passwordField);

		JButton btnNewButton = new JButton("REGISTRARSE");
		btnNewButton.setBounds(1103, 76, 116, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
			}
		});
		panel_1.add(btnNewButton);

		btnNewButton_1 = new JButton("INGRESAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresoCorrecto = false;
				usuarioIngresado = textField.getText();
				contrasenaIngresada = passwordField.getText();
				textField.setText("");
				passwordField.setText("");
				textField.requestFocus();// se vuelve a colocar el cursor al principio
				if (contadorUsuariosRegistrados > 0) {
					for (Usuario e : listaDeUsuarios) {
						if (usuarioIngresado.equalsIgnoreCase(e.dimeUsuario()) == true
								&& contrasenaIngresada.equalsIgnoreCase(e.dimeContrasena()) == true) {
							ingresoCorrecto = true;
							sesionIniciada = true;
							panel_5.setVisible(false);
							panel_6.setVisible(true);
						}
					}
					if (ingresoCorrecto == true) {
						textField.setText("");
						passwordField.setText("");
						textField.requestFocus();
						lblNewLabel_10.setText("USUARIO: " + usuarioIngresado);
						panel_1.setVisible(false);
						panel_2.setVisible(false);
						panel_3.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "SU USUARIO O CONTRASEÑA SON INCORRECTOS");
					}
				} else {
					JOptionPane.showMessageDialog(null, "NO HAY USUARIOS REGISTRADOS!!!");
				}
			}
		});
		btnNewButton_1.setBounds(1100, 7, 119, 23);
		panel_1.add(btnNewButton_1);

		lblNewLabel_30 = new JLabel("");
		lblNewLabel_30.setBackground(Color.BLACK);
		lblNewLabel_30.setIcon(new ImageIcon("src/prueba/Imagenes-de-Ferrari.jpg"));
		lblNewLabel_30.setBounds(0, 0, 1229, 583);
		panel_1.add(lblNewLabel_30);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.RED);
		panel_13.setBounds(945, 0, 284, 583);
		panel_1.add(panel_13);
		panel_13.setLayout(null);

		lblNewLabel_31 = new JLabel("Lo esperamos en nuestro");
		lblNewLabel_31.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 18));
		lblNewLabel_31.setBounds(86, 254, 198, 76);
		panel_13.add(lblNewLabel_31);

		lblNewLabel_32 = new JLabel("Sitio de Compras");
		lblNewLabel_32.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 28));
		lblNewLabel_32.setBounds(80, 389, 204, 51);
		panel_13.add(lblNewLabel_32);

		panel_2 = new JPanel();
		panel.add(panel_2, "name_29389273306823");
		panel_2.setLayout(null);

		lblNewLabel_2 = new JLabel("NUEVO USUARIO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(20, 11, 181, 25);
		panel_2.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("USUARIO");
		lblNewLabel_3.setBounds(20, 117, 59, 14);
		panel_2.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setBounds(192, 114, 142, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_4 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_4.setBounds(20, 167, 92, 14);
		panel_2.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("CONFIRMAR CONTRASE\u00D1A");
		lblNewLabel_5.setBounds(20, 207, 150, 14);
		panel_2.add(lblNewLabel_5);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 164, 142, 20);
		panel_2.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(192, 204, 142, 20);
		panel_2.add(passwordField_2);

		lblNewLabel_6 = new JLabel("DNI");
		lblNewLabel_6.setBounds(20, 268, 75, 14);
		panel_2.add(lblNewLabel_6);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if ((int) arg0.getKeyChar() < 48 || (int) arg0.getKeyChar() > 57) {
					arg0.consume();
				}
			}
		});
		textField_2.setBounds(192, 265, 142, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		btnNewButton_2 = new JButton("REGISTRAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usuarioIngresado = textField_1.getText();
				contrasenaIngresada = passwordField_1.getText();
				confirmacionContrasena = passwordField_2.getText();
				DNI = textField_2.getText();
				if (contrasenaIngresada.equalsIgnoreCase(confirmacionContrasena)) {
					contadorUsuariosRegistrados++;
					JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO CORRECTAMENTE");
					listaDeUsuarios = new ArrayList<Usuario>();
					listaDeUsuarios.add(new Usuario(usuarioIngresado, contrasenaIngresada, DNI));
					textField_1.setText("");
					;
					passwordField_1.setText("");
					passwordField_2.setText("");
					textField_2.setText("");
					textField_1.requestFocus();
					panel_1.setVisible(true);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "LA CONTRASEÑA NO COINCIDE");
					textField_1.setText("");
					;
					passwordField_1.setText("");
					passwordField_2.setText("");
					textField_2.setText("");
					textField_1.requestFocus();
				}
			}
		});
		btnNewButton_2.setBounds(20, 345, 147, 23);
		panel_2.add(btnNewButton_2);

		panel_3 = new JPanel();
		panel.add(panel_3, "name_31010134936023");
		panel_3.setLayout(null);

		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("src/prueba/Barbie Real.jpg"));
		lblNewLabel_8.setBounds(715, 11, 492, 572);
		panel_3.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("BIENVENIDO A:    YOCOMPRO.COM!!!");
		lblNewLabel_9.setForeground(Color.CYAN);
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 30));
		lblNewLabel_9.setBounds(59, 259, 578, 59);
		panel_3.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel(usuarioIngresado);
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 30));
		lblNewLabel_10.setBounds(59, 155, 551, 50);
		panel_3.add(lblNewLabel_10);

		panel_4 = new JPanel();

		tabbedPane.addTab("COMPRAS", null, panel_4, null);
		panel_4.setLayout(new CardLayout(0, 0));

		panel_5 = new JPanel();
		panel_4.add(panel_5, "name_39958016111029");
		panel_5.setLayout(null);

		lblNewLabel_11 = new JLabel("LA PROXIMA INICIO SESION...");
		lblNewLabel_11.setBounds(27, 36, 604, 59);
		lblNewLabel_11.setFont(new Font("Sitka Display", Font.PLAIN, 39));
		panel_5.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(476, 92, 717, 480);
		lblNewLabel_12.setIcon(new ImageIcon("src/prueba/No Inicio.jpg"));
		panel_5.add(lblNewLabel_12);

		panel_6 = new JPanel();
		panel_4.add(panel_6, "name_39989348030133");
		panel_6.setLayout(null);

		lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("src/prueba/Auto de Lujo.jpg"));
		lblNewLabel_13.setBounds(643, 89, 438, 331);
		panel_6.add(lblNewLabel_13);

		lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setInheritsPopupMenu(false);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setIcon(new ImageIcon("src/prueba/Moto Saltando.jpg"));
		lblNewLabel_14.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_14.setBounds(56, 89, 452, 331);
		panel_6.add(lblNewLabel_14);

		btnNewButton_3 = new JButton("COMPRAR MOTO");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioPorEleccion = 0;
				panel_11.setVisible(false);
				estadoEscogido = (String) comboBox.getSelectedItem();
				marcaEscogida = (String) comboBox_2.getSelectedItem();
				localidadDeDestinoEscogida = (String) comboBox_1.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("Nuevo/a")) {
					precioPorEleccion += 1000;
				} else if (estadoEscogido.equalsIgnoreCase("Usado/a")) {
					precioPorEleccion += 500;
				}

				if (marcaEscogida.equalsIgnoreCase("Toyota")) {
					precioPorEleccion += 2500;

				} else if (marcaEscogida.equalsIgnoreCase("Mitsubisi")) {
					precioPorEleccion += 2000;

				} else if (marcaEscogida.equalsIgnoreCase("GP")) {
					precioPorEleccion += 1500;
				}

				if (localidadDeDestinoEscogida.equalsIgnoreCase("Buenos Aires")) {
					precioPorEleccion += 500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar del Plata")) {
					precioPorEleccion += 250;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar de Ajó")) {
					precioPorEleccion += 100;
				}
				lblNewLabel_20.setText("" + precioPorEleccion);
				lblNewLabel_20.setVisible(true);
				panel_6.setVisible(false);
				panel_7.setVisible(true);

			}
		});
		btnNewButton_3.setBounds(55, 418, 453, 46);
		panel_6.add(btnNewButton_3);
		btnNewButton_4 = new JButton("COMPRAR AUTO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioPorEleccion = 0;
				estadoEscogido = (String) comboBox_5.getSelectedItem();
				marcaEscogida = (String) comboBox_3.getSelectedItem();
				localidadDeDestinoEscogida = (String) comboBox_4.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("Nuevo/a")) {
					precioPorEleccion += 25000;
				} else if (estadoEscogido.equalsIgnoreCase("Usado/a")) {
					precioPorEleccion += 20000;
				}

				if (marcaEscogida.equalsIgnoreCase("Ferrari")) {
					precioPorEleccion += 15000;

				} else if (marcaEscogida.equalsIgnoreCase("Porche")) {
					precioPorEleccion += 10000;

				} else if (marcaEscogida.equalsIgnoreCase("Fitito")) {
					precioPorEleccion += 5000;
				}

				if (localidadDeDestinoEscogida.equalsIgnoreCase("Buenos Aires")) {
					precioPorEleccion += 3500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar del Plata")) {
					precioPorEleccion += 2500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar de Ajó")) {
					precioPorEleccion += 1500;
				}
				lblNewLabel_29.setText("" + precioPorEleccion);
				lblNewLabel_29.setVisible(true);

				panel_6.setVisible(false);
				panel_11.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(643, 418, 438, 46);
		panel_6.add(btnNewButton_4);

		panel_7 = new JPanel();
		panel_4.add(panel_7, "name_44668134701601");
		panel_7.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("ESTADO");
		lblNewLabel_15.setBounds(10, 89, 69, 29);
		panel_7.add(lblNewLabel_15);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioA1 = 0;
				estadoEscogido = (String) comboBox.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("Nuevo/a")) {
					precioA1 += 1000;
				} else if (estadoEscogido.equalsIgnoreCase("Usado/a")) {
					precioA1 += 500;
				}
				precioPorEleccion = precioA1 + precioA2 + precioA3;
				lblNewLabel_20.setText("" + precioPorEleccion);
				lblNewLabel_20.setVisible(true);
				precioPorEleccion = 0;
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Ninguno", "Nuevo/a", "Usado/a" }));
		comboBox.setBounds(180, 93, 161, 20);
		panel_7.add(comboBox);

		JLabel lblNewLabel_16 = new JLabel("COMPRAR MOTOCICLETA");
		lblNewLabel_16.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 30));
		lblNewLabel_16.setBounds(44, 23, 399, 55);
		panel_7.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("LOCALIDAD DE DESTINO");
		lblNewLabel_17.setBounds(10, 233, 143, 14);
		panel_7.add(lblNewLabel_17);

		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioA3 = 0;
				localidadDeDestinoEscogida = (String) comboBox_1.getSelectedItem();
				if (localidadDeDestinoEscogida.equalsIgnoreCase("Buenos Aires")) {
					precioA3 += 500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar del Plata")) {
					precioA3 += 250;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar de Ajó")) {
					precioA3 += 100;
				}
				precioPorEleccion = precioA1 + precioA2 + precioA3;
				lblNewLabel_20.setText("" + precioPorEleccion);
				lblNewLabel_20.setVisible(true);
				precioPorEleccion = 0;
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "Ninguna", "Buenos Aires", "Mar del Plata", "Mar de Aj\u00F3" }));
		comboBox_1.setBounds(180, 230, 161, 20);
		panel_7.add(comboBox_1);

		JLabel lblNewLabel_18 = new JLabel("MARCA");
		lblNewLabel_18.setBounds(10, 163, 87, 20);
		panel_7.add(lblNewLabel_18);

		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioA2 = 0;
				marcaEscogida = (String) comboBox_2.getSelectedItem();
				if (marcaEscogida.equalsIgnoreCase("Toyota")) {
					precioA2 += 2500;

				} else if (marcaEscogida.equalsIgnoreCase("Mitsubisi")) {
					precioA2 += 2000;

				} else if (marcaEscogida.equalsIgnoreCase("GP")) {
					precioA2 += 1500;
				}
				precioPorEleccion = precioA1 + precioA2 + precioA3;
				lblNewLabel_20.setText("" + precioPorEleccion);
				lblNewLabel_20.setVisible(true);
				precioPorEleccion = 0;
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Ninguna", "Toyota", "Mitzubizi", "GP" }));
		comboBox_2.setBounds(180, 163, 161, 20);
		panel_7.add(comboBox_2);

		JLabel lblNewLabel_19 = new JLabel("PRECIO SEG\u00DAN ELECCI\u00D3N");
		lblNewLabel_19.setBounds(10, 377, 151, 29);
		panel_7.add(lblNewLabel_19);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 255, 255));
		panel_8.setBounds(180, 364, 161, 55);
		panel_7.add(panel_8);
		panel_8.setLayout(null);

		lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setBounds(10, 11, 138, 41);
		panel_8.add(lblNewLabel_20);
		lblNewLabel_20.setForeground(Color.GREEN);
		lblNewLabel_20.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_20.setVisible(false);

		JButton btnNewButton_5 = new JButton("COMPRAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estadoEscogido = (String) comboBox.getSelectedItem();
				marcaEscogida = (String) comboBox_2.getSelectedItem();
				localidadDeDestinoEscogida = (String) comboBox_1.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("ninguno") == false
						&& marcaEscogida.equalsIgnoreCase("ninguna") == false
						&& localidadDeDestinoEscogida.equalsIgnoreCase("ninguna") == false) {
					precioFinal = lblNewLabel_20.getText();
					precioPorEleccion = Float.parseFloat(precioFinal);
					panel_11.setVisible(false);
					totalGastado += precioPorEleccion;
					lblNewLabel_23.setText("TOTAL INVERTIDO HASTA AHORA: " + totalGastado);
					panel_7.setVisible(false);
					panel_11.setVisible(false);
					panel_9.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,
							"RECUERDE LLENAR TODOS LOS CAMPOS DE LOS CRITERIOS DE BUSQUEDA");
				}
			}
		});
		btnNewButton_5.setBackground(new Color(0, 255, 0));
		btnNewButton_5.setBounds(733, 137, 229, 42);
		panel_7.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("CANCELAR COMPRA");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_11.setVisible(false);
				panel_7.setVisible(false);
				panel_9.setVisible(true);
			}
		});
		btnNewButton_6.setBackground(new Color(255, 0, 0));
		btnNewButton_6.setBounds(733, 229, 229, 42);
		panel_7.add(btnNewButton_6);

		lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setIcon(new ImageIcon("src/prueba/ghostridergrabieldeloto.jpg"));
		lblNewLabel_33.setBounds(700, 62, 346, 223);
		panel_7.add(lblNewLabel_33);

		panel_9 = new JPanel();
		panel_4.add(panel_9, "name_56094084449533");
		panel_9.setLayout(null);

		lblNewLabel_21 = new JLabel("GRACIAS POR SU COMPRA");
		lblNewLabel_21.setForeground(new Color(30, 144, 255));
		lblNewLabel_21.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		lblNewLabel_21.setBounds(132, 29, 472, 46);
		panel_9.add(lblNewLabel_21);

		btnNewButton_7 = new JButton("SEGUIR COMPRANDO");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_9.setVisible(false);
				panel_11.setVisible(false);
				panel_6.setVisible(true);
			}
		});
		btnNewButton_7.setBackground(new Color(255, 215, 0));
		btnNewButton_7.setBounds(46, 502, 178, 23);
		panel_9.add(btnNewButton_7);

		btnNewButton_8 = new JButton("CERRAR SESI\u00D3N");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioPorEleccion = 0;
				sesionIniciada = false;
				panel_3.setVisible(false);
				panel_6.setVisible(false);
				panel_9.setVisible(false);
				panel_7.setVisible(false);
				panel_11.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnNewButton_8.setForeground(new Color(128, 0, 128));
		btnNewButton_8.setBounds(529, 502, 171, 23);
		panel_9.add(btnNewButton_8);

		lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon("src/prueba/Caminando.gif.gif"));
		lblNewLabel_22.setBounds(150, 86, 421, 371);
		panel_9.add(lblNewLabel_22);

		panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 255, 255));
		panel_10.setBounds(626, 211, 603, 93);
		panel_9.add(panel_10);

		lblNewLabel_23 = new JLabel("");
		panel_10.add(lblNewLabel_23);
		lblNewLabel_23.setForeground(new Color(255, 0, 255));
		lblNewLabel_23.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));

		lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon("src/prueba/Dinero Callendo.gif"));
		lblNewLabel_24.setBounds(696, 65, 444, 263);
		panel_9.add(lblNewLabel_24);

		panel_11 = new JPanel();
		panel_4.add(panel_11, "name_61797983866400");
		panel_11.setLayout(null);

		lblNewLabel_25 = new JLabel("ESTADO");
		lblNewLabel_25.setBounds(10, 123, 69, 29);
		panel_11.add(lblNewLabel_25);

		comboBox_3 = new JComboBox();
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioB2 = 0;
				marcaEscogida = (String) comboBox_3.getSelectedItem();
				if (marcaEscogida.equalsIgnoreCase("Ferrari")) {
					precioB2 += 15000;
				} else if (marcaEscogida.equalsIgnoreCase("Porche")) {
					precioB2 += 10000;
				} else if (marcaEscogida.equalsIgnoreCase("Fitito")) {
					precioB2 += 5000;
				}
				precioPorEleccion = precioB1 + precioB2 + precioB3;
				lblNewLabel_29.setText("" + precioPorEleccion);
				lblNewLabel_29.setVisible(true);
				precioPorEleccion = 0;
			}
		});
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Ninguna", "Ferrari", "Porche", "Fitito" }));
		comboBox_3.setBounds(193, 206, 161, 20);
		panel_11.add(comboBox_3);

		lblNewLabel_26 = new JLabel("COMPRAR AUTOM\u00D3VIL");
		lblNewLabel_26.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 30));
		lblNewLabel_26.setBounds(10, 33, 363, 55);
		panel_11.add(lblNewLabel_26);

		lblNewLabel_27 = new JLabel("LOCALIDAD DE DESTINO");
		lblNewLabel_27.setBounds(10, 291, 143, 14);
		panel_11.add(lblNewLabel_27);

		comboBox_4 = new JComboBox();
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioB3 = 0;
				localidadDeDestinoEscogida = (String) comboBox_4.getSelectedItem();
				if (localidadDeDestinoEscogida.equalsIgnoreCase("Buenos Aires")) {
					precioB3 += 3500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar del Plata")) {
					precioB3 += 2500;
				} else if (localidadDeDestinoEscogida.equalsIgnoreCase("Mar de Ajó")) {
					precioB3 += 1500;
				}
				precioPorEleccion = precioB1 + precioB2 + precioB3;
				lblNewLabel_29.setText("" + precioPorEleccion);
				lblNewLabel_29.setVisible(true);
				precioPorEleccion = 0;
			}
		});
		comboBox_4.setModel(new DefaultComboBoxModel(
				new String[] { "Ninguna", "Buenos Aires", "Mar del Plata", "Mar de Aj\u00F3" }));
		comboBox_4.setBounds(194, 288, 161, 20);
		panel_11.add(comboBox_4);

		lblNewLabel_28 = new JLabel("MARCA");
		lblNewLabel_28.setBounds(10, 205, 87, 20);
		panel_11.add(lblNewLabel_28);

		comboBox_5 = new JComboBox();
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				precioB1 = 0;
				estadoEscogido = (String) comboBox_5.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("Nuevo/a")) {
					precioB1 += 25000;
				} else if (estadoEscogido.equalsIgnoreCase("Usado/a")) {
					precioB1 += 20000;
				}
				precioPorEleccion = precioB1 + precioB2 + precioB3;
				lblNewLabel_29.setText("" + precioPorEleccion);
				lblNewLabel_29.setVisible(true);
				precioPorEleccion = 0;

			}
		});
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Ninguno", "Nuevo/a", "Usado/a" }));
		comboBox_5.setBounds(192, 128, 161, 20);
		panel_11.add(comboBox_5);

		btnNewButton_10 = new JButton("CANCELAR COMPRA");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_11.setVisible(false);
				panel_7.setVisible(false);
				panel_9.setVisible(true);
			}
		});
		btnNewButton_10.setBackground(new Color(255, 0, 0));
		btnNewButton_10.setBounds(712, 265, 169, 40);
		panel_11.add(btnNewButton_10);

		btnNewButton_11 = new JButton("COMPRAR");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				estadoEscogido = (String) comboBox_5.getSelectedItem();
				marcaEscogida = (String) comboBox_3.getSelectedItem();
				localidadDeDestinoEscogida = (String) comboBox_4.getSelectedItem();
				if (estadoEscogido.equalsIgnoreCase("ninguno") == false
						&& marcaEscogida.equalsIgnoreCase("ninguna") == false
						&& localidadDeDestinoEscogida.equalsIgnoreCase("ninguna") == false) {
					precioFinal = lblNewLabel_29.getText();
					precioPorEleccion = Float.parseFloat(precioFinal);
					totalGastado += precioPorEleccion;
					lblNewLabel_23.setText("TOTAL INVERTIDO HASTA AHORA: " + totalGastado);
					panel_7.setVisible(false);
					panel_11.setVisible(false);
					panel_9.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null,
							"RECUERDE LLENAR TODOS LOS CAMPOS DE LOS CRITERIOS DE BUSQUEDA");
				}
			}
		});

		btnNewButton_11.setBackground(new Color(0, 255, 0));
		btnNewButton_11.setBounds(712, 186, 174, 40);
		panel_11.add(btnNewButton_11);

		panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 255, 255));
		panel_12.setBounds(195, 386, 161, 62);
		panel_11.add(panel_12);
		panel_12.setLayout(null);

		lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setForeground(Color.GREEN);
		lblNewLabel_29.setBackground(Color.GREEN);
		lblNewLabel_29.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		lblNewLabel_29.setBounds(10, 11, 140, 40);
		panel_12.add(lblNewLabel_29);

		JLabel lblNewLabel_7 = new JLabel("PRECIO SEG\u00DAN ELECCI\u00D3N");
		lblNewLabel_7.setBounds(10, 409, 161, 14);
		panel_11.add(lblNewLabel_7);

		lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setIcon(new ImageIcon("src/prueba/Auto2.jfif"));
		lblNewLabel_34.setBounds(643, 118, 468, 273);
		panel_11.add(lblNewLabel_34);
	}

	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_6;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;

	private String usuarioIngresado = "";
	private String contrasenaIngresada = "";
	private String confirmacionContrasena = "";
	private String DNI = "";
	private ArrayList<Usuario> listaDeUsuarios;
	private boolean ingresoCorrecto = false;
	private JButton btnNewButton_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private boolean sesionIniciada = false;
	private int contadorUsuariosRegistrados = 0;
	private JLabel lblNewLabel_10;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JPanel panel_6;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPanel panel_7;
	private JLabel lblNewLabel_20;
	private String estadoEscogido;
	private String marcaEscogida;
	private String localidadDeDestinoEscogida;
	private float precioPorEleccion = 0;
	private JPanel panel_9;
	private JLabel lblNewLabel_21;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_22;
	private float totalGastado = 0;
	private JLabel lblNewLabel_23;
	private JPanel panel_10;
	private JLabel lblNewLabel_24;
	private JPanel panel_11;
	private JLabel lblNewLabel_25;
	private JComboBox comboBox_3;
	private JLabel lblNewLabel_26;
	private JLabel lblNewLabel_27;
	private JComboBox comboBox_4;
	private JLabel lblNewLabel_28;
	private JComboBox comboBox_5;
	private JLabel lblNewLabel_29;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JPanel panel_12;
	private float precioA1 = 0;
	private float precioA2 = 0;
	private float precioA3 = 0;
	private float precioB1 = 0;
	private float precioB2 = 0;
	private float precioB3 = 0;
	private String precioFinal = "";
	private JLabel lblNewLabel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JLabel lblNewLabel_34;
}
