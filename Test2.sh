#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systèmes de transmission        ###"
echo "### Chaîne transmission logique parfaite en Java séance 1           ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anaïs MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo
echo " TEST : "
echo " Les tests ne sont pas compilé (src/test/SimulateurTest.java), néanmoins une série non exhaustive de test va débuter. Fermez une sonde pour passé au test suivant"
cd ./bin/
cd bin
java simulateur.Simulateur -mess 000000000000000000000000000000
java simulateur.Simulateur -mess 111111111111111111111111111111
java simulateur.Simulateur -mess 010101010101010101010101010101
java simulateur.Simulateur -mess 000101111101000100111100001001