package vista;

import datosUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaCrearActividad extends JFrame implements ActionListener{

    public PanelCrearActividad panelCrearAct;
    public PanelCrearActividadTipo1o2 panelCrearActTipo1o2;
    public PanelCrearActividadTipo3 panelCrearActTipo3;
    private Usuario usuario;

    public VentanaCrearActividad(Usuario usuario) {
        this.usuario = usuario;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.panelCrearAct = new PanelCrearActividad();
        this.add(this.panelCrearAct);
        this.panelCrearAct.btnVolver.addActionListener(this);
        this.panelCrearAct.tipo1.addActionListener(this);
        this.panelCrearAct.tipo2.addActionListener(this);
        this.panelCrearAct.tipo3.addActionListener(this);

        this.setSize(350, 250);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaCrearActividad.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.panelCrearAct.tipo1 == ae.getSource()){
            int actividad = 1;
            try {
                VentanaCrearActividadTipo1o2 tipo1 = new VentanaCrearActividadTipo1o2(actividad, this.usuario);
            } catch (IOException ex) {
                Logger.getLogger(VentanaCrearActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }else if(this.panelCrearAct.tipo2 == ae.getSource()){
            int actividad = 2;
            try {
                VentanaCrearActividadTipo1o2 tipo2 = new VentanaCrearActividadTipo1o2(actividad, this.usuario);
            } catch (IOException ex) {
                Logger.getLogger(VentanaCrearActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }else if(this.panelCrearAct.tipo3 == ae.getSource()){
            try {
                VentanaCrearActividadTipo3 tipo3 = new VentanaCrearActividadTipo3(this.usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.setVisible(false);
        }else if (this.panelCrearAct.btnVolver == ae.getSource()) {
            try {
                VentanaProfesor vp = new VentanaProfesor(this.usuario);
                this.setVisible(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
