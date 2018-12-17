package logica;

public class ActividadTipo2 extends Actividad {
	private String respuestaCorrecta;

	public ActividadTipo2() {
            super();
            this.respuestaCorrecta="";
            
	}
        
        
	public ActividadTipo2(String titulo, String enunciado, String respuestaCorrecta) {
            super(titulo, enunciado);
            this.respuestaCorrecta=respuestaCorrecta;
            
	}

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

	public boolean comprobarRespuesta(String respuestaUsuario) {
		if(respuestaCorrecta==respuestaUsuario){
                    return true;
                }else{
                    return false;
                }
	}

    @Override
    public String toString() {
        return "ActividadTipo2{" + "respuestaCorrecta=" + respuestaCorrecta + '}';
    }
        
        

}