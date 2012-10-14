package mx.uv.infoestudiante;
import junit.framework.TestCase;

public class EstudianteTest extends TestCase {
	public EstudianteTest() {}
	
	public void testCrear() {
		final String primerNombreEstudiante = "Juan Foo";
		
		Estudiante estudiante = new Estudiante("Juan Foo");
		assertEquals(primerNombreEstudiante,estudiante.getNombre());
		
		final String segundoNombreEstudiante = "Juana Bar";
		
		Estudiante segundoEstudiante = new Estudiante("Juana Bar");
		assertEquals(segundoNombreEstudiante,segundoEstudiante.getNombre());
	}
}