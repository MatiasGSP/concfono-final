package datosUsuario;

import java.util.ArrayList;

public class Usuario {
    
	private String nombre;
	private String clave;
        public ArrayList<Alumno> alumnos;

	public Usuario(String nombre, String clave) {
            this.nombre=nombre;
            this.clave=clave;
            this.alumnos = new ArrayList<>();
	}
        
        public void agregarAlumno(Alumno alumno){
            alumnos.add(alumno);
        }
        
        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", clave=" + clave + ", alumnos=" + alumnos + '}';
    }

    
        
}