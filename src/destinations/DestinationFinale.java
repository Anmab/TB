package destinations;
import information.*;

public class DestinationFinale extends Destination < Boolean >{
	/**
	 * Permet a la destination de recevoir une information Boolean
	 */
    public void recevoir(Information<Boolean> information) throws InformationNonConforme{
		this.informationRecue=information;
    }
}
