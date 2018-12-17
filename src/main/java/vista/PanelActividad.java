package vista;

import escrituraArchivos.GestorDeCarpeta;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Actividad;
import logica.ActividadTipo1;
import logica.ActividadTipo2;
import logica.ActividadTipo3;

public class PanelActividad extends JPanel {

    private ArrayList<ActividadTipo1> actTipo1;
    private ArrayList<ActividadTipo2> actTipo2;
    private ArrayList<ActividadTipo3> actTipo3;
    private JLabel lblActividad, lblEnunciado, lblImagenActividad;
    public JTextField txtRespuesta;
    public JButton btnVolver, btnConfirmar, btnAgregarRespuesta;
    private ImageIcon imgVolver = new ImageIcon("src/main/java/imagenPanel/Volver.png");
    private ImageIcon imgConfirmar = new ImageIcon("src/main/java/imagenPanel/Confirmar.png");
    private ImageIcon imgAgregar = new ImageIcon("src/main/java/imagenPanel/Agregar_2.png");
    private String ruta = "src/main/java/imagenActividad/";
    public Actividad actividad;
    public int tipoAct;

    public PanelActividad() throws IOException {
         actTipo1 = GestorDeCarpeta.leerActTipo1();
         actTipo2 = GestorDeCarpeta.leerActTipo2();
         actTipo3 = GestorDeCarpeta.leerActTipo3();
        Random azar = new Random();
        int i = azar.nextInt(3);
        switch (i) {
            case 0:
                inicializarComponentes(this.actAleatoria1());
                tipoAct = 1;
                break;
            case 1:
                inicializarComponentes(this.actAleatoria2());
                tipoAct = 2;
                break;
            case 2:
                inicializarComponentesTipo3(this.actAleatoria3());
                tipoAct = 3;
                break;
        }
    }
    
    public PanelActividad(Actividad actividad){
        if(!(actividad instanceof ActividadTipo3)){
            if(actividad instanceof ActividadTipo1)
                tipoAct = 1;
            if(actividad instanceof ActividadTipo2)
                tipoAct = 2;
            inicializarComponentes(actividad);
        }else{
            inicializarComponentesTipo3(actividad);
            tipoAct = 3;
        }
        
    }

    public Actividad actAleatoria1() {
        Random azar = new Random();
        Actividad act = actTipo1.get(azar.nextInt(actTipo1.size()));
        return act;
    }

    public Actividad actAleatoria2() {
        Random azar = new Random();
        Actividad act = actTipo2.get(azar.nextInt(actTipo2.size()));
        return act;
    }

    public Actividad actAleatoria3() {
        Random azar = new Random();
        Actividad act = actTipo3.get(azar.nextInt(actTipo3.size()));
        return act;
    }

    public void inicializarComponentes(Actividad act) {
        actividad = act;
        this.setLayout(null);
        this.setBackground(Color.PINK);

        ImageIcon rutaActividad = new ImageIcon(this.ruta + act.getTitulo() + ".png");
        this.lblImagenActividad = new JLabel();
        this.lblImagenActividad.setBounds(50, 50, 300, 250);
        this.lblImagenActividad.setIcon(rutaActividad);
        add(this.lblImagenActividad);

        this.lblActividad = new JLabel(act.getTitulo());
        this.lblActividad.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblActividad.setBounds(125, 305, 150, 30);
        add(this.lblActividad);

        this.lblEnunciado = new JLabel(act.getEnunciado());
        this.lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblEnunciado.setBounds(100, 345, 200, 30);
        add(this.lblEnunciado);

        this.txtRespuesta = new JTextField();
        this.txtRespuesta.setBounds(185, 375, 30, 20);
        add(this.txtRespuesta);

        this.btnConfirmar = new JButton();
        this.btnConfirmar.setBounds(150, 430, 100, 20);
        this.btnConfirmar.setBorderPainted(false);
        Icon icConfirmar = new ImageIcon(this.imgConfirmar.getImage().getScaledInstance(this.btnConfirmar.getWidth(), this.btnConfirmar.getHeight(), Image.SCALE_DEFAULT));
        this.btnConfirmar.setIcon(icConfirmar);
        add(this.btnConfirmar);

        this.btnVolver = new JButton();
        this.btnVolver.setBounds(125, 1, 150, 20);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.imgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        add(this.btnVolver);
        
        this.btnAgregarRespuesta = new JButton();
    }

    public void inicializarComponentesTipo3(Actividad act) {
        actividad = act;
        this.setLayout(null);
        this.setBackground(Color.PINK);

        ImageIcon rutaActividad = new ImageIcon(this.ruta + act.getTitulo() + ".png");
        this.lblImagenActividad = new JLabel();
        this.lblImagenActividad.setBounds(50, 50, 300, 250);
        this.lblImagenActividad.setIcon(rutaActividad);
        add(this.lblImagenActividad);

        this.lblActividad = new JLabel(act.getTitulo());
        this.lblActividad.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblActividad.setBounds(125, 305, 150, 30);
        add(this.lblActividad);

        this.lblEnunciado = new JLabel(act.getEnunciado());
        this.lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
        this.lblEnunciado.setBounds(100, 345, 200, 30);
        add(this.lblEnunciado);

        this.btnAgregarRespuesta = new JButton();
        this.btnAgregarRespuesta.setBounds(150, 405, 100, 30);
        this.btnAgregarRespuesta.setBorderPainted(false);
        Icon icAgregar = new ImageIcon(this.imgAgregar.getImage().getScaledInstance(this.btnAgregarRespuesta.getWidth(), this.btnAgregarRespuesta.getHeight(), Image.SCALE_DEFAULT));
        this.btnAgregarRespuesta.setIcon(icAgregar);
        add(this.btnAgregarRespuesta);

        this.btnVolver = new JButton();
        this.btnVolver.setBounds(125, 1, 150, 20);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.imgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        add(this.btnVolver);
        
        this.btnConfirmar = new JButton();
    }
}
