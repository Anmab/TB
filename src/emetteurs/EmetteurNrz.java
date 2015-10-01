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

		 for (int i=0; i<informationRecue.nbElements();i++) {
			 int nbEchanSymbole = 30;
			 Float amplitudeMax = (float)1;
			 Float amplitudeMin = (float)-1;
			 if(informationRecue.iemeElement(i) == true){
				 for(int j =0; j<nbEchanSymbole; j++){
					 informationEmise.add(amplitudeMax);
				 }
			 }
			 else{
				 for(int j =0; j<nbEchanSymbole; j++){
					 informationEmise.add(amplitudeMin);
				 }
			 }
 		  }
 		  		  
 		  for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) {
 			  destinationConnectee.recevoir(informationEmise);
 		  }
 	  }
   }

}
