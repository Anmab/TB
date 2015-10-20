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
cd ./bin


# NRZ -ti 0
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 
	done
done


for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 15 0.2
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 15 0.2
	done
done


for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 15 0.2 -ti 2 30 0.4
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 15 0.2 -ti 2 30 0.4
	done
done
