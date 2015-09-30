package visualisations;
import information.Information;


/** 
 * Classe r�alisant l'affichage d'information compos�e d'�l�ments r�els (float)
 * @author prou
 */
   public class SondeAnalogique extends Sonde <Float> {
    
   
    /**
    * pour construire une sonde analogique  
    * @param nom  le nom de la fen�tre d'affichage
    */
      public SondeAnalogique(String nom) {
         super(nom);
      }
   
   
   	 
      public void recevoir (Information <Float> information) { 
         informationRecue = information;
         int nbElements = information.nbElements();
         float [] table = new float[nbElements];
         int i = 0;
         for (float f : information) {
            table[i] = f;
            i++;
         }
         new VueCourbe (table, nom); 
      }
   	 
   	
   
   
   }