package hello.Accion;

public class AccionImp implements Accion{

    private final String codigoAccion;
    private final String parametro;

    public Accion(String codigoAccion, String parametro) {
        this.codigoAccion = codigoAccion;
        this.parametro = parametro;
    }

    public String getCodigoAccion() {
        return codigoAccion;
    }

    public String getParametro() {
        return parametro;
    }
}
