package vista;

import datosUsuario.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import escrituraArchivos.GestorDeCarpeta;

public class VentanaCreacionUsuario extends JFrame implements ActionListener {

    public PanelCreacionUsuario panelUsu;
    private Usuario usuario;

    public VentanaCreacionUsuario(Usuario usuario) {
        this.usuario = usuario;
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        this.panelUsu = new PanelCreacionUsuario(this.usuario);
        this.add(this.panelUsu);
        this.panelUsu.volver.addActionListener(this);
        this.panelUsu.crear.addActionListener(this);

        this.setSize(300, 200);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaCreacionUsuario.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario, clave;
        Usuario user;
        boolean cuentaCreada;
        if (this.panelUsu.crear == ae.getSource()) {
            usuario = this.panelUsu.txtUsuario.getText();
            clave = this.panelUsu.clave.getText();
            if (!usuario.equals("") && !clave.equals("")) {
                if(usuario.matches("[a-zA-Z0-9]*")){
                    user = new Usuario(usuario, clave);
                    try {
                        cuentaCreada = GestorDeCarpeta.agregarUsuario(user);
                        if (cuentaCreada) {
                            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito");
                            this.panelUsu.txtUsuario.setText("");
                            this.panelUsu.clave.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
                        }
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Sólo puede ingresar un usuario con letras y números.");
                }    
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese datos en los campos faltantes");
            }
        } else if (this.panelUsu.volver == ae.getSource()) {
            try {
                VentanaProfesor vp = new VentanaProfesor(this.usuario);
                this.setVisible(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
