/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

/**
 *
 * @author Matias
 */
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class LectorArchivo {
    
    private String ruta;
    
    public LectorArchivo(String rutaArchivo){
        this.ruta=rutaArchivo;
    }
    
    public String[] leerArchivo() throws IOException{      /// nos devuelve un arreglo de Strings, donde cada elemento del arreglo es una fila del archivo de texto.
        FileReader fr = new FileReader(this.ruta);          
        BufferedReader lector = new BufferedReader(fr);
        
        int nroLineas = contarLineas();         
        String[] texto = new String[nroLineas];         /// se usa el método contarLineas() para determinar el largo del arreglo.
        
        for(int i=0;i<nroLineas;i++){
            texto[i]=lector.readLine();
        }
        
        lector.close();
        return texto;
    }
    
    public int contarLineas() throws IOException{
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        
        String linea;
        int nroLineas=0;
        
        while((linea=br.readLine())!=null){
            nroLineas++;
        }
        br.close();
        return nroLineas;
    }
    
    
    
}
