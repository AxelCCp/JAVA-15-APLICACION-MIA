package Aplicacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class A4_BaseDatosTxt extends JFrame {
	public A4_BaseDatosTxt() {
		setTitle("Base de datos, conexión con archivo.txt");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(740,140,500,600);
		setVisible(true);	
	}
}
class LaminaBaseDatosTxt extends JPanel {
	public LaminaBaseDatosTxt() {
		
		setLayout(new BorderLayout());
		laminaNorte = new JPanel();
		add(laminaNorte,BorderLayout.NORTH);
		
		comboTablas = new JComboBox();
		laminaNorte.add(comboTablas,BorderLayout.NORTH);
		
		areaInformacion = new JTextArea();
		add(areaInformacion,BorderLayout.CENTER);
		areaInformacion.setLineWrap(true);
		
		JScrollPane deslizador = new JScrollPane(areaInformacion);
		add(deslizador);
		
		conectarBaseDatos(); 
		obtenerTablas();
		
		comboTablas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String nombreTabla = (String) comboTablas.getSelectedItem();
				mostrarInformacion(nombreTabla);
			}
		});
		botonCrud("Insertar", "C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/table.gif", Color.WHITE,99,25);
		botonCrud("Actualizar", "C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/action_refresh.gif", Color.WHITE,111,25);
		botonCrud("Borrar", "C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/page_text_delete.gif", Color.WHITE,92,25);
	}
	//:::::::::::::::::::::::::::::::::::::::::::::
	
	//MÉTODO QUE CONECTA CON BASE DE DATOS ::::::::
	public void conectarBaseDatos() {
		miConexion = null;
		String []datos = new String[3];
		
		//(1)Buscar archivo de conexión
		try {
			entrada = new FileReader("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/RutaDeConexionBBDD.txt");
			
		}catch(IOException e) {
			
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Texto", ".txt");
			chooser.setFileFilter(filtro);
			int returnVal = chooser.showOpenDialog(this);
			
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {entrada = new FileReader(chooser.getSelectedFile());}
				catch (FileNotFoundException e1) {e1.printStackTrace();}
			}
		}
		
		//(2)Leer archivo de conexión y conectar
		try {
			BufferedReader miBuffer = new BufferedReader(entrada);  
			for(int i=0;i<=2;i++) {
				datos[i]=miBuffer.readLine();
			}
			miConexion = DriverManager.getConnection(datos[0],datos[1],datos[2]);
			entrada.close();
			areaInformacion.setText("Paso 1: Se encontró archivo de conexión a Base de Datos."
									+ "\nPaso 2: Archivo de conexión leído."
									+ "\nPaso 3: Conexión establecida con Base de datos");
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}
	//::::::::::::::::::::::::::::::::::::::::::
	
	//MÉTODO QUE CARGA EL JCOMBOBOX ::::::::::::
	public void obtenerTablas() {
		ResultSet miResultSet = null;
		
		try {
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			miResultSet = datosBBDD.getTables(null, null, null, null);
			while(miResultSet.next()){
				comboTablas.addItem(miResultSet.getString("TABLE_NAME"));	
			}
			areaInformacion.append("\nPaso4: Se han obtenido tablas");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//::::::::::::::::::::::::::::::::::::::::::
	
	//MÉTODO QUE CARGA INFORMACIÓN::::::::::::::
	public void mostrarInformacion(String tabla) {
		ArrayList<String>campos = new ArrayList<String>();
		String consulta = "SELECT * FROM " + tabla;
		
		try {
			areaInformacion.setText("");
			Statement miStatement = miConexion.createStatement();
			ResultSet miResultSet = miStatement.executeQuery(consulta);
			ResultSetMetaData rsBBDD = miResultSet.getMetaData();
			for(int i=1;i<=rsBBDD.getColumnCount();i++) {
				campos.add(rsBBDD.getColumnLabel(i));
			}
			while(miResultSet.next()) {
				for(String nombreCampo: campos) {
					areaInformacion.append(miResultSet.getString(nombreCampo) + "   ");
				}
				areaInformacion.append("\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("no se concretó el método mostrarInformacion(String tabla)");
		}
	}
	//::::::::::::::::::::::::::::::::::::::::::
	
	//MÉTODO QUE CONFIGURA BOTONES::::::::::::::
	public void botonCrud(String nombre, String icono, Color fondo,int largo, int ancho) {
		botonCrud = new JButton(nombre, new ImageIcon(icono));
		botonCrud.setBackground(fondo);
		botonCrud.setPreferredSize(new Dimension(largo,ancho));
		laminaNorte.add(botonCrud);
		botonCrud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(nombre=="Insertar") {
					marco2("Insertar Datos");
				}else if(nombre=="Actualizar") {
					marco2("Actualizar Datos");
				}else if(nombre=="Borrar") {
					marco2("Borrar Datos");
				}
			}
		});
	}
	//MÉTODO QUE CONFIGURA MARCO DEL CRUD
	public void marco2(String titulo) {
		 marcoCrud = new  A4_BaseDatosTxt();
		 marcoCrud.setTitle(titulo);
		 marcoCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 marcoCrud.setBounds(740,460,500,150);
		 marcoCrud.setVisible(true);
		 
		 laminaCrud = new JPanel();
		 laminaCrud.setLayout(new FlowLayout());
		 
		 marcoCrud.add(laminaCrud,BorderLayout.NORTH);
		 
		 txtCrud = new JTextArea();
		 marcoCrud.add(txtCrud,BorderLayout.CENTER);
		 
		 txtCrud.setBackground(Color.getHSBColor(0.1f, 0.1f, 0.95f));
		 txtCrud.setLineWrap(true);
		 
		 JScrollPane deslizadora = new JScrollPane(txtCrud);
		 marcoCrud.add(deslizadora);
		 
		 botonEjecutar("Ejecutar","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/action_go.gif");
	}
	//MÉTODO QUE CONSTRUYE EL BOTÓN EJECUTAR
	public void botonEjecutar(String nombre, String icono) {
		JButton botonEjecutar  = new JButton(nombre, new ImageIcon(icono));
		botonEjecutar.setBounds(new Rectangle(95,25));
		botonEjecutar.setBackground(Color.WHITE);
		laminaCrud.add(botonEjecutar);
		botonEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int respuesta = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea realizar cambios a la base de datos?", "Cambios en base de datos", JOptionPane.YES_NO_OPTION);
				
				if(respuesta==0) {
					int confirmacion = JOptionPane.showConfirmDialog(null, "Confirmar Operacion", "Confirmación de envío", JOptionPane.YES_NO_OPTION);
					if(confirmacion==0) {
						String instruccionSql = txtCrud.getText();
						txtCrud.setEditable(false);	
						
						try {
							Statement miStatement = miConexion.createStatement();
							miStatement.executeUpdate(instruccionSql);
							txtCrud.append("\nDatos modificados");
							txtCrud.setForeground(Color.BLUE);txtCrud.setBackground(Color.getHSBColor(0.3f, 0.1f, 0.9f));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							txtCrud.append("\nHubo errores de sintaxis SQL");
							txtCrud.setForeground(Color.RED);txtCrud.setBackground(Color.getHSBColor(0.0f, 0.22f, 0.99f));
						}	
					}
				}
			}
		});
	}
	
	//::::::::::::::::::::::::::::::::::::::::::
	private JPanel laminaNorte;
	private JComboBox comboTablas;
	private JTextArea areaInformacion; 
	private FileReader entrada;
	private Connection miConexion;
	//
	private JButton botonCrud;
	//
	private A4_BaseDatosTxt marcoCrud;
	private JPanel laminaCrud;
	private JTextArea txtCrud; 
}
