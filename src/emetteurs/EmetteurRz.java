package emetteurs;
import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurRz extends Transmetteur<Boolean, Float> {
	private int nbEch ;
	private float ampMin;
	private float ampMax;
	
	public EmetteurRz(){
		super();
		nbEch = 30;
		ampMin = 0.0f;
		ampMax = 1.0f;
	}
	public void setnbEch(int nbEch){
		this.nbEch = nbEch;
	}
	public void setampMin(float ampMin){
		this.ampMin = ampMin;
	}
	public void setampMax(float ampMax){
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
 	  if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
 	  else{

		 for (int i=0; i<informationRecue.nbElements();i++) {
			 if(informationRecue.iemeElement(i) == true){
				 for(int j=0; j<nbEch/3; j++){
					 informationEmise.add(ampMin);
				 }
				 for(int j =nbEch/3; j<nbEch*2/3; j++){
					 informationEmise.add(ampMax);
				 }
				 for(int j =nbEch*2/3; j<nbEch; j++){
					 informationEmise.add(ampMin);
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
