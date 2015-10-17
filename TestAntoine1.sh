#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission         ###"
echo "### Chaine transmission logique parfaite en Java séance 1           ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL  ###" 
echo "#######################################################################"
echo
cd ./bin
for i in {-25..10..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form RZ -snr $i.$j -test -mess 2000
	done
done



# for i in {-25..10..1}
# do
# java simulateur.Simulateur -form NRZ -snr $i -test -mess 2000
# done
# for i in {-25..10..1}
# do
# java simulateur.Simulateur -form RZT -snr $i -test -mess 2000
# done