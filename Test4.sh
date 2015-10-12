#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission         ###"
echo "### Chaine transmission logique parfaite en Java séance 1           ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL  ###" 
echo "#######################################################################"
echo
echo " TEST 4 : "
echo " Les tests ne sont pas compile (src/test/SimulateurTest.java), neanmoins une serie non exhaustive de test va debuter. Fermez une sonde pour passe au test suivant"
cd ./bin/
echo
echo " Signal aleatoire sans sonde en NRZ RZ NRZT amplitude non entière"
echo
java simulateur.Simulateur -form RZ -ampl -1 1
echo
java simulateur.Simulateur -form NRZ -ampl -1.1 2
echo
java simulateur.Simulateur -form NRZT -ampl -5.5 -3
echo
echo
echo " Signal aleatoire sans sonde en NRZ RZ NRZT avec snr positif"
echo
java simulateur.Simulateur -form RZ -snr 10
echo
java simulateur.Simulateur -form NRZ -snr 100
echo
java simulateur.Simulateur -form NRZT -snr 3
echo
echo " Signal aleatoire sans sonde en NRZ RZ NRZT avec snr négatif"
echo
java simulateur.Simulateur -form RZ -snr -10
echo
java simulateur.Simulateur -form NRZ -snr -100
echo
java simulateur.Simulateur -form NRZT -snr -3
echo