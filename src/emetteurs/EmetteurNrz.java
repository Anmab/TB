package emetteurs;

import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurNrz extends Transmetteur<Boolean,Float>{
	private int nbEch ;
	private float ampMin;
	private float ampMax;
	
	public EmetteurNrz(int nbEch, float ampMin,float ampMax){
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
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
    	  Information informationEmise = new Information() ;
 	  if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
 	  else{

		 for (int i=0; i<informationRecue.nbElements();i++) {
			 if(informationRecue.iemeElement(i) == true){
				 for(int j =0; j<nbEch; j++){
					 informationEmise.add(ampMax);
				 }
			 }
			 else{
				 for(int j =0; j<nbEch; j++){
					 informationEmise.add(ampMin);
				 }
			 }
 		  }
 		  		  
 		  for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) {
 			  destinationConnectee.recevoir(informationEmise);
 		  }
 	  }
   }

}
