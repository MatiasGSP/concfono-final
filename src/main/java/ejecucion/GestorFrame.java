/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejecucion;

import datosUsuario.Usuario;
import escrituraArchivos.GestorDeCarpeta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import vista.VentanaActividad;
import vista.VentanaInicial;
import vista.VentanaProfesor;

/**
 *
 * @author Matias
 */
public class GestorFrame implements ActionListener {
    
    private String usuario;
    private VentanaInicial v1;
    private GestorDeCarpeta gdc;
    
    public GestorFrame() throws IOException{
        
        
        inicializarComponentes();
        
    }
    
    public void inicializarComponentes() throws IOException{
        
        gdc = new GestorDeCarpeta();
        v1 = new VentanaInicial();
        v1.panelIni.btnEntrar.addActionListener(this);
        v1.panelIni.btnSalir.addActionListener(this);
        v1.panelIni.btnJugar.addActionListener(this);
            
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario, clave;
        Usuario userAux;
        VentanaProfesor vp;
        if(v1.panelIni.btnEntrar == ae.getSource()){
            usuario = v1.panelIni.tfUsuario.getText();
            clave=String.valueOf(v1.panelIni.pfClave.getPassword());
            userAux= new Usuario(usuario,clave);
            try {
                gdc = new GestorDeCarpeta();
            } catch (IOException ex) {
                Logger.getLogger(GestorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(gdc.comprobarUsuario(userAux)){
                    vp = new VentanaProfesor(userAux);
                    v1.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta.");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }else if(v1.panelIni.btnSalir  == ae.getSource()){
            System.exit(0);
        }else if(v1.panelIni.btnJugar == ae.getSource()){
            try {           
                VentanaActividad va = new VentanaActividad();
            } catch (IOException ex) {
                Logger.getLogger(GestorFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            v1.setVisible(false);
        }
    }
}
    
   
   
