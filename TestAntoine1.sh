#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systemes de transmission        ###"
echo "### Chaine transmission logique parfaite en Java                    ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anais MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo 

if [ -d "./test" ]
then
	DATE=`date +%Y-%m-%d:%H:%M:%S`
	mv  test test-$DATE.OLD
fi
mkdir test

echo Début du test : >> ./test/log.txt
echo  $DATE >> ./test/log.txt
cd ./bin
BEFORE=$SECONDS

#  RZ
for i in {-30..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form RZ -snr $i.$j -test TEB -mess 4000 
	done
done

ELAPSED1=$(($SECONDS-$BEFORE))
echo RZ ok : >> ./test/log.txt
echo  ELAPSED1 >> ./test/log.txt

# NRZ
for i in {-30..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -test TEB -mess 4000 
	done
done

ELAPSED2=$(($SECONDS-$ELAPSED1))

echo NRZ ok : >> ./test/log.txt
echo  ELAPSED2 >> ./test/log.txt

# NRZT
for i in {-30..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZT -snr $i.$j -test TEB -mess 4000 
	done
done

ELAPSED3=$(($SECONDS-$ELAPSED2))
ELAPSEDF1=$(($SECONDS-$BEFORE))
echo NRZT ok : >> ./test/log.txt
echo  ELAPSED3 >> ./test/log.txt
echo Fase 1 ok : >> ./test/log.txt
echo  ELAPSEDF1 >> ./test/log.txt
