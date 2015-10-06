#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission         ###"
echo "### Chaine transmission logique parfaite en Java seance 3            ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL  ###" 
echo "#######################################################################"
echo
echo " TEST 4 : "
echo " Les tests ne sont pas compile (src/test/SimulateurTest.java), neanmoins une serie non exhaustive de test va debuter. Fermez une sonde pour passe au test suivant"
cd ./bin/
TableauTEB[11];
TableauSNR[11];
echo
java simulateur.Simulateur -form RZ -snr 1
tabSNR[0] = 1;
tabTEB[0] = simulateur.calculTauxErreurBinaire();
echo
java simulateur.Simulateur -form NRZ -snr 2
tabTEB[1] = simulateur.calculTauxErreurBinaire();
tabSNR[1] = 2;
echo
java simulateur.Simulateur -form NRZT -snr 0,5
tabTEB[2] = simulateur.calculTauxErreurBinaire();
tabSNR[2] = 0,5;
echo
java simulateur.Simulateur -form RZ -ampl -3 -1 -snr 0,1
tabTEB[3] = simulateur.calculTauxErreurBinaire();
tabSNR[3] = 0,1;
echo
java simulateur.Simulateur -form NRZ -ampl -3 -1 -snr 1
tabTEB[4] = simulateur.calculTauxErreurBinaire();
tabSNR[4] = 1;
echo
java simulateur.Simulateur -form NRZT -ampl -3 -1 -snr 0,5
tabTEB[5] = simulateur.calculTauxErreurBinaire();
tabSNR[5] = 0,5;
echo
java simulateur.Simulateur -form RZ -ampl -3 10 -snr 0,8
tabTEB[6] = simulateur.calculTauxErreurBinaire();
tabSNR[6] = 0,8;
echo
java simulateur.Simulateur -form NRZ -ampl -3 10 -snr 2
tabTEB[7] = simulateur.calculTauxErreurBinaire();
tabSNR[7] = 2;
echo
java simulateur.Simulateur -form NRZT -ampl -3 10 -snr 1
tabTEB[8] = simulateur.calculTauxErreurBinaire();
tabSNR[8] = 1;
echo
java simulateur.Simulateur -form RZ -nbEch 100 -snr 0,5
tabTEB[9] = simulateur.calculTauxErreurBinaire();
tabSNR[9] = 0,5;
echo
java simulateur.Simulateur -form NRZ -nbEch 100 -snr 2
tabTEB[10] = simulateur.calculTauxErreurBinaire();
tabSNR[10] = 2;
echo
java simulateur.Simulateur -form NRZT -nbEch 100 -snr 4
tabTEB[11] = simulateur.calculTauxErreurBinaire();
tabSNR[11] = 4;
