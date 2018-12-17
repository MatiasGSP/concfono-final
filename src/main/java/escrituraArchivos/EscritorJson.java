/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datosUsuario.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias
 */
public class EscritorJson {
    
    private final static String ruta = System.getProperty("user.home")+GestorDeCarpeta.separador+"concienciafonologica"+GestorDeCarpeta.separador+"datos"+GestorDeCarpeta.separador;
    
    public EscritorJson(Usuario usuario) throws IOException{                                                                                                //// debe ser llamado con Usuario.getNombre() 
          final String rutaUser = ruta+usuario.getNombre()+".json";
          boolean iniciarArchivoUsuario;
//        this.usuario = usuario;
//        this.nombre = this.usuario.getNombre();
//        System.out.println(nombre);
////        ruta2 += GestorDeCarpeta.separador+"datos"+GestorDeCarpeta.separador+this.usuario.getNombre()+".json";
//        System.out.println(ruta1);
          File archivoUsuario = new File(rutaUser);
          if(!archivoUsuario.isFile())
              iniciarArchivoUsuario = archivoUsuario.createNewFile();
          }
          
      
    public boolean agregarDatosUsuario(Usuario usuario) throws IOException {
        
        final String rutaUser = ruta+usuario.getNombre()+".json";
        File archivoUsuario = new File(rutaUser);
        if(!archivoUsuario.isFile())
            archivoUsuario.createNewFile();
        boolean respuesta = false;
        Type listType = new TypeToken<Usuario>() {}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(usuario, listType);
        
        try (FileWriter file = new FileWriter(rutaUser)){
            
            file.write(json);
            respuesta = true;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return respuesta;
    }
    
    public static Usuario leerUsuario(Usuario usuario) {
        
        final String rutaUser = ruta+usuario.getNombre()+".json";
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rutaUser));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Usuario usuarioF = gson.fromJson(br, new TypeToken<Usuario>() {}.getType());
        if(usuarioF==null)
            usuarioF = usuario;
        return usuarioF;
    }
}
