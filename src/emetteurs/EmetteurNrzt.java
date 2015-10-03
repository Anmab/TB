package emetteurs;


import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurNrzt extends Transmetteur<Boolean,Float>{
	private int nbEch ;
	private float ampMin;
	private float ampMax;
	
	public EmetteurNrzt(int nbEch, float ampMin,float ampMax){
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
 		 float coef = ((ampMax-ampMin)*3)/ nbEch;
 		 float coef2 =(3*(ampMin-ampMax))/nbEch;
 		 for (int i=0; i<informationRecue.nbElements();i++) {
			 if(informationRecue.iemeElement(i) == true){
				 for(int j=0; j<nbEch/3; j++){
					 informationEmise.add((coef)*j+ampMin);
				 }
				 for(int j =nbEch/3; j<nbEch*2/3; j++){
					 informationEmise.add(ampMax);
				 }
				 for(int j =nbEch*2/3; j<nbEch; j++){
					 informationEmise.add((coef2)*j+(3*ampMax-2*ampMin));
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
