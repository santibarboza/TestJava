package presenter;

import model.*;
import view.*;

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
	  public static Memoria getMemoria(){
	  	return OCModelServerModule.getInstance().getMemoria();
	  }

}
