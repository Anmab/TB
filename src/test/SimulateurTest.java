package test;
import static org.hamcrest.CoreMatchers.*;
import simulateur.ArgumentsException;
import simulateur.Simulateur;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class SimulateurTest {
	private Simulateur simulateur = null;

	
	/**
	 *  Permet d'utilisé la fonction collector.checkThat(valider(thrown),is(true)); pour tester la levé d'exception
	 * @param arg
	 * @return
	 */
	public boolean valider(boolean arg ){
		return arg ;
	}
	
	@Rule
		public ErrorCollector collector = new ErrorCollector();
	
	@Before
		public void setUp() throws Exception {

		}
	
	@Test
	public void testSimulateur() throws Exception{
		System.out.println("Tests du Simulateur :");
	}
	
}
