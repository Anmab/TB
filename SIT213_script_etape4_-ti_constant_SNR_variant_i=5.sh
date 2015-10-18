#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 -testTEB '

echo '#########  Simulation permettant d obtenir le TEB en fonction d un SNR pour un codage NRZ (argument -ti constant) #########'

$cmd_base  -form NRZ -snr 100 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 75 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 50 -ti 5 50 0.5     
$cmd_base  -form NRZ -snr 25 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 20 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 15 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 14 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 13 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 12 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 11 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 10 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 9 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 8 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 7 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 6 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 5 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 4 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 3 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 2 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 1 -ti 5 50 0.5
$cmd_base  -form NRZ -snr 0 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -1 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -2 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -3 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -4 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -5 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -6 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -7 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -8 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -10 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -15 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -20 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -25 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -30 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -35 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -40 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -50 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -75 -ti 5 50 0.5
$cmd_base  -form NRZ -snr -100 -ti 5 50 0.5

echo '######### Simulation permettant d obtenir le TEB en fonction d un SNR pour un codage NRZT (argument -ti constant) #########'

$cmd_base  -form NRZT -snr 100 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 75 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 50 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 25 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 20 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 15 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 14 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 13 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 12 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 11 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 10 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 9 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 8 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 7 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 6 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 5 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 4 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 3 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 2 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 1 -ti 5 50 0.5
$cmd_base  -form NRZT -snr 0 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -1 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -2 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -3 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -4 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -5 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -6 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -7 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -8 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -10 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -15 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -20 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -25 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -30 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -35 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -40 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -50 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -75 -ti 5 50 0.5
$cmd_base  -form NRZT -snr -100 -ti 5 50 0.5

echo '#########  Simulation permettant d obtenir le TEB en fonction d un SNR pour un codage RZ (argument -ti constant) #########'

$cmd_base  -form RZ -snr 100 -ti 5 50 0.5
$cmd_base  -form RZ -snr 75 -ti 5 50 0.5
$cmd_base  -form RZ -snr 50 -ti 5 50 0.5
$cmd_base  -form RZ -snr 25 -ti 5 50 0.5
$cmd_base  -form RZ -snr 20 -ti 5 50 0.5
$cmd_base  -form RZ -snr 15 -ti 5 50 0.5
$cmd_base  -form RZ -snr 14 -ti 5 50 0.5
$cmd_base  -form RZ -snr 13 -ti 5 50 0.5
$cmd_base  -form RZ -snr 12 -ti 5 50 0.5    
$cmd_base  -form RZ -snr 11 -ti 5 50 0.5
$cmd_base  -form RZ -snr 10 -ti 5 50 0.5
$cmd_base  -form RZ -snr 9 -ti 5 50 0.5
$cmd_base  -form RZ -snr 8 -ti 5 50 0.5
$cmd_base  -form RZ -snr 7 -ti 5 50 0.5
$cmd_base  -form RZ -snr 6 -ti 5 50 0.5
$cmd_base  -form RZ -snr 5 -ti 5 50 0.5
$cmd_base  -form RZ -snr 4 -ti 5 50 0.5
$cmd_base  -form RZ -snr 3 -ti 5 50 0.5
$cmd_base  -form RZ -snr 2 -ti 5 50 0.5
$cmd_base  -form RZ -snr 1 -ti 5 50 0.5
$cmd_base  -form RZ -snr 0 -ti 5 50 0.5
$cmd_base  -form RZ -snr -1 -ti 5 50 0.5
$cmd_base  -form RZ -snr -2 -ti 5 50 0.5
$cmd_base  -form RZ -snr -3 -ti 5 50 0.5
$cmd_base  -form RZ -snr -4 -ti 5 50 0.5
$cmd_base  -form RZ -snr -5 -ti 5 50 0.5
$cmd_base  -form RZ -snr -6 -ti 5 50 0.5
$cmd_base  -form RZ -snr -7 -ti 5 50 0.5
$cmd_base  -form RZ -snr -8 -ti 5 50 0.5
$cmd_base  -form RZ -snr -10 -ti 5 50 0.5
$cmd_base  -form RZ -snr -15 -ti 5 50 0.5
$cmd_base  -form RZ -snr -20 -ti 5 50 0.5
$cmd_base  -form RZ -snr -25 -ti 5 50 0.5
$cmd_base  -form RZ -snr -30 -ti 5 50 0.5
$cmd_base  -form RZ -snr -35 -ti 5 50 0.5
$cmd_base  -form RZ -snr -40 -ti 5 50 0.5
$cmd_base  -form RZ -snr -50 -ti 5 50 0.5
$cmd_base  -form RZ -snr -75 -ti 5 50 0.5
$cmd_base  -form RZ -snr -100 -ti 5 50 0.5

echo '######### Fin des simulations #########'
