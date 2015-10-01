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
	private boolean validite = false;
	
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
			validite = false;
		}
	
	//Test des arguments invalide
	@Test
	public void testArg() {
	  String invalideOptions1[] = {" "};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
	}
	@Test
	public void testArg2() {
	  String invalideOptions1[] = {"qsdfqsdf"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
	}
	@Test
	public void testArg3() {
	  String invalideOptions1[] = {"-mess","a"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
	}
	@Test
	public void testArg4() {
	  String invalideOptions1[] = {"-mess",""};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg5() {
	  String invalideOptions1[] = {"-seed",""};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg6() {
	  String invalideOptions1[] = {"-seed","cv"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg7() {
	  String invalideOptions1[] = {"-mess","0"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg8() {
	  String invalideOptions1[] = {"-form","NRR"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg9() {
	  String invalideOptions1[] = {"-form"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg10() {
	  String invalideOptions1[] = {"-nbEch","NRR"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg11() {
	  String invalideOptions1[] = {"-nbEch","999999"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg12() {
	  String invalideOptions1[] = {"-nbEch","0"};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg13() {
	  String invalideOptions1[] = {"-nbEch"," "};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
		}
	@Test
	public void testArg14() {
		  String invalideOptions1[] = {"-ampl"," "};
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
			}
	@Test
	public void testArg15() {
		  String invalideOptions1[] = {"-ampl","3","1"};
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
			}
	@Test
	public void testArg16() {
		  String invalideOptions1[] = {"-ampl","3"};
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
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
