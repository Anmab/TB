package recepteurs;

import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;
import destinations.DestinationInterface;

public class RecepteurRz extends Transmetteur<Float, Boolean> {
	private int nbEch;
	private float ampMin;
	private float ampMax;

	/**
	 * @param nbEch
	 *            nombre d'echantillon
	 * @param ampMin
	 *            amplitude minimale
	 * @param ampMax
	 *            amplitude maximale
	 */

	public RecepteurRz(int nbEch, float ampMin, float ampMax) {
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
	}

	/**
	 * recoit une information. Cette methode, en fin d'execution, appelle la
	 * methode emettre.
	 * 
	 * @param information
	 *            l'information recue
	 * @throws InformationNonConforme
	 *             si un informationRecue est "null"
	 */
	@Override
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
	 * Transforme une information analogique (Information<Float>) en information
	 * logique Au millieu d'un symbole, on test sa valeur pour determiner la
	 * nature de l'information
	 */
	@Override
	public void emettre() throws InformationNonConforme {
		Information informationEmise = new Information();
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");

		else {
			for (int i = nbEch / 2; i < informationRecue.nbElements(); i += nbEch) {
				if (informationRecue.iemeElement(i) >= ((ampMax + ampMin) / 2)) {
					informationEmise.add(true);
				} else {
					informationEmise.add(false);
				}

			}
		}

		for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(informationEmise);
		}
	}
}
