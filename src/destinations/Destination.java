package destinations;
import information.*;


/** 
 * Classe Abstraite d'un composant destination d'informations dont les �l�ments sont de type T 
 * @author prou
 */
    public  abstract class Destination <T> implements DestinationInterface <T> {
   
   
   
   /** 
   * l'information re�ue par la destination 
   */
      protected Information <T>  informationRecue;
   	 
   /** 
   * un constructeur factorisant les initialisations communes aux r�alisations de la classe abstraite Destination 
   */
       public Destination() {
         informationRecue = null;
      }

   /**
    * retourne la derni�re information re�ue par la destination
    * @return une information   
    */
       public Information  <T>  getInformationRecue() {
         return this.informationRecue;
      }
   	    
   /**
    * re�oit une information 
    * @param information  l'information  � recevoir
    */
       public  abstract void recevoir(Information <T> information) throws InformationNonConforme;  
    
   
   }