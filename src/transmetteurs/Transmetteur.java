package transmetteurs;
	import sources.*;
	import destinations.*;
	import information.*;


   import java.util.*;

/** 
 * Classe Abstraite d'un composant transmetteur d'informations dont les �l�ments sont de type R en entr�e et de type E en sortie;
 * l'entr�e du transmetteur impl�mente l'interface DestinationInterface, 
 * la sortie du transmetteur impl�mente l'interface SourceInterface
 * @author prou
 */
    public abstract  class Transmetteur <R,E> implements  DestinationInterface <R>, SourceInterface <E> {
   
   
   /** 
   * la liste des composants destination connect�s en sortie du transmetteur 
   */
      protected LinkedList <DestinationInterface <E>> destinationsConnectees;
   
   /** 
   * l'information re�ue en entr�e du transmetteur     */
      protected Information <R>  informationRecue;
		
   /** 
   * l'information �mise en sortie du transmetteur  
   */		
      protected Information <E>  informationEmise;

   
   /** 
   * un constructeur factorisant les initialisations communes aux r�alisations de la classe abstraite Transmetteur 
   */
       public Transmetteur() {
         destinationsConnectees = new LinkedList <DestinationInterface <E>> ();
         informationRecue = null;
         informationEmise = null;
      }

     
   	
   /**
    * retourne la derni�re information re�ue en entr�e du transmetteur
    * @return une information   
    */
       public Information <R>  getInformationRecue() {
         return this.informationRecue;
      }

   /**
    * retourne la derni�re information �mise en sortie du transmetteur
	 * @return une information   
    */
       public Information <E>  getInformationEmise() {
         return this.informationEmise;
      }
 

   /**
    * connecte une  destination � la sortie du transmetteur 
    * @param destination  la destination � connecter
	 */
       public void connecter (DestinationInterface <E> destination) {
         destinationsConnectees.add(destination); 
      }

   
   /**
    * d�connecte une  destination de la la sortie du transmetteur 
    * @param destination  la destination � d�connecter
    */
       public void deconnecter (DestinationInterface <E> destination) {
         destinationsConnectees.remove(destination); 
      }

   	    
   /**
    * re�oit une information. 
	 * Cette m�thode, en fin d'ex�cution, appelle la m�thode �mettre.
    * @param information  l'information  re�ue
    */
       public  abstract void recevoir(Information <R> information) throws InformationNonConforme;
      
   
    /**
    * �met l'information construite par le transmetteur  
    */
      public  abstract void emettre() throws InformationNonConforme; 
      
      public  abstract LinkedList<Float> getBruit() ;  
   }
    
     

    