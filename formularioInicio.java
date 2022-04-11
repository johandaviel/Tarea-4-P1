package Tarea4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class formularioInicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton botonRegistrar;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JButton botonIngresar;
	
	//connection to the database
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/registrousuarios";
	private static final String usuario = "root";
	
	//database
	//Connection cn = null; Statement stm = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioInicio frame = new formularioInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/*
	static {
		try {
			Class.forName(controlador);
		} catch (ClassNotFoundException e) {
			System.out.println("error en el controlador.");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, "");
			
			System.out.println("conexion ok.");
		} catch (SQLException e) {
			System.out.println("error en la conexion. ");
			e.printStackTrace();
		}
		return conexion;
	}
	*/
	
	
	public formularioInicio() {
		setBackground(new Color(0, 51, 102));
		setTitle("INICIAR SESION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 287, 282);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		botonRegistrar = new JButton("REGISTRARSE");
		botonRegistrar.setBackground(new Color(0, 255, 255));
		botonRegistrar.addActionListener(this);
		botonRegistrar.setBounds(62, 195, 134, 23);
		contentPane.add(botonRegistrar);
		
		botonIngresar = new JButton("INGRESAR");
		botonIngresar.addActionListener(this);
		botonIngresar.setBackground(Color.CYAN);
		botonIngresar.setBounds(62, 124, 134, 23);
		contentPane.add(botonIngresar);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(30, 42, 65, 23);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 43, 134, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CLAVE: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 78, 65, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NO TIENES UNA CUENTA?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(62, 164, 147, 20);
		contentPane.add(lblNewLabel_1);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(107, 79, 134, 20);
		contentPane.add(txtClave);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonIngresar) {
			handle_botonIngresar_actionPerformed(e);
		}
		if (e.getSource() == botonRegistrar) {
			handle_botonRegistrar_actionPerformed(e);
		}
	}
	protected void handle_botonRegistrar_actionPerformed(ActionEvent e) {
		registrar registro = new registrar();
		registro.setVisible(true);
	}
	protected void handle_botonIngresar_actionPerformed(ActionEvent e) {
		visualizarDatos mostrar = new visualizarDatos();
		mostrar.setVisible(true);
	}
}
