package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import datosUsuario.Usuario;
import java.awt.Image;
import javax.swing.Icon;

public class PanelCreacionUsuario extends JPanel{

    private JLabel lblUsuario, lblClave;
    public JTextField txtUsuario, clave;
    public JButton crear, volver;
    private final ImageIcon imgCrear = new ImageIcon("src/main/java/imagenPanel/Crear.png");
    private final ImageIcon imgVolver = new ImageIcon("src/main/java/imagenPanel/Volver_1.png");
    private final ImageIcon imgNombre = new ImageIcon("src/main/java/imagenPanel/Nombre.png");
    private final ImageIcon imgClave = new ImageIcon("src/main/java/imagenPanel/Clave.png");
    public Usuario usuario;

    public PanelCreacionUsuario(Usuario usuario) {
        this.usuario = usuario;
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.PINK);

        this.lblUsuario = new JLabel();
        this.lblUsuario.setBounds(20, 20, 100, 20);
        Icon icUsuario = new ImageIcon(this.imgNombre.getImage().getScaledInstance(this.lblUsuario.getWidth(), this.lblUsuario.getHeight(), Image.SCALE_DEFAULT));
        this.lblUsuario.setIcon(icUsuario);
        add(this.lblUsuario);
        this.txtUsuario = new JTextField();
        this.txtUsuario.setBounds(130, 20, 150, 20);
        add(this.txtUsuario);

        this.lblClave = new JLabel();
        this.lblClave.setBounds(20, 50, 50, 20);
        Icon icClave= new ImageIcon(this.imgClave.getImage().getScaledInstance(this.lblClave.getWidth(), this.lblClave.getHeight(), Image.SCALE_DEFAULT));
        this.lblClave.setIcon(icClave);
        add(this.lblClave);
        this.clave = new JTextField();
        this.clave.setBounds(130, 50, 150, 20);
        add(this.clave);

        this.crear = new JButton();
        this.crear.setBounds(20, 100, 250, 30);
        this.crear.setBorderPainted(false);
        Icon icCrear = new ImageIcon(this.imgCrear.getImage().getScaledInstance(this.crear.getWidth(), this.crear.getHeight(), Image.SCALE_DEFAULT));
        this.crear.setIcon(icCrear);
        this.add(this.crear);

        this.volver = new JButton();
        this.volver.setBounds(20, 140, 250, 30);
        this.volver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.imgVolver.getImage().getScaledInstance(this.volver.getWidth(), this.volver.getHeight(), Image.SCALE_DEFAULT));
        this.volver.setIcon(icVolver);
        this.add(this.volver);
    }
}
