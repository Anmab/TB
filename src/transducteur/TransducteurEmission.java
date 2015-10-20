package transducteur;

import transmetteurs.*;
import destinations.*;
import information.*;

public class TransducteurEmission extends Transmetteur<Float, Float> {

	public void recevoir(Information<Float> information) throws InformationNonConforme {
		this.informationRecue = information;
		if (informationRecue == null) throw new InformationNonConforme(
					"Erreur : Information non conforme");
		else
			informationRecue = information;
		emettre();
	}

	public void emettre() throws InformationNonConforme {

		if (informationRecue == null)
			throw new InformationNonConforme(
					"Erreur : Information non conforme");
		else {
			informationEmise = new Information();
		}

		for (int i = 0; i < informationRecue.nbElements(); i++) {

			if (informationRecue.iemeElement(i) == 0) {
				informationEmise.add((float) 0);
				informationEmise.add((float) 1);
				informationEmise.add((float) 0);
			} else {
				informationEmise.add((float) 1);
				informationEmise.add((float) 0);
				informationEmise.add((float) 1);

			}

			for (DestinationInterface<Float> destinationConnectee : destinationsConnectees) {
				destinationConnectee.recevoir(informationEmise);
			}
		}
	}

}
