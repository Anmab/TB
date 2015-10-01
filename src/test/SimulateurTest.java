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
	public void testTP1() throws Exception{
		System.out.println("Tests du Simulateur :");
		System.out.println("	Chaîne transmission logique parfaite en Java séance 1 :");
		
		// Teste a vide
		String options[] = {"-s"};
		simulateur = new Simulateur(options);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message prédéfini 
		String options2[] = {"-mess","0101010101010101111111"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message prédéfini et sonde
		String options3[] = {"-mess","0101001010101010101111111","-s"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aléatoire 
		String options4[] = {"-mess","48"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aléatoire et sonde
		String options5[] = {"-mess","88","-s"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aléatoire et seed
		String options6[] = {"-mess","42","-seed","1"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aléatoire et seed de 100
		String options7[] = {"-seed","1"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
	
}
