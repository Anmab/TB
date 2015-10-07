package recepteurs;

import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;
import destinations.DestinationInterface;

public class RecepteurNrztV2 extends Transmetteur<Float, Boolean> {
	private int nbEch;
	private float ampMin;
	private float ampMax;

	/**
	 * @param nbEch
	 *            nombre d'échantillon
	 * @param ampMin
	 *            amplitude minimale
	 * @param ampMax
	 *            amplitude maximale
	 */

	public RecepteurNrztV2(int nbEch, float ampMin, float ampMax) {
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
	}

	/**
	 * reçoit une information. Cette méthode, en fin d'exécution, appelle la
	 * méthode émettre.
	 * 
	 * @param information
	 *            l'information ré�ue
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
	 * logique Au millieu d'un symbole, on test sa valeur pour déterminé la
	 * nature de l'information
	 */
	@Override
	public void emettre() throws InformationNonConforme {

		float sommeEch = 0;
		float moyenneSymbole = 0;

		Information informationEmise = new Information();
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");

		else {
			for (int symbole = 0; symbole < informationRecue.nbElements(); symbole += nbEch) {
				sommeEch = 0;

				for (int echantillon = (symbole + (nbEch / 3)); echantillon < (symbole + (2 * nbEch) / 3); echantillon++) {
					sommeEch += (informationRecue.iemeElement(echantillon));
				}
				moyenneSymbole = sommeEch / ((1 / 3) * nbEch);

				if (moyenneSymbole >= (ampMax + ampMin) / 2) {
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
