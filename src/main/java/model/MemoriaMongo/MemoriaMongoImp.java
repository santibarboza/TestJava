package model.MemoriaMongo;
import com.mongodb.*;
import java.util.ArrayList;
import java.util.List;
import model.RepresentacionMemoria.*;
import model.Ejecucion.*;
import org.bson.Document;


public class MemoriaMongoImp implements MemoriaMongo{
	protected DBCollection coleccion;
	protected String id;

	protected DBObject objeto;
	protected Memoria memoria;
	protected EjecucionServer ejecucion;
	
	public MemoriaMongoImp(EjecucionServer ejecucion, DBCollection coleccion,String id){
		this.ejecucion=ejecucion;
		this.memoria=ejecucion.getMemoria();
		this.coleccion=coleccion;
		this.id=id;
		recuperarObjeto();
		iniciar();
	}
	private void recuperarObjeto(){
		obtenerObjeto();
		if(esNuevoObjeto())
			crearObjeto();
	}
	private void obtenerObjeto(){
		objeto = coleccion.findOne(crearQuery());
	}
	private BasicDBObject crearQuery(){
		BasicDBObject query = new BasicDBObject();
		query.put("id_User", id);
		return query;
	}
	private boolean esNuevoObjeto(){
		return objeto==null;
	}
	private void crearObjeto(){
		BasicDBObject document = new BasicDBObject();
		document.put("id_User", id);
		document.put("memoria", crearMemoria());
		document.put("registros", crearRegistros());
		document.put("pc", crearPC());
		coleccion.insert(document);
		obtenerObjeto();
	}
	private ArrayList<Integer> crearMemoria(){
 		ArrayList<Integer> list= new ArrayList<Integer>();
 		for(int i=0;i<256;i++)
 			list.add(0);
 		return list;
	}
	private ArrayList<Integer> crearRegistros(){
 		ArrayList<Integer> list= new ArrayList<Integer>();
 		for(int i=0;i<16;i++)
 			list.add(0);
 		return list;
	}
	private Integer crearPC(){
 		return new Integer(memoria.getDireccionInicio());
	}
	public void iniciar(){
		iniciarMemoria();
		iniciarRegistros();
		iniciarEjecucion();
	}
	private void iniciarMemoria(){
		ArrayList<Integer> memoriaDB= leermemoria();
		for(int i=0;i<256;i++)
 			memoria.escribirMemoria(i,memoriaDB.get(i));
	}
	private ArrayList<Integer> leermemoria(){
		return (ArrayList<Integer>)objeto.get("memoria");
	}
	private void iniciarRegistros(){
		ArrayList<Integer> registrosDB= leerregistros();
		for(int i=0;i<16;i++)
 			memoria.escribirRegistro(i,registrosDB.get(i));
	}
	private ArrayList<Integer> leerregistros(){
		return (ArrayList<Integer>)objeto.get("registros");
	}

	private void iniciarEjecucion(){
		Integer pc= leerPC();
		ejecucion.setPC(pc.intValue());
	}
	private Integer leerPC(){
		return (Integer)objeto.get("pc");
	}
	public Memoria getMemoria(){
		return memoria;
	}
	public void guardarMemoria(){
		ArrayList<Integer> memoriaList=obtenerMemoriaAGuardar();
		ArrayList<Integer> registrosList=obtenerRegistrosAGuardar();
		Integer pc= obtenerPCaGuadar();
		updateDB(memoriaList,registrosList,pc);
	}

	private ArrayList<Integer> obtenerMemoriaAGuardar(){
		ArrayList<Integer> list= new ArrayList<Integer>();
 		for(int i=0;i<256;i++)
 			list.add(memoria.leerMemoria(i));
 		return list;
	}
	private ArrayList<Integer> obtenerRegistrosAGuardar(){
		ArrayList<Integer> list= new ArrayList<Integer>();
 		for(int i=0;i<16;i++)
 			list.add(memoria.leerRegistro(i));
 		return list;
	}
	private Integer obtenerPCaGuadar(){
		return new Integer(ejecucion.getPC());
	}
	private void updateDB(ArrayList<Integer> memoriaDB,ArrayList<Integer>registrosDB,Integer pc){
		BasicDBObject query = crearQuery();
		BasicDBObject objetoNuevo = crearObjetoNuevo(memoriaDB,registrosDB,pc);
		BasicDBObject updateObject = crearObjetoUpdate(objetoNuevo);
 		coleccion.update(query, updateObject);	
	}
	private BasicDBObject crearObjetoNuevo(ArrayList<Integer> memoriaDB,ArrayList<Integer>registrosDB,Integer pc){
		BasicDBObject objetoNuevo = new BasicDBObject();
		objetoNuevo.put("memoria", memoriaDB);
		objetoNuevo.put("registros", registrosDB);
		objetoNuevo.put("pc", pc);
		return objetoNuevo;
	}
	private BasicDBObject crearObjetoUpdate(BasicDBObject objetoNuevo){
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", objetoNuevo);
		return updateObject;
	}
}