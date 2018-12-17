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
import logica.*;

public class VentanaCrearActividadTipo1o2 extends JFrame implements ActionListener{
    PanelCrearActividadTipo1o2 panelCrearActividadTipo1o2;
    private Usuario usuario;
    private int actividad;
    private GestorDeCarpeta gdc;
    
    public VentanaCrearActividadTipo1o2(int actividad, Usuario usuario) throws IOException {
        this.gdc = new GestorDeCarpeta();
        this.usuario = usuario;
        inicializarComponentes(actividad);
    }

    private void inicializarComponentes(int actividad) {
        this.actividad = actividad;
        this.panelCrearActividadTipo1o2 = new PanelCrearActividadTipo1o2(actividad);
        this.add(this.panelCrearActividadTipo1o2);
        this.panelCrearActividadTipo1o2.btnAgregar.addActionListener(this);
        this.panelCrearActividadTipo1o2.btnLimpiar.addActionListener(this);
        this.panelCrearActividadTipo1o2.btnVolver.addActionListener(this);

        this.setSize(350, 250);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaCrearActividadTipo1o2.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.panelCrearActividadTipo1o2.btnAgregar == ae.getSource()){
            int respFinal;
            String titulo = panelCrearActividadTipo1o2.txtTitulo.getText();
            String enunciado = panelCrearActividadTipo1o2.txtEnunciado.getText();
            String respuesta = panelCrearActividadTipo1o2.txtRespuesta.getText().toLowerCase();
            if(titulo!=null && enunciado!=null && respuesta!=null){
                if(actividad==1){
                    if(respuesta.matches("^[0-9]+$")){
                        respFinal = Integer.parseInt(respuesta);
                        ActividadTipo1 act1 = new ActividadTipo1(titulo,enunciado,respFinal);
                        try {
                            gdc.agregarAct1(act1);
                            JOptionPane.showMessageDialog(null, "Actividad creada con éxito");
                            this.panelCrearActividadTipo1o2.txtTitulo.setText("");
                            this.panelCrearActividadTipo1o2.txtEnunciado.setText("");
                            this.panelCrearActividadTipo1o2.txtRespuesta.setText("");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Debe ingresar un número en la respuesta");
                    }       
                }else if(actividad==2){
                    ActividadTipo2 act2 = new ActividadTipo2(titulo,enunciado,respuesta);
                    try {
                            gdc.agregarAct2(act2);
                            JOptionPane.showMessageDialog(null, "Actividad creada con éxito");
                            this.panelCrearActividadTipo1o2.txtTitulo.setText("");
                            this.panelCrearActividadTipo1o2.txtEnunciado.setText("");
                            this.panelCrearActividadTipo1o2.txtRespuesta.setText("");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        
                    }       
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Rellene los campos");
            }
        }else if(this.panelCrearActividadTipo1o2.btnLimpiar == ae.getSource()){
            this.panelCrearActividadTipo1o2.txtTitulo.setText("");
            this.panelCrearActividadTipo1o2.txtEnunciado.setText("");
            this.panelCrearActividadTipo1o2.txtRespuesta.setText("");
        }else if(this.panelCrearActividadTipo1o2.btnVolver == ae.getSource()){
            VentanaCrearActividad vca = new VentanaCrearActividad(this.usuario);
            this.setVisible(false);
        }
    }
}
