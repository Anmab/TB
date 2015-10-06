#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : syste mes de transmission       ###"
echo "### Chaine transmission logique parfaite en Java séance 1          ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo
echo " TEST : "
echo " Les tests ne sont pas compile (src/test/SimulateurTest.java), neanmoins une serie non exhaustive de test va debuter. Fermez une sonde pour passe au test suivant"
cd ./bin/
cd bin
java simulateur.Simulateur -mess 000000000000000000000000000000
java simulateur.Simulateur -mess 111111111111111111111111111111
java simulateur.Simulateur -mess 010101010101010101010101010101
java simulateur.Simulateur -mess 000101111101000100111100001001