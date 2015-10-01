package transmetteurs;
import destinations.*;
import information.*;


public class TransmetteurParfaitAnalogique extends Transmetteur <Float,Float>{
	public TransmetteurParfaitAnalogique(){
		super();
	}
   /**
    * re�oit une information. 
	 * Cette m�thode, en fin d'ex�cution, appelle la m�thode �mettre.
    * @param information  l'information  re�ue
    */
       public void recevoir(Information <Float> information) throws InformationNonConforme {
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
    		  // Transmision parfaite
    		  this.informationEmise = informationRecue;
    		  //Transmition erroné
    		  /*
    		  Information informationEmise = new Information() ;
    		  for (int i = 0 ; i < informationRecue.nbElements(); i++)
    			  informationEmise.add(true);
    			  */
    		  for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) {
    			  destinationConnectee.recevoir(informationEmise);
    		  }
    	  }
	  }
}
