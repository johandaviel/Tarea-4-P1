package Tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class registrar extends JFrame implements ActionListener {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	conexiondb conectar = new conexiondb();
	Connection connect = conectar.conectar();
	private JButton botonGuardar;
	private JTextField txtId;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registrar frame = new registrar();
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
	public registrar() {
		setTitle("REGISTRAR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 299, 351);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOMBRE:");
		lblNewLabel.setBounds(29, 55, 64, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(29, 88, 64, 22);
		getContentPane().add(lblApellido);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setBounds(29, 121, 64, 22);
		getContentPane().add(lblUsuario);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(29, 154, 64, 22);
		getContentPane().add(lblEmail);
		
		JLabel lblClave = new JLabel("CLAVE:");
		lblClave.setBounds(29, 187, 64, 22);
		getContentPane().add(lblClave);
		
		JLabel lblConfirmarClave = new JLabel("VALIDAR CLAVE: ");
		lblConfirmarClave.setBounds(10, 220, 100, 22);
		getContentPane().add(lblConfirmarClave);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 56, 133, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(103, 89, 133, 20);
		getContentPane().add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(103, 122, 133, 20);
		getContentPane().add(txtUsuario);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 155, 133, 20);
		getContentPane().add(txtEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 188, 133, 20);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(103, 221, 133, 20);
		getContentPane().add(passwordField_1);
		
		botonGuardar = new JButton("GUARDAR");
		botonGuardar.addActionListener(this);
		botonGuardar.setBounds(103, 253, 89, 23);
		getContentPane().add(botonGuardar);
		
		JLabel lblid = new JLabel("ID: ");
		lblid.setBounds(47, 30, 46, 14);
		getContentPane().add(lblid);
		
		txtId = new JTextField();
		txtId.setBounds(103, 25, 133, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonGuardar) {
			handle_btnNewButton_actionPerformed(e);
		}
	}
	protected void handle_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			PreparedStatement registrar = connect.prepareStatement("INSERT INTO mostrardatos (idUsuario, Nombre, Apellido, Usuario, Email) VALUES (?,?,?,?,?)");
			registrar.setString(1, txtId.getText());
			registrar.setString(2, txtNombre.getText());
			registrar.setString(3, txtApellido.getText());
			registrar.setString(4, txtUsuario.getText());
			registrar.setString(5, txtEmail.getText());
			registrar.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro agregado con exito. ");
			txtId.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtUsuario.setText("");
			txtEmail.setText("");
			passwordField.setText("");
			passwordField_1.setText("");
			txtId.requestFocus();

		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e + " no se pudo bro. ");
		}
	}
}
