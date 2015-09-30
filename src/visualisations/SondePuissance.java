package visualisations;
import information.Information;


/** 
 * Classe r�alisant l'affichage de la puissance d'une information compos�e d'�l�ments de type r�el (float)
 * @author prou
 */
   public class SondePuissance extends Sonde <Float> {
   
   /**
    * pour construire une sonde puissance 
    * @param nom  le nom de la fen�tre d'affichage
	 */
      public SondePuissance(String nom) {
         super(nom);
      }
   
   
   	 
      public void recevoir (Information <Float> information) { 
         informationRecue = information;
         int nbElements = information.nbElements();
         Double puissance = 0.0;
         for (int i = 0; i < nbElements; i++) {
            puissance +=  information.iemeElement(i) *  information.iemeElement(i);
         }
         puissance = puissance / nbElements;
         new VueValeur (puissance,  nom); 
      }
   	 
   	
   
   
   }