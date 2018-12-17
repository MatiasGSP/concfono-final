package logica;

public class ActividadTipo1 extends Actividad {
	private int respuestaCorrecta;

	public ActividadTipo1() {
            super();
            this.respuestaCorrecta=0;
            
	}
        
        public ActividadTipo1(String titulo, String enunciado, int respuestaCorrecta) {
            super(titulo, enunciado);
            this.respuestaCorrecta=respuestaCorrecta;
            
	}

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

	public void inicializarActividad() {
		throw new UnsupportedOperationException();
	}

	public boolean comprobarRespuesta(int respuestaUsuario) {
		if(respuestaUsuario==this.respuestaCorrecta){
                    return true;
                }else{
                    return false;
                }
	}

    @Override
    public String toString() {
        return "ActividadTipo1{" + "respuestaCorrecta=" + respuestaCorrecta + '}';
    }
        
        
}