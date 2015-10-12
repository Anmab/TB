package transmetteurs;

import destinations.*;
import information.*;

import java.math.*;
import java.util.*;

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
		float ech = 0;
		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");

		else {

			informationEmise = new Information();
		}
		System.out.println(decalage[0]);
		System.out.println(decalage[1]);
		System.out.println(decalage[2]);
		System.out.println(decalage[3]);
		System.out.println(decalage[4]);
		System.out.println(ampliRelative[0]);
		System.out.println(ampliRelative[1]);
		System.out.println(ampliRelative[2]);
		System.out.println(ampliRelative[3]);
		System.out.println(ampliRelative[4]);
		for (int i = 0 ; i<informationRecue.nbElements();i++){
			ech = informationRecue.iemeElement(i);
			if(i-decalage[0]>=0){
				ech += ampliRelative[0]*informationRecue.iemeElement(i-decalage[0]);
				//System.out.println( ampliRelative[0]*informationRecue.iemeElement(i-decalage[0]));
			}
			if(i-decalage[1]>=0){
				ech += ampliRelative[1]*informationRecue.iemeElement(i-decalage[1]);
				//System.out.println("b");
			}
			if(i-decalage[2]>=0){
				ech += ampliRelative[2]*informationRecue.iemeElement(i-decalage[2]);
				//System.out.println("c");
			}
			if(i-decalage[3]>=0){
				ech += ampliRelative[3]*informationRecue.iemeElement(i-decalage[3]);
				//System.out.println("d");
			}
			if(i-decalage[4]>=0){
				ech += ampliRelative[4]*informationRecue.iemeElement(i-decalage[4]);
				//System.out.println("e");
			}
			informationEmise.add(ech);
				
		}
		for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
			destinationConnectee.recevoir(informationEmise);
		}
	}
}
