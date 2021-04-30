package com.edu.ubosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelImagen extends JPanel{
	
	private JLabel fondo;
	private JLabel titulo;
	private JTextField textFileChooser;
	private JButton btnChooser;
	private JButton btnAction;
	private JButton btnDescargar;
	private JLabel imagenCifrada;
	private JLabel lambda1;
	private JLabel lambda2;
	private JLabel lambda3;
	private JLabel iteraciones;
	private JTextField l1;
	private JTextField l2;
	private JTextField l3;
	private JTextField textIteracion;
	
	private BufferedImage imagenSalida;
	
	private String tipo;
	
	private JButton volver;
	
	
	
	public PanelImagen() {
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
		
		titulo = new JLabel("Seleccione la Imagen");
		titulo.setBounds(40,40,300,50);
		titulo.setFont(new Font("helvetica",Font.BOLD,25));
		titulo.setForeground(new Color(65,0,111));
		
		volver = new JButton("Volver");
		volver.setFont(new Font("helvetica",Font.BOLD,13));
		volver.setBackground(Color.WHITE);
		volver.setBounds(650,500,80,30);
		
		btnChooser = new JButton("Cargar");
		btnChooser.setBounds(120,100,100,30);
		btnChooser.setBackground(new Color(65,0,111));
		btnChooser.setForeground(Color.white);
		
		textFileChooser = new JTextField();
		textFileChooser.setBounds(30,140,300,20);
		textFileChooser.setEnabled(false);
		
		lambda1 = new JLabel("λ1");
		lambda1.setBounds(100,160,300,50);
		lambda1.setFont(new Font("helvetica",Font.BOLD,20));
		lambda1.setForeground(new Color(65,0,111));
		
		l1 = new JTextField();
		l1.setBounds(100,200,20,20);
		
		lambda2 = new JLabel("λ2");
		lambda2.setBounds(160,160,300,50);
		lambda2.setFont(new Font("helvetica",Font.BOLD,20));
		lambda2.setForeground(new Color(65,0,111));
		
		l2 = new JTextField();
		l2.setBounds(160,200,20,20);
		
		lambda3 = new JLabel("λ3");
		lambda3.setBounds(220,160,300,50);
		lambda3.setFont(new Font("helvetica",Font.BOLD,20));
		lambda3.setForeground(new Color(65,0,111));
		
		l3 = new JTextField();
		l3.setBounds(220,200,20,20);
		
		iteraciones = new JLabel("Iteraciones");
		iteraciones.setBounds(120,220,300,50);
		iteraciones.setFont(new Font("helvetica",Font.BOLD,20));
		iteraciones.setForeground(new Color(65,0,111));
		
		textIteracion = new JTextField();
		textIteracion.setBounds(160,270,30,30);
		
		btnAction = new JButton("CIFRAR");
		btnAction.setBounds(70,350,200,40);
		btnAction.setBackground(new Color(203,0,0));
		btnAction.setForeground(Color.white);
		
		imagenCifrada = new JLabel();
		imagenCifrada.setSize(250,250);
		imagenCifrada.setBounds(420,130,250,250);
		imagenCifrada.setOpaque(true);
		imagenCifrada.setBackground(Color.WHITE);
		imagenCifrada.setBorder(BorderFactory.createBevelBorder(0));
		
		btnDescargar = new JButton("DESCARGAR");
		btnDescargar.setBounds(440,400,200,40);
		btnDescargar.setBackground(new Color(0,179,54));
		btnDescargar.setForeground(Color.white);
		
		add(fondo);
		fondo.add(titulo);
		fondo.add(btnAction);
		fondo.add(textFileChooser);
		fondo.add(lambda1);
		fondo.add(l1);
		fondo.add(lambda2);
		fondo.add(l2);
		fondo.add(lambda3);
		fondo.add(l3);
		fondo.add(iteraciones);
		fondo.add(textIteracion);
		fondo.add(btnChooser);
		fondo.add(imagenCifrada);
		fondo.add(btnDescargar);
		fondo.add(volver);
		
		
	}
	
	public void limpiar() {
		textFileChooser.setText("");
		l1.setText("");
		l2.setText("");
		l3.setText("");
		textIteracion.setText("");
		imagenCifrada.setIcon(null);
	}

	public String fileChooser(int opcion) {
		
		JFileChooser jc = new JFileChooser();
		File file = null;
		if(opcion ==1) {
			FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("PNG Images", "png"); 
			jc.setFileFilter(imgFilter);
			int result = jc.showOpenDialog(this);
			if(result != JFileChooser.CANCEL_OPTION) {
			file = jc.getSelectedFile();
			}
		}
		else {
			jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = jc.showOpenDialog(this);
			if(result != JFileChooser.CANCEL_OPTION) {
				file = jc.getSelectedFile();
			}
		}
		return file!=null?file.getAbsolutePath():"";
	}
	
	public JTextField getTextFileChooser() {
		return textFileChooser;
	}

	public JButton getBtnChooser() {
		return btnChooser;
	}

	public JButton getBtnAction() {
		return btnAction;
	}

	public JButton getBtnDescargar() {
		return btnDescargar;
	}

	public JLabel getImagenCifrada() {
		return imagenCifrada;
	}

	public JLabel getLambda1() {
		return lambda1;
	}

	public JLabel getLambda2() {
		return lambda2;
	}

	public JLabel getLambda3() {
		return lambda3;
	}

	public JLabel getIteraciones() {
		return iteraciones;
	}

	public JTextField getL1() {
		return l1;
	}

	public JTextField getL2() {
		return l2;
	}

	public JTextField getL3() {
		return l3;
	}

	public JTextField getTextIteracion() {
		return textIteracion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BufferedImage getImagenSalida() {
		return imagenSalida;
	}

	public void setImagenSalida(BufferedImage imagenSalida) {
		this.imagenSalida = imagenSalida;
	}

	public JButton getVolver() {
		return volver;
	}
	
	
	

}
