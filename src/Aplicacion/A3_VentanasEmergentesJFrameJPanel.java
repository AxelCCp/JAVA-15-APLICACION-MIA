package Aplicacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;



public class A3_VentanasEmergentesJFrameJPanel extends JFrame {
	public A3_VentanasEmergentesJFrameJPanel() {
		
	}
}

//VENTANA DE PLANILLA:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MConfiguraciones extends JFrame{
	public MConfiguraciones() {
		setTitle("Planilla");
		setBounds(610,20,740,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		setVisible(true);
	}		
}
class LConfiguraciones extends JPanel{
	public LConfiguraciones(){
		setLayout(new BorderLayout());
		JPanel laminacentral = new JPanel();
		add(laminacentral,BorderLayout.NORTH);
		JTextArea planilla = new JTextArea();
		add(planilla,BorderLayout.CENTER);
		planilla.setWrapStyleWord(true);
		JScrollPane deslizadora = new JScrollPane(planilla);
		add(deslizadora);
		planilla.append("PLANILLA DE EMPLEADOS\n");
		
		/*
		Empleado empleado1 = new Empleado("Jason", 1000, 1985, 6,18);
		Empleado empleado2 = new Empleado("Fredy", 1500, 1990, 5,15);
		Empleado empleado3 = new Empleado("Alien", 2500, 1950, 12,20);
		empleado1.subeSueldo(10);
		empleado2.subeSueldo(8);
		empleado3.subeSueldo(5);
		planilla.append("\nNOMBRE: " + empleado1.getNombre() + "--- SUELDO: " + empleado1.getSueldo() + "--- FECHA CONTRATO: " + empleado1.getFechaContrato());
		planilla.append("\nNOMBRE: " + empleado2.getNombre() + "--- SUELDO: " + empleado2.getSueldo() + "--- FECHA CONTRATO: " + empleado2.getFechaContrato());
		planilla.append("\nNOMBRE: " + empleado3.getNombre() + "--- SUELDO: " + empleado3.getSueldo() + "--- FECHA CONTRATO: " + empleado3.getFechaContrato());
		*/
		
		Empleado[]misEmpleados = new Empleado[3];
		misEmpleados[0]=new Empleado("Jason", 1000, 1985, 6,18);
		misEmpleados[1]=new Empleado("Fredy", 1500, 1990, 5,15);
		misEmpleados[2]=new Empleado("Alien", 2500, 1950, 12,20);
		
		//for(int i=0;i<3;i++) misEmpleados[i].subeSueldo(10);
		for(Empleado x : misEmpleados) x.subeSueldo(10);
		
		//for(int i=0;i<3;i++) planilla.append("\nNOMBRE: " + misEmpleados[i].getNombre()+ "--- SUELDO: " + misEmpleados[i].getSueldo()+ "--- FECHA CONTRATO: " + misEmpleados[i].getFechaContrato()); 
		for(Empleado y : misEmpleados) planilla.append("\nNOMBRE: " + y.getNombre()+ "--- SUELDO: " + y.getSueldo()+ "--- FECHA CONTRATO: " + y.getFechaContrato()); 
		
	}
}

class Empleado{
	public Empleado(String nombre, double sueldo, int agno, int mes, int dia) {
		
		this.nombre= nombre;
		this.sueldo=sueldo;
		GregorianCalendar calendario = new GregorianCalendar(agno, mes-1, dia); 
		altaContrato=calendario.getTime();//devuelve la fecha.
	}
	public String getNombre() {
		return nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public Date getFechaContrato() {
		return altaContrato;
	}
	
	public void subeSueldo(double porcentaje) {
		double aumento = sueldo*porcentaje/100;
		sueldo+=aumento;
	}
	
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
}
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA DE  IMAGENES:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MImagenes extends JFrame{
	public MImagenes() {
		setTitle("Imagenes");
		setBounds(830,50,500,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
class LImagenes extends JPanel{
	public LImagenes() {
		this.setBackground(Color.ORANGE);
		
	}
}
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA DE EDITOR DE TXT:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MEditor extends JFrame{
	public MEditor() {
		setTitle("Editor txt");
		setBounds(90,30,1200,700);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
class LEditor extends JPanel{
	
	public LEditor() {
		this.setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		JPanel laminaNorte = new JPanel();
		add(laminaNorte,BorderLayout.NORTH);
		JTextArea areaTexto = new JTextArea();
		add(areaTexto,BorderLayout.CENTER);
		//CONSTRUCCIÓN BARRA SUPERIOR----------
		barra = new JMenuBar();
		laminaNorte.add(barra);
		
		configuraJMenu("Fuente",Color.DARK_GRAY,Color.LIGHT_GRAY);
		
	}
	
	public void configuraJMenu(String nombreJMenu,Color colorY, Color cborde) {	
		JMenu elemento = new JMenu(nombreJMenu);
		barra.add(elemento);
		elemento.setForeground(colorY);
		elemento.setBorder(BorderFactory.createLineBorder(cborde));
		
	}
	private JMenuBar barra;
}

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA DE CONEXIÓN CON BBDD::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

class MBBDD extends JFrame{
	public MBBDD() {
		setTitle("Conexion a Base de Datos");
		setBounds(770,110,500,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);	
	}
}
class LBBDD extends JPanel{
	public LBBDD() {
		//LÁMINA
		setLayout(new BorderLayout());
		setBackground(Color.GREEN);
		JPanel laminaNorte = new JPanel();
		add(laminaNorte,BorderLayout.NORTH);
		//AREA TEXTO
		areaInformacion = new JTextArea();
		areaInformacion.setBackground(Color.getHSBColor(500, 800, 20));
		add(areaInformacion,BorderLayout.CENTER);	
		//BARRA DESPLAZADORA
		JScrollPane desliza = new JScrollPane(areaInformacion);
		add(desliza);
		//COMBOBOX
		JComboBox comboBases = new JComboBox();
		laminaNorte.add(comboBases,BorderLayout.WEST);
		JComboBox comboTablas= new JComboBox();
		laminaNorte.add(comboTablas,BorderLayout.EAST);
		comboBases.addItem("BASES DE DATOS");
		comboBases.addItem("NO DISPONIBLE");
		comboTablas.addItem("TABLAS");
		comboTablas.addItem("clientes");
		comboTablas.addItem("pedidos");
		comboTablas.addItem("productos");
		comboTablas.addActionListener(new ActionListener() {
			ResultSet rs;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Connection miConexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
					Statement miStatement = miConexion.createStatement();
					if(comboTablas.getSelectedItem() == "clientes") 
						rs = miStatement.executeQuery("SELECT * FROM CLIENTES");
					else if(comboTablas.getSelectedItem() == "pedidos")
						rs = miStatement.executeQuery("SELECT * FROM PEDIDOS");
					else if(comboTablas.getSelectedItem() == "productos")
						rs = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
					areaInformacion.setText("");	
					areaInformacion.append("Conexión con base de datos OK!!!");
					areaInformacion.append("\n-------------------------------------------------------");
					areaInformacion.append("\n");	
					if(comboTablas.getSelectedItem() == "clientes") {
						while(rs.next()) {
							areaInformacion.append(rs.getString("CÓDIGOCLIENTE") + "--->" + rs.getString("EMPRESA") + "--->" + rs.getString("DIRECCIÓN") + "\n");
						}
					}else if(comboTablas.getSelectedItem() == "pedidos") {
						while(rs.next()) {
							areaInformacion.append(rs.getString("NÚMERODEPEDIDO") + "--->" + rs.getString("CÓDIGOCLIENTE") + "--->" + rs.getString("FECHADEPEDIDO") + "\n");
						}
					}else if(comboTablas.getSelectedItem() == "productos") {
						while(rs.next()) {
							areaInformacion.append(rs.getString("CÓDIGOARTÍCULO") + "--->" + rs.getString("SECCIÓN") + "--->" + rs.getString("PRECIO") + "\n");
						}
					}
					rs.close();	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					areaInformacion.append(" :( ... No conecta con la base de datos!!! ... :O");
					}
			}
		});
		areaInformacion.setText("");
	}
	private JTextArea areaInformacion;
}
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA DE CALCULADORA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MCalculadora extends JFrame{
	public MCalculadora() {
		setTitle("Calculadora");
		setBounds(740,140,500,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);	
	}
}
class LCalculadora extends JPanel{
	public LCalculadora() {
		this.setBackground(Color.YELLOW);
	}
}
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA DE NOTAS RÁPIDAS:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MNotas extends JFrame{
	public MNotas() {
		setTitle("Notas Rápidas");
		setBounds(710,170,500,600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
}

class LNotas extends JPanel{
	public LNotas() {
		
		//ESTRUCTURA VENTANA
		this.setBackground(Color.LIGHT_GRAY);
		areaTexto = new JTextArea(32,43);
		areaTexto.setLineWrap(true);
		areaTexto.setBackground(Color.WHITE);
		add(areaTexto,BorderLayout.CENTER);
		
		//CONFIGURACIÓN LÁMINA SUPERIOR, BARRA MENÚ Y MENÚ::::::::::::
		laminaSuperior = new JPanel();
		setLayout(new BorderLayout());
		
		laminaSuperior.setBackground(Color.lightGray);
		add(laminaSuperior,BorderLayout.NORTH);
		//BARRA DEL MENÚ
		barraMenu = new JMenuBar();
		barraMenu.setBackground(Color.LIGHT_GRAY);
		laminaSuperior.add(barraMenu);
		
		//MENU
		archivo = new JMenu("Archivo");
		tamano = new JMenu("Tamaño");
		colorLetras = new JMenu("Color de Letras");
		personalizacion = new JMenu("Personalización");
		
		//PEGAMOS MENÚ A LA BARRA
		barraMenu.add(archivo);
		barraMenu.add(tamano);
		barraMenu.add(colorLetras);
		barraMenu.add(personalizacion);
		
		//ARCHIVO
		//FUNCIÓN GUARDAR::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		JMenuItem guardar = new JMenuItem("Guardar");
		archivo.add(guardar);
		guardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String contenido = areaTexto.getText();
				System.out.println(contenido);
				//CREAR ARCHIVO TXT
				File ruta1 = new File("C:\\Users/Fantasma/Downloads/PILDORAS INFORMÁTICAS/notas.txt");
				try {
					ruta1.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("No fue posible crear el archivo para guardar");
				}
				//INDICAMOS DONDE VAMOS A ESCRIBIR
				String archivoDestino = ruta1.getAbsolutePath();
				FileWriter escritura;
				try {
					escritura = new FileWriter(archivoDestino);
				
					for(int i=0;i<contenido.length();i++) {
					escritura.write(contenido.charAt(i));
					}
					escritura.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 	
			}
		});
		
		//ARCHIVO
		//FUNCIÓN ABRIR::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		JMenuItem abrir = new JMenuItem("Abrir");
		archivo.add(abrir);
		abrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FileReader entrada = new FileReader("C:\\Users/Fantasma/Downloads/PILDORAS INFORMÁTICAS/notas.txt");
					BufferedReader miBuffer = new BufferedReader(entrada);
					String linea="";
					while (linea!=null) {
						linea = miBuffer.readLine();
						areaTexto.append(linea);
					}
					entrada.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("No se encontró archivo en la ruta especificada");	
				}
			}
		});
		//ARCHIVO
		//FUNCIÓN ABRIR OTRO:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		JMenuItem abrirOtro = new JMenuItem("Abrir Otro");
		archivo.add(abrirOtro);
		abrirOtro.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//VENTANA DE BÚSQUEDA EN EXPLORADOR
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo Texto", "txt");
				chooser.setFileFilter(filtro);
				int returnVal = chooser.showOpenDialog(abrirOtro);
				//SI APRUEBA EL VALOR, LEER ARCHIVO
				if(returnVal == chooser.APPROVE_OPTION) {
					try {
						entrada = new FileReader(chooser.getSelectedFile().getAbsolutePath());
						//FLUJO DE DATOS QUE ENTREGA LA INFORMACIÓN
						BufferedReader buffer = new BufferedReader(entrada);
						String texto = buffer.readLine();
						areaTexto.append(texto);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						areaTexto.append("No se pudo abrir el Archivo");
					}
				}
			}
			FileReader entrada;
		});
		//ARCHIVO
		//NUEVA NOTA DE TEXTO::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		JMenuItem nuevo = new JMenuItem("Nuevo");
		archivo.add(nuevo);
		nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MNotas nuevoMarco = new MNotas();
				LNotas nuevaLamina = new LNotas();
				nuevoMarco.add(nuevaLamina);
			}
		});
		//ESTILO DE LETRA::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		JMenuItem cazul = new JMenuItem("Azul");
		JMenuItem cnegra = new JMenuItem("Negra");
		JMenuItem croja = new JMenuItem("Roja");
		JMenuItem cverde = new JMenuItem("Verde");
		colorLetras.add(cazul);
		colorLetras.add(cnegra);
		colorLetras.add(croja);
		colorLetras.add(cverde);
		cazul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTexto.setForeground(Color.BLUE);
			}
		});
		cnegra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTexto.setForeground(Color.BLACK);
			}
		});
		croja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTexto.setForeground(Color.RED);
			}
		});
		cverde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaTexto.setForeground(Color.GREEN);
			}
		});
		//TAMAÑO LETRA:::::::::::::::::::::::::::::::::::::::::::
		ButtonGroup grupotamano = new ButtonGroup();
		JRadioButtonMenuItem catorce = new JRadioButtonMenuItem("14");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem dieciocho = new JRadioButtonMenuItem("18");		
		tamano.add(catorce);
		tamano.add(dieciseis);
		tamano.add(dieciocho);
		grupotamano.add(catorce);
		grupotamano.add(dieciseis);
		grupotamano.add(dieciocho);
		catorce.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			areaTexto.setFont(new Font("",Font.PLAIN,14));	
			}
		});
		dieciseis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			areaTexto.setFont(new Font("",Font.PLAIN,16));	
			}
		});
		dieciocho.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			areaTexto.setFont(new Font("",Font.PLAIN,18));	
			}
		});
		
		//PERSONALIZACIÓN::::::::::::::::::::::::::::::::::::::::
		JMenuItem perRojo = new JMenuItem(new ImageIcon("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/flag_red.gif"));
		personalizacion.add(perRojo);
		perRojo.addActionListener(new ColorNotas(Color.RED));
		JMenuItem perAzul = new JMenuItem(new ImageIcon("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/flag_blue.gif"));
		personalizacion.add(perAzul);
		perAzul.addActionListener(new ColorNotas(Color.CYAN));
		JMenuItem perVerde = new JMenuItem(new ImageIcon("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/flag_green.gif"));
		personalizacion.add(perVerde);
		perVerde.addActionListener(new ColorNotas(Color.GREEN));
		JMenuItem perNaranjo = new JMenuItem(new ImageIcon("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/flag_orange.gif"));
		personalizacion.add(perNaranjo);
		perNaranjo.addActionListener(new ColorNotas(Color.ORANGE));
		JMenuItem perBlanco = new JMenuItem(new ImageIcon("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/flag_white.gif"));
		personalizacion.add(perBlanco);
		perBlanco.addActionListener(new ColorNotas(Color.WHITE));
		
		add(laminaSuperior,BorderLayout.NORTH);
		laminaSuperior.add(barraMenu);
		
		add(areaTexto,BorderLayout.SOUTH);
		JScrollPane barraScroll = new JScrollPane(areaTexto);
		add(barraScroll);
	}
	
	 private class ColorNotas implements ActionListener{
			public ColorNotas(Color p) {
				ColorDeNotas= p;
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setBackground(ColorDeNotas);
				laminaSuperior.setBackground(ColorDeNotas);
				barraMenu.setBackground(ColorDeNotas);
			}
			private Color ColorDeNotas;
	}
	  
	//----------- 
	private JTextArea areaTexto;
	private JPanel laminaSuperior;
	private JMenuBar barraMenu;
	private JMenu archivo; 
	private JMenu colorLetras;
	private JMenu tamano; 
	private JMenu personalizacion; 
}
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

//VENTANA OPCIONES:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
class MVentanaOps extends JFrame{
	public MVentanaOps() {
		setTitle("Opciones");
		setBounds(600,100,300,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit objToolkit = Toolkit.getDefaultToolkit();
		Image icono = objToolkit.getImage("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/chmod.gif");
		this.setIconImage(icono);
		setVisible(true);
	}
}
class LVentanaOps extends JPanel{
	public LVentanaOps() {
		setLayout(new BorderLayout());
	}
}
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


