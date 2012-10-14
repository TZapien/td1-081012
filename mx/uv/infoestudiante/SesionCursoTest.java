package mx.uv.infoestudiante;
import junit.framework.TestCase;
import java.util.*;

public class SesionCursoTest extends TestCase{
	private SesionCurso sesion;
	private Date fechaInicio;
	
	public void setUp() {
		fechaInicio = crearFecha(2003,1,6);
		sesion = new SesionCurso("ENGL","101", fechaInicio);
	}
	
	Date crearFecha(int anio, int mes, int dia) {
		GregorianCalendar calendario = new GregorianCalendar();
		calendario.clear();
		calendario.set(Calendar.YEAR, anio);
		calendario.set(Calendar.MONTH, mes - 1);
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		return calendario.getTime();
	}
			
	public void testFechasCurso() {
		Date diezYSeisSemanas = crearFecha(2003, 4, 25);
		assertEquals(diezYSeisSemanas, sesion.getFechaFin());

	}
	
	public void testCrear() {
		assertEquals("ENGL", sesion.getDepartamento());
		assertEquals("101",sesion.getNumero());
		assertEquals(0, sesion.getNumeroDeEstudiantes());
		assertEquals(fechaInicio, sesion.getFechaInicio());
	}
	
	public void testInscribirEstudiantes() {
		Estudiante estudiante1 = new Estudiante("Juan Lopez");
		sesion.inscribir(estudiante1);
		assertEquals(1, sesion.getNumeroDeEstudiantes());
		assertEquals(estudiante1, sesion.get(0));
		
		Estudiante estudiante2 = new Estudiante("Laura Mora");
		sesion.inscribir(estudiante2);
		assertEquals(2, sesion.getNumeroDeEstudiantes());
		assertEquals(estudiante1, sesion.get(0));
		assertEquals(estudiante2, sesion.get(1));
	}
	
public void testListaReporte() {
	sesion.inscribir(new Estudiante("A"));
	sesion.inscribir(new Estudiante("B"));
	
	String listaReporte = sesion.getListaReporte();
	assertEquals(SesionCurso.ENCABEZADO_LISTA_REPORTE +
			"A" + SesionCurso.NUEVA_LINEA +
			"B" + SesionCurso.NUEVA_LINEA +
			SesionCurso.PIE_DE_PAGINA_LISTA_REPORTE + "2" +
			SesionCurso.NUEVA_LINEA, listaReporte);
}

}
