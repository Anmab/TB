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

# NRZ
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
mv  ../test ../test-ti-null.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.1
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.1
	done
done
mv  ../test ../test-ti-1-10-0.1.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.2
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.2
	done
done
mv  ../test ../test-ti-1-10-0.2.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.3
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.3
	done
done
mv  ../test ../test-ti-1-10-0.3.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.4
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.4
	done
done
mv  ../test ../test-ti-1-10-0.4.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.5
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.5
	done
done
mv  ../test ../test-ti-1-10-0.5.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.6
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.6
	done
done
mv  ../test ../test-ti-1-10-0.6.OLD
mkdir ../test

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 10 0.7
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 10 0.7
	done
done
mv  ../test ../test-ti-1-10-0.7.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.1
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.1
	done
done
mv  ../test ../test-ti-1-20-0.1.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.2
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.2
	done
done
mv  ../test ../test-ti-1-20-0.2.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.3
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.3
	done
done
mv  ../test ../test-ti-1-20-0.3.OLD
mkdir ../test

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.4
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.4
	done
done
mv  ../test ../test-ti-1-20-0.4.OLD
mkdir ../test

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.5
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.5
	done
done
mv  ../test ../test-ti-1-20-0.5.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.6
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.6
	done
done
mv  ../test ../test-ti-1-20-0.6.OLD
mkdir ../test

for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 20 0.7
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 20 0.7
	done
done
mv  ../test ../test-ti-1-20-0.7.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.1
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.1
	done
done
mv  ../test ../test-ti-1-30-0.1.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.2
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.2
	done
done
mv  ../test ../test-ti-1-30-0.2.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.3
	done
done
for i in {0..20..1}
do
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.3
	done
done
mv  ../test ../test-ti-1-30-0.3.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.4
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.4
	done
done
mv  ../test ../test-ti-1-30-0.4.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.5
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.5
	done
done
mv  ../test ../test-ti-1-30-0.5.OLD
mkdir ../test
for i in {40..0..-1}
do
	for j in {9..0..-1}
	do
		java simulateur.Simulateur -form NRZ -snr -$i.$j -testTEB -mess 10000 -ti 1 30 0.6
	done
done
for i in {0..20..1}
do
	for j in {0..9..1}
	do
		java simulateur.Simulateur -form NRZ -snr $i.$j -testTEB -mess 10000 -ti 1 30 0.6
	done
done
mv  ../test ../test-ti-1-30-0.6.OLD
mkdir ../test