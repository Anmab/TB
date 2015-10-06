#!/bin/bash
echo "########################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission    		###"
echo "### Chaine transmission logique parfaite en Java séance 1    	    ###" 
echo "### Antoine Dunan / Aymeric Scherrer / Sophie Daniel / Anais Mabille  ###" 
echo "########################################################################"
echo
echo " TEST : "
echo " Les tests ne sont pas compile (src/test/SimulateurTest.java), neanmoins une serie non exhaustive de test va debuter. Fermez une sonde pour passe au test suivant"
cd ./bin/
echo
echo " -mess 010101010101 Signale determine sans sonde"
java simulateur.Simulateur -mess 010101010101
java simulateur.Simulateur -mess 111111111111111
echo
echo " -s Signal aleatoire de 99 bits sans sode"
java simulateur.Simulateur -mess 99
echo
echo " -s Signal aleatoire de 99 bits sans sode avec seed"
java simulateur.Simulateur -mess 99 -seed 2
echo
echo " -s Signal aleatoire de 100 bits avec sonde"
java simulateur.Simulateur -s