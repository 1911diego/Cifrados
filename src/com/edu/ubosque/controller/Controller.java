package com.edu.ubosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.edu.ubosque.model.AutomataCelular;
import com.edu.ubosque.model.CifradoAritmetico;
import com.edu.ubosque.model.CifradoImagen;
import com.edu.ubosque.model.DescifradoImagen;
import com.edu.ubosque.view.View;

public class Controller implements ActionListener{

	private View v ;
	
	
	public Controller() {
		v = new View();
		setListeners();
	}
	
	public void setListeners() {
		v.getPanelPrincipal().getBtnAutomata().addActionListener(this);
		v.getPanelPrincipal().getBtnImagen().addActionListener(this);
		v.getPanelPrincipal().getBtnModular().addActionListener(this);
		
		v.getPanelOpcion().getCifrar().addActionListener(this);
		v.getPanelOpcion().getDescifrar().addActionListener(this);
		v.getPanelOpcion().getVolver().addActionListener(this);
		
		v.getPanelImagen().getBtnChooser().addActionListener(this);
		v.getPanelImagen().getBtnAction().addActionListener(this);
		v.getPanelImagen().getBtnDescargar().addActionListener(this);
		v.getPanelImagen().getVolver().addActionListener(this);
		
		v.getPanelAutomata().getBtnCifrar().addActionListener(this);
		v.getPanelAutomata().getVolver().addActionListener(this);
		
		v.getPanelAritmetico().getBtnCifrar().addActionListener(this);
		v.getPanelAritmetico().getVolver().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == v.getPanelPrincipal().getBtnImagen()) {
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(true);
			v.getPanelOpcion().getTitulo().setText("Cifrado de Imágen");
			v.getPanelImagen().setVisible(false);
			v.getPanelAritmetico().setVisible(false);
		}
		
		if(e.getSource() == v.getPanelPrincipal().getBtnAutomata()) {
		
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelAutomata().setVisible(true);
			v.getPanelImagen().setVisible(false);
			v.getPanelAritmetico().setVisible(false);
		}
		
		if(e.getSource() == v.getPanelPrincipal().getBtnModular()) {
			v.getPanelAritmetico().setVisible(false);
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(true);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelOpcion().getTitulo().setText("Cifrado Modular");
		}
		
		if(e.getSource() == v.getPanelOpcion().getCifrar() && v.getPanelOpcion().getTitulo().getText().equals("Cifrado Modular")) {
			v.getPanelAritmetico().setVisible(true);
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelAritmetico().getBtnCifrar().setText("cifrar");
		}
		
		if(e.getSource() == v.getPanelOpcion().getDescifrar() && v.getPanelOpcion().getTitulo().getText().equals("Cifrado Modular")) {
			v.getPanelAritmetico().setVisible(true);
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelAritmetico().getBtnCifrar().setText("descifrar");
		}
		
		
		if(e.getSource() == v.getPanelOpcion().getCifrar() && v.getPanelOpcion().getTitulo().getText().equals("Cifrado de Imágen")) {
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelImagen().setVisible(true);
			v.getPanelImagen().setTipo("cifrar");
			v.getPanelImagen().getBtnAction().setText("cifrar");
		}
		
		if(e.getSource() == v.getPanelOpcion().getDescifrar() && v.getPanelOpcion().getTitulo().getText().equals("Cifrado de Imágen")) {
			v.getPanelPrincipal().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelImagen().setVisible(true);
			v.getPanelImagen().setTipo("Descifrar");
			v.getPanelImagen().getBtnAction().setText("Descifrar");
		}
		
		if(e.getSource() == v.getPanelImagen().getBtnChooser()) {
			String file = v.getPanelImagen().fileChooser(1);
			v.getPanelImagen().getTextFileChooser().setText(file);
		}
		
		if(e.getSource() == v.getPanelImagen().getBtnAction()) {
			try {
			int l1 = Integer.parseInt(v.getPanelImagen().getL1().getText());
			int l2 = Integer.parseInt(v.getPanelImagen().getL2().getText());
			int l3 = Integer.parseInt(v.getPanelImagen().getL3().getText());
			int iteracion = Integer.parseInt(v.getPanelImagen().getTextIteracion().getText());
			String file = v.getPanelImagen().getTextFileChooser().getText();
			
			if(v.getPanelImagen().getTipo().equals("cifrar")) {
				CifradoImagen cifrado = new CifradoImagen(file,l1,l2,l3,iteracion);
				BufferedImage bi = cifrado.cifrarImagen();
				v.getPanelImagen().setImagenSalida(bi);
				v.getPanelImagen().getImagenCifrada().setIcon(new ImageIcon(bi));
			}else {
				DescifradoImagen descifrado = new DescifradoImagen(file,l1,l2,l3,iteracion);
				BufferedImage bi = descifrado.descifrarImagen();
				v.getPanelImagen().setImagenSalida(bi);
				v.getPanelImagen().getImagenCifrada().setIcon(new ImageIcon(bi));
			}
			}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null,"Los datos ingresados están Erroneos");
			}
			
		}
		
		if(e.getSource() == v.getPanelImagen().getBtnDescargar()) {
			String file = v.getPanelImagen().fileChooser(2);
			
			file = file+"\\"+UUID.randomUUID()+".png";
			
			try {
				ImageIO.write(v.getPanelImagen().getImagenSalida(),"png",new File(file));
				JOptionPane.showMessageDialog(null,"Se ha exportado la imagen exitosamente!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null,"No hay ninguna imagen para exportar");
			}
		}
		
		
		if(e.getSource() == v.getPanelAutomata().getBtnCifrar()) {
			if(v.getPanelAutomata().getTxtPalabra().getText().matches("[0-9]*") || v.getPanelAutomata().getTxtSecreta().getText().matches("[0-9]*")){
				JOptionPane.showMessageDialog(null,"Los datos ingresados son Erroneos, por favor intente de nuevo");
			}
			else {
				
			try {
			String palabra = v.getPanelAutomata().getTxtPalabra().getText().toLowerCase();
			String secreta = v.getPanelAutomata().getTxtSecreta().getText().toLowerCase();
			int celula = Integer.parseInt(v.getPanelAutomata().getTxtCelula().getText());
			int tiempo = Integer.parseInt(v.getPanelAutomata().getTxtTiempo().getText());
			
			AutomataCelular automata = new AutomataCelular();
			String cifrado = automata.cifrado(palabra, secreta, celula, tiempo);
			v.getPanelAutomata().getLblCifrado().setText(cifrado);
			}
			catch(Exception e4) {
				JOptionPane.showMessageDialog(null,"Los datos ingresados son Erroneos, por favor intente de nuevo");
			}
			}
		}
		
		if(e.getSource() == v.getPanelAritmetico().getBtnCifrar()) {
			try {
			String palabra = v.getPanelAritmetico().getTxtPalabra().getText();
			int corrimiento = Integer.parseInt(v.getPanelAritmetico().getTxtSecreta().getText());
			
			CifradoAritmetico cifrado = new CifradoAritmetico();
			if(v.getPanelAritmetico().getBtnCifrar().getText().equals("cifrar")) {
					String cif = cifrado.cifrar(corrimiento, palabra, true);
					v.getPanelAritmetico().getLblCifrado().setText(cif);
				
			}else {
					String cif = cifrado.cifrar(corrimiento, palabra, false);
					v.getPanelAritmetico().getLblCifrado().setText(cif);
			}
			}
			catch(Exception e5) {
				JOptionPane.showMessageDialog(null,"Los datos ingresados son erroneos");
			}
			
		}
		
		if(e.getSource() == v.getPanelOpcion().getVolver()) {
			v.getPanelAritmetico().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelPrincipal().setVisible(true);
		}
		
		if(e.getSource() == v.getPanelAritmetico().getVolver()) {
			v.getPanelAritmetico().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelOpcion().setVisible(true);
			v.getPanelPrincipal().setVisible(false);
			v.getPanelAritmetico().limpiar();
		}
		
		if(e.getSource() == v.getPanelImagen().getVolver()) {
			v.getPanelAritmetico().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelOpcion().setVisible(true);
			v.getPanelPrincipal().setVisible(false);
			v.getPanelImagen().limpiar();
		}
		
		if(e.getSource() == v.getPanelAutomata().getVolver()) {
			v.getPanelAritmetico().setVisible(false);
			v.getPanelAutomata().setVisible(false);
			v.getPanelImagen().setVisible(false);
			v.getPanelOpcion().setVisible(false);
			v.getPanelPrincipal().setVisible(true);
			v.getPanelAutomata().getVolver();
			v.getPanelAutomata().limpiar();
		}
		
		
	}
}
