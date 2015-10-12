package transmetteurs;

import destinations.*;
import information.*;


public class TransmetteurParfaitLogique extends Transmetteur < Boolean , Boolean >{
	public TransmetteurParfaitLogique(){
		super();
	}
	/**
	 * recoit une information. Cette methode, en fin d'execution, appelle la
	 * methode emettre.
	 * 
	 * @param information
	 *            l'information recue
	 */
       public void recevoir(Information <Boolean> information) throws InformationNonConforme {
    	   this.informationRecue = information;
     	  if (informationRecue == null)
    			throw new InformationNonConforme("Erreur : Information non conforme");
      	  else
      		informationRecue = information;
     	  	emettre();
       }
    /**
    * Emet l'information construite par le transmetteur  
    */
      public void emettre() throws InformationNonConforme{
    	  if (informationRecue == null)
  			throw new InformationNonConforme("Erreur : Information non conforme");
    	  else{
    		  // Transmision parfaite
    		  this.informationEmise = informationRecue;
    		  //Transmition erroné
    		  /*
    		  Information informationEmise = new Information() ;
    		  for (int i = 0 ; i < informationRecue.nbElements(); i++)
    			  informationEmise.add(true);
    			  */
    		  for (DestinationInterface <Boolean> destinationConnectee : destinationsConnectees) {
    			  destinationConnectee.recevoir(informationEmise);
    		  }
    	  }
	  }
}
