/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Matias
 */
public class EscritorDeArchivo {
        
        private String ruta;
        private boolean añadir_a_archivo = false;   /// atributo que podemos agregar al constructor de FileWriter para adjuntar el texto agregado al ya existente, sin sobreescribir nada. Por defecto será false, lo que significa que FileWriter sobreescribirá el archivo de texto.
        
        public EscritorDeArchivo(String rutaDeArchivo){
            this.ruta=rutaDeArchivo;
        }

        public EscritorDeArchivo(String rutaDeArchivo, boolean añadir_a_archivo){
            this.ruta=rutaDeArchivo;
            this.añadir_a_archivo=añadir_a_archivo;
        }
        
        public void escribir(String texto) throws IOException{                          /// escribe una linea nueva, cambiando de fila al terminar el texto.
                FileWriter fw = new FileWriter(this.ruta, this.añadir_a_archivo);
                PrintWriter escritor = new PrintWriter(fw);
                escritor.printf("%s" + "%n", texto);
                escritor.close();
        }
        

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
        
    public void crearArchivoTexto() throws IOException{                     /// método usado al crear un Usuario. Este método se ejecuta junto a la creación del User, y, junto con el método escribir() agregan los datos de usuario a su archivo de texto.
                FileWriter fw = new FileWriter(this.ruta, true);
                PrintWriter creador = new PrintWriter(fw);
                creador.printf("");
                creador.close();
    }
}
