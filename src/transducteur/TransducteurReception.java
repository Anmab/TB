package transducteur;

import transmetteurs.*;
import destinations.*;
import information.*;

public class TransducteurReception extends Transmetteur<Boolean, Boolean> {

	
	public void recevoir(Information<Boolean> information) throws InformationNonConforme {
	 	   this.informationRecue = information;
	   	  if (informationRecue == null)
	  			throw new InformationNonConforme("Erreur : Information non conforme");
	    	  else
	    		informationRecue = information;
	   	  	emettre();
	     }
		
	
	public void emettre() throws InformationNonConforme {
		if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
  	  else {
  		informationEmise = new Information();
  	  }
  	  
  	for (int i = 0; i < informationRecue.nbElements(); i=i+3)
  	{
  				
  	  if (informationRecue.iemeElement(i) == false && informationRecue.iemeElement(i+1) == false && informationRecue.iemeElement(i+2) == false) {
  		informationEmise.add(false);
  	  }
  	  if (informationRecue.iemeElement(i) == false && informationRecue.iemeElement(i+1) == false && informationRecue.iemeElement(i+2) == true) {
  		informationEmise.add(true);
  	  }
  	  if (informationRecue.iemeElement(i) == false && informationRecue.iemeElement(i+1) == true && informationRecue.iemeElement(i+2) == false) {
  		informationEmise.add(false);
  	  }
  	  if (informationRecue.iemeElement(i) == false && informationRecue.iemeElement(i+1) == true && informationRecue.iemeElement(i+2) == true) {
  		informationEmise.add(false);
  	  }
  	  if (informationRecue.iemeElement(i) == true && informationRecue.iemeElement(i+1) == false && informationRecue.iemeElement(i+2) == false) {
  		informationEmise.add(true);
  	  }
  	  if (informationRecue.iemeElement(i) == true && informationRecue.iemeElement(i+1) == false && informationRecue.iemeElement(i+2) == true) {
  		informationEmise.add(true);
  	  }  	  
  	  if (informationRecue.iemeElement(i) == true && informationRecue.iemeElement(i+1) == true && informationRecue.iemeElement(i+2) == false) {
  		informationEmise.add(false);
  	  }
  	  if (informationRecue.iemeElement(i) == true && informationRecue.iemeElement(i+1) == true && informationRecue.iemeElement(i+2) == true) {
  		informationEmise.add(true);
  	  }
  	}
  	
	for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) {
		destinationConnectee.recevoir(informationEmise);
	}
	}
}


