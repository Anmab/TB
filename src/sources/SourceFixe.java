package sources;
import information.*;

public class SourceFixe extends	Source<Boolean>{
	/**
	 * Constructeur de SourceFixe
	 * @param info
	 */
    public SourceFixe (Information<Boolean> info) {
    	super();
    	this.informationGeneree  = info;
    }
    /**
     * Constructeur de SourceFix a partir d'une chaine de caractaire
     * @param messageString
     */
    public SourceFixe (String messageString) {
    	super();
    	informationGeneree = new Information<Boolean>() ;
    	for (int i=0; i < messageString.length(); i++ ){
    		if (messageString.charAt(i) == '1'){
    			this.informationGeneree.add(true);
    		}
    		else if (messageString.charAt(i) == '0'){
    			//System.out.println(i);
    			this.informationGeneree.add(false);
    		}
    		else 
    			System.out.println("Erreur string");
    	}

    }
}