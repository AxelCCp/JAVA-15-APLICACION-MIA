package Spring1_ID_Xml;

public class C6_DirectorEmpleado implements C2_Empleados {

	public C6_DirectorEmpleado(C4_CreacionDeInformes informeNuevo) {
		this.informeNuevo=informeNuevo;
	}
	C4_CreacionDeInformes informeNuevo;
	
	
	@Override
	public String getTarea() {
		// TODO Auto-generated method stub
		return "TAREA: DIRIGE CUESTIONES RELATIVAS A LA EMPRESA";
	}
	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "INFORME: ENTREGA REPORTES ACERCA DE LOS RESULTADOS DE LA DIRECCIÓN DENTRO DE LA EMPRESA" + "\n" + 
				informeNuevo.getInforme();
	}
}
