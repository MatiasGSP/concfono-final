package vista;

import datosUsuario.Alumno;
import datosUsuario.Usuario;
import ejecucion.GestorFrame;
import escrituraArchivos.EscritorJson;
import escrituraArchivos.GestorDeCarpeta;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaProfesor extends JFrame implements ActionListener {

    public PanelProfesorSuperior panelProfeSup;
    public PanelProfesorInferior panelProfeInf;
    private Usuario usuario;
    private EscritorJson json;
    private String ruta;

    public VentanaProfesor(Usuario usuario) throws IOException {
        this.ruta = GestorDeCarpeta.ruta + GestorDeCarpeta.separador + "datos" + GestorDeCarpeta.separador + usuario.getNombre() + ".json";
        json = new EscritorJson(usuario);
        this.usuario = json.leerUsuario(usuario);
        System.out.println(usuario);
        inicializarComponentes();
    }

    private void inicializarComponentes() throws IOException {
        this.panelProfeSup = new PanelProfesorSuperior();
        this.add(this.panelProfeSup, BorderLayout.NORTH);
        this.panelProfeInf = new PanelProfesorInferior(this.usuario);
        this.add(this.panelProfeInf);
        this.panelProfeSup.itPlanTrabajo.addActionListener(this);
//        this.panelProfeSup.itIndicadores.addActionListener(this);
        this.panelProfeSup.itIngresarAlumno.addActionListener(this);
        this.panelProfeSup.itCrearActividad.addActionListener(this);
        this.panelProfeSup.itCrearCuenta.addActionListener(this);
        this.panelProfeSup.itAyuda.addActionListener(this);
        this.panelProfeSup.itVolver.addActionListener(this);
        this.panelProfeSup.itSalir.addActionListener(this);

        this.setSize(500, 500);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaProfesor.this);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.panelProfeSup.itPlanTrabajo == ae.getSource()) {
            try {
                VentanaPlanTrabajo vpt = new VentanaPlanTrabajo(usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.setVisible(false);
        } else if (this.panelProfeSup.itIndicadores == ae.getSource()) {
            VentanaIndicadores vInd = new VentanaIndicadores();
            this.setVisible(false);
        } else if (this.panelProfeSup.itIngresarAlumno == ae.getSource()) {
            String nombreAlumno = JOptionPane.showInputDialog(null, "Nombre del alumno");
            if(nombreAlumno!=null){
                if(!nombreAlumno.equals("")){
                    Alumno alumno = new Alumno(nombreAlumno);
                    usuario = panelProfeInf.usuario;
                    System.out.println(usuario);
                    this.usuario.agregarAlumno(alumno);
                    try {
                        json.agregarDatosUsuario(usuario);
                        Object[] fila = {nombreAlumno, "Sin actividades pendientes"};
                        this.panelProfeInf.modelo.addRow(fila);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Hubo un error al ingresar al alumno");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "¡¡Debe ingresar un nombre!!");
                }
            }
        } else if (this.panelProfeSup.itCrearActividad == ae.getSource()) {
            VentanaCrearActividad vca = new VentanaCrearActividad(usuario);
            this.setVisible(false);
        } else if (this.panelProfeSup.itCrearCuenta == ae.getSource()) {
            VentanaCreacionUsuario vcu = new VentanaCreacionUsuario(usuario);
            this.setVisible(false);
        } else if (this.panelProfeSup.itAyuda == ae.getSource()) {
            JOptionPane.showMessageDialog(null, "Ayuda");
        } else if (this.panelProfeSup.itVolver == ae.getSource()) {
            try {
                GestorFrame gf = new GestorFrame();
                this.setVisible(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (this.panelProfeSup.itSalir == ae.getSource()) {
            System.exit(0);
        }
    }
    }

