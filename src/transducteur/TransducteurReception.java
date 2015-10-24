package transducteur;

import transmetteurs.*;
import destinations.*;
import information.*;

public class TransducteurReception extends Transmetteur<Boolean, Boolean> {

	
	public void recevoir(Information<Boolean> information) throws InformationNonConforme {
	 	   this.informationRecue = information;
	   	  if (informationRecue == null)
	  			throw new InformationNonConforme("Erreur : Information non conforme");
	    	  else
	    		informationRecue = information;
	   	  	emettre();
	     }
		
	
	public void emettre() throws InformationNonConforme {
		if (informationRecue == null)
			throw new InformationNonConforme("Erreur : Information non conforme");
		else 
			informationEmise = new Information<Boolean>();		
	/*	
  	boolean a = false;
  	boolean b = false;
  	boolean c = false;
	*/
  	
  	for (int i = 0; i < informationRecue.nbElements(); i=i+3)
  	{
  		boolean a=this.informationRecue.iemeElement(i);
  		boolean b=this.informationRecue.iemeElement(i+1);
  		boolean c=this.informationRecue.iemeElement(i+2);
/*  		
  		switch (a && b && c)
  		{
  		case ((a==false) && (b==false) && (c==false))
  		this.informationEmise.add(false);
  		
  		case ((a==false) && (b==false) && (c==true))
  		this.informationEmise.add(true);
  		
  		case ((a==false) && (b==true) && (c==false))
  		this.informationEmise.add(false);
  		
  		case ((a==false) && (b==true) && (c==true))
  		this.informationEmise.add(false);
  		
  		case ((a==true) && (b==false) && (c==false))
  		this.informationEmise.add(true);
  		
  		case ((a==true) && (b==false) && (c==true))
  		this.informationEmise.add(true);
  		*/
  		
		if ((a==false) && (b==false) && (c==false))
		this.informationEmise.add(false);
		
		else if ((a==false) && (b==false) && (c==true))
		this.informationEmise.add(true);
		
		else if ((a==false) && (b==true) && (c==false))
		this.informationEmise.add(false);
		
		else if ((a==false) && (b==true) && (c==true))
		this.informationEmise.add(false);
		
		else if ((a==true) && (b==false) && (c==false))
		this.informationEmise.add(true);
		
		else if ((a==true) && (b==false) && (c==true))
		this.informationEmise.add(true);
  	}
  	
	
	for (DestinationInterface<Boolean> destinationConnectee : destinationsConnectees) {
		destinationConnectee.recevoir(informationEmise);
	}
	}
}


