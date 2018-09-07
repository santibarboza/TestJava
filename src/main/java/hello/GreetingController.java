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
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/compilar")
    public Accion compilar(@RequestBody BodyCompilado body) {
    	return new Accion("OK","Codigo Compilado esta Aqui");
    }
     @RequestMapping("/compilar")
    public List<Accion> compilar(@RequestParam(value="name", defaultValue="World") String name) {
    	List<Accion> list= new ArrayList<Accion>();
    	list.add(new Accion("Error","Error 1"));
    	list.add(new Accion("Error","Error 2"));
    	return list;
    }

   //	@PostMapping("/compilar")
	//public Greeting newEmployee(@RequestBody Employee newEmployee) {
//		return new Greeting(1,"compilar");
//	}
//	@RequestMapping("/")
  //  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //    return new Greeting(counter.incrementAndGet(),"Hola niño");
    //}

}
