package hello;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data   //anotación Lombok para crear todos los métodos getters, setters, equals, hash y toString, en función de los campos.
@Entity //
public class BodyCompilado {


    private @Id @GeneratedValue Long id;
    private  String direccionInicio;
    private  String codigoFuente;

    public BodyCompilado(String direccionInicio, String codigoFuente) {
        this.direccionInicio = direccionInicio;
        this.codigoFuente = codigoFuente;
    }
/*
    public String getDireccionInicio() {
        return direccionInicio;
    }

    public String getCodigoFuente() {
        return codigoFuente;
    }
    public void setDireccionInicio(String direccionInicio) {
        this.direccionInicio = direccionInicio;
    }
    public void setCodigoFuente(String codigoFuente) {
        this.codigoFuente = codigoFuente;
    }
    */
}
