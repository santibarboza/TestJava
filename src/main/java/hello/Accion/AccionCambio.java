package hello.Accion;

public class AccionCambio implements Accion{

    private final String codigoAccion;
    private final Map<Integer,String> parametro;

    public AccionCambio(String codigoAccion, Map<Integer,String> parametro) {
        this.codigoAccion = codigoAccion;
        this.parametro = parametro;
    }

    public String getCodigoAccion() {
        return codigoAccion;
    }

    public Map<Integer,String> getParametro() {
        return parametro;
    }
}
