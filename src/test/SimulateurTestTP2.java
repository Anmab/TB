package test;
import static org.hamcrest.CoreMatchers.*;
import simulateur.ArgumentsException;
import simulateur.Simulateur;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class SimulateurTestTP2 {
	private Simulateur simulateur = null;

	
	/**
	 *  Permet d'utilisé la fonction collector.checkThat(valider(thrown),is(true)); pour tester la levé d'exception
	 * @param arg
	 * @return
	 */

	@Rule
		public ErrorCollector collector = new ErrorCollector();
	
	@Before
		public void setUp() throws Exception {

		}
	
	@Test
	public void testTP2() throws Exception{
		System.out.println("Tests du Simulateur :");
		System.out.println("	Chaîne transmission analogique parfaite en Java séance 2 :");
				

		String options1[] = {"-form","RZ"};
		simulateur = new Simulateur(options1);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options2[] = {"-form","NRZ"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options3[] = {"-form","NRZT"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options4[] = {"-form","NRZT","-nbEch","1000"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options5[] = {"-form","NRZ","-nbEch","100"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options6[] = {"-form","RZ","-nbEch","10"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options7[] = {"-form","NRZT","-ampl","1","10"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options8[] = {"-form","NRZ","-ampl","2","9"};
		simulateur = new Simulateur(options8);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options9[] = {"-form","RZ","-ampl","0","10"};
		simulateur = new Simulateur(options9);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options10[] = {"-form","NRZT","-ampl","1","10","-s"};
		simulateur = new Simulateur(options10);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options11[] = {"-form","NRZ","-ampl","2","9","-s"};
		simulateur = new Simulateur(options11);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		String options12[] = {"-form","RZ","-ampl","0","10","-s"};
		simulateur = new Simulateur(options12);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
}
