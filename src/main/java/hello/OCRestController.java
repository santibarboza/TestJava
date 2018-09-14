package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.List;
import hello.Accion.*;




import java.util.Map;
import java.util.HashMap;

import presenter.*;
import view.*;



@RestController
public class OCRestController {

    @PostMapping("/compilarPost")
    public Accion compilarPost(@RequestBody BodyCompilado body) {
    	return new AccionImp("OK","Codigo Compilado esta Aqui");
    }
    @RequestMapping("/mapeo")
    public Map<Integer,String> mapeo(@RequestParam(value="id", defaultValue="World") String id) {
        Map<Integer,String> map= new  HashMap<Integer,String>();
        map.put(123, "hola");
        map.put(3, "chau");
        map.put(4, "chsaa");
    	return map;
    }

    @RequestMapping("/compilar")
    public List<Accion> compilar(@RequestParam(value="id", defaultValue="World") String id) {
        Map<Integer,String> map= new  HashMap<Integer,String>();
        map.put(123, "hola");
        map.put(3, "chau");
        map.put(4, "chsaa");

        List<Accion> list= new ArrayList<Accion>();
        list.add(new AccionImp("OK","El Programa Compilo Correctamente"));
        list.add(new AccionImp("setID","128317293"));
        list.add(new AccionCambio("setID",map));
        return list;
    }
    @RequestMapping("/ejecutarPaso")
    public List<Accion> ejecutar(@RequestParam(value="id", defaultValue="World") String id) {
        List<Accion> list= new ArrayList<Accion>();
        list.add(new AccionImp("Error","Error 1"));
        list.add(new AccionImp("Error","Error 2"));
        return list;
    }

    @RequestMapping("/test1")
    public List<Accion> test1(@RequestParam(value="id", defaultValue="111") String id) {
        OCPresenter presenter = OCPresenterServerModule.getInstance().startApplication();
        OCViewServer view=OCPresenterServerModule.getInstance().getOCView();
        presenter.updatePCView("PCViejo");
        presenter.updatePCView("PCNuevo");
        presenter.updateLogs("LogNuevo");
        return obtenerAcciones(view,id);
    }
    @PostMapping("/test2")
    public BodyCompilado test2(@RequestBody BodyCompilado body) {
        return body;
    }

    @RequestMapping("/test3")
    public BodyCompilado test3(@RequestParam(value="id", defaultValue="111") String id) {
        return new BodyCompilado("0E", "Codigo Milagroso");
    }

    @PostMapping("/test4")
    public BodyCompilado test4(@ModelAttribute BodyCompilado body) {
        return body;
    }
    @PostMapping("/test5")
    public String test5(@RequestBody String body) {
        return body;
    }
    private List<Accion> obtenerAcciones(OCViewServer view, String id){
        List<Accion> list =view.obtenerAcciones();
        list.add(new AccionImp("setID",id));
        return list;
    }

}
