package vista;

import datosUsuario.Usuario;
import escrituraArchivos.EscritorJson;
import escrituraArchivos.GestorDeCarpeta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import logica.*;

public class VentanaPlanTrabajo extends JFrame implements ActionListener {

    public PanelPlanTrabajo panelPlanTrabajo;
    private Usuario usuario;
    private EscritorJson json;

    public VentanaPlanTrabajo(Usuario usuario) throws IOException {
        this.json = new EscritorJson(usuario);
        this.usuario = usuario;
        inicializarComponentes();
    }

    private void inicializarComponentes() throws IOException {
        this.panelPlanTrabajo = new PanelPlanTrabajo(usuario);
        add(this.panelPlanTrabajo);

        this.setSize(700, 500);
        this.setTitle("Plan de Trabajo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaPlanTrabajo.this);
        this.setResizable(false);
        this.setVisible(true);

        this.panelPlanTrabajo.btnAgregarTipo1.addActionListener(this);
        this.panelPlanTrabajo.btnAgregarTipo2.addActionListener(this);
        this.panelPlanTrabajo.btnAgregarTipo3.addActionListener(this);
        this.panelPlanTrabajo.btnEliminar.addActionListener(this);
        this.panelPlanTrabajo.btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<ActividadTipo1> actividades1 = new ArrayList<>();
        ArrayList<ActividadTipo2> actividades2 = new ArrayList<>();
        ArrayList<ActividadTipo3> actividades3 = new ArrayList<>();
        if (this.panelPlanTrabajo.btnAgregarTipo1 == ae.getSource()) {
            String titulo = (String)this.panelPlanTrabajo.cboxTipo1.getSelectedItem();
            try {
                actividades1 = GestorDeCarpeta.leerActTipo1();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Actividad act = new ActividadTipo1();
            for(ActividadTipo1 a : actividades1){
                if(a.getTitulo().equals(titulo))
                    act = a;
            }
            int nroAlumno = 0;
            String alumno = (String)panelPlanTrabajo.cboxAlumno.getSelectedItem();
            for(int i=0;i<usuario.alumnos.size();i++){
                if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                    nroAlumno = i;
            }
            usuario.alumnos.get(nroAlumno).planTrabajo.add(act);
            try {
                json.agregarDatosUsuario(usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.panelPlanTrabajo.cboxActividad.addItem(act.getTitulo());
        } else if (this.panelPlanTrabajo.btnAgregarTipo2 == ae.getSource()) {
            String titulo = (String)this.panelPlanTrabajo.cboxTipo2.getSelectedItem();
            try {
                actividades2 = GestorDeCarpeta.leerActTipo2();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Actividad act = new ActividadTipo2();
            for(ActividadTipo2 a : actividades2){
                if(a.getTitulo().equals(titulo))
                    act = a;
            }
            int nroAlumno = 0;
            String alumno = (String)panelPlanTrabajo.cboxAlumno.getSelectedItem();
            for(int i=0;i<usuario.alumnos.size();i++){
                if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                    nroAlumno = i;
            }
            usuario.alumnos.get(nroAlumno).planTrabajo.add(act);
            try {
                json.agregarDatosUsuario(usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.panelPlanTrabajo.cboxActividad.addItem(act.getTitulo());
        } else if (this.panelPlanTrabajo.btnAgregarTipo3 == ae.getSource()) {
            String titulo = (String)this.panelPlanTrabajo.cboxTipo3.getSelectedItem();
            try {
                actividades3 = GestorDeCarpeta.leerActTipo3();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Actividad act = new ActividadTipo3();
            for(ActividadTipo3 a : actividades3){
                if(a.getTitulo().equals(titulo))
                    act = a;
            }
            int nroAlumno = 0;
            String alumno = (String)panelPlanTrabajo.cboxAlumno.getSelectedItem();
            for(int i=0;i<usuario.alumnos.size();i++){
                if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                    nroAlumno = i;
            }
            usuario.alumnos.get(nroAlumno).planTrabajo.add(act);
            try {
                json.agregarDatosUsuario(usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            this.panelPlanTrabajo.cboxActividad.addItem(act.getTitulo());
        } else if (this.panelPlanTrabajo.btnEliminar == ae.getSource()) {
            Actividad act = new Actividad();
            int nroAlumno = 0;
            String actividad = (String)panelPlanTrabajo.cboxActividad.getSelectedItem();
            String alumno = (String)panelPlanTrabajo.cboxAlumno.getSelectedItem();
            for(int i=0;i<usuario.alumnos.size();i++){
                if(alumno.equals(usuario.alumnos.get(i).getNombre()))
                    nroAlumno = i;
            }
            for(Actividad a : usuario.alumnos.get(nroAlumno).getPlanTrabajo()){
                if(a.getTitulo().equals(actividad))
                    act = a;
            }
            panelPlanTrabajo.cboxActividad.removeItem(act.getTitulo());
            usuario.alumnos.get(nroAlumno).removerActividad(act);
            try {
                json.agregarDatosUsuario(usuario);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else if (this.panelPlanTrabajo.btnVolver == ae.getSource()) {
            try {
                VentanaProfesor vp = new VentanaProfesor(this.usuario);
                this.setVisible(false);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
