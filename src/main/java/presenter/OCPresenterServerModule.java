package presenter;

import model.*;
import model.MemoriaMongo.*;
import view.*;
import model.RepresentacionMemoria.*;

public class OCPresenterServerModule {
	private static OCPresenterServerModule instance;

	  private OCPresenterServerModule() { }

	  public static OCPresenterServerModule getInstance() {
	    if (instance == null) {
	      instance = new OCPresenterServerModule();
	    }
	    return instance;
	  }
	  public OCPresenter  startApplication() {
	    OCPresenter presenter = getOCPresenter();
	    OCView view = openOCWindowAndGetView(presenter);
	    presenter.setEnableLog(true);
	    presenter.setOCView(view);
	    setPresenterToModel(presenter);
	    return presenter;
	  }
	  private OCPresenter getOCPresenter() {
	    return new OCPresenterImpl(OCModelServerModule.getInstance().getOCModel());
	  }
	  private OCView openOCWindowAndGetView(OCPresenter presenter) {
	    return OCViewServerModule.getInstance().openOCWindow(presenter);
	  }
	  private void setPresenterToModel(OCPresenter presenter) {
		  OCModelServerModule.getInstance().getOCModel().setOCPresenter(presenter);
	  }
	  public static MemoriaMongo getMemoriaMongo(String id){
	  	MemoriaMongoFactoryImp memoriafactory=new MemoriaMongoFactoryImp();
	  	Memoria memoria= OCModelServerModule.getInstance().getMemoria();
	  	return memoriafactory.iniciarMemoria(memoria,id);
	  }

	  public static OCViewServer getOCView(){
	  	return OCViewServerModule.getInstance().getOCView();
	  }

}
