#!/bin/bash
echo "###################################################################"
echo "### FIP SIT213 : atelier logiciel : systèmes de transmission    ###"
echo "### Chaîne transmission logique parfaite en Java séance 1       ###" 
echo "### Antoine Dunan / Aymeric Scerrer                             ###" 
echo "###################################################################"
echo
echo " TEST : "
echo " Les tests ne sont pas compilé (src/test/SimulateurTest.java), néanmoins une série non exhaustive de test va débuter. Fermez une sonde pour passé au test suivant"
cd ./bin/
echo
echo " -mess 010101010101 Signale déterminé sans sonde"
java simulateur.Simulateur -mess 010101010101
java simulateur.Simulateur -mess 111111111111111
echo
echo " -s Signal aléatoire de 99 bits sans sode"
java simulateur.Simulateur -mess 99
echo
echo " -s Signal aléatoire de 99 bits sans sode avec seed"
java simulateur.Simulateur -mess 99 -seed 2
echo
echo " -s Signal aléatoire de 100 bits avec sode"
java simulateur.Simulateur -s