/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosUsuario;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carme
 */
public class AlumnoTest {
    
    @Test
    public void comprobarActividadesTest(){
        Usuario user = new Usuario("user","pass");
        Alumno alumno = new Alumno("Fulanito");
        user.agregarAlumno(alumno);
        boolean esperado = true;                        
        boolean obtenido = !(user.alumnos.get(0).comprobarPlanTrabajo());           /// el alumno no tiene plan de trabajo, por ende el método comprobarPlanTrabajo debe retornar falso.
        assertEquals(esperado,obtenido);
    }
    
}
