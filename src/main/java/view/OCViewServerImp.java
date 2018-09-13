package view;

import java.io.File;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import hello.Accion.*;

public class OCViewServerImp implements OCViewServer{
	protected List <Accion> accionesActuales;
	protected String contenidoActual;

	public OCViewServerImp(){
		accionesActuales= new ArrayList<Accion>();		
	}
	public void updateTextoTutorial(String texto){
		accionesActuales.add(new AccionImp("Mostrar",texto));
	}
	public void updateContenidoArchivoActual(String contenido){
		contenidoActual=contenido;
	}
	public void updateCodigoCompilado(String codigo){
		accionesActuales.add(new AccionImp("Compilado",codigo));		
	}
	public void updateRegistros(Map<Integer,String> registros){
		accionesActuales.add(new AccionCambio("updateRegistros",registros));	
	}
	public void updateMemoria(Map<Integer,String> memoria){
		accionesActuales.add(new AccionCambio("updateMemoria",memoria));	
	}
	public void updatePCView(String pc){
		accionesActuales.add(new AccionImp("SetPC",pc));		
	}
	public void updateLogs(String log){
		accionesActuales.add(new AccionImp("UpdateLogs",log));
	}
	public void mostrarMensaje(String mensaje){
		accionesActuales.add(new AccionImp("Mostrar",mensaje));		
	}
	public List<Accion> obtenerAcciones(){
		List<Accion> retornar=accionesActuales;
		accionesActuales= new ArrayList<Accion>();
		return retornar;	
	}

	public void updateNombreArchivo(String fileName){}
	public void updateInstrucionView(String instruccion){}
	public String pedirDialogo(String pedido){return "";}
	public boolean pedirAbrirArchivo(){return true;}
	public boolean guardarArchivo(){return true;}
	public File recuperarArchivo(){return null;}
	public void habilitarOpcionesdeEjecucion(){}
	public void habilitarOpcionesdeEjecucionPasoaPaso(){}
	public void deshabilitarOpcionesdeEjecucionPasoaPaso(){}
	public void habilitarGuardarPanel(){}
	public void deshabilitarGuardarPanel(){}
	public void habilitarOpcionesdeCompilacion(){}
	public void mostrarMemoria(){}
	public void mostrarAyuda(){}

}
