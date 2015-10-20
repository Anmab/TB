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

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 
# 	done
# done


# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.1
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.1
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40 -ti 4 30 0.60
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40 -ti 4 30 0.60
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40 -ti 4 30 0.60 -ti 5 40 0.75
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.1 -ti 2 10 0.25 -ti 3 20 0.40 -ti 4 30 0.60 -ti 5 40 0.75
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.2 -ti 2 10 0.25 -ti 3 30 0.45 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.2 -ti 2 10 0.25 -ti 3 30 0.45 
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.3 -ti 2 10 0.25 -ti 3 25 0.45 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.3 -ti 2 10 0.25 -ti 3 25 0.45 
# 	done
# done

# for i in {40..0..-1}
# do
# 	for j in {9..0..-1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr -$i.$j -testTEB -mess 10000 -ti 1 5 0.3 -ti 2 10 0.25 -ti 3 30 0.40 
# 	done
# done
# for i in {0..20..1}
# do
# 	for j in {0..9..1}
# 	do
# 		java simulateur.Simulateur -form RZ -snr $i.$j -testTEB -mess 10000 -ti 1 5 0.3 -ti 2 10 0.25 -ti 3 30 0.40 
# 	done
# done