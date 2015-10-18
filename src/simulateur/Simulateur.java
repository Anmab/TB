package simulateur;

import sources.*;
import destinations.*;
import transmetteurs.*;
import information.*;
import visualisations.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

import emetteurs.*;
import recepteurs.*;

/**
 * La classe Simulateur permet de construire et simuler une chaine de
 * transmission composee d'une Source, d'un nombre variable de Transmetteur(s)
 * et d'une Destination.
 * 
 */
public class Simulateur {

	private boolean affichage = false;
	/** indique si le simulateur utilise des sondes d'affichage */
	private boolean messageAleatoire = true;
	/** indique si le simulateur utilise un message genere de maniere aleatoire */
	private boolean aleatoireAvecGerme = false;
	/**
	 * indique si le simulateur utilise un germe pour initialiser les
	 * generateurs aleatoires
	 */
	private Integer seed = null;
	/** la valeur de la semence utilisee pour les generateurs aleatoires */
	private int nbBitsMess = 100;
	/**
	 * la longueur du message aleatoire a transmettre si un message n'est pas
	 * impose
	 */
	private String messageString = "100";
	/** la chaine de caracteres correspondant a m dans l'argument -mess m */

	private Source<Boolean> source = null;
	/** le composant Source de la chaine de transmission */
	private Transmetteur<Boolean, Boolean> transmetteurLogique = null;
	/** le composant Transmetteur parfait logique de la chaine de transmission */
	private Destination<Boolean> destination = null;
	/** le composant Destination de la chaine de transmission */

	// Analogique
	private String forme = "non";
	/**
	 * indique au Simulateur le type de la forme 
	 * utilise null si le signal est logique NRZ NRZT RZ
	 */
	private Integer nbEch = 30;
	/** indique au Simulateur le nombre d'echantillons par symbole */
	private float amplMin = 0.0f;
	/** indique au Simulateur l'amplitude min du signal */
	private float amplMax = 1.0f;
	/** indique au Simulateur l'amplitude max du signal */

	private Transmetteur<Float, Float> transmetteurAnalogique = null;
	/**
	 * le composant Transmetteur parfait Analogique de la chaine de transmission
	 */
	private Transmetteur<Boolean, Float> emetteur = null;
	/** le composant emetteur parfait Analogique de la chaine de transmission */
	private Transmetteur<Float, Boolean> recepteur = null;
	/** le composant recepteur parfait Analogique de la chaine de transmission */

	// Signal bruite
	private float snr = 0.0f;
	/** indique au simulateur le rapport signal sur bruit. */

	private boolean testTEB = false;
	private boolean testBruit = false;
	/** indique au simulateur s'il doit generer des fichier de test */

	private boolean help = false;
	/** indique au Simulateur s'il doit afficher une page d'aide*/
	
	//multitrajet
	private float ampliRelative[] = new float[5];
	private int decalage[] = new int[5];
	private int nTrajet=0;
	
	private Transmetteur<Float, Float> transmetteurMultiTrajets = null;
	/**
	 * le composant Transmetteur parfait Analogique de la chaine de transmission
	 */
	/**
	 * Le constructeur de Simulateur construit une chaine de transmission
	 * composee d'une Source <Boolean>, d'une Destination <Boolean> et de
	 * Transmetteur(s) [voir la methode analyseArguments]... <br>
	 * Les differents composants de la chaine de transmission (Source,
	 * Transmetteur(s), Destination, Sonde(s) de visualisation) sont crees et
	 * connectes.
	 * 
	 * @param args
	 *            le tableau des differents arguments.
	 * 
	 * @throws ArgumentsException
	 *             si un des arguments est incorrect
	 * 
	 */
	public Simulateur(String[] args) throws ArgumentsException {

		analyseArguments(args); // analyser et recuperer les arguments
		// Source
		if (messageAleatoire == true && aleatoireAvecGerme == false) {
			// Source aleatoire sans seed
			source = new SourceAleatoire(nbBitsMess);
		}
		if (messageAleatoire == true && aleatoireAvecGerme == true) {
			// Source aléatoire sans seed
			source = new SourceAleatoire(nbBitsMess, seed);
		}
		if (messageAleatoire == false) {
			// Soruce fix
			source = new SourceFixe(messageString);
		}
		// Transmetteur
		if (forme == "non") {
			transmetteurLogique = new TransmetteurParfaitLogique();
		} else {
			if (snr == 0)
				transmetteurAnalogique = new TransmetteurParfaitAnalogique();
			else{
				transmetteurAnalogique = new TransmetteurAnalogiqueBruite(snr);
			}
			transmetteurMultiTrajets = new TransmetteurMultiTrajets(ampliRelative, decalage);
		}
		// Destination
		destination = new DestinationFinale();
		// emmeteur-recepteurs
		if (forme == "NRZ") {
			emetteur = new EmetteurNrz(nbEch, amplMin, amplMax);
			recepteur = new RecepteurNrzV2(nbEch, amplMin, amplMax);
		}
		if (forme == "RZ") {
			emetteur = new EmetteurRz(nbEch, amplMin, amplMax);
			recepteur = new RecepteurRzV2(nbEch, amplMin, amplMax);
		}
		if (forme == "NRZT") {
			emetteur = new EmetteurNrzt(nbEch, amplMin, amplMax);
			recepteur = new RecepteurNrztV2(nbEch, amplMin, amplMax);
		}

		
		
		// Connections
		if (forme == "non") {
			// Logique
			source.connecter(transmetteurLogique);
			transmetteurLogique.connecter(destination);
			if (affichage == true) {
				SondeLogique soundeLogique1 = new SondeLogique(
						"Sonde Logique : Source", 1920);
				SondeLogique soundeLogique2 = new SondeLogique(
						"Sonde Logique : Destination", 1920);
				source.connecter(soundeLogique1);
				transmetteurLogique.connecter(soundeLogique2);
			}
		} else if (nTrajet != 0) {
			// Analogique avec multi trajet
			source.connecter(emetteur);
			emetteur.connecter(transmetteurMultiTrajets);
			transmetteurMultiTrajets.connecter(transmetteurAnalogique);
			transmetteurAnalogique.connecter(recepteur);
			recepteur.connecter(destination);
			if (affichage == true) {
				SondeLogique soundeLogique1 = new SondeLogique(
						"Sonde Logique : Source", 1920);
				SondeLogique soundeLogique2 = new SondeLogique(
						"Sonde Logique : Destination", 1920);
				SondeAnalogique soundeanalogique1 = new SondeAnalogique(
						"Sonde Analogique : Sortie de l'emetteur (entree du canal de transmission");
				SondeAnalogique soundeanalogique2 = new SondeAnalogique(
						"Sonde Analogique : Sortie du canal de transmission (entree du recepteur)");
				SondeAnalogique soundeanalogique3 = new SondeAnalogique(
						"Sonde Analogique : correspond au multi-trajet");
				source.connecter(soundeLogique1);
				recepteur.connecter(soundeLogique2);
				emetteur.connecter(soundeanalogique1);
				transmetteurAnalogique.connecter(soundeanalogique2);	
				transmetteurMultiTrajets.connecter(soundeanalogique3);
			}
		}else if(nTrajet == 0){
			// Analogique sans multi trajet
			source.connecter(emetteur);
			emetteur.connecter(transmetteurAnalogique);
			transmetteurAnalogique.connecter(recepteur);
			recepteur.connecter(destination);
			if (affichage == true) {
				SondeLogique soundeLogique1 = new SondeLogique(
						"Sonde Logique : Source", 1920);
				SondeLogique soundeLogique2 = new SondeLogique(
						"Sonde Logique : Destination", 1920);
				SondeAnalogique soundeanalogique1 = new SondeAnalogique(
						"Sonde Analogique : Sortie de l'émetteur");
				SondeAnalogique soundeanalogique2 = new SondeAnalogique(
						"Sonde Analogique : Sortie du canal de transmission");
				source.connecter(soundeLogique1);
				recepteur.connecter(soundeLogique2);
				emetteur.connecter(soundeanalogique1);
				transmetteurAnalogique.connecter(soundeanalogique2);		
			}
		}
	}

	/**
	 * La methode analyseArguments extrait d'un tableau de chaines de caracteres
	 * les differentes options de la simulation. Elle met a jour les attributs
	 * du Simulateur.
	 * 
	 * @param args
	 *            le tableau des differents arguments. <br>
	 * <br>
	 *            Les arguments autorises sont : <br>
	 *            <dl>
	 *            <dt>-mess m</dt>
	 *            <dd>m (String) constitue de 7 ou plus digits a 0 | 1, le
	 *            message a transmettre</dd>
	 *            <dt>-mess m</dt>
	 *            <dd>m (int) constitue de 1 a 6 digits, le nombre de bits du
	 *            message "aleatoire" a transmettre</dd>
	 *            <dt>-s</dt>
	 *            <dd>utilisation des sondes d'affichage</dd>
	 *            <dt>-seed v</dt>
	 *            <dd>v (int) d'initialisation pour les generateurs aleatoires</dd>
	 *            <br>
	 *            <dt>-form f</dt>
	 *            <dd>codage (String) RZ, NRZR, NRZT, la forme d'onde du signal
	 *            a transmettre (RZ par dfaut)</dd>
	 *            <dt>-nbEch ne</dt>
	 *            <dd>ne (int) le nombre d'echantillons par bit (ne >= 6 pour du
	 *            RZ, ne >= 9 pour du NRZT, ne >= 18 pour du RZ, 30 par defaut))
	 *            </dd>
	 *            <dt>-ampl min max</dt>
	 *            <dd>min (float) et max (float), les amplitudes min et max du
	 *            signal analogique a transmettre (min < max, 0.0 et 1.0 par
	 *            defaut)</dd>
	 *            <br>
	 *            <dt>-snr s</dt>
	 *            <dd>s (float) le rapport signal/bruit en dB</dd>
	 *            <br>
	 *            <dt>-ti i dt ar</dt>
	 *            <dd>i (int) numero du trajet indirect (de 1 a 5), dt (int)
	 *            valeur du decalage temporel du ieme trajet indirect en nombre
	 *            d'echantillons par bit, ar (float) amplitude relative au
	 *            signal initial du signal ayant effectuee le ieme trajet
	 *            indirect</dd>
	 *            <br>
	 *            <dt>-transducteur</dt>
	 *            <dd>utilisation de transducteur</dd>
	 *            <br>
	 *            <dt>-aveugle</dt>
	 *            <dd>les recepteurs ne connaissent ni l'amplitude min et max du
	 *            signal, ni les differents trajets indirects (s'il y en a).</dd>
	 *            <br>
	 *            </dl>
	 * <br>
	 *            <b>Contraintes</b> : Il y a des interdependances sur les
	 *            parametres effectifs.
	 * 
	 * @throws ArgumentsException
	 *             si un des arguments est incorrect.
	 * 
	 */
	public void analyseArguments(String[] args) throws ArgumentsException {
		for (int ii = 0; ii < decalage.length; ii++) {
			decalage[ii] = 0;
			ampliRelative[ii] = 0;
		}
		for (int i = 0; i < args.length; i++) {

			if (args[i].matches("-s")) {
				affichage = true;
			}

			else if (args[i].matches("-seed")) {
				aleatoireAvecGerme = true;
				i++;
				// traiter la valeur associee
				try {
					seed = new Integer(args[i]);
				} catch (Exception e) {
					throw new ArgumentsException(
							"Valeur du parametre -seed  invalide :" + args[i]);
				}
			}

			else if (args[i].matches("-mess")) {
				i++;
				// traiter la valeur associee
				messageString = args[i];
				if (args[i].matches("[0,1]{7,}")) {
					messageAleatoire = false;
					nbBitsMess = args[i].length();
				} else if (args[i].matches("[0-9]{1,6}")) {
					messageAleatoire = true;
					nbBitsMess = new Integer(args[i]);
					if (nbBitsMess < 1)
						throw new ArgumentsException(
								"Valeur du parametre -mess invalide : "
										+ nbBitsMess);
				} else
					throw new ArgumentsException(
							"Valeur du parametre -mess invalide : " + args[i]);
			} else if (args[i].matches("-form")) {
				i++;
				if (args[i].matches("NRZ")) {
					forme = "NRZ";
				} else if (args[i].matches("NRZT")) {
					forme = "NRZT";
				} else if (args[i].matches("RZ")) {
					forme = "RZ";
				} else
					throw new ArgumentsException(
							"Valeur du parametre -form invalide : " + args[i]);
			}

			else if (args[i].matches("-nbEch")) {
				i++;
				if (args[i].matches("[0-9]{1,5}")) {
					nbEch = new Integer(args[i]);
					if (nbEch < 1) {
						throw new ArgumentsException(
								"Valeur du parametre -nbEch invalide : "
										+ args[i]);
					}
				} else
					throw new ArgumentsException(
							"Valeur du parametre -nbEch invalide : " + args[i]);
			} else if (args[i].matches("-ampl")) {
				i++;
				if (args[i].matches("^[+-]?[0-9]+(.?[0-9]*)?")) {
					amplMin = new Float(args[i]);
				} else
					throw new ArgumentsException(
							"Valeur du parametre -ampl invalide : " + args[i]);
				i++;
				if (args[i].matches("^[+-]?[0-9]+(.?[0-9]*)?")) {
					amplMax = new Float(args[i]);
				} else
					throw new ArgumentsException(
							"Valeur du parametre -ampl invalide : " + args[i]);

				if (amplMin > amplMax) {
					throw new ArgumentsException(
							"Valeur du parametre -ampl invalide : " + args[i]);
				}
			} else if (args[i].matches("-snr")) {
				i++;
				if (args[i].matches("^[+-]?[0-9]+(.?[0-9]*)?")) {
					snr = new Float(args[i]);
				} else
					throw new ArgumentsException(
							"Valeur du parametre -snr invalide : " + args[i]);
			} else if (args[i].matches("-testBruit")) {
				testBruit = true;
			}else if (args[i].matches("-testTEB")) {
				testTEB = true;
				
			} else if (args[i].matches("-help|-h")) {
				help = true;
			} else if (args[i].matches("-ti")) {
				i++;
				if (args[i].matches("[1-5]")) {
					//i = nbTrajet
					nTrajet = new Integer(args[i]);
					i++;
					if (args[i].matches("[0-9]+")) {
						//dt = decalage
						decalage[nTrajet-1] = new Integer(args[i]);
						i++;
					}
					else{
						throw new ArgumentsException("Valeur du parametre -ti i dt invalide : " + args[i]);
					}
					if (args[i].matches("[0-9]+(.?[0-9]*)?")) {
						//ar = ampliRelative
						ampliRelative[nTrajet-1] = new Float(args[i]);	
					}
					else{
						throw new ArgumentsException("Valeur du parametre -ti i dt ar invalide : " + args[i]);
					}
				}
				else {
					throw new ArgumentsException("Valeur du parametre -ti i invalide : " + args[i]);
				}
			} else
				throw new ArgumentsException("Option invalide :" + args[i]);
		}

		// Condition final
		if (forme=="non" && nTrajet != 0 ){
			throw new ArgumentsException("L'option -ti (le multitrajet) ne peut etre faite sur un signal logique, ajouter -form [RZ,NRZ,NRZT]");
		}
		if (forme=="non" && snr != 0 ){
			throw new ArgumentsException("L'option -snr  ne peut etre faite sur un signal logique, ajouter -form [RZ,NRZ,NRZT]");
		}
		if (forme == "non" && nbEch != 30  ){
			throw new ArgumentsException("L'option -nbEch  ne peut etre faite sur un signal logique, ajouter -form [RZ,NRZ,NRZT]");
		}
	}

	/**
	 * La methode execute effectue un envoi de message par la source de la
	 * chaine de transmission du Simulateur.
	 * 
	 * @return les options explicites de simulation.
	 * 
	 * @throws Exception
	 *             si un probleme survient lors de l'execution
	 * 
	 */
	public void execute() throws Exception {
		source.emettre();
		if (testBruit) {
			if (transmetteurAnalogique != null) {
				if (transmetteurAnalogique.getBruit() != null) {
					File f = new File("../test/Bruit.csv");
					try {
						FileWriter fw = new FileWriter(f);

						for (int i = 1; i < transmetteurAnalogique.getBruit().nbElements() - 1; i++) {
							fw.write(String.valueOf(transmetteurAnalogique.getBruit().iemeElement(i)));
							fw.write("\r\n");
						}

						fw.close();
					} catch (IOException exception) {
						System.out.println("Erreur lors de la lecture : "
								+ exception.getMessage());
					}
				}
			}
		}

	}

	/**
	 * La methode calculTauxErreurBinaire permet de calculer le Taux d'erreur Binaire d'une ligne de transmission
	 * Entre le source et la destination finale
	 * 
	 * @return Le TRB (Float)
	 */
	public float calculTauxErreurBinaire() {
		// Nombre de bits faux
		int nbBitFaux = 0;
		// Acquisition du message emis
		Information<Boolean> messageON;
		messageON = source.getInformationEmise();
		// Acquisition du message recu
		Information<Boolean> messageOUT;
		messageOUT = destination.getInformationRecue();
		// Comparaison des messages et calcule du nombre d'erreur
		for (int i = 0; i < messageON.nbElements()
				&& i < messageOUT.nbElements(); i++) {
			if (!messageON.iemeElement(i).equals(messageOUT.iemeElement(i)))
				nbBitFaux++;
		}
		// Prise en compte de la différence de taille des messages
		if (messageON.nbElements() != messageOUT.nbElements()) {
			nbBitFaux += Math.abs(messageON.nbElements()
					- messageOUT.nbElements());
		}
		// retourne le TEB
		return ((float) nbBitFaux / (float) messageON.nbElements());
	}
	/**
	 * La fonction main instancie un Simulateur a l'aide des arguments
	 * passes en parametre et affiche le resultat de l'execution d'une transmission.
	 * 
	 * @param args
	 *            les differents arguments qui serviront a l'instanciation du
	 *            Simulateur.
	 */
	public static void main(String[] args) {
		System.out
				.println("*********************************************************");
		System.out
				.println("**                   Simulateur-2000                   **");
		System.out
				.println("*********************************************************");
		Simulateur simulateur = null;

		try {
			simulateur = new Simulateur(args);
		} catch (Exception e) {
			System.out.println(e);
			System.exit(-1);
		}
		if (simulateur.help == true){
			Help help = new Help();
		}
		else{
			try {
				simulateur.execute();
				float tauxErreurBinaire = simulateur.calculTauxErreurBinaire();
				String s = "java  Simulateur  ";
				for (int i = 0; i < args.length; i++) {
					s += args[i] + "  ";
				}
				System.out.println(s + "  =>   TEB : " + tauxErreurBinaire);
				if(simulateur.testTEB){
					try {
						String TEBstring = String.valueOf(tauxErreurBinaire);
					    BufferedWriter out = new BufferedWriter(new FileWriter("../test/TEB.csv", true));
					    out.write(simulateur.snr +";"+simulateur.forme+";"+ TEBstring+"\r\n");
					    out.close();
					}
					catch (IOException exception) {
						System.out.println("Erreur lors de l'écriture de TEB : "
								+ exception.getMessage());
					
					}
				}
				
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				System.exit(-2);
			}
		}
	}
}
