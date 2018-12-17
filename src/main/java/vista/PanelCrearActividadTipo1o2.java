package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCrearActividadTipo1o2 extends JPanel {

    public JButton btnAgregar, btnLimpiar, btnVolver;
    private JLabel lblTitulo, lblEnunciado, lblRespuesta;
    public JTextField txtTitulo, txtEnunciado, txtRespuesta;
    private final ImageIcon ImgAgregar = new ImageIcon("src/main/java/imagenPanel/Agregar.png");
    private final ImageIcon ImgLimpiar = new ImageIcon("src/main/java/imagenPanel/Limpiar.png");
    private final ImageIcon ImgTitulo = new ImageIcon("src/main/java/imagenPanel/Titulo.png");
    private final ImageIcon ImgEnunciado = new ImageIcon("src/main/java/imagenPanel/Enunciado.png");
    private final ImageIcon ImgRespuesta = new ImageIcon("src/main/java/imagenPanel/Respuesta.png");
    private final ImageIcon ImgVolver = new ImageIcon("src/main/java/imagenPanel/Volver_2.png");

    public PanelCrearActividadTipo1o2(int actividad) {
        inicializarComponentes(actividad);
    }

    public void inicializarComponentes(int actividad) {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        
        this.lblTitulo = new JLabel();
        this.lblTitulo.setBounds(20, 10, 70, 20);
        Icon icTitulo = new ImageIcon(this.ImgTitulo.getImage().getScaledInstance(this.lblTitulo.getWidth(), this.lblTitulo.getHeight(), Image.SCALE_DEFAULT));
        this.lblTitulo.setIcon(icTitulo);
        add(this.lblTitulo);
        if(actividad==1){
            this.txtTitulo = new JTextField("ej. SILLON");
        }else if(actividad==2){
            this.txtTitulo = new JTextField("ej. CAMIONETA");
        }
        this.txtTitulo.setBounds(100, 10, 200, 20);
        add(this.txtTitulo);

        this.lblEnunciado = new JLabel();
        this.lblEnunciado.setBounds(20, 40, 70, 20);
        Icon icEnunciado = new ImageIcon(this.ImgEnunciado.getImage().getScaledInstance(this.lblEnunciado.getWidth(), this.lblEnunciado.getHeight(), Image.SCALE_DEFAULT));
        this.lblEnunciado.setIcon(icEnunciado);
        add(this.lblEnunciado);
        if(actividad==1){
            this.txtEnunciado = new JTextField("ej. Cantidad de silabas");
        }else if(actividad==2){
            this.txtEnunciado = new JTextField("ej. Ultima silaba");
        }
        this.txtEnunciado.setBounds(100, 40, 200, 20);
        add(this.txtEnunciado);

        this.lblRespuesta = new JLabel();
        this.lblRespuesta.setBounds(20, 70, 70, 20);
        Icon icRespuesta = new ImageIcon(this.ImgRespuesta.getImage().getScaledInstance(this.lblRespuesta.getWidth(), this.lblRespuesta.getHeight(), Image.SCALE_DEFAULT));
        this.lblRespuesta.setIcon(icRespuesta);
        add(this.lblRespuesta);
        if(actividad==1){
            this.txtRespuesta = new JTextField("ej. 2");
        }else if(actividad==2){
            this.txtRespuesta = new JTextField("ej. ta");
        }        
        this.txtRespuesta.setBounds(100, 70, 200, 20);
        add(this.txtRespuesta);

        this.btnAgregar = new JButton();
        this.btnAgregar.setBounds(65, 110, 100, 30);
        this.btnAgregar.setBorderPainted(false);
        Icon icAgregar = new ImageIcon(this.ImgAgregar.getImage().getScaledInstance(this.btnAgregar.getWidth(), this.btnAgregar.getHeight(), Image.SCALE_DEFAULT));
        this.btnAgregar.setIcon(icAgregar);
        add(this.btnAgregar);

        this.btnLimpiar = new JButton();
        this.btnLimpiar.setBounds(175, 110, 100, 30);
        this.btnLimpiar.setBorderPainted(false);
        Icon icLimpiar = new ImageIcon(this.ImgLimpiar.getImage().getScaledInstance(this.btnLimpiar.getWidth(), this.btnLimpiar.getHeight(), Image.SCALE_DEFAULT));
        this.btnLimpiar.setIcon(icLimpiar);
        add(this.btnLimpiar);
        
        this.btnVolver = new JButton();
        this.btnVolver.setBounds(125, 140, 100, 30);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.ImgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        add(this.btnVolver);
    }
}
