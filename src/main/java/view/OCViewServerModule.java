package view;

import presenter.OCPresenter;


public class OCViewServerModule {
	  private static OCViewServerModule instance;
	  private OCViewServer ocView ;

	  private OCViewServerModule() { }

	  public static OCViewServerModule getInstance() {
	    if (instance == null) {
	      instance = new OCViewServerModule();
	    }
	    return instance;9
	  }

	  public OCView openOCWindow(OCPresenter ocPresenter) {
	    ocView= new OCViewServerImp(ocPresenter);
	    return ocView;
	  }
	  public  OCViewServer getOCView(){
	  	return ocView; 
	  }
}
