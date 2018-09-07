package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public BodyCompilado greeting(@RequestParam(value="name", defaultValue="World") String name) {
//        return new Greeting(counter.incrementAndGet(),"Hola niño");
    	return new BodyCompilado("FF","codigoFuente");
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
