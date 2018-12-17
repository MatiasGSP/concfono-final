package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import datosUsuario.Usuario;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

public class PanelIndicadores extends JPanel{

    private JLabel lblIndicador;
    public JButton btnVolver;
    private final ImageIcon imgVolver = new ImageIcon("src/main/java/imagenPanel/Volver_3.png");
    private final ImageIcon imgIndicador = new ImageIcon("src/main/java/imagenPanel/Indicadores.png");
    public JTable tabla;
    public DefaultTableModel modelo;

    public PanelIndicadores() {
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        this.setBackground(Color.PINK);
        this.setLayout(null);

        this.lblIndicador = new JLabel();
        this.lblIndicador.setBounds(200, 20, 100, 20);
        Icon icIndicador = new ImageIcon(this.imgIndicador.getImage().getScaledInstance(this.lblIndicador.getWidth(), this.lblIndicador.getHeight(), Image.SCALE_DEFAULT));
        this.lblIndicador.setIcon(icIndicador);
        add(this.lblIndicador);

        this.btnVolver = new JButton();
        this.btnVolver.setBounds(395, 20, 100, 30);
        this.btnVolver.setBorderPainted(false);
        Icon icVolver = new ImageIcon(this.imgVolver.getImage().getScaledInstance(this.btnVolver.getWidth(), this.btnVolver.getHeight(), Image.SCALE_DEFAULT));
        this.btnVolver.setIcon(icVolver);
        this.add(this.btnVolver);

        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("ALUMNO");
        this.modelo.addColumn("TIPO 1 (B / M)");
        this.modelo.addColumn("TIPO 2 (B / M)");
        this.modelo.addColumn("TIPO 3 (B / M)");
        this.tabla = new JTable(modelo);
        this.tabla.getTableHeader().setReorderingAllowed(false);
        JScrollPane scroll = new JScrollPane(this.tabla);
        scroll.setBounds(10, 60, 480, 400);
        scroll.setBackground(Color.WHITE);
        this.add(scroll);
    }
}
