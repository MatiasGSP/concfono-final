package vista;

import javax.swing.JFrame;

public class VentanaInicial extends JFrame {

    public PanelInicial panelIni;
    public PanelCreacionUsuario panelCreacionUsu;

    public VentanaInicial() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        this.panelIni = new PanelInicial();
        this.add(this.panelIni);

        this.setSize(800, 500);
        this.setTitle("Fonoaudiologia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(VentanaInicial.this);
        this.setResizable(false);
        this.setVisible(true);
    }
}