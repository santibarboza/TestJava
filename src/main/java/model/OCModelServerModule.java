package model;

import model.*;

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
