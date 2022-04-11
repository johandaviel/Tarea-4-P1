package Tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.Font;

public class visualizarDatos extends JFrame {

	private JPanel contentPane;
	private JTable tablaDatos;
	
	conexiondb conectar = new conexiondb();
	Connection connect = conectar.conectar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					visualizarDatos frame = new visualizarDatos();
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
	public visualizarDatos() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		
		tablaDatos = new JTable();
		tablaDatos.setColumnSelectionAllowed(true);
		tablaDatos.setCellSelectionEnabled(true);
		panel.add(tablaDatos);
		tablaDatos.setVisible(true);
	}
	
	
	public void mostrarDatos() {
		DefaultTableModel tblDatos = new DefaultTableModel();
		tblDatos.addColumn("idUsuario");
		tblDatos.addColumn("Nombre");
		tblDatos.addColumn("Apellido");
		tblDatos.addColumn("Usuario");
		tblDatos.addColumn("Email");
		tablaDatos.setModel(tblDatos);
		
		String sql = "SELECT * FROM mostrardatos";
		
		String []datos = new String[5];
		
		try {
			Statement leer = connect.createStatement();
			ResultSet resultado = leer.executeQuery(sql);
			
			while(resultado.next()) {
				datos[0] = resultado.getString(1);
				datos[1] = resultado.getString(2);
				datos[2] = resultado.getString(3);
				datos[3] = resultado.getString(4);
				datos[4] = resultado.getString(5);
				tblDatos.addRow(datos);
				tablaDatos.setModel(tblDatos);

			}
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e + " hubo un bobo. " );
			e.printStackTrace();
		}
		
		
		}

}
