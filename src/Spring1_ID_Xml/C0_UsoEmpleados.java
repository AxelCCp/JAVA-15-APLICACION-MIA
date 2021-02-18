package Spring1_ID_Xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class C0_UsoEmpleados {
	public static void main(String[]args) {
		
		ClassPathXmlApplicationContext  contexto = new ClassPathXmlApplicationContext("ApplicationContext.xml"); 
		
		C2_Empleados XXX = contexto.getBean("secretarioEmpleado",C2_Empleados.class);
		System.out.println(XXX.getTarea());
		System.out.println(XXX.getInforme());
		
		contexto.close();
		
		
	}
}
