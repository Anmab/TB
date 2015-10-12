package transmetteurs;

import java.util.LinkedList;

import destinations.*;
import information.*;

public class TransmetteurParfaitAnalogique extends Transmetteur<Float, Float> {
	public TransmetteurParfaitAnalogique() {
		super();
	}

	/**
	 * recoit une information. Cette methode, en fin d'execution, appelle la
	 * methode emettre.
	 * 
	 * @param information
	 *            l'information recue
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
	 * Emet l'information construite par le transmetteur
	 */
	public void emettre() throws InformationNonConforme {
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");
		else {
			// Transmision parfaite
			this.informationEmise = informationRecue;
			// Transmition erroné
			/*
			 * Information informationEmise = new Information() ; for (int i = 0
			 * ; i < informationRecue.nbElements(); i++)
			 * informationEmise.add(0);
			 */
			for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
				destinationConnectee.recevoir(informationEmise);
			}
		}
	}
}
