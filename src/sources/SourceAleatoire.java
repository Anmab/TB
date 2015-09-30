package sources;
import information.*;
import java.util.*;

public class SourceAleatoire extends Source<Boolean>  {
	/**
	 * Constructeur de sourceAleatoire sans seed
	 * @param taille 
	 */
	private Random random;
	
    public SourceAleatoire (int taille) {
    	super();
    	this.random = new Random();
    	this.informationGeneree = generer_une_trame(taille);
    }
    /**
     * Constructeur de sourceAleatoire avec seed
     * @param taille 
     * @param seed 
     */
    public SourceAleatoire (int taille, int seed) {
    	super();
    	 this.random = new Random(seed);
    	this.informationGeneree = generer_une_trame(taille);
    }
    private Information<Boolean> generer_une_trame(int taille){
    	Information informationGeneree = new Information();
    	 for (int i = 0; i < taille; i++) {
    		 informationGeneree.add(this.random.nextBoolean());
    		 }

    	return informationGeneree;
    }
}