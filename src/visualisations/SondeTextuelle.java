package visualisations;
import information.Information;


/** 
 * Classe r�alisant l'affichage (textuel) d'information compos�e d'�l�ments de type T
 * @author prou
 */
    public class SondeTextuelle <T> extends Sonde <T> {
   
   /**
    * pour construire une sonde textuelle 
    * @param nom  le nom de la fen�tre d'affichage
	 */
       public SondeTextuelle(String nom) {
         super(nom);
      }
   
       public void recevoir (Information <T> information) { 		 		 	
         informationRecue = information;
         System.out.println(nom + " : " + information);
      }
   	 
   	
   
   
   }