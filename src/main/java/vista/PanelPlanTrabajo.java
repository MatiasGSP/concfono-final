package vista;

import datosUsuario.Alumno;
import datosUsuario.Usuario;
import escrituraArchivos.GestorDeCarpeta;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.*;

public class PanelPlanTrabajo extends JPanel {

    public JButton btnAgregarTipo1, btnAgregarTipo2, btnAgregarTipo3, btnVolver, btnEliminar;
    private final ImageIcon imgAgregar = new ImageIcon("src/main/java/imagenPanel/Agregar_1.png");
    private final ImageIcon imgVolver = new ImageIcon("src/main/java/imagenPanel/Volver_3.png");
    private final ImageIcon imgEliminar = new ImageIcon("src/main/java/imagenPanel/Eliminar.png");
    private final ImageIcon imgAlumno = new ImageIcon("src/main/java/imagenPanel/Alumno.png");
    private final ImageIcon imgTipo1 = new ImageIcon("src/main/java/imagenPanel/Tipo1_1.png");
    private final ImageIcon imgTipo2 = new ImageIcon("src/main/java/imagenPanel/Tipo2_1.png");
    private final ImageIcon imgTipo3 = new ImageIcon("src/main/java/imagenPanel/Tipo3_1.png");
    private final ImageIcon imgActividades = new ImageIcon("src/main/java/imagenPanel/Actividades.png");
    public JComboBox cboxAlumno, cboxActividad, cboxTipo1, cboxTipo2, cboxTipo3;
    private JLabel lblAlumno, lblTipo1, lblTipo2, lblTipo3, lblActividad;
    private Usuario usuario;

    public PanelPlanTrabajo(Usuario usuario) throws IOException {
        this.usuario = usuario;
        inicializarComponentes();
    }

    public void inicializarComponentes() throws IOException {
        this.setBackground(Color.PINK);
        this.setLayout(null);

        this.lblAlumno = new JLabel();
        this.lblAlumno.setBounds(225, 40, 50, 30);
        Icon icAlumno = new ImageIcon(this.imgAlumno.getImage().getScaledInstance(this.lblAlumno.getWidth(), this.lblAlumno.getHeight(), Image.SCALE_DEFAULT));
        this.lblAlumno.setIcon(icAlumno);
        add(this.lblAlumno);
        this.cboxAlumno = new JComboBox(); //por modificar de los archivos de los alumnos
        for(Alumno a: usuario.alumnos)
            this.cboxAlumno.addItem(a.getNombre());
        this.cboxAlumno.setBounds(280, 40, 200, 30);
        add(this.cboxAlumno);

        this.lblTipo1 = new JLabel();
        this.lblTipo1.setBounds(90, 110, 50, 30);
        Icon icTipo1 = new ImageIcon(this.imgTipo1.getImage().getScaledInstance(this.lblTipo1.getWidth(), this.lblTipo1.getHeight(), Image.SCALE_DEFAULT));
        this.lblTipo1.setIcon(icTipo1);
        add(this.lblTipo1);
        this.cboxTipo1 = new JComboBox(); //por modificar de los archivos de actividades tipo1
        ArrayList<ActividadTipo1> act1 = GestorDeCarpeta.leerActTipo1();
        for(ActividadTipo1 act : act1 )
            this.cboxTipo1.addItem(act.getTitulo());
        this.cboxTipo1.setBounds(65, 145, 100, 30);
        add(this.cboxTipo1);
        this.btnAgregarTipo1 = new JButton();
        this.btnAgregarTipo1.setBounds(65, 195, 100, 20);
        this.btnAgregarTipo1.setBorderPainted(false);
        Icon icAgregar1 = new ImageIcon(this.imgAgregar.getImage().getScaledInstance(this.btnAgregarTipo1.getWidth(), this.btnAgregarTipo1.getHeight(), Image.SCALE_DEFAULT));
        this.btnAgregarTipo1.setIcon(icAgregar1);
        add(this.btnAgregarTipo1);

        this.lblTipo2 = new JLabel("Tipo 2");
        this.lblTipo2.setBounds(325, 110, 50, 30);
        Icon icTipo2 = new ImageIcon(this.imgTipo2.getImage().getScaledInstance(this.lblTipo2.getWidth(), this.lblTipo2.getHeight(), Image.SCALE_DEFAULT));
        this.lblTipo2.setIcon(icTipo2);
        add(this.lblTipo2);
        this.cboxTipo2 = new JComboBox(); //por modificar de los archivos de actividades tipo2
        ArrayList<ActividadTipo2> act2 = GestorDeCarpeta.leerActTipo2();
        for(ActividadTipo2 act : act2 )
            this.cboxTipo2.addItem(act.getTitulo());
        this.cboxTipo2.setBounds(300, 145, 100, 30);
        add(this.cboxTipo2);
        this.btnAgregarTipo2 = new JButton();
        this.btnAgregarTipo2.setBounds(300, 195, 100, 20);
        this.btnAgregarTipo2.setBorderPainted(false);
        Icon icAgregar2 = new ImageIcon(this.imgAgregar.getImage().getScaledInstance(this.btnAgregarTipo2.getWidth(), this.btnAgregarTipo2.getHeight(), Image.SCALE_DEFAULT));
        this.btnAgregarTipo2.setIcon(icAgregar2);
        add(this.btnAgregarTipo2);

        this.lblTipo3 = new JLabel("Tipo 3");
        this.lblTipo3.setBounds(550, 110, 50, 30);
        Icon icTipo3 = new ImageIcon(this.imgTipo3.getImage().getScaledInstance(this.lblTipo3.getWidth(), this.lblTipo3.getHeight(), Image.SCALE_DEFAULT));
        this.lblTipo3.setIcon(icTipo3);
        add(this.lblTipo3);
        this.cboxTipo3 = new JComboBox(); //por modificar de los archivos de actividades tipo3
        ArrayList<ActividadTipo3> act3 = GestorDeCarpeta.leerActTipo3();
        for(ActividadTipo3 act : act3 )
            this.cboxTipo3.addItem(act.getTitulo());
        this.cboxTipo3.setBounds(525, 145, 100, 30);
        add(this.cboxTipo3);
        this.btnAgregarTipo3 = new JButton();
        this.btnAgregarTipo3.setBounds(525, 195, 100, 20);
        this.btnAgregarTipo3.setBorderPainted(false);
        Icon icAgregar3 = new ImageIcon(this.imgAgregar.getImage().getScaledInstance(this.btnAgregarTipo3.getWidth(), this.btnAgregarTipo3.getHeight(), Image.SCALE_DEFAULT));
        this.btnAgregarTipo3.setIcon(icAgregar3);
        add(this.btnAgregarTipo3);

        this.lblActividad = new JLabel();
        this.lblActividad.setBounds(180, 300, 100, 40);
        Icon icAct = new ImageIcon(this.imgActividades.getImage().getScaledInstance(this.lblActividad.getWidth(), this.lblActividad.getHeight(), Image.SCALE_DEFAULT));
        this.lblActividad.setIcon(icAct);
        add(this.lblActividad);
        this.cboxActividad = new JComboBox();
        int nroAlumno = 0;
        String alumno = (String)cboxAlumno.getSelectedItem();
        for(int i=0;i<usuario.alumnos.size();i++){
            if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                nroAlumno = i;
        }
        for(Actividad act: usuario.alumnos.get(nroAlumno).getPlanTrabajo())
            this.cboxActividad.addItem(act.getTitulo());
        this.cboxActividad.setBounds(285, 305, 150, 30);
        add(this.cboxActividad);
        this.btnEliminar = new JButton();
        this.btnEliminar.setBounds(485, 305, 100, 30);
        this.btnEliminar.setBorderPainted(false);
        Icon icEliminar = new ImageIcon(this.imgEliminar.getImage().getScaledInstance(this.btnEliminar.getWidth(), this.btnEliminar.getHeight(), Image.SCALE_DEFAULT));
        this.btnEliminar.setIcon(icEliminar);
        add(this.btnEliminar);

        this.btnVolver = new JButton();
        this.btnVolver.setBounds(310, 430, 100, 30);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.imgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        add(this.btnVolver);
        
        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nroAlumno = 0;
                String alumno = (String)cboxAlumno.getSelectedItem();
                cboxActividad.removeAllItems();
                for(int i=0;i<usuario.alumnos.size();i++){
                    if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                         nroAlumno = i;
                }
            for(Actividad act: usuario.alumnos.get(nroAlumno).getPlanTrabajo())
                cboxActividad.addItem(act.getTitulo());
                
            }
        };
        
        cboxAlumno.addActionListener(cbActionListener);
    }
    
   
}
