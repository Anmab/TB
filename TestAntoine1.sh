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

# BEFORE=$SECONDS
# java simulateur.Simulateur -form RZ -snr -1 -mess 40000 
# ELAPSED=$(($SECONDS-$BEFORE))
# echo $ELAPSED
# RZ

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 99999 -transducteur
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 99999 -transducteur
	done
done

# NRZ
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 99999 -transducteur
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 99999 -transducteur
	done
done

# NRZT
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZT -snr -$i.$j -testTEB -mess 99999 -transducteur
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZT -snr $i.$j -testTEB -mess 99999 -transducteur
	done
done

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 99999 
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 99999
	done
done

# NRZ
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 99999
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 99999
	done
done

# NRZT
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZT -snr -$i.$j -testTEB -mess 99999
	done
done
for i in {0..25..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZT -snr $i.$j -testTEB -mess 99999
	done
done
