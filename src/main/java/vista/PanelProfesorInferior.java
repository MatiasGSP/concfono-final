 package vista;

import datosUsuario.Alumno;
import datosUsuario.Usuario;
import escrituraArchivos.EscritorJson;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logica.Actividad;

public class PanelProfesorInferior extends JPanel {
    
    public JButton btnJugar, btnEliminar, btnLimpiar;
    private JLabel lblAlumnos;
    private final ImageIcon imgAlumnos = new ImageIcon("src/main/java/imagenPanel/Alumnos.png");
    private final ImageIcon imgJugar = new ImageIcon("src/main/java/imagenPanel/Jugar_1.png");
    private final ImageIcon imgLimpiar = new ImageIcon("src/main/java/imagenPanel/Limpiar_1.png");
    private final ImageIcon imgEliminar = new ImageIcon("src/main/java/imagenPanel/Eliminar.png");
    public JTable tabla;
    public DefaultTableModel modelo;
    private EscritorJson json;
    private String ruta;
    public Usuario usuario;
    public JComboBox alumnos;

    public PanelProfesorInferior(Usuario usuario) throws IOException {
 //       json = new EscritorJson(usuario);
        this.usuario = usuario;
        this.usuario = EscritorJson.leerUsuario(usuario);
 //       this.ruta = GestorDeCarpeta.ruta+GestorDeCarpeta.separador+"datos"+GestorDeCarpeta.separador+this.usuario.getNombre()+".json";
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        
        this.lblAlumnos = new JLabel();
        this.lblAlumnos.setBounds(200, 0, 100, 20);
        Icon icAlumnos = new ImageIcon(this.imgAlumnos.getImage().getScaledInstance(this.lblAlumnos.getWidth(), this.lblAlumnos.getHeight(), Image.SCALE_DEFAULT));
        this.lblAlumnos.setIcon(icAlumnos);
        add(this.lblAlumnos);

        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("ALUMNO");
        this.modelo.addColumn("ESTADO DEL PLAN DE TRABAJO");
        this.tabla = new JTable(modelo);

        for(int i=0;i<usuario.alumnos.size();i++){
            if(this.usuario.alumnos.get(i).comprobarPlanTrabajo()){
                Object[] fila = {this.usuario.alumnos.get(i).getNombre() , "Actividades pendientes"};
                this.modelo.addRow(fila);
            }else{
                Object[] fila = {this.usuario.alumnos.get(i).getNombre() , "Sin actividades pendientes"};
                this.modelo.addRow(fila);
            }
        }
        JScrollPane scroll = new JScrollPane(this.tabla);
        scroll.setBounds(10, 20, 470, 300);
        this.add(scroll);
        
        alumnos = new JComboBox();
        for(int i=0;i<usuario.alumnos.size();i++){
                this.alumnos.addItem(usuario.alumnos.get(i).getNombre());}
        this.alumnos.setBounds(175, 340, 150, 30);
        add(this.alumnos);
        
        this.btnJugar = new JButton();
        this.btnJugar.setBorderPainted(false);
        this.btnJugar.setBounds(50, 400, 100, 30);
        Icon icJugar = new ImageIcon(this.imgJugar.getImage().getScaledInstance(this.btnJugar.getWidth(), this.btnJugar.getHeight(), Image.SCALE_DEFAULT));
        this.btnJugar.setIcon(icJugar);
//        add(this.btnJugar);
        
        this.btnEliminar = new JButton();
        this.btnEliminar.setBorderPainted(false);
        this.btnEliminar.setBounds(200, 400, 100, 30);
        Icon icElimIcon = new ImageIcon(this.imgEliminar.getImage().getScaledInstance(this.btnEliminar.getWidth(), this.btnEliminar.getHeight(), Image.SCALE_DEFAULT));
        this.btnEliminar.setIcon(icElimIcon);
//        add(this.btnEliminar);
        
        this.btnLimpiar = new JButton();
        this.btnLimpiar.setBorderPainted(false);
        this.btnLimpiar.setBounds(350, 400, 100, 30);
        Icon icLimpiar = new ImageIcon(this.imgLimpiar.getImage().getScaledInstance(this.btnLimpiar.getWidth(), this.btnLimpiar.getHeight(), Image.SCALE_DEFAULT));
        this.btnLimpiar.setIcon(icLimpiar);
//        add(this.btnLimpiar);
    }
}