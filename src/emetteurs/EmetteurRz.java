package emetteurs;

/** La classe Emetteur RZ permet d'emettre une suite de float selon le code en ligne RZ ( Return to Zero) vers le recepteur RZ à travers un transmetteur analogique parfait.
 * @author DUNAN
 * @author SCHERRER
 */

import java.util.LinkedList;

import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurRz extends Transmetteur<Boolean, Float> {
	private int nbEch ;
	private float ampMin;
	private float ampMax;
	
	/**
	 *    @param nbEch  nombre d'échantillon
	 *    @param ampMin  amplitude minimale
	 *    @param ampMax  amplitude maximale  
	 */   
	
	public EmetteurRz(int nbEch, float ampMin,float ampMax){
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
	}
	   /**
	    * reçoit une information. 
		 * Cette méthode, en fin d'exécution, appelle la méthode émettre.
	    * @param information  l'information  ré�ue
	    * @throws InformationNonConforme si un informationRecue est "null"
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
	 * Construction d'un symbole en fonction des élements reçus
	 * Si True : ampMin entre 0 et nbEch/3
	 * 			 ampMax entre nbEch/3 et nbEch*2/3
	 * 			 ampMin entre nbEch*2/3 et nbEch
	 * 
	 * Si False : ampMin
	 * @throws InformationNonConforme si un informationRecue est "null"
	 */
    
      public void emettre() throws InformationNonConforme{
    	  Information informationEmise = new Information() ;
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
   }	  public LinkedList<Float> getBruit(){
		  return null;
	  }

}
