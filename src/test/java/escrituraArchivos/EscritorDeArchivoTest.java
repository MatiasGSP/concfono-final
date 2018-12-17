/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

import java.io.IOException;
import static java.util.Arrays.deepEquals;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carme
 */
public class EscritorDeArchivoTest {
    
    @Test
    public void archivoTest() throws IOException{
        EscritorDeArchivo eda = new EscritorDeArchivo("rutatest");
        eda.crearArchivoTexto();
        eda.escribir("LINEA PARA TESTEO");
        LectorArchivo lector = new LectorArchivo("rutatest");
        String[] obtenidoArr = lector.leerArchivo();
        String[] esperadoArr = new String[1];
        esperadoArr[0] = "LINEA PARA TESTEO";
        boolean esperado = true;
        boolean obtenido = false;
        if(deepEquals(esperadoArr,obtenidoArr)==true)
            obtenido = true;
        assertEquals(esperado,obtenido);
        
    }
}
