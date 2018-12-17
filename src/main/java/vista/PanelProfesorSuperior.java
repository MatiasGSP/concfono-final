package vista;

import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PanelProfesorSuperior extends JMenuBar {

    private JMenu menuAyuda, menuArchivo;
    public JMenuItem itPlanTrabajo, itIndicadores, itIngresarAlumno, itCrearActividad;
    public JMenuItem itCrearCuenta, itAyuda, itVolver, itSalir;

    public PanelProfesorSuperior() {
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setBackground(Color.WHITE);
        this.menuArchivo = new JMenu("Archivo");
        this.itPlanTrabajo = new JMenuItem("Crear plan de trabajo");
//        this.itIndicadores = new JMenuItem("Ver indicadores");
        this.itIngresarAlumno = new JMenuItem("Ingresar alumno");
        this.itCrearActividad = new JMenuItem("Crear actividad");

        this.menuAyuda = new JMenu("Ayuda");
        this.itCrearCuenta = new JMenuItem("Crear cuenta");
        this.itAyuda = new JMenuItem("Ayuda");
        this.itVolver = new JMenuItem("Cerrar sesion");
        this.itSalir = new JMenuItem("Salir");

        this.menuArchivo.add(this.itPlanTrabajo);
//        this.menuArchivo.add(this.itIndicadores);
        this.menuArchivo.add(this.itIngresarAlumno);
        this.menuArchivo.add(this.itCrearActividad);
        this.menuAyuda.add(this.itCrearCuenta);
        this.menuAyuda.add(this.itAyuda);
        this.menuAyuda.add(this.itVolver);
        this.menuAyuda.add(this.itSalir);

        this.add(this.menuArchivo);
        this.add(this.menuAyuda);
    }
}
