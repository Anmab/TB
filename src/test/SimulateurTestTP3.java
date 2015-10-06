package test;

import static org.hamcrest.CoreMatchers.*;
import simulateur.ArgumentsException;
import simulateur.Simulateur;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;



public class SimulateurTestTP3 {
		private Simulateur simulateur = null;		
	/**
	*  Permet d'utilise la fonction collector.checkThat(valider(thrown),is(true)); pour tester la levee d'exception
	* @param arg
	* @return
	*/

	@Rule
	public ErrorCollector collector = new ErrorCollector();
		
	@Before
	public void setUp() throws Exception {

	}
	public void TestNRZBruite() throws Exception{
			
		System.out.println("Tests du Simulateur :");
		System.out.println("	Chaine transmission analogique bruitee en Java seance 3 :");
		
				
		// Avec message predefini puis codage NRZ
		String options2[] = {"-mess","0101010101010101111111","-form","NRZ", "- snr 1"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message predefini et sonde  puis codage NRZ
		String options3[] = {"-mess","0101001010101010101111111","-form","NRZ","-s", "- snr 1"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire  puis codage NRZ
		String options4[] = {"-mess","48","-form","NRZ" , "- snr 1"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et sonde  puis codage NRZ
		String options5[] = {"-mess","88","-form","NRZ","-s" , "- snr 1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et seed  puis codage NRZ
		String options6[] = {"-mess","42","-form","NRZ","-seed","1" , "- snr 1"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et seed de 100  puis codage NRZ
		String options7[] = {"-seed","1","-form","NRZ", "- snr 1"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}

	public void TestNRZTBruite() throws Exception{
		
		System.out.println("Tests du Simulateur :");
		System.out.println("	Chaine transmission analogique bruitee en Java seance 3 :");
		
				
		// Avec message predefini puis codage NRZT
		String options2[] = {"-mess","0101010101010101111111","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message predefini et sonde  puis codage NRZT
		String options3[] = {"-mess","0101001010101010101111111","-form","NRZT","-s", "- snr 1"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire  puis codage NRZT
		String options4[] = {"-mess","48","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et sonde  puis codage NRZ
		String options5[] = {"-mess","88","-form","NRZT","-s", "- snr 1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et seed  puis codage NRZT
		String options6[] = {"-mess","42","-form","NRZT","-seed","1", "- snr 1"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et seed de 100  puis codage NRZT
		String options7[] = {"-seed","1","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
	
	public void TestRZBruite() throws Exception{
		System.out.println("Tests du Simulateur :");
		System.out.println("	Chaine transmission analogique bruitee en Java seance 3 :");
	
			
		// Avec message predefini puis codage RZ
		String options2[] = {"-mess","0101010101010101111111","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options2);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	
		// Avec message predefini et sonde  puis codage RZ
		String options3[] = {"-mess","0101001010101010101111111","-form","NRZT","-s", "- snr 1"};
		simulateur = new Simulateur(options3);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	
		// Avec message aleatoire  puis codage RZ
		String options4[] = {"-mess","48","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options4);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	
		// Avec message aleatoire et sonde  puis codage RZ
		String options5[] = {"-mess","88","-form","NRZT","-s", "- snr 1"};
		simulateur = new Simulateur(options5);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	
		// Avec message aleatoire et seed  puis codage RZ
		String options6[] = {"-mess","42","-form","NRZT","-seed","1", "- snr 1"};
		simulateur = new Simulateur(options6);
		simulateur.execute();
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
		
		// Avec message aleatoire et seed de 100  puis codage RZ
		String options7[] = {"-seed","1","-form","NRZT", "- snr 1"};
		simulateur = new Simulateur(options7);
		simulateur.execute();
		float a = simulateur.calculTauxErreurBinaire();
		System.out.println(a);
		collector.checkThat(simulateur.calculTauxErreurBinaire(),is((float)0));
	}
}


