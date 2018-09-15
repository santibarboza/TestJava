package model.Ejecucion;

import model.RepresentacionMemoria.Memoria;

public class EjecucionServerImp extends EjecucionImpl implements EjecucionServer{
	public EjecucionServerImp(Memoria memoria){
		super(memoria);
	}
	public int getPC(){
		return pc;
	}
	public void setPC(int pc){
		this.pc=pc;
	}
}
