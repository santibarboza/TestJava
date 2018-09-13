package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import hello.Accion;

@RestController
public class OCRestController {

    @PostMapping("/compilarPost")
    public Accion compilarPost(@RequestBody BodyCompilado body) {
    	return new AccionImp("OK","Codigo Compilado esta Aqui");
    }
    @RequestMapping("/compilar")
    public List<Accion> compilar(@RequestParam(value="id", defaultValue="World") String id) {
    	List<Accion> list= new ArrayList<Accion>();
    	list.add(new AccionImp("OK","El Programa Compilo Correctamente"));
    	list.add(new AccionImp("setID","128317293"));
    	return list;
    }

    @RequestMapping("/ejecutarPaso")
    public List<Accion> ejecutar(@RequestParam(value="id", defaultValue="World") String id) {
    	List<Accion> list= new ArrayList<Accion>();
    	list.add(new AccionImp("Error","Error 1"));
    	list.add(new AccionImp("Error","Error 2"));
    	return list;
    }

}
