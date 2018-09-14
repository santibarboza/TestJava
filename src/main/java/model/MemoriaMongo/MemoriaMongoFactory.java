package model.MemoriaMongo;
import model.RepresentacionMemoria.Memoria;

public interface MemoriaMongoFactory{
	public MemoriaMongo crearMemoriaMongo(Memoria Memoria, String id);
}