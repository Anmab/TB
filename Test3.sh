#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systèmes de transmission        ###"
echo "### Chaîne transmission logique parfaite en Java séance 1           ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anaïs MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo
echo " TEST 3 : "
echo " Les tests ne sont pas compilé (src/test/SimulateurTest.java), néanmoins une série non exhaustive de test va débuter. Fermez une sonde pour passé au test suivant"
cd ./bin/
echo
echo " Signale aléatoire sans sonde en NRZ RZ NRZT"
echo
java simulateur.Simulateur -form RZ
echo
java simulateur.Simulateur -form NRZ
echo
java simulateur.Simulateur -form NRZT
echo
echo " Signale aléatoire sans sonde en NRZ RZ NRZT -amplitude négative"
echo
java simulateur.Simulateur -form RZ -ampl -3 -1
echo
java simulateur.Simulateur -form NRZ -ampl -3 -1
echo
java simulateur.Simulateur -form NRZT -ampl -3 -1
echo
echo " Signale aléatoire sans sonde en NRZ RZ NRZT -amplitude négative/positive"
echo
java simulateur.Simulateur -form RZ -ampl -3 10
echo
java simulateur.Simulateur -form NRZ -ampl -3 10
echo
java simulateur.Simulateur -form NRZT -ampl -3 10
echo
echo " Signale aléatoire sans sonde en NRZ RZ NRZT avec 100 echantillons"
echo
java simulateur.Simulateur -form RZ -nbEch 100
echo
java simulateur.Simulateur -form NRZ -nbEch 100
echo
java simulateur.Simulateur -form NRZT -nbEch 100
