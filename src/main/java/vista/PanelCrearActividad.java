package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import datosUsuario.Usuario;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.JTextField;

public class PanelCrearActividad extends JPanel{

    public JButton tipo1, tipo2, tipo3, btnAgregar, btnLimpiar, btnVolver;
    private final ImageIcon ImgTipo1 = new ImageIcon("src/main/java/imagenPanel/Tipo1.png");
    private final ImageIcon ImgTipo2 = new ImageIcon("src/main/java/imagenPanel/Tipo2.png");
    private final ImageIcon ImgTipo3 = new ImageIcon("src/main/java/imagenPanel/Tipo3.png");
    private final ImageIcon ImgVolver = new ImageIcon("src/main/java/imagenPanel/Volver_2.png");
    private final ImageIcon ImgTipo = new ImageIcon("src/main/java/imagenPanel/Tipo.png");
    private JLabel tipo;
    public JTextField txtTitulo, txtEnunciado, txtRespuesta, txtCantRespuesta;
    private Usuario usuario;

    public PanelCrearActividad() {
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.PINK);

        this.tipo = new JLabel();
        this.tipo.setBounds(85, 20, 150, 30);
        Icon icTipo = new ImageIcon(this.ImgTipo.getImage().getScaledInstance(this.tipo.getWidth(), this.tipo.getHeight(), Image.SCALE_DEFAULT));
        this.tipo.setIcon(icTipo);
        add(this.tipo);

        this.tipo1 = new JButton();
        this.tipo1.setBounds(10, 65, 100, 30);
        this.tipo1.setBorderPainted(false);
        Icon icTipo1 = new ImageIcon(this.ImgTipo1.getImage().getScaledInstance(this.tipo1.getWidth(), this.tipo1.getHeight(), Image.SCALE_DEFAULT));
        this.tipo1.setIcon(icTipo1);
        add(this.tipo1);

        this.tipo2 = new JButton();
        this.tipo2.setBounds(120, 65, 100, 30);
        this.tipo2.setBorderPainted(false);
        Icon icTipo2 = new ImageIcon(this.ImgTipo2.getImage().getScaledInstance(this.tipo2.getWidth(), this.tipo2.getHeight(), Image.SCALE_DEFAULT));
        this.tipo2.setIcon(icTipo2);
        add(this.tipo2);

        this.tipo3 = new JButton();
        this.tipo3.setBounds(230, 65, 100, 30);
        this.tipo3.setBorderPainted(false);
        Icon icTipo3 = new ImageIcon(this.ImgTipo3.getImage().getScaledInstance(this.tipo3.getWidth(), this.tipo3.getHeight(), Image.SCALE_DEFAULT));
        this.tipo3.setIcon(icTipo3);
        add(this.tipo3);        

        this.btnVolver = new JButton();
        this.btnVolver.setBounds(122, 130, 100, 30);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.ImgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        add(this.btnVolver);
    }
}
