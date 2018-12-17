package vista;

import datosUsuario.Usuario;
import escrituraArchivos.GestorDeCarpeta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.ActividadTipo3;

public class VentanaCrearActividadTipo3 extends JFrame implements ActionListener{
    PanelCrearActividadTipo3 panelCrearActividadTipo3;
    private Usuario usuario;
    private GestorDeCarpeta gdc;

    public VentanaCrearActividadTipo3(Usuario usuario) throws IOException {
        this.usuario = usuario;
        inicializarComponentes();
        gdc = new GestorDeCarpeta();
    }
    
    public void inicializarComponentes(){
        this.panelCrearActividadTipo3 = new PanelCrearActividadTipo3();
        this.add(this.panelCrearActividadTipo3);
        this.panelCrearActividadTipo3.btnAgregar.addActionListener(this);
        this.panelCrearActividadTipo3.btnLimpiar.addActionListener(this);
        this.panelCrearActividadTipo3.btnVolver.addActionListener(this);
        
        this.setSize(350, 250);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaCrearActividadTipo3.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int cantRespuestas; 
        boolean arregloCorrecto = false;
        if(this.panelCrearActividadTipo3.btnAgregar == ae.getSource()){
            String titulo = this.panelCrearActividadTipo3.txtTitulo.getText();
            String enunciado = this.panelCrearActividadTipo3.txtEnunciado.getText();
            String cant = this.panelCrearActividadTipo3.txtCantRespuesta.getText();
            if(titulo!=null && enunciado!=null && cant!=null){
                if(cant.matches("^[0-9]+$")){
                    cantRespuestas = Integer.parseInt(cant);
                    String[] respuesta = new String[cantRespuestas];
                    for(int i = 0 ; i < cantRespuestas ; i++){
                        respuesta[i]=JOptionPane.showInputDialog(null, "Respuesta "+(i+1)).toLowerCase();
                    }
                    for(String s : respuesta){
                        if(!s.equals("") && s!=null && s.chars().allMatch(Character::isLetter))
                            arregloCorrecto = true;
                    }
                    if(arregloCorrecto==true){
                        ActividadTipo3 act3 = new ActividadTipo3(titulo,enunciado,respuesta);
                        try {
                            gdc.agregarAct3(act3);
                        } catch (IOException ex) {
                            Logger.getLogger(VentanaCrearActividadTipo3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(null, "Actividad creada con éxito");
                        this.panelCrearActividadTipo3.txtTitulo.setText("");
                        this.panelCrearActividadTipo3.txtEnunciado.setText("");
                        this.panelCrearActividadTipo3.txtCantRespuesta.setText("");        
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese un número en la cantidad de respuestas");
                }
                    
            }else{
                JOptionPane.showMessageDialog(null, "Rellene los campos correctamente");}
        }else if(this.panelCrearActividadTipo3.btnLimpiar == ae.getSource()){
            this.panelCrearActividadTipo3.txtTitulo.setText("");
            this.panelCrearActividadTipo3.txtEnunciado.setText("");
            this.panelCrearActividadTipo3.txtCantRespuesta.setText("");
        }else if(this.panelCrearActividadTipo3.btnVolver == ae.getSource()){
            VentanaCrearActividad vca = new VentanaCrearActividad(this.usuario);
            this.setVisible(false);
        }
    }
    
    
}
    
