package Aplicacion;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class A0_MarcoJframe extends JFrame{
	public A0_MarcoJframe() {
		this.getContentPane().setBackground(Color.DARK_GRAY);
		setTitle("Inicio");
		setBounds(200,100,395,500);
		A1_LaminaJPanel milamina = new A1_LaminaJPanel();
		add(milamina);
		Toolkit objToolkit = Toolkit.getDefaultToolkit();
		Image imagenMarco = objToolkit.getImage("C:\\Users/Fantasma/OneDrive/1.-DOCUMENTOS/eclipse-workspace/X_AppV1/src/Aplicacion/logoapp.jpg");
		setIconImage(imagenMarco);
	}	
}


