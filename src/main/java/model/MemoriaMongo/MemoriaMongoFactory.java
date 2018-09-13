package model.MemoriaMongo;
import model.RepresentacionMemoria.Memoria;

public interface MemoriaMongoFactory{
	public MemoriaMongo iniciarMemoria(Memoria Memoria, String id);
}