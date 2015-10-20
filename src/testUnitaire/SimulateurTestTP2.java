package testUnitaire;
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
	 *  Permet d'utiliser la fonction collector.checkThat(valider(thrown),is(true)); pour tester la levee d'exception
	 * @param arg
	 * @return
	 */

	@Rule
		public ErrorCollector collector = new ErrorCollector();
	
	@Before
		public void setUp() throws Exception {

		}
	
	@Test
	public void testFormSimple() throws Exception{
		
		// Test RZ simple
		String options[] = {"-form","RZ"};
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ simple
		options[1]= "NRZ";
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT simple
		options[1]= "NRZT";
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
	
	@Test
	public void testRZ() throws Exception{
		
		// Test RZ simple
		String options[] = {"-form","RZ"};
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec sonde
		String options2[] = {"-form","RZ","-s"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec amplitude positive
		String options3[] = {"-form","RZ","-ampl","1","2"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));

		// Test RZ avec amplitude negative
		String options4[] = {"-form","RZ","-ampl","-2","2"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec amplitude negative
		String options5[] = {"-form","RZ","-ampl","-2","-1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec amplitude negative et nulle
		String options6[] = {"-form","RZ","-ampl","-2","0"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec amplitude positive et nulle
		String options7[] = {"-form","RZ","-ampl","0","10"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ avec nombre d'echantillons
		String options8[] = {"-form","RZ","-nbEch","10"};
		simulateur = new Simulateur(options8);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test RZ combiné
		String options9[] = {"-form","RZ","-nbEch","10","-ampl","1","10","-s"};
		simulateur = new Simulateur(options9);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
	@Test
	public void testNRZ() throws Exception{
		
		// Test NRZ simple
		String options[] = {"-form","NRZ"};
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec sonde
		String options2[] = {"-form","NRZ","-s"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec amplitude positive
		String options3[] = {"-form","NRZ","-ampl","1","2"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));

		// Test NRZ avec amplitude negative
		String options4[] = {"-form","NRZ","-ampl","-2","2"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec amplitude negative
		String options5[] = {"-form","NRZ","-ampl","-2","-1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec amplitude negative et nulle
		String options6[] = {"-form","NRZ","-ampl","-2","0"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec amplitude positive et nulle
		String options7[] = {"-form","NRZ","-ampl","0","10"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ avec nombre d'echantillons
		String options8[] = {"-form","NRZ","-nbEch","10"};
		simulateur = new Simulateur(options8);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZ combiné
		String options9[] = {"-form","NRZ","-nbEch","10","-ampl","1","10","-s"};
		simulateur = new Simulateur(options9);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
	
	@Test
	public void testNRZT() throws Exception{
		
		// Test NRZT simple
		String options[] = {"-form","NRZT"};
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec sonde
		String options2[] = {"-form","NRZT","-s"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec amplitude positive
		String options3[] = {"-form","NRZT","-ampl","1","2"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));

		// Test NRZT avec amplitude negative
		String options4[] = {"-form","NRZT","-ampl","-2","2"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec amplitude negative
		String options5[] = {"-form","NRZT","-ampl","-2","-1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec amplitude negative et nulle
		String options6[] = {"-form","NRZT","-ampl","-2","0"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec amplitude positive et nulle
		String options7[] = {"-form","NRZT","-ampl","0","10"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT avec nombre d'echantillons
		String options8[] = {"-form","NRZT","-nbEch","10"};
		simulateur = new Simulateur(options8);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Test NRZT combiné
		String options9[] = {"-form","NRZT","-nbEch","10","-ampl","1","10","-s"};
		simulateur = new Simulateur(options9);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
}
