package com.edu.ubosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelOpcion extends JPanel {
	
	private JLabel fondo;
	private JLabel titulo;
	private JButton cifrar;
	private JButton descifrar;
	private JButton volver;
	
	
	public PanelOpcion() {
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
		
		volver = new JButton("Volver");
		volver.setFont(new Font("helvetica",Font.BOLD,13));
		volver.setBackground(Color.WHITE);
		volver.setBounds(650,500,80,30);
		
		titulo = new JLabel();
		titulo.setBounds((View.ANCHO/2)-180,50,350,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,40));
		titulo.setForeground(new Color(65,0,111));
		
		cifrar = new JButton("Cifrar");
		cifrar.setBounds((View.ANCHO/2)-140,250,250,50);
		cifrar.setBackground(new Color(65,0,111));
		cifrar.setForeground(Color.white);
		
		descifrar = new JButton("Descifrar");
		descifrar.setBounds((View.ANCHO/2)-140,350,250,50);
		descifrar.setBackground(new Color(65,0,111));
		descifrar.setForeground(Color.white);
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(cifrar);
		fondo.add(descifrar);
		fondo.add(volver);
	}

	public JButton getCifrar() {
		return cifrar;
	}

	public JButton getDescifrar() {
		return descifrar;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getVolver() {
		return volver;
	}

	
	
	

	
}
