package view;

import javax.swing.JFrame;
import presenter.OCPresenter;


public class OCViewServerModule {
	  private static OCViewServerModule instance;

	  private OCViewServerModule() { }

	  public static OCViewServerModule getInstance() {
	    if (instance == null) {
	      instance = new OCViewServerModule();
	    }
	    return instance;
	  }

	  public OCView openOCWindow(OCPresenter ocPresenter) {
	    OCViewServerImpl ocView = new OCViewServerImpl(ocPresenter);
	    return ocView;
	  }
}
