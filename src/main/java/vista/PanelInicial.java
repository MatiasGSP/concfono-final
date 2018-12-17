package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelInicial extends JPanel {

    public JButton btnEntrar, btnSalir, btnJugar;
    private JLabel lblUsuario, lblClave , fondo;
    public JTextField tfUsuario;
    public JPasswordField pfClave;
    private final ImageIcon imgEntrar = new ImageIcon("src/main/java/imagenPanel/Entrar.png");
    private final ImageIcon imgSalir = new ImageIcon("src/main/java/imagenPanel/Salir.png");
    private final ImageIcon imgJugar = new ImageIcon("src/main/java/imagenPanel/Jugar.png");
    private final ImageIcon imgUsuario = new ImageIcon("src/main/java/imagenPanel/Usuario.png");
    private final ImageIcon imgClave = new ImageIcon("src/main/java/imagenPanel/Clave.png");
    private final ImageIcon imgFondo = new ImageIcon("src/main/java/imagenDecoracion/fondo1.png");

    public PanelInicial() {
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.PINK);

        this.lblUsuario = new JLabel();
        this.lblUsuario.setBounds(560, 300, 50, 20);
        Icon icUsuario = new ImageIcon(this.imgUsuario.getImage().getScaledInstance(this.lblUsuario.getWidth(), this.lblUsuario.getHeight(), Image.SCALE_DEFAULT));
        this.lblUsuario.setIcon(icUsuario);
        add(this.lblUsuario);
        this.tfUsuario = new JTextField();
        this.tfUsuario.setBounds(610, 300, 150, 20);
        add(this.tfUsuario);

        this.lblClave = new JLabel();
        this.lblClave.setBounds(560, 350, 50, 20);
        Icon icClave = new ImageIcon(this.imgClave.getImage().getScaledInstance(this.lblClave.getWidth(), this.lblClave.getHeight(), Image.SCALE_DEFAULT));
        this.lblClave.setIcon(icClave);
        add(this.lblClave);
        this.pfClave = new JPasswordField();
        this.pfClave.setBounds(610, 350, 150, 20);
        add(this.pfClave);

        this.btnEntrar = new JButton();
        this.btnEntrar.setBounds(570, 400, 80, 20);
        this.btnEntrar.setBorderPainted(false);
        Icon icEntrar = new ImageIcon(this.imgEntrar.getImage().getScaledInstance(this.btnEntrar.getWidth(), this.btnEntrar.getHeight(), Image.SCALE_DEFAULT));
        this.btnEntrar.setIcon(icEntrar);
        this.add(this.btnEntrar);

        this.btnSalir = new JButton();
        this.btnSalir.setBounds(670, 400, 80, 20);
        this.btnSalir.setBorderPainted(false);
        Icon icSalir = new ImageIcon(this.imgSalir.getImage().getScaledInstance(this.btnSalir.getWidth(), this.btnSalir.getHeight(), Image.SCALE_DEFAULT));
        this.btnSalir.setIcon(icSalir);
        this.add(this.btnSalir);

        this.btnJugar = new JButton();
        this.btnJugar.setBounds(560, 20, 200, 200);
        this.btnJugar.setBorderPainted(false);
        Icon icJugar = new ImageIcon(this.imgJugar.getImage().getScaledInstance(this.btnJugar.getWidth(), this.btnJugar.getHeight(), Image.SCALE_DEFAULT));
        this.btnJugar.setIcon(icJugar);
        this.add(this.btnJugar);
        
        this.fondo = new JLabel();
        this.fondo.setBounds(10, 10, 525, 440);
        Icon icFondo = new ImageIcon(this.imgFondo.getImage().getScaledInstance(this.fondo.getWidth(), this.fondo.getHeight(), Image.SCALE_DEFAULT));
        this.fondo.setIcon(icFondo);
        this.add(this.fondo);
    }
}