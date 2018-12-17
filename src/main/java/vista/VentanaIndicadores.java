package vista;

import datosUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class VentanaIndicadores extends JFrame implements ActionListener{

    public PanelIndicadores panelInd;
    public Usuario usuario;

    public VentanaIndicadores() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.panelInd = new PanelIndicadores();
        this.add(this.panelInd);
        this.panelInd.btnVolver.addActionListener(this);

        this.setSize(500, 500);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaIndicadores.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.panelInd.btnVolver == ae.getSource()) {
            try {
                VentanaProfesor vp = new VentanaProfesor(this.usuario);
                this.setVisible(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
