package com.edu.ubosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAutomata extends JPanel{
	
	private JLabel fondo;
	private JLabel titulo;
	private JLabel lblPalabra;
	private JLabel lblSecreta;
	private JLabel lblCelula;
	private JLabel lblTiempo;
	
	private JTextField txtPalabra;
	private JTextField txtSecreta;
	private JTextField txtCelula;
	private JTextField txtTiempo;
	
	private JButton btnCifrar;
	
	private JTextField lblCifrado;
	
	private JButton volver;
	
	public PanelAutomata() {
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
		
		volver.setForeground(new Color(65,0,111));
		
		titulo = new JLabel("Cifrado Autómata Celular");
		titulo.setBounds((View.ANCHO/2)-200,40,400,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,30));
		titulo.setForeground(new Color(65,0,111));
		
		lblPalabra = new JLabel("Palabra a Cifrar");
		lblPalabra.setBounds(30,100,200,50);
		lblPalabra.setFont(new Font("helvetica",Font.BOLD,20));
		lblPalabra.setForeground(new Color(65,0,111));
		
		txtPalabra = new JTextField();
		txtPalabra.setBounds(30,150,150,20);
		
		lblSecreta = new JLabel("Palabra Secreta");
		lblSecreta.setBounds(230,100,200,50);
		lblSecreta.setFont(new Font("helvetica",Font.BOLD,20));
		lblSecreta.setForeground(new Color(65,0,111));
		
		txtSecreta = new JTextField();
		txtSecreta.setBounds(230,150,150,20);
		
		lblCelula = new JLabel("Célula");
		lblCelula.setBounds(470,100,100,50);
		lblCelula.setFont(new Font("helvetica",Font.BOLD,20));
		lblCelula.setForeground(new Color(65,0,111));
		
		txtCelula = new JTextField();
		txtCelula.setBounds(480,150,40,20);
		
		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setBounds(600,100,100,50);
		lblTiempo.setFont(new Font("helvetica",Font.BOLD,20));
		lblTiempo.setForeground(new Color(65,0,111));
		
		txtTiempo = new JTextField();
		txtTiempo.setBounds(610,150,40,20);
		
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
		fondo.add(lblSecreta);
		fondo.add(lblCelula);
		fondo.add(lblTiempo);
		fondo.add(txtPalabra);
		fondo.add(txtSecreta);
		fondo.add(txtCelula);
		fondo.add(txtTiempo);
		fondo.add(btnCifrar);
		fondo.add(resultado);
		fondo.add(lblCifrado);
		fondo.add(volver);
	}

	public void limpiar() {
		txtPalabra.setText("");
		txtSecreta.setText("");
		txtCelula.setText("");
		txtTiempo.setText("");
		lblCifrado.setText("");
	}

	
	public JTextField getTxtPalabra() {
		return txtPalabra;
	}

	public JTextField getTxtSecreta() {
		return txtSecreta;
	}

	public JTextField getTxtCelula() {
		return txtCelula;
	}

	public JTextField getTxtTiempo() {
		return txtTiempo;
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
