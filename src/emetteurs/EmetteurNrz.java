package emetteurs;

import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurNrz extends Transmetteur<Boolean,Float>{
	public EmetteurNrz(){
		super();
	}
	
    public void recevoir(Information <Boolean> information) throws InformationNonConforme {
 	   this.informationRecue = information;
  	  if (informationRecue == null)
 			throw new InformationNonConforme("Erreur : Information non conforme");
   	  else
   		informationRecue = information;
  	  	emettre();
    }
    
	 /**
	 * �met l'information construite par le transmetteur  
	 */
      public void emettre() throws InformationNonConforme{
 	  if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
 	  else{

 		  this.informationEmise = informationRecue;

		 for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) {
 			  destinationConnectee.recevoir(informationEmise);
 		  }
 		  
 		  
 		  
 		  
 		  
 		  
 		  for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) {
 			  destinationConnectee.recevoir(informationEmise);
 		  }
 	  }
   }

}
