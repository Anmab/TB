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
  				
  	  if (informationRecue.iemeElement(i) == false) {
  		// TODO
  	  }
  	  else {
  		  // TODO
  		  
  	  }
  	}
  	
	for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) {
		destinationConnectee.recevoir(informationEmise);
	}
	}
}


