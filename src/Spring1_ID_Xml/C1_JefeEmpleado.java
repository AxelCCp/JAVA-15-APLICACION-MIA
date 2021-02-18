package Spring1_ID_Xml;

public class C1_JefeEmpleado implements C2_Empleados {

	public C1_JefeEmpleado(C4_CreacionDeInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
		
	}
	C4_CreacionDeInformes informeNuevo;
	
	public String getTarea() {
		return"TAREA: EL JEFE SE ENCARGA DE LA PLANTILLA DE LA EMPRESA";
	}
	
	
	public String getInforme() {
		return"INFORME: EL INFORME DEL JEFE SE TRATA DE EL AVANCE EN EL PROYECTO" + "\n" 
				+ informeNuevo.getInforme();
	}
	
}
