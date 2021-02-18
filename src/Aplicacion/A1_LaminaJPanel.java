package Aplicacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class A1_LaminaJPanel extends JPanel {
	public A1_LaminaJPanel() {
		setLayout(new BorderLayout());
		//LÁMINA BOTONES
		laminaBotones = new JPanel();
		add(laminaBotones,BorderLayout.CENTER);
		laminaBotones.setBackground(Color.LIGHT_GRAY);
		//JLABEL 1:::::::::::::::::::::::::::::::::::::::::::::
		String saludo = "Hola!";
		label = new JLabel(saludo,JLabel.CENTER);
		label.setPreferredSize(new Dimension(113,40));
		Font fuente = new Font("Arial", Font.BOLD,26);
		label.setFont(fuente);
		laminaBotones.add(label);
		//JLABEL 2:::::::::::::::::::::::::::::::::::::::::::::
		String fecha = "Fecha";
		label2 = new JLabel(fecha,JLabel.CENTER);
		label2.setPreferredSize(new Dimension(112,40));
		label2.setFont(fuente);
		laminaBotones.add(label2);
		//JLABEL 3:::::::::::::::::::RELOJ:::::::::::::::::::::
		String hora = "Hora";
		label3 = new JLabel(hora,JLabel.CENTER);
		label3.setPreferredSize(new Dimension(112,40));
		label3.setFont(fuente);
		
		Calendar reloj = new GregorianCalendar();
		int horas,minutos,segundos;
		horas= reloj.get(Calendar.HOUR_OF_DAY);
		minutos=reloj.get(Calendar.MINUTE);
		segundos=reloj.get(Calendar.SECOND);

		laminaBotones.add(label3);
		
		//BOTONES LÁMINA PRINCIPAL:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		//BOTÓN PANILLA
		construyeBoton("Planilla","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/icon_user.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN DE IMÁGENES
		construyeBoton("Imágenes","C:\\Users/Fantasma/Pictures/IMAGENES/goku.jpg",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN DE EDITOR DE TEXTO
		construyeBoton("Editor de texto","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/edit.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN BBDD CONEXION SIMPLE
		construyeBoton("Base de Datos","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/sql.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN BBDD/txt
		construyeBoton("BBDD/txt","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/icon_link.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN Notas txt
		construyeBoton("Notas txt","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/page_text.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN DE CALCULADORA
		construyeBoton("Calculadora","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/date_new.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN JSP
		construyeBoton("JSP","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/icon_world.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		//BOTÓN SERVLETS
		construyeBoton("Serlets","C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/icon_world_dynamic.gif",Color.DARK_GRAY,Color.LIGHT_GRAY,Color.CYAN);
		
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		
		//CONFIGURACIÓN DE BOTONES "COLOR" :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		lamina2 = new JPanel();
		lamina2.setBackground(Color.DARK_GRAY);
		add(lamina2,BorderLayout.SOUTH);
		//public void botonPersonaliza(String nombre, String icono, int largo, int ancho, Color colorBoton,Color colorLetras, Color colorBorde)
		botonPersonaliza("Opciones", "C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/chmod.gif", 88, 25, Color.darkGray, Color.LIGHT_GRAY, Color.GRAY);
	}
		
	//MÉTODO CONSTRUCCION BOTÓN:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public void construyeBoton(String nombre, String icono, Color colorboton, Color colorletras, Color colorborde) {
		boton = new JButton(nombre, new ImageIcon(icono));
		boton.setBackground(colorboton);
		boton.setPreferredSize(new Dimension(120,120));
		boton.setForeground(colorletras);
		boton.setBorder(BorderFactory.createLineBorder(colorborde));
		laminaBotones.add(boton);
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nombre == "BBDD/txt") {
					A4_BaseDatosTxt marcoBaseDatosTxt = new A4_BaseDatosTxt();
					LaminaBaseDatosTxt laminaBaseDatosTxt = new LaminaBaseDatosTxt();
					marcoBaseDatosTxt.add(laminaBaseDatosTxt);
				}else if(nombre == "Notas txt") {
					MNotas marcoNotas = new MNotas();
					LNotas laminaNotas = new LNotas();
					marcoNotas.add(laminaNotas);
				}else if(nombre=="Calculadora") {
					MCalculadora marcoCalculadora = new MCalculadora();
					LCalculadora laminaCalculadora = new LCalculadora();
					marcoCalculadora.add(laminaCalculadora);
				}else if(nombre =="Base de Datos") {
					MBBDD marcoBBDD = new MBBDD();
					LBBDD laminaBBDD = new LBBDD();
					marcoBBDD.add(laminaBBDD);
				}else if(nombre=="Editor de texto") {
					MEditor MarcoEditor = new MEditor();
					LEditor LaminaEditor = new LEditor();
					MarcoEditor.add(LaminaEditor);
				}else if(nombre == "Imágenes") {
					MImagenes marcoImagenes = new MImagenes();
					LImagenes laminaImagenes = new LImagenes();
					marcoImagenes.add(laminaImagenes);
				}else if(nombre == "Planilla") {
					MConfiguraciones marcoConfig = new MConfiguraciones();
					LConfiguraciones laminaConfig = new LConfiguraciones();
					marcoConfig.add(laminaConfig);	
				}
			}
		});
	}
	private JButton boton;
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	
	//MÉTODO QUE CONSTRUYE BOTÓN DE PERSONALIZACIÓN OPCIONES::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	public void botonPersonaliza(String nombre, String icono, int largo, int ancho, Color colorBoton,Color colorLetras, Color colorBorde) {
		botonOpciones = new JButton(nombre,new ImageIcon(icono));
		botonOpciones.setPreferredSize(new Dimension(largo,ancho));
		botonOpciones.setBackground(colorBoton);
		botonOpciones.setForeground(colorLetras);
		botonOpciones.setBorder(BorderFactory.createLineBorder(colorBorde));
		lamina2.add(botonOpciones);	
		botonOpciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mVentanaOp = new MVentanaOps();
				lVentanaOp = new LVentanaOps();
				mVentanaOp.add(lVentanaOp);
				lVentanaOp.setBackground(Color.GRAY);
				lVentanaOp.setLayout(null);
				temas = new JLabel("Temas");
				temas.setBounds(30, 10, 60, 15);
				lVentanaOp.add(temas);
				claro = new JRadioButton("Claro");
				normal = new JRadioButton("Normal");
				oscuro = new JRadioButton("Oscuro");
				claro.setBounds(10, 30, 80, 15);
				normal.setBounds(10, 50, 80, 15);
				oscuro.setBounds(10, 70, 80, 15);
				lVentanaOp.add(claro);
				lVentanaOp.add(normal);
				lVentanaOp.add(oscuro);
				ButtonGroup grupoTemas = new ButtonGroup();
				grupoTemas.add(claro);
				grupoTemas.add(normal);
				grupoTemas.add(oscuro);
				EventoRadioButton eventoRadio = new EventoRadioButton();
				claro.addActionListener(eventoRadio);
				normal.addActionListener(eventoRadio);
				oscuro.addActionListener(eventoRadio);
			}
		});
	botonOpciones.addMouseListener(new MouseListener() {
		public void mouseClicked(MouseEvent e) {botonOpciones.setBackground(Color.BLUE);}
		public void mouseEntered(MouseEvent e) {botonOpciones.setBackground(Color.ORANGE);}
		public void mouseExited(MouseEvent e) {botonOpciones.setBackground(Color.DARK_GRAY);}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
	});
	}
	private class EventoRadioButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==claro) {
				laminaBotones.setBackground(Color.WHITE);
				lamina2.setBackground(Color.WHITE);
				lVentanaOp.setBackground(Color.WHITE);
				temas.setForeground(Color.GRAY);
				label.setForeground(Color.GRAY);
				label2.setForeground(Color.GRAY);
				label3.setForeground(Color.GRAY);
			}else if(e.getSource()==normal){
				laminaBotones.setBackground(Color.LIGHT_GRAY);
				lamina2.setBackground(Color.LIGHT_GRAY);
				lVentanaOp.setBackground(Color.LIGHT_GRAY);
				temas.setForeground(Color.DARK_GRAY);
				label.setForeground(Color.DARK_GRAY);
				label2.setForeground(Color.DARK_GRAY);
				label3.setForeground(Color.DARK_GRAY);
			}else if(e.getSource()==oscuro){
				laminaBotones.setBackground(Color.getHSBColor(0, 0, 0.1f));
				lamina2.setBackground(Color.getHSBColor(0, 0, 0.1f));
				lVentanaOp.setBackground(Color.getHSBColor(0, 0, 0.1f));
				temas.setForeground(Color.LIGHT_GRAY);
				label.setForeground(Color.CYAN);
				label2.setForeground(Color.GRAY);
				label3.setForeground(Color.GRAY);
			}
		}	
	}
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JButton botonOpciones;
	private MVentanaOps mVentanaOp;
	private LVentanaOps lVentanaOp;
	private JLabel temas;
	private JRadioButton claro;
	private JRadioButton normal;
	private JRadioButton oscuro;
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JPanel laminaBotones;
	private JPanel lamina2;
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JButton bConfig;
	private String rutaGif;
	private JButton bImagen;
	private JButton bEditortxt;
	private JButton bBBDD;
	private JButton bBBBDDTxt;
	private JButton calculadora;
	private JButton notas;
	
}
