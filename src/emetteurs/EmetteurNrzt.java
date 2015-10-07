package emetteurs;

/** La classe Emetteur NRZT permet d'emettre une suite de float selon une variante du code en ligne NRZ ( No Return to Zero) qui est NRZT (le symbole à plus la forme d'un trapèze, afin de se rapprocher de la réalité), vers le recepteur NRZ à travers un transmetteur analogique parfait.
 * @author DUNAN
 * @author SCHERRER
 */

import java.util.LinkedList;

import transmetteurs.Transmetteur;
import destinations.DestinationInterface;
import information.*;

public class EmetteurNrzt extends Transmetteur<Boolean,Float>{
	private int nbEch ;
	private float ampMin;
	private float ampMax;
	
	
	/**
	 *    @param nbEch  nombre d'échantillon
	 *    @param ampMin  amplitude minimale
	 *    @param ampMax  amplitude maximale  
	 */   
	
	public EmetteurNrzt(int nbEch, float ampMin,float ampMax){
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
	}
	
	 /**
	 * reçoit une information. 
	 * Cette méthode, en fin d'exécution, appelle la méthode émettre.
	 * @param information  l'information  réçue
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
	 * Si True : (coef)*j+ampMin entre 0 et nbEch/3    
	 * 			 ampMax entre nbEch/3 et (2*nbEch)/3  
	 * 			 (coef2)*j+(3*ampMax-2*ampMin) entre (2*nbEch)/3 et nbEch
	 * 
	 *Si False : AmpMin
	 *@throws InformationNonConforme si un informationRecue est "null"
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
	  public LinkedList<Float> getBruit(){
		  return null;
	  }

}
