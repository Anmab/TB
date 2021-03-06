package transmetteurs;

import destinations.*;
import information.*;


public class TransmetteurMultiTrajets extends Transmetteur<Float, Float> {

	private int nTrajet[];
	private float ampliRelative[];
	private int decalage[];

	public TransmetteurMultiTrajets(float ampliRelative[],int decalage[]) {
		super();
		this.ampliRelative = ampliRelative;
		this.decalage = decalage;
	}

	/**
	 * recoit une information. Cette methode, en fin d'execution, appelle la
	 * methode emettre.
	 * 
	 * @param information
	 *            l'information recue
	 */

	public void recevoir(Information<Float> information) throws InformationNonConforme {
		this.informationRecue = information;
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");
		else
			informationRecue = information;
		emettre();
	}

	/**
	 * emet l'information construite par le transmetteur
	 */
	public void emettre() throws InformationNonConforme {
		float ech = 0;
		if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");

		else {

			informationEmise = new Information();
		}
		for (int i = 0 ; i<informationRecue.nbElements();i++){
			ech = informationRecue.iemeElement(i);
			if(i-decalage[0]>=0){
				ech += ampliRelative[0]*informationRecue.iemeElement(i-decalage[0]);
			}
			if(i-decalage[1]>=0){
				ech += ampliRelative[1]*informationRecue.iemeElement(i-decalage[1]);
			}
			if(i-decalage[2]>=0){
				ech += ampliRelative[2]*informationRecue.iemeElement(i-decalage[2]);
			}
			if(i-decalage[3]>=0){
				ech += ampliRelative[3]*informationRecue.iemeElement(i-decalage[3]);
			}
			if(i-decalage[4]>=0){
				ech += ampliRelative[4]*informationRecue.iemeElement(i-decalage[4]);
			}
			informationEmise.add(ech);
				
		}
		for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(informationEmise);
		}
	}
}
