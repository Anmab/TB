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
		  if (informationRecue == null)
				throw new InformationNonConforme("Erreur : Information non conforme");
		  
	 	  else 
	 	  {
	 		 for (int i=0; i<informationRecue.nbElements();i++)
	 			 { if (nbEch/2 == ampMax)
	 				 informationEmise.add(true);
	 			 else
	 				 informationEmise.add(false);
	 			 }
				
	 		  		  
	 		  for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) 
	 		  {
	 			  destinationConnectee.recevoir(informationEmise);
	 		  }
	 	  }
	}
}
	

