#!/bin/bash
echo "#######################################################################"
echo "### FIP SIT213 : atelier logiciel : systèmes de transmission        ###"
echo "### Chaîne transmission logique parfaite en Java séance 1           ###" 
echo "### Antoine Dunan / Aymeric Scerrer / Anaïs MABILLE / Sophie DANIEL ###" 
echo "#######################################################################"
echo
echo "Compilation du programme ..."
echo
mv ./src/test ./
mkdir ./bin
javac ./src/*/*.java -d ./bin
echo
echo "Création de la JavaDoc ..."
echo
mkdir ./doc
javadoc ./src/*/* -d doc
mv ./test ./src/test 
echo
echo "FIN"
echo