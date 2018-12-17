package vista;

import ejecucion.GestorFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.ActividadTipo1;
import logica.ActividadTipo2;
import logica.ActividadTipo3;

public class VentanaActividad extends JFrame implements ActionListener {

    public PanelActividad panelAct;

    public VentanaActividad() throws IOException {
        inicializarComponentes();
    }

    public void inicializarComponentes() throws IOException {

        this.panelAct = new PanelActividad();
        this.add(this.panelAct);
        this.panelAct.btnConfirmar.addActionListener(this);
        this.panelAct.btnAgregarRespuesta.addActionListener(this);
        this.panelAct.btnVolver.addActionListener(this);

        this.setSize(400, 500);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaActividad.this);
        this.setResizable(false);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String respuesta;
        int respTotal;
        int nroResp = 0;
        if (this.panelAct.btnVolver == ae.getSource()) {
            this.setVisible(false);
            try {
                GestorFrame gf = new GestorFrame();
            } catch (IOException ex) {
                Logger.getLogger(VentanaActividad.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (this.panelAct.btnConfirmar == ae.getSource()) {
            if (this.panelAct.tipoAct == 1) {
                respuesta = this.panelAct.txtRespuesta.getText();
                if (Integer.toString(((ActividadTipo1) panelAct.actividad).getRespuestaCorrecta()).equals(respuesta)) {
                    try {
                        this.setVisible(false);
                        VentanaActividad va = new VentanaActividad();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecto");
                }
            } else if (this.panelAct.tipoAct == 2) {
                respuesta = this.panelAct.txtRespuesta.getText().toLowerCase();
                if (((ActividadTipo2) panelAct.actividad).getRespuestaCorrecta().equals(respuesta)) {
                    try {
                        this.setVisible(false);
                        VentanaActividad va = new VentanaActividad();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrecto");
                }
            }
        } else if (this.panelAct.btnAgregarRespuesta == ae.getSource()) {
            respTotal = ((ActividadTipo3) panelAct.actividad).getRespuestaCorrecta().length;
            for (int i = 0; i < respTotal; i++) {
                respuesta = JOptionPane.showInputDialog(null, (nroResp + 1) + "° RESPUESTA").toLowerCase();
                if (respuesta != null && respuesta.equals(((ActividadTipo3) panelAct.actividad).getRespuestaCorrecta()[i])) {
                    nroResp++;
                }
            }
            if (respTotal == nroResp) {
                try {
                    this.setVisible(false);
                    VentanaActividad va = new VentanaActividad();
                } catch (IOException ex) {
                    Logger.getLogger(VentanaActividad.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incorrecto");
            }
        }
    }
}
