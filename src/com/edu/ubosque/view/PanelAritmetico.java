package com.edu.ubosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class PanelAritmetico extends JPanel {

	private JLabel fondo;
	private JLabel titulo;
	private JLabel lblPalabra;
	private JLabel lblCorrimiento;
	
	private JTextField txtPalabra;
	private JTextField txtCorrimiento;

	private JButton btnCifrar;
	
	private JTextField lblCifrado;
	
	private JButton volver;
	
	public PanelAritmetico() {
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
		
		titulo = new JLabel("Aritmética Modular");
		titulo.setBounds((View.ANCHO/2)-180,40,400,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,30));
		titulo.setForeground(new Color(65,0,111));
		
		volver = new JButton("Volver");
		volver.setFont(new Font("helvetica",Font.BOLD,13));
		volver.setBackground(Color.WHITE);
		volver.setBounds(650,500,80,30);
		
		lblPalabra = new JLabel("Palabra a Cifrar");
		lblPalabra.setBounds(160,100,200,50);
		lblPalabra.setFont(new Font("helvetica",Font.BOLD,20));
		lblPalabra.setForeground(new Color(65,0,111));
		
		txtPalabra = new JTextField();
		txtPalabra.setBounds(160,150,150,20);
		
		lblCorrimiento = new JLabel("N de Corrimientos");
		lblCorrimiento.setBounds(400,100,200,50);
		lblCorrimiento.setFont(new Font("helvetica",Font.BOLD,20));
		lblCorrimiento.setForeground(new Color(65,0,111));
		
		txtCorrimiento = new JTextField();
		txtCorrimiento.setBounds(450,150,50,20);
		
		
		btnCifrar = new JButton("CIFRAR");
		btnCifrar.setBounds((View.ANCHO/2)-130,200,200,40);
		btnCifrar.setBackground(new Color(203,0,0));
		btnCifrar.setForeground(Color.white);
		
		JLabel resultado = new JLabel("Resultado:");
		resultado.setBounds((View.ANCHO/2)-100,280,400,50);
		resultado.setFont(new Font("helvetica",Font.BOLD,30));
		resultado.setForeground(new Color(65,0,111));
		
		lblCifrado = new JTextField();
		lblCifrado.setBounds((View.ANCHO/2)-170,350,300,60);
		lblCifrado.setFont(new Font("helvetica",Font.BOLD,30));
		lblCifrado.setForeground(new Color(0,203,0));
		lblCifrado.setBorder(null);
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(lblPalabra);
		fondo.add(lblCorrimiento);
		fondo.add(txtPalabra);
		fondo.add(txtCorrimiento);
		fondo.add(btnCifrar);
		fondo.add(resultado);
		fondo.add(lblCifrado);
		fondo.add(volver);
	}
	
	
	public void limpiar() {
		txtPalabra.setText("");
		txtCorrimiento.setText("");
		lblCifrado.setText("");
	}

	public JTextField getTxtPalabra() {
		return txtPalabra;
	}

	public JTextField getTxtSecreta() {
		return txtCorrimiento;
	}

	public JButton getBtnCifrar() {
		return btnCifrar;
	}

	public JTextField getLblCifrado() {
		return lblCifrado;
	}

	public JButton getVolver() {
		return volver;
	}

	
	
}
