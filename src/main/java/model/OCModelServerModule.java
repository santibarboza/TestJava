package model;

import ogradle.*;
import model.Analizadores.AnalizadorLexico;
import model.Analizadores.AnalizadorLexicoImpl;
import model.Analizadores.AnalizadorSintacticoySemantico;
import model.Analizadores.AnalizadorSintacticoySemanticoImpl;
import model.Analizadores.ReglasImpl;
import model.Archivos.ArchivoAbstractFactory;
import model.Archivos.ArchivoConcreteFactory;
import model.Ejecucion.Ejecucion;
import model.Ejecucion.EjecucionImpl;
import model.Mapeo.MapFactoryImpl;
import model.RepresentacionMemoria.Memoria;
import model.RepresentacionMemoria.MemoriaImpl;
import model.RepresentacionMemoria.RepresentacionDeLaMemoria;
import model.RepresentacionMemoria.RepresentacionDeLaMemoriaImpl;
import model.RepresentacionMemoria.TabladeEtiquetas;
import model.RepresentacionMemoria.TabladeEtiquetasImpl;

public class OCModelServerModule {
	private static OCModelServerModule instance;
	  private OCModel ocModel;
	  private Memoria memoria;

	  private OCModelServerModule() {
		memoria=new MemoriaImpl(new MapFactoryImpl<Integer,String>());
		TabladeEtiquetas tablaDeEtiquetas=new TabladeEtiquetasImpl();
		AnalizadorLexico analizadorLexico= new AnalizadorLexicoImpl(ReglasImpl.getInstance());
		RepresentacionDeLaMemoria representacion= 
		  new RepresentacionDeLaMemoriaImpl(memoria,tablaDeEtiquetas);
		AnalizadorSintacticoySemantico analizadorSintacticoySemantico=
				new AnalizadorSintacticoySemanticoImpl(analizadorLexico,representacion);
		ArchivoAbstractFactory archivosFactory= new ArchivoConcreteFactory();
		Ejecucion ejecucion=new EjecucionImpl(memoria);
	    ocModel =  new OCModelImpl(analizadorLexico,
	    		analizadorSintacticoySemantico,archivosFactory,ejecucion);
	    ejecucion.setModel(ocModel);
	  }

	  public static OCModelServerModule getInstance() {
	    if(instance == null) {
	      instance =  new OCModelServerModule();
	    }
	    return instance;
	  }

	  public OCModel getOCModel() {
	    return ocModel;
	  }
	  public  Memoria getMemoria(){
	  	return memoria;
	  }

}
