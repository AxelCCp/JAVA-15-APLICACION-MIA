package Spring1_ID_Xml;

public class C3_SecretarioEmpleado implements C2_Empleados {

	@Override
	public String getTarea() {
		// TODO Auto-generated method stub
		return "TAREA: ORGANIZA LA AGENDA DE LOS JEFES";
	}

	public String getInforme() {
		return "INFORME: EL INFORME DEL SECRETARIO ES ACERCA DE LAS REUNIONES DEL MES" + "\n" 
				+ informeNuevo.getInforme();
	}
	
	
	public void setInforme(C5_Informes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	C5_Informes informeNuevo;
}

