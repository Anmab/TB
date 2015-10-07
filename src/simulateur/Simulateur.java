package simulateur;

import sources.*;
import destinations.*;
import transmetteurs.*;
import information.*;
import visualisations.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;

import emetteurs.*;
import recepteurs.*;

/**
 * La classe Simulateur permet de construire et simuler une cha�ne de
 * transmission compos�e d'une Source, d'un nombre variable de Transmetteur(s)
 * et d'une Destination.
 * 
 * @author cousin
 * @author prou
 * 
 */
public class Simulateur {

	private boolean affichage = false;
	/** indique si le Simulateur utilise des sondes d'affichage */
	private boolean messageAleatoire = true;
	/** indique si le Simulateur utilise un message g�n�r� de mani�re al�atoire */
	private boolean aleatoireAvecGerme = false;
	/**
	 * indique si le Simulateur utilise un germe pour initialiser les
	 * g�n�rateurs al�atoires
	 */
	private Integer seed = null;
	/** la valeur de la semence utilis�e pour les g�n�rateurs al�atoires */
	private int nbBitsMess = 100;
	/**
	 * la longueur du message al�atoire � transmettre si un message n'est pas
	 * impose
	 */
	private String messageString = "100";
	/** la cha�ne de caract�res correspondant � m dans l'argument -mess m */

	private Source<Boolean> source = null;
	/** le composant Source de la chaine de transmission */
	private Transmetteur<Boolean, Boolean> transmetteurLogique = null;
	/** le composant Transmetteur parfait logique de la chaine de transmission */
	private Destination<Boolean> destination = null;
	/** le composant Destination de la chaine de transmission */

	// Analogique
	private String forme = "non";
	/**
	 * indique au Simulateur le type de de forme d'aude utilisé null si le
	 * signal est logique NRZ NRZT RZ
	 */
	private Integer nbEch = 30;
	/** indique au Simulateur le nombre d'echantillons utilisé par symbole */
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

	// Signal bruité
	private float snr = 0.0f;
	/** indique au Simulateur le rapport Signal sur bruit. */

	private boolean test = false;

	/** indique au Simulateur si il doit générer des fichier de test */

	/**
	 * Le constructeur de Simulateur construit une cha�ne de transmission
	 * compos�e d'une Source <Boolean>, d'une Destination <Boolean> et de
	 * Transmetteur(s) [voir la m�thode analyseArguments]... <br>
	 * Les diff�rents composants de la cha�ne de transmission (Source,
	 * Transmetteur(s), Destination, Sonde(s) de visualisation) sont cr��s et
	 * connect�s.
	 * 
	 * @param args
	 *            le tableau des diff�rents arguments.
	 * 
	 * @throws ArgumentsException
	 *             si un des arguments est incorrect
	 * 
	 */
	public Simulateur(String[] args) throws ArgumentsException {

		analyseArguments(args); // analyser et r�cup�rer les arguments
		// Source
		if (messageAleatoire == true && aleatoireAvecGerme == false) {
			// Source aléatoire sans seed
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
			else
				transmetteurAnalogique = new TransmetteurAnalogiqueBruite(snr);
		}
		// Destination
		destination = new DestinationFinale();
		// emmeteur-recepteurs
		if (forme == "NRZ") {
			emetteur = new EmetteurNrz(nbEch, amplMin, amplMax);
			recepteur = new RecepteurNrz(nbEch, amplMin, amplMax);
		}
		if (forme == "RZ") {
			emetteur = new EmetteurRz(nbEch, amplMin, amplMax);
			recepteur = new RecepteurRz(nbEch, amplMin, amplMax);
		}
		if (forme == "NRZT") {
			emetteur = new EmetteurNrzt(nbEch, amplMin, amplMax);
			recepteur = new RecepteurNrzt(nbEch, amplMin, amplMax);
		}

		// Connections
		if (forme == "non") {
			// Logique
			source.connecter(transmetteurLogique);
			transmetteurLogique.connecter(destination);
			if (affichage == true) {
				SondeLogique soundeLogique1 = new SondeLogique(
						"Sonde Logique1", 1920);
				SondeLogique soundeLogique2 = new SondeLogique(
						"Sonde Logique2", 1920);
				source.connecter(soundeLogique1);
				transmetteurLogique.connecter(soundeLogique2);
			}
		} else {
			// Analogique
			source.connecter(emetteur);
			emetteur.connecter(transmetteurAnalogique);
			transmetteurAnalogique.connecter(recepteur);
			recepteur.connecter(destination);
			if (affichage == true) {
				SondeLogique soundeLogique1 = new SondeLogique(
						"Sonde Logique1", 1920);
				SondeLogique soundeLogique2 = new SondeLogique(
						"Sonde Logique2", 1920);
				SondeAnalogique soundeanalogique1 = new SondeAnalogique(
						"Sonde Analogique1");
				SondeAnalogique soundeanalogique2 = new SondeAnalogique(
						"Sonde Analogique2");
				source.connecter(soundeLogique1);
				recepteur.connecter(soundeLogique2);
				emetteur.connecter(soundeanalogique1);
				transmetteurAnalogique.connecter(soundeanalogique2);

			}
		}
	}

	/**
	 * La m�thode analyseArguments extrait d'un tableau de cha�nes de caract�res
	 * les diff�rentes options de la simulation. Elle met � jour les attributs
	 * du Simulateur.
	 * 
	 * @param args
	 *            le tableau des diff�rents arguments. <br>
	 * <br>
	 *            Les arguments autoris�s sont : <br>
	 *            <dl>
	 *            <dt>-mess m</dt>
	 *            <dd>m (String) constitu� de 7 ou plus digits � 0 | 1, le
	 *            message � transmettre</dd>
	 *            <dt>-mess m</dt>
	 *            <dd>m (int) constitu� de 1 � 6 digits, le nombre de bits du
	 *            message "al�atoire" � transmettre</dd>
	 *            <dt>-s</dt>
	 *            <dd>utilisation des sondes d'affichage</dd>
	 *            <dt>-seed v</dt>
	 *            <dd>v (int) d'initialisation pour les g�n�rateurs al�atoires</dd>
	 *            <br>
	 *            <dt>-form f</dt>
	 *            <dd>codage (String) RZ, NRZR, NRZT, la forme d'onde du signal
	 *            � transmettre (RZ par d�faut)</dd>
	 *            <dt>-nbEch ne</dt>
	 *            <dd>ne (int) le nombre d'�chantillons par bit (ne >= 6 pour du
	 *            RZ, ne >= 9 pour du NRZT, ne >= 18 pour du RZ, 30 par d�faut))
	 *            </dd>
	 *            <dt>-ampl min max</dt>
	 *            <dd>min (float) et max (float), les amplitudes min et max du
	 *            signal analogique � transmettre ( min < max, 0.0 et 1.0 par
	 *            d�faut))</dd>
	 *            <br>
	 *            <dt>-snr s</dt>
	 *            <dd>s (float) le rapport signal/bruit en dB</dd>
	 *            <br>
	 *            <dt>-ti i dt ar</dt>
	 *            <dd>i (int) numero du trajet indirect (de 1 � 5), dt (int)
	 *            valeur du decalage temporel du i�me trajet indirect en nombre
	 *            d'�chantillons par bit, ar (float) amplitude relative au
	 *            signal initial du signal ayant effectu� le i�me trajet
	 *            indirect</dd>
	 *            <br>
	 *            <dt>-transducteur</dt>
	 *            <dd>utilisation de transducteur</dd>
	 *            <br>
	 *            <dt>-aveugle</dt>
	 *            <dd>les r�cepteurs ne connaissent ni l'amplitude min et max du
	 *            signal, ni les diff�rents trajets indirects (s'il y en a).</dd>
	 *            <br>
	 *            </dl>
	 * <br>
	 *            <b>Contraintes</b> : Il y a des interd�pendances sur les
	 *            param�tres effectifs.
	 * 
	 * @throws ArgumentsException
	 *             si un des arguments est incorrect.
	 * 
	 */
	public void analyseArguments(String[] args) throws ArgumentsException {

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
			} else if (args[i].matches("-test")) {
				test = true;
			} else
				throw new ArgumentsException("Option invalide :" + args[i]);
		}

	}

	/**
	 * La m�thode execute effectue un envoi de message par la source de la
	 * cha�ne de transmission du Simulateur.
	 * 
	 * @return les options explicites de simulation.
	 * 
	 * @throws Exception
	 *             si un probl�me survient lors de l'ex�cution
	 * 
	 */
	public void execute() throws Exception {
		source.emettre();
		if (test) {
			if (transmetteurAnalogique != null) {
				if (transmetteurAnalogique.getBruit() != null) {
					File f = new File("../testBruit.csv");
					try {
						FileWriter fw = new FileWriter(f);

						for (int i = 1; i < transmetteurAnalogique.getBruit()
								.size() - 1; i++) {
							fw.write(String.valueOf(transmetteurAnalogique
									.getBruit().get(i)));
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
	 * Permet de colculer le Taux d'erreur Binaire d'une ligne de transmission
	 * Entre le source et la destination final
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
		// Prise en compte de la différance de taille est messages
		if (messageON.nbElements() != messageOUT.nbElements()) {
			nbBitFaux += Math.abs(messageON.nbElements()
					- messageOUT.nbElements());
		}
		// retourne le TEB
		return ((float) nbBitFaux / (float) messageON.nbElements());
	}

	/**
	 * La fonction main instancie un Simulateur � l'aide des arguments
	 * param�tres et affiche le r�sultat de l'ex�cution d'une transmission.
	 * 
	 * @param args
	 *            les diff�rents arguments qui serviront � l'instanciation du
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

		try {
			simulateur.execute();
			float tauxErreurBinaire = simulateur.calculTauxErreurBinaire();
			String s = "java  Simulateur  ";
			for (int i = 0; i < args.length; i++) {
				s += args[i] + "  ";
			}
			System.out.println(s + "  =>   TEB : " + tauxErreurBinaire);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.exit(-2);
		}
	}
}
