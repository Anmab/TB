package recepteurs;

import destinations.DestinationInterface;
import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;

public class RecepteurNrz extends Transmetteur<Float,Boolean> 
{

	@Override
	public void recevoir(Information<Float> information) throws InformationNonConforme 
	{
		// test
		this.informationRecue = information;
	  	  if (informationRecue == null)
	 			throw new InformationNonConforme("Erreur : Information non conforme");
	   	  else
	   		informationRecue = information;
	  	  	emettre();
	}

	@Override
	public void emettre() throws InformationNonConforme 
	{
		 if (informationRecue == null)
				throw new InformationNonConforme("Erreur : Information non conforme");
	 	  else
	 	  {

	 		  this.informationEmise = informationRecue;

			 for (DestinationInterface <Float> destinationConnectee : destinationsConnectees) 
			 {
	 			  destinationConnectee.recevoir(informationEmise);
		
			 }

	 	  }
	}
}
