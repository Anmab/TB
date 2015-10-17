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
	 * Permet d'utilisé la fonction
	 * collector.checkThat(valider(thrown),is(true)); pour tester la levée
	 * d'exception
	 * 
	 * @param arg
	 * @return
	 */
	public boolean valider(boolean arg) {
		return arg;
	}

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Before
	public void setUp() throws Exception {
		validite = false;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			null
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void nullArg() {
		String invalideOptions1[] = { " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	//			char
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void badArg() {
		String invalideOptions1[] = { "qsdfqsdf" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			mess
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void messNull() {
		String invalideOptions1[] = { "-mess", "" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void messChar() {
		String invalideOptions1[] = { "-mess", "a" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void messZero() {
		String invalideOptions1[] = { "-mess", "0" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			seed
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void seedNull() {
		String invalideOptions1[] = { "-seed", "" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void seedChar() {
		String invalideOptions1[] = { "-seed", "cv" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			form
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void formBadChar() {
		String invalideOptions1[] = { "-form", "NRR" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void formNull() {
		String invalideOptions1[] = { "-form", "" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			nbEch
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void nbEchChar() {
		String invalideOptions1[] = { "-nbEch", "NRR" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void nbCharTooLongNum() {
		String invalideOptions1[] = { "-nbEch", "999999" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void nbCharZero() {
		String invalideOptions1[] = { "-nbEch", "0" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void nbCharNull() {
		String invalideOptions1[] = { "-nbEch", " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			Ampl
	/////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void amplNull() {
		String invalideOptions1[] = { "-ampl", " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void amplMinSupMax() {
		String invalideOptions1[] = { "-ampl", "3", "1" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void amplNullMax() {
		String invalideOptions1[] = { "-ampl", "3", " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void amplNullMin() {
		String invalideOptions1[] = { "-ampl", "", "1" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	//			SNR
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void snrLogique() {
		String invalideOptions1[] = { "-snr", "2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void snrNull() {
		String invalideOptions1[] = { "-form", "RZ", "-snr", "" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void snrChar() {
		String invalideOptions1[] = { "-form", "RZ", "-snr", "a" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//			ti
	/////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void tiLogique() {
		String invalideOptions1[] = { "-ti", " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiNull() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", " " };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiIChar() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "aasc", "2", "0.2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void titdChar() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "1", "arsd", "0.2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiarChar() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "1", "2", "qdf" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiINull() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "", "2", "0.2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void titdNull() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "1", "", "0.2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiarNull() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "1", "2", "" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void tiITooLarge() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "6", "2", "0.2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}

	@Test
	public void titdFloat() {
		String invalideOptions1[] = { "-form", "NRZ", "-ti", "1", "2.1", "2" };
		try {
			simulateur = new Simulateur(invalideOptions1);
		} catch (ArgumentsException e) {
			validite = true;
		}
		collector.checkThat(valider(validite), is(true));
	}
}
