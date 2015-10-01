package recepteurs;

import destinations.DestinationInterface;
import information.Information;
import information.InformationNonConforme;
import transmetteurs.Transmetteur;

public class RecepteurNrz extends Transmetteur<Float,Boolean> 
{
	private int nbEch ;
	private float ampMin;
	private float ampMax;

	public RecepteurNrz()	{
		super();
		nbEch = 30;
		ampMin = 0.0f;
		ampMax = 1.0f;
	}
	public void setnbEch(int nbEch)	{
		this.nbEch = nbEch;
	}
	public void setampMin(float ampMin)	{
		this.ampMin = ampMin;
	}
	public void setampMax(float ampMax)	{
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
	public void emettre() throws InformationNonConforme 
	{
		 if (informationRecue == null)
				throw new InformationNonConforme("Erreur : Information non conforme");
	 	  else
	 		 for (int i=0; i<informationRecue.nbElements();i++) 
	 		 {
				 if(informationRecue.iemeElement(i) == 1.0) {
					 for(int j =0; j<nbEch; j++) {
						 informationEmise.add(true);
					 }
				 }
				 else {
					 for(int j =0; j<nbEch; j++) {
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

