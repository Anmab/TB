#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission        ###"
echo "### Chaine transmission logique parfaite en Java                    ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo 

# if [ -d "./test" ]
# then
# 	DATE=`date +%Y-%m-%d:%H:%M:%S`
# 	mv  test test-$DATE.OLD
# fi
# mkdir test

# echo Début du test : >> ./test/log.txt
# echo  $DATE >> ./test/log.txt
 cd ./bin


BEFORE=$SECONDS
java simulateur.Simulateur -form RZ -snr -1 -mess 40000 
ELAPSED=$(($SECONDS-$BEFORE))
echo $ELAPSED
#  RZ
# for i in {30..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -test TEB -mess 4000 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -test TEB -mess 4000 
# 	done
# done

# NRZ
# for i in {30..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form NRZ -snr -$i.$j -test TEB -mess 4000 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form NRZ -snr $i.$j -test TEB -mess 4000 
# 	done
# done

# # NRZT
# for i in {30..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form NRZT -snr -$i.$j -test TEB -mess 4000 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form NRZT -snr $i.$j -test TEB -mess 4000 
# 	done
# done

