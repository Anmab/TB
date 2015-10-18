package simulateur;

public class Help {
 public Help(){
  System.out.println("Ce document recapitule les modalites d'invocation du simulateur, afin d'harmoniser l'utilisation des simulateurs rendus par les differentes equipes. La documentation ci-dessous est fournie se lon le modèle de pages man Linux.");
  System.out.println("SIMULATEUR(1)");
  System.out.println("NAME");
  System.out.println("Simulation de la transmission d'un message numerique.");
  System.out.println();
  System.out.println("SYNOPSIS");
  System.out.println("java Simulateur [...]");
  System.out.println();
  System.out.println("DESCRIPTION");
  System.out.println("Il s'agit de simuler la transmission d'un message numerique (train de bits 0 ou 1) dans un système de transmission entre un point d’entree jusqu'a un point de sortie,via un canal de transmission (ou de communication).Les nombreux paramètres de la simulation permettent de choisir les caracteristiques du message a trans mettre, du canal de propagation et du système de transmission.");
  System.out.println("Le resultat de la simulation est la valeur du taux,d’erreur binaire de la transmission totale (TEB). Les graphiques reproduisant le signal a differents etages du système de transmission (si option –s ) sont assimilables a des resultats.");
  System.out.println();
  System.out.println(" OPTIONS :");
  System.out.println("Par defaut le simulateur doit utiliser une chaîne de transmission logique, avec un message aleatoire de longueur 100, sans utilisation de sondes et sans utilisation de transducteur.");
  System.out.println();
  System.out.println("-mess m");
  System.out.println("precise le message ou la longueur du message a emettre :");
  System.out.println("Si m est une suite de 0 et de 1 de longueur au moins egale a 7, m est le message a emettre.");
  System.out.println("Si m comporte au plus 6 chiffres decimaux et correspond a la representation en base 10 d'un entier, cet entier est la longueur du message que le simulateur doit generer et transmettre.");
  System.out.println("Par defaut le simulateur doit generer et transmettre un message de longueur 100.");
  System.out.println();
  System.out.println("-s");
  System.out.println("indique l’utilisation des sondes. Par defaut le simulateur n’utilise pas de sondes");
  System.out.println();
  System.out.println("-seed v");
  System.out.println("precise l’utilisation d’une semence pour l’initialisation des generateurs aleatoires du simulateur. v doit être une valeur entière. L’utilisation d’une semence permet de rejouer a l’identique une simulation (a la fois pour le message emis et le bruitage s’il est active).Par defaut le simulateur n’utilise pas de semence pour initialiser ses generateurs aleatoires.");
  System.out.println();
  System.out.println("-form f");
  System.out.println("utilisation d’une transmission analogique, f precise la forme d’onde. Le paramètre f peut prendre les valeurs suivantes :");
  System.out.println("NRZ forme d'onde rectangulaire");
  System.out.println("NRZT forme d'onde trapezoïdale (temps de montee ou de descente a 1/3 du temps bit)");
  System.out.println("RZ forme d'onde impulsionnelle (amplitudemin sur le premier et dernier tiers du temps bit, impulsionnelle sur le tiers central ave c un max au milieu du temps bit egal a l’amplitude max)");
  System.out.println("Par defaut le simulateur doit utiliser la forme d’onde RZ pour le signal analogique.");
  System.out.println();
  System.out.println("-nbEch ne");
  System.out.println("utilisation d’une transmission analogique, ne precise le nombre d’echantillons par bit. ne doit être une valeur entière positive. Par defaut le simulateur doit utiliser 30 echantillons par bit.");
  System.out.println();
  System.out.println("-ampl min max");
  System.out.println("utilisation d’une transmission analogique, min et max precisent l’amplitude min et max du signal. min et max doivent être des valeurs flottantes (avec min < max ). Par defaut, le simulateur doit utiliser 0.0f comme min et 1.0f comme max.");
  System.out.println();
  System.out.println("-snr s");
  System.out.println("utilisation d’une transmission analogique bruitee, c'est la valeur du rapport signal sur bruit (SNR en dB). Le paramètre s doit être une valeur flottante.");
  System.out.println();
  System.out.println("-ti i dt ar");
  System.out.println("utilisation d’une transmission analogique multitrajet. dt precise le decalage temporel (en nombre d’echantillons) entre le i ème trajet indirect du signal et le trajet direct, ar precise l’amplitude relative du signal du i ème trajet indirect par rapport a celle du signal du trajet direct. Les paramètres i, dt et ar doivent être respectivement une valeur entière (de 1 a 5), une valeur entière et une valeur flottante. Par defaut le simulateur doit utiliser 0 et 0. 0f pour tous les trajets indirects (5 au maximum).");
  System.out.println();
  System.out.println("-transducteur");
  System.out.println("precise l’utilisation d’un transducteur (en emission et reception). Par defaut, le simulateur n’utilise pas de transducteur.");
  System.out.println();
  System.out.println("-aveugle");
  System.out.println("precise l’utilisation de mecanismes de determination, dans les etages de reception du signal analogique, des amplitudes min et max, des retards et de leurs amplitudes relatives. Par defaut, le simulateur n’utilise pas ces mecanismes, et les valeurs des amplitudes min et max, de s retards et de leurs amplitudes relatives sont des paramètres des etages de reception. ");
  System.out.println();
  System.out.println("-h -help");
  System.out.println("premet d'afficher ce messge d'aide");
  System.out.println();
  System.out.println("-testTEB");
  System.out.println("Permet d'enregisterer les résultats de la simulation");
  System.out.println("-testBruit");
  System.out.println("Permets de generer un fichier .Csv qui contient les echantillons du bruit geneges par le simulateur ne fonctionne que lorsque la transmission est bruitee");

 }
}
