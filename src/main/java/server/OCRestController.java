package server;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.List;
import server.Accion.*;


import java.util.Map;
import java.util.HashMap;

import presenter.*;
import view.*;
import model.MemoriaMongo.*;


@RestController
public class OCRestController {
    private OCPresenter presenter;
    private OCViewServer view;
    private MemoriaMongo memoriaMongo;

    @PostMapping("/compilar")
    public List<Accion> compilar(@RequestBody BodyCompilado body,@RequestParam(value="id", defaultValue="IdDefault") String idUsuario){
        idUsuario=obtenerID(idUsuario);
        iniciarAplicacion(idUsuario);
        realizarcompilacion(body);
        guardarMemoria();
        return obtenerAccionesRealizadas(idUsuario);
    }
    private String obtenerID(String id){
        if(esIDPorDefecto(id))
            return crearNuevaID();
        return id;
    }
    private boolean esIDPorDefecto(String idUsuario){
        return idUsuario.equals("IdDefault");
    }
    private String crearNuevaID(){
        return java.util.UUID.randomUUID().toString();
    }
    private void iniciarAplicacion(String idUsuario){
        iniciarPresenter();
        obtenerView();
        obtenerMemoriaMongo(idUsuario);
    }
    private void iniciarPresenter(){
        presenter = OCPresenterServerModule.getInstance().startApplication();
    }
    private void obtenerView(){
        view=OCPresenterServerModule.getInstance().getOCView();
    }
    private void obtenerMemoriaMongo(String idUsuario){
        memoriaMongo = OCPresenterServerModule.getMemoriaMongo(idUsuario);
    }
    private void realizarcompilacion(BodyCompilado body){
        presenter.onEventCompilar(body.getCodigoFuente(),body.getDireccionInicio());  
    }
    private void guardarMemoria(){
        memoriaMongo.guardarMemoria(); 
    }
    private List<Accion> obtenerAccionesRealizadas(String idUsuario){
        return view.obtenerAcciones(idUsuario);
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
}
