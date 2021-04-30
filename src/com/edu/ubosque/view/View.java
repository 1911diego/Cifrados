package com.edu.ubosque.view;

import javax.swing.JFrame;

public class View extends JFrame{
	
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	
	private PanelPrincipal panelPrincipal;
	private PanelImagen panelImagen;
	private PanelOpcion panelOpcion;
	private PanelAutomata panelAutomata;
	private PanelAritmetico panelAritmetico;
	
	
	
	public View() {
		setSize(800,600);
		setTitle("Cifrados");
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		init();
		
		setVisible(true);
	}
	
	public void init() {
		panelPrincipal = new PanelPrincipal();
		panelPrincipal.setVisible(true);
		
		panelOpcion = new PanelOpcion();
		panelOpcion.setVisible(false);
		
		panelImagen = new PanelImagen();
		panelImagen.setVisible(false);
		
		panelAutomata = new PanelAutomata();
		panelAutomata.setVisible(false);
		
		panelAritmetico = new PanelAritmetico();
		panelAritmetico.setVisible(false);
		
		getContentPane().add(panelPrincipal);
		getContentPane().add(panelOpcion);
		getContentPane().add(panelImagen);
		getContentPane().add(panelAutomata);
		getContentPane().add(panelAritmetico);
		
		
	}
	

	
	public PanelPrincipal getPanelPrincipal() {
		return panelPrincipal;
	}

	public PanelImagen getPanelImagen() {
		return panelImagen;
	}

	public PanelOpcion getPanelOpcion() {
		return panelOpcion;
	}


	public PanelAutomata getPanelAutomata() {
		return panelAutomata;
	}

	public PanelAritmetico getPanelAritmetico() {
		return panelAritmetico;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

}
