package test;
import static org.hamcrest.CoreMatchers.*;
import simulateur.ArgumentsException;
import simulateur.Simulateur;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class SimulateurTestException {
	private Simulateur simulateur = null;
	private boolean validite = false;
	
	/**
	 *  Permet d'utilisé la fonction collector.checkThat(valider(thrown),is(true)); pour tester la levée d'exception
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
	
	/**
	 * Test sans argument
	 */
	@Test
	public void testArgNull() {
	  String invalideOptions1[] = {" "};
	  try {
		  simulateur = new Simulateur(invalideOptions1);
	  } catch (ArgumentsException e) {
		  validite = true;
	  }
	  collector.checkThat(valider(validite),is(true));
	}
	
	/**
	 * argument non valide sdfqsdf
	 */
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
	/**
	 * -mess avec option incorrect
	 */
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
	  String invalideOptions1[] = {"-form",""};
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
		  String invalideOptions1[] = {"-ampl","3"," "};
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
			}
	// Etape 4 
	@Test
	public void testArg17() {
		  String invalideOptions1[] = {"-ti","6","5", "0.2f"}; 
		  // test avec le paramètre i non compris entre 1 et 5
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
			}
	
	@Test
	public void testArg18() {
		  String invalideOptions1[] = {"-ti","0","5", "0.2f"}; 
		  // test avec le paramètre i non compris entre 1 et 5
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
			}
	
	@Test
	public void testArg19() {
		  String invalideOptions1[] = {"-ti","2","5.3f", "0.2f"}; 
		  // test avec le paramètre dt, valeur non entière
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
	}
	
	@Test
	public void testArg20() {
		  String invalideOptions1[] = {"-ti","2","5.3f", "3"}; 
		  // test avec le paramètre ar, valeur positive non flottante
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
	}
	
	public void testArg21() {
		  String invalideOptions1[] = {"-ti","2","5.3f", "-3"}; 
		  // test avec le paramètre ar, valeur négative non flottante
		  try {
			  simulateur = new Simulateur(invalideOptions1);
		  } catch (ArgumentsException e) {
			  validite = true;
		  }
		  collector.checkThat(valider(validite),is(true));
	}
}
