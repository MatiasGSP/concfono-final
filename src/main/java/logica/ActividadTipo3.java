package logica;

import java.util.Arrays;

public class ActividadTipo3 extends Actividad {
	private String[] respuestaCorrecta;

	public ActividadTipo3() {
            super();
	}
        
        public ActividadTipo3(String titulo, String enunciado, String[] respuestaCorrecta) {
            super(titulo, enunciado);
            this.respuestaCorrecta=respuestaCorrecta;   
	}

    public String[] getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String[] respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }
        
	public void inicializarActividad() {
		throw new UnsupportedOperationException();
	}

	public boolean comprobarRespuesta(String[] respuestaUsuario) {
		if(respuestaCorrecta==respuestaUsuario){
                    return true;
                }else{
                    return false;
                }
	}

    @Override
    public String toString() {
        return "ActividadTipo3{" + "respuestaCorrecta=" + respuestaCorrecta + '}';
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
        final ActividadTipo3 other = (ActividadTipo3) obj;
        if (!Arrays.deepEquals(this.respuestaCorrecta, other.respuestaCorrecta)) {
            return false;
        }
        return true;
    }

        
}