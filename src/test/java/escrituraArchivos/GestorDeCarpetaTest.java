/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

import datosUsuario.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import logica.ActividadTipo3;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carme
 */
public class GestorDeCarpetaTest {
    
   
    @Test
    public void leerAct3Test() throws IOException{
        boolean obtenido = false;
        String titulo = "TROPICAL";
        String enunciado = "INGRESE LAS 3 SÍLABAS";
        String[] respuesta = new String[3];
        respuesta[0] = "tro";
        respuesta[1] = "pi";
        respuesta[2] = "cal";
        ActividadTipo3 act = new ActividadTipo3(titulo,enunciado,respuesta);
        GestorDeCarpeta gdc = new GestorDeCarpeta();
        gdc.agregarAct3(act);
        ArrayList<ActividadTipo3> actividades = new ArrayList<>();
        actividades = GestorDeCarpeta.leerActTipo3();
        for(ActividadTipo3 act3 : actividades){
            if(act3.equals(act))
                obtenido = true;
        }
        boolean esperado = true;
        assertEquals(esperado,obtenido);
    }
    
    @Test
    public void comprobarUsuarioTest() throws IOException{
        Usuario user = new Usuario("user","pass");
        GestorDeCarpeta gdc = new GestorDeCarpeta();
        boolean esperado = true;
        boolean obtenido = gdc.comprobarUsuario(user);
        assertEquals(esperado,obtenido);
    }
    
    
}
