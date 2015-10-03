package recepteurs;

import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;
import destinations.DestinationInterface;

public class RecepteurNrzt extends Transmetteur<Float,Boolean> 
{
	private int nbEch ;
	private float ampMin;
	private float ampMax;

	public RecepteurNrzt(int nbEch, float ampMin, float ampMax)	
	{
		super();
		this.nbEch = nbEch;
		this.ampMin = ampMin;
		this.ampMax = ampMax;
	}

	
	@Override
	public void recevoir(Information<Float> information) throws InformationNonConforme 
	{
		this.informationRecue = information;
		if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
		else
			informationRecue = information;
		emettre();

	}
	@Override
	public void emettre() throws InformationNonConforme {
		Information informationEmise = new Information() ;
		  if (informationRecue == null)
				throw new InformationNonConforme("Erreur : Information non conforme");
		  
	 	  else {
	 		 for (int i=nbEch/2; i<informationRecue.nbElements();i+=nbEch){
	 			 if (informationRecue.iemeElement(i) >= ((ampMax+ampMin) / 2)){
	 				informationEmise.add(true);
	 			 }
	 			 else{
	 				informationEmise.add(false);
	 			 }
	 				 
	 		 }
	 	  }
		    		  
 		  for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) 
 		  {
 			  destinationConnectee.recevoir(informationEmise);
 		  }
	}
}
	

