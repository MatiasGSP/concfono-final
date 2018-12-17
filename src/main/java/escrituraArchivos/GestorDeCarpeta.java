/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escrituraArchivos;

import datosUsuario.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logica.Actividad;
import logica.ActividadTipo1;
import logica.ActividadTipo2;
import logica.ActividadTipo3;

/**
 *
 * @author Matias
 */
public class GestorDeCarpeta {
    
    public static String separador;
    public static String ruta;
    
    public GestorDeCarpeta() throws IOException{           /// crea las carpetas iniciales para el funcionamiento del programa, las que contienen los archivos .txt
        
        String path_usuario = System.getProperty("user.home");   /// nos da el directorio de la carpeta "profile" del usuario que ejecuta el programa   
        this.separador = System.getProperty("file.separator");   /// detecta el caracter del separador que usa el respectivo OS.
        String path=path_usuario+this.separador+"concienciafonologica";
        this.ruta=path;
        new File(path).mkdirs();           ///   el comando File(String pathfile).mkdirs() crea la carpeta de directorio pathfile, pero si esta existe NO la reemplaza. Perfecta para inicializar los archivos que el software usará para la permanencia de datos
        new File(path+this.separador+"datos").mkdirs();
        path=path+this.separador+"actividades";
        new File(path).mkdirs();
        this.crearArchivoUsuarios();
        this.inicializarArchivoActividad1();
        this.inicializarArchivoActividad2();
        this.inicializarArchivoActividad3();
        Usuario user = new Usuario("user","pass");
        GestorDeCarpeta.agregarUsuario(user);
//        new File(path+this.separador+"tipo1").mkdirs();
//        new File(path+this.separador+"tipo2").mkdirs();
//        new File(path+this.separador+"tipo3").mkdirs();
        
    }
    
    public boolean comprobarUsuario(Usuario usuario) throws IOException {   /// comprueba el nombre de la carpeta (por ende, el nombre de usuario).
        String[] usuarios; boolean respuesta = false;
        String ruta = this.ruta+this.separador+"usuario.txt";         /// todos los datos "recordados" por el software serán leídos desde archivos de texto. En el caso de los usuarios, la información será guardada en archivos de texto que por nombre tendrá el "nombre" del Usuario (en formato "nombre".txt), dentro del folder "usuarios" que el software generará luego de incializarse.
        LectorArchivo lector = new LectorArchivo(ruta);
        usuarios = lector.leerArchivo();
        for(int i=0; i < usuarios.length ; i++){
            if(usuario.getNombre().equals(usuarios[i]) && usuario.getClave().equals(usuarios[i+1]))
            respuesta = true;
        }
        return respuesta;     
        }
    
    
//    public boolean comprobarNombre(Usuario usuario){   /// comprueba el nombre de la carpeta (por ende, el nombre de usuario).
//        String ruta = this.ruta+this.separador+"usuarios"+this.separador+usuario.getNombre()+".txt";         /// todos los datos "recordados" por el software serán leídos desde archivos de texto. En el caso de los usuarios, la información será guardada en archivos de texto que por nombre tendrá el "nombre" del Usuario (en formato "nombre".txt), dentro del folder "usuarios" que el software generará luego de incializarse.
//        File textfile = new File(ruta);
//        if(textfile.isFile() && !textfile.isDirectory()) { 
//            return false;
//        }else{
//            return true;
//        }
//    }
    
//    public void crearArchivoUsuario(Usuario usuario) throws IOException{    /// crea el archivo "usuario".txt, para el usuario ingresado, en concienciafonologica/usuarios/.
//        String ruta = this.ruta+this.separador+"usuarios"+this.separador+usuario.getNombre()+".txt";
//        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
//        escritor.crearArchivoTexto();
//        escritor.escribir(usuario.getNombre());             /// en la primera fila, agrega el nombre de usuario
//        escritor.escribir(usuario.getClave());              /// en la segunda fila, la clave
//    }
    
    public boolean crearArchivoUsuarios() throws IOException{
        boolean respuesta = false;
        String ruta = this.ruta+this.separador+"usuario.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        try{
            escritor.crearArchivoTexto();
            respuesta = true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    
    public static boolean agregarUsuario(Usuario usuario) throws IOException{
        boolean proceso = true;
        String ruta = GestorDeCarpeta.ruta+GestorDeCarpeta.separador+"usuario.txt";
        LectorArchivo lector = new LectorArchivo(ruta);
        String[] usuarios = lector.leerArchivo();
        for(String s: usuarios){
            if(s.equals(usuario.getNombre()))
                proceso=false;
        }
        if(proceso){
            EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
            escritor.escribir(usuario.getNombre());
            escritor.escribir(usuario.getClave());
        }
        return proceso;
    }
    
//    public ArrayList<Usuario> leerUsuarios() throws IOException{                                  /// método nos otorga ArrayList de los usuarios guardados en la ruta concienciafonologica/usuarios.
//        String[] textoArchivo; Usuario userAux;
//        ArrayList<Usuario> usuariosFinal = new ArrayList<Usuario>();
//        String ruta = this.ruta+this.separador+"usuario.txt";
//        LectorArchivo lector = new LectorArchivo(ruta);
//        textoArchivo = lector.leerArchivo();
//        for(int i=0;i<textoArchivo.length;i++){
//               userAux = new Usuario(textoArchivo[i],textoArchivo[i+1]);
//               usuariosFinal.add(userAux); 
//               i++;
//           } 
//        return usuariosFinal;
//    }
    
//     public ArrayList<Usuario> leerUsuarios() throws IOException{                                  /// método nos otorga ArrayList de los usuarios guardados en la ruta concienciafonologica/usuarios.
//        String user; String pass; String rutaAux; String[] textoArchivo; Usuario userAux;
//        ArrayList<Usuario> usuariosFinal = new ArrayList<Usuario>();
//        String ruta = this.ruta+this.separador+"usuarios";
//        File usuarios = new File(ruta);
//        File[] listaUsuarios = usuarios.listFiles();
//        for(int i=0;i<listaUsuarios.length;i++){
//           if(listaUsuarios[i].isFile()){
//               rutaAux=ruta+this.separador+listaUsuarios[i].getName();
//               textoArchivo=leerTextoUsuario(rutaAux);
//               userAux = new Usuario(textoArchivo[0],textoArchivo[1]);
//               usuariosFinal.add(userAux); 
//           } 
//        }
//        return usuariosFinal;
//    }
    
//    public void inicializarArchivoActividad1(ActividadTipo1 act) throws IOException{   /// crea archivos .txt para las actividades en concienciafonologica/actividades/actividadtipo1/
//        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo1"+this.separador+act.getTitulo()+".txt";
//        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
//        escritor.crearArchivoTexto();
//        escritor.escribir(act.getTitulo());                                         /// para todas las actividades, en la primera fila, agrega el título
//        escritor.escribir(act.getEnunciado());                                          /// en la segunda, el enunciado
//        escritor.escribir(Integer.toString(act.getRespuestaCorrecta()));                //  en la tercera, la respuesta correcta.
//    }
//    
    
    public void inicializarArchivoActividad1() throws IOException{   /// crea archivos .txt para las actividades en concienciafonologica/actividades/actividadtipo1/
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo1.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.crearArchivoTexto();
    }
    
    public void agregarAct1(ActividadTipo1 act) throws IOException{
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo1.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.escribir(act.getTitulo());                                         
        escritor.escribir(act.getEnunciado());                                         
        escritor.escribir(Integer.toString(act.getRespuestaCorrecta())); 
    }
        
//    public void inicializarArchivoActividad2(ActividadTipo2 act) throws IOException{    
//        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo2"+this.separador+act.getTitulo()+".txt";
//        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
//        escritor.crearArchivoTexto();
//        escritor.escribir(act.getTitulo());
//        escritor.escribir(act.getEnunciado());
//        escritor.escribir(act.getRespuestaCorrecta());
//        
//    }
    
    public void inicializarArchivoActividad2() throws IOException{    
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo2.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.crearArchivoTexto();  
    }
    
    public void agregarAct2(ActividadTipo2 act) throws IOException{
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo2.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.escribir(act.getTitulo());
        escritor.escribir(act.getEnunciado());
        escritor.escribir(act.getRespuestaCorrecta());
    }
        
//    public void inicializarArchivoActividad3(ActividadTipo3 act) throws IOException{    
//        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo3"+this.separador+act.getTitulo()+".txt";
//        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
//        escritor.crearArchivoTexto();
//        escritor.escribir(act.getTitulo());
//        escritor.escribir(act.getEnunciado());
//        for(int i=0;i<act.getRespuestaCorrecta().length;i++){
//            escritor.escribir(act.getRespuestaCorrecta()[i]+" ");
//       
//    }
//    }
    
    public void inicializarArchivoActividad3() throws IOException{    
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo3.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.crearArchivoTexto();
    }
    
    public void agregarAct3(ActividadTipo3 act) throws IOException{
        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo3.txt";
        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
        escritor.escribir(act.getTitulo());
        escritor.escribir(act.getEnunciado());
        escritor.escribir(Integer.toString(act.getRespuestaCorrecta().length));
        for(int i=0;i<act.getRespuestaCorrecta().length;i++){
            escritor.escribir(act.getRespuestaCorrecta()[i]);   
    }
    }
    
//    public void agregarTexto(Usuario usuario, String texto) throws IOException{    /// agrega una linea de texto al textfile usuario.getNombre().txt.
//        String ruta = this.ruta+this.separador+"usuarios"+this.separador+usuario.getNombre()+".txt";
//        EscritorDeArchivo escritor = new EscritorDeArchivo(ruta, true);
//        escritor.escribir(texto);               
//    }
    
//    public String[] leerTextoUsuario(Usuario usuario) throws IOException{
//        String ruta = this.ruta+this.separador+"usuarios"+this.separador+usuario.getNombre()+".txt";
//        LectorArchivo lector = new LectorArchivo(ruta);
//        return lector.leerArchivo();
//        
//    }
    
    public String[] leerTextoUsuario(String ruta) throws IOException{
        LectorArchivo lector = new LectorArchivo(ruta);
        return lector.leerArchivo();
        
    }

    
//    public ArrayList<ActividadTipo1> leerActividadesTipo1() throws IOException{                 /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo1.
//        String titulo; String enunciado; String rutaAux; String[] textoArchivo; ActividadTipo1 actAux;
//        ArrayList<ActividadTipo1> actividades1Final = new ArrayList<ActividadTipo1>();
//        String ruta = this.ruta+this.separador+"usuarios";
//        File actividadesTipo1 = new File(ruta);
//        File[] listaActividades = actividadesTipo1.listFiles();
//        for(int i=0;i<listaActividades.length;i++){
//           if(listaActividades[i].isFile()){
//               rutaAux=ruta+this.separador+listaActividades[i].getName();
//               textoArchivo=leerTextoUsuario(rutaAux);
//               actAux = new ActividadTipo1(textoArchivo[0],textoArchivo[1],Integer.parseInt(textoArchivo[2]));          /// crea una actividad tipo 1 con String titulo, String enunciado e int respuestaCorrecta.
//               actividades1Final.add(actAux);   
//           } 
//        }
//        return actividades1Final;
//    }
    
    public static  ArrayList<ActividadTipo1> leerActTipo1() throws IOException{                             /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo2.
        String[] textoArchivo; ActividadTipo1 actAux;
        ArrayList<ActividadTipo1> actividades1Final = new ArrayList<ActividadTipo1>();
//        String ruta = this.ruta+this.separador+"actividades"+this.separador+"tipo1.txt";
        LectorArchivo lector = new LectorArchivo(GestorDeCarpeta.ruta+GestorDeCarpeta.separador+"actividades"+GestorDeCarpeta.separador+"tipo1.txt");
        textoArchivo = lector.leerArchivo();
        for(int i=0;i<textoArchivo.length;i++){
           if(i%3==0){
               actAux = new ActividadTipo1(textoArchivo[i],textoArchivo[i+1], Integer.parseInt(textoArchivo[i+2]));   /// crea una actividad tipo 2 con String titulo, String enunciado y String respuestaCorrecta.
               actividades1Final.add(actAux); 
           } 
        }
        return actividades1Final;
    }
    
    
//    public ArrayList<ActividadTipo2> leerActividadesTipo2() throws IOException{                             /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo2.
//        String titulo; String enunciado; String rutaAux; String[] textoArchivo; ActividadTipo2 actAux;
//        ArrayList<ActividadTipo2> actividades2Final = new ArrayList<ActividadTipo2>();
//        String ruta = this.ruta+this.separador+"usuarios";
//        File actividadesTipo2 = new File(ruta);
//        File[] listaActividades = actividadesTipo2.listFiles();
//        for(int i=0;i<listaActividades.length;i++){
//           if(listaActividades[i].isFile()){
//               rutaAux=ruta+this.separador+listaActividades[i].getName();
//               textoArchivo=leerTextoUsuario(rutaAux);
//               actAux = new ActividadTipo2(textoArchivo[0],textoArchivo[1], textoArchivo[2]);   /// crea una actividad tipo 2 con String titulo, String enunciado y String respuestaCorrecta.
//               actividades2Final.add(actAux); 
//           } 
//        }
//        return actividades2Final;
//    }
    
    public static ArrayList<ActividadTipo2> leerActTipo2() throws IOException{                             /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo2.
        String[] textoArchivo; ActividadTipo2 actAux;
        ArrayList<ActividadTipo2> actividades2Final = new ArrayList<>();
        String ruta = GestorDeCarpeta.ruta+GestorDeCarpeta.separador+"actividades"+GestorDeCarpeta.separador+"tipo2.txt";
        LectorArchivo lector = new LectorArchivo(ruta);
        textoArchivo = lector.leerArchivo();
        for(int i=0;i<textoArchivo.length;i++){
           if(i%3==0){
               actAux = new ActividadTipo2(textoArchivo[i],textoArchivo[i+1], textoArchivo[i+2]);   /// crea una actividad tipo 2 con String titulo, String enunciado y String respuestaCorrecta.
               actividades2Final.add(actAux); 
           } 
        }
        return actividades2Final;
    }
    
//    public ArrayList<ActividadTipo3> leerActividadesTipo3() throws IOException{                                                             /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo3.
//        String titulo; String enunciado; String rutaAux; String[] textoArchivo; String[] resultadoAct; ActividadTipo3 actAux;
//        ArrayList<ActividadTipo3> actividades3Final = new ArrayList<>();
//        String ruta = this.ruta+this.separador+"usuarios";
//        File actividadesTipo3 = new File(ruta);
//        File[] listaActividades = actividadesTipo3.listFiles();
//        for(int i=0;i<listaActividades.length;i++){
//           if(listaActividades[i].isFile()){
//               rutaAux=ruta+this.separador+listaActividades[i].getName();
//               textoArchivo=leerTextoUsuario(rutaAux);
//               resultadoAct= new String[textoArchivo.length-2];                 /// las lineas de la respuesta (o sea, lo que va en el arreglo de Strings) siempre serán 2 menos que las del archivo total. Se restan el enunciado y el titulo.
//               for(i=0;i<textoArchivo.length-2;i++){
//                   resultadoAct[i]=textoArchivo[i+2];
//               }
//               actAux = new ActividadTipo3(textoArchivo[0],textoArchivo[1],resultadoAct);       /// crea una actividad tipo 3 con String titulo, String enunciado y String[] respuestaCorrecta.
//               actividades3Final.add(actAux); 
//           } 
//        }
//        return actividades3Final;
//    }
    
    public static ArrayList<ActividadTipo3> leerActTipo3() throws IOException{                             /// método nos otorga ArrayList de las actividades guardadas en la ruta concienciafonologica/actividades/tipo2.
        String[] textoArchivo; ActividadTipo3 actAux; int nroRespuestas; String[] respuestas;
        ArrayList<ActividadTipo3> actividades3Final = new ArrayList<>();
        String ruta = GestorDeCarpeta.ruta+GestorDeCarpeta.separador+"actividades"+GestorDeCarpeta.separador+"tipo3.txt";
        LectorArchivo lector = new LectorArchivo(ruta);
        textoArchivo = lector.leerArchivo();
        for(int i=0;i<textoArchivo.length;i++){
               nroRespuestas = Integer.parseInt(textoArchivo[i+2]); 
               respuestas = new String[nroRespuestas];
               for(int j=0;j<nroRespuestas;j++){
                   respuestas[j] = textoArchivo[i+3+j];
               }
               actAux = new ActividadTipo3(textoArchivo[i],textoArchivo[i+1], respuestas);   /// crea una actividad tipo 2 con String titulo, String enunciado y String respuestaCorrecta.
               actividades3Final.add(actAux);
               i= i + nroRespuestas + 2 ;
           } 
        
        return actividades3Final;
    }
}