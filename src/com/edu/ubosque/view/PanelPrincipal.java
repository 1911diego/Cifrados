package com.edu.ubosque.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel {

	
	private JLabel fondo;
	private JLabel titulo;
	private JButton btnModular;
	private JButton btnAutomata;
	private JButton btnImagen;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public PanelPrincipal() {
		setSize(View.ANCHO,View.ALTO);
		setLayout(null);
		init();
	}
	
	public void init() {
		
		fondo = new JLabel();
		fondo.setSize(View.ANCHO,View.ALTO);
		fondo.setOpaque(true);
		ImageIcon image = new ImageIcon(getClass().getResource("/img/fondo.png"));
		fondo.setIcon(image);
		
		titulo = new JLabel("CIFRADOS");
		titulo.setBounds((View.ANCHO/2)-150,50,300,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,50));
		titulo.setForeground(new Color(65,0,111));
		
		btnModular = new JButton("Cifrado con Aritmética Modular");
		btnModular.setBounds((View.ANCHO/2)-140,200,250,50);
		btnModular.setBackground(new Color(65,0,111));
		btnModular.setForeground(Color.white);
		
		btnAutomata = new JButton("Cifrado con Autómatas Celulares");
		btnAutomata.setBounds((View.ANCHO/2)-140,300,250,50);
		btnAutomata.setBackground(new Color(65,0,111));
		btnAutomata.setForeground(Color.white);
		
		
		btnImagen = new JButton("Cifrado de Imágenes");
		btnImagen.setBounds((View.ANCHO/2)-140,400,250,50);
		btnImagen.setBackground(new Color(65,0,111));
		btnImagen.setForeground(Color.white);
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(btnModular);
		fondo.add(btnAutomata);
		fondo.add(btnImagen);
		
	}

	public JButton getBtnModular() {
		return btnModular;
	}

	public JButton getBtnAutomata() {
		return btnAutomata;
	}

	public JButton getBtnImagen() {
		return btnImagen;
	}
	
	
}
