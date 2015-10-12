package transmetteurs;

import destinations.*;
import information.*;

import java.math.*;
import java.util.*;

public class TransmetteurMultiTrajets extends Transmetteur<Float, Float> {
	private float snr;
	private int nbTrajet;
	private LinkedList<Float> signalBruite;

	public TransmetteurMultiTrajets(float snr, int nbTrajet) {
		super();
		this.snr = snr;
		this.nbTrajet=nbTrajet;
		
		signalBruite = new LinkedList();
	}

	/**
	 * re�oit une information. Cette m�thode, en fin d'ex�cution, appelle la
	 * m�thode �mettre.
	 * 
	 * @param information
	 *            l'information re�ue
	 */
	
	
	public void recevoir(Information<Float> information)
			throws InformationNonConforme {
		this.informationRecue = information;
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");
		else
			informationRecue = information;
		emettre();
	}

	/**
	 * �met l'information construite par le transmetteur
	 */
	public void emettre() throws InformationNonConforme {
		float a1 = 0;
		float a2 = 0;
		float tau = 0;
		signalBruite = new LinkedList();

		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");

		else {

			informationEmise = new Information();

			float energieSignal = 0;
			float puissanceSignal = 0;

			/**
			 * Calcul de l'énergie du signal
			 **/

			for (int i = 0; i < informationRecue.nbElements(); i++) {
				energieSignal += Math.pow(informationRecue.iemeElement(i), 2);

			}

			/**
			 * Calcul de la puissance du signal
			 **/

			puissanceSignal = energieSignal / informationRecue.nbElements();
			
			System.out.println("Puissance signal : "+puissanceSignal);

			/**
			 * Calcul de l'écart-type
			 **/

			tau = (float) Math.sqrt(puissanceSignal
					/ (Math.pow(10, (snr / 10))));
			
			System.out.println("tau : "+tau);

			for (int i = 0; i < informationRecue.nbElements(); i++) {

				a1 = (float) Math.random();
				a2 = (float) Math.random();

				/**
				 * Ajout du bruit avec le signal recue
				 **/

				float b = (float) (tau * Math.sqrt((-2) * Math.log10(1 - a1)) * Math
						.cos(2 * Math.PI * a2));
				signalBruite.add(b);
				informationEmise.add((float) informationRecue.iemeElement(i)
						+ b);
				signalBruite.add(b);
			}

			for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
				destinationConnectee.recevoir(informationEmise);
			}
		}
	}

	public LinkedList<Float> getBruit() {
		return signalBruite;
	}

}
