package transmetteurs;

import destinations.*;
import information.*;

import java.math.*;
import java.util.*;

public class TransmetteurMultiTrajets extends Transmetteur<Float, Float> {

	private int nTrajet[];
	private float ampliRelative[];
	private float decalage[];

	public TransmetteurMultiTrajets(int nTrajet[], float ampliRelative[],
			float decalage[]) {
		super();
		this.nTrajet = nTrajet;
		this.ampliRelative = ampliRelative;
		this.decalage = decalage;
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
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");

		else {

			informationEmise = new Information();
		}
		
		for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(informationEmise);
		}
	}
}
