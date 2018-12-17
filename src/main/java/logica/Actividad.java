/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Matias
 */
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Matias
 */
public class Actividad {
    
    private String titulo;
    private String enunciado;

public Actividad(){     
    this.enunciado="";
    this.titulo="";  
}

public Actividad(String titulo, String enunciado){     
    this.enunciado=enunciado;
    this.titulo=titulo;   
}

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Actividad{" + "titulo=" + titulo + ", enunciado=" + enunciado + '}';
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.enunciado, other.enunciado)) {
            return false;
        }
        return true;
    }


}
