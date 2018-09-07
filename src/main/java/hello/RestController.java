package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/compilarPost")
    public Accion compilarPost(@RequestBody BodyCompilado body) {
    	return new Accion("OK","Codigo Compilado esta Aqui");
    }
    @RequestMapping("/compilar")
    public List<Accion> compilar(@RequestParam(value="id", defaultValue="World") String id) {
    	List<Accion> list= new ArrayList<Accion>();
    	//list.add(new Accion("Error","Error Lexico: BlaBlaBla"));
    	list.add(new Accion("OK","El Programa Compilo Correctamente"));
    	list.add(new Accion("setID","128317293"));
    	return list;
    }

    @RequestMapping("/ejecutarPaso")
    public List<Accion> ejecutar(@RequestParam(value="id", defaultValue="World") String id) {
    	List<Accion> list= new ArrayList<Accion>();
    	list.add(new Accion("Error","Error 1"));
    	list.add(new Accion("Error","Error 2"));
    	return list;
    }

}
