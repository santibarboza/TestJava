package hello;

public class BodyCompilado {

    private final String direccionInicio;
    private final String codigoFuente;

    public BodyCompilado(String direccionInicio, String codigoFuente) {
        this.direccionInicio = direccionInicio;
        this.codigoFuente = codigoFuente;
    }

    public String getDireccionInicio() {
        return direccionInicio;
    }

    public String getCodigoFuente() {
        return codigoFuente;
    }
}
