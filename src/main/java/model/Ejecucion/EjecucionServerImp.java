package model.Ejecucion;

public class EjecucionServerImp extends EjecucionImpl implements EjecucionServer{
	public int getPC(){
		return pc;
	}
	public void setPC(int pc){
		this.pc=pc;
	}
}
