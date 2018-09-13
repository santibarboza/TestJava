package view;

import java.util.List;
import hello.Accion.Accion;

public interface OCViewServer extends OCView{
	public List<Accion> obtenerAcciones();
}
