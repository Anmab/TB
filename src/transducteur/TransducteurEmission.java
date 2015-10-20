package transducteur;

import transmetteurs.*;
import destinations.*;
import information.*;

public class TransducteurEmission extends Transmetteur<Boolean, Boolean> {

	public void recevoir(Information<Boolean> information) throws InformationNonConforme {
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

			if (informationRecue.iemeElement(i) == false) {
				informationEmise.add(false);
				informationEmise.add(true);
				informationEmise.add(false);
			} else {
				informationEmise.add(true);
				informationEmise.add(false);
				informationEmise.add(true);

			}

			for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) {
				destinationConnectee.recevoir(informationEmise);
			}
		}
	}

}
