#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 -test '

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument dt pour un signal NRZ #########'
$cmd_base  -form NRZ -snr 1 -ti 3 300 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 250 0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 200 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 150 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 50 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 0 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 -50 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 -100 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 -150 0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 -200 0.5f  
$cmd_base  -form NRZ -snr 1 -ti 3 -250 0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 -300 0.5f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument dt pour un signal NRZT #########'
$cmd_base  -form NRZT -snr 1 -ti 3 300 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 250 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 200 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 150 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.5f
$cmd_base  -form NRZT -snr 1 -ti 3 50 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 0 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 -50 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 -100 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 -150 0.5f
$cmd_base  -form NRZT -snr 1 -ti 3 -200 0.5f  
$cmd_base  -form NRZT -snr 1 -ti 3 -250 0.5f
$cmd_base  -form NRZT -snr 1 -ti 3 -300 0.5f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument dt pour un signal RZ #########'
$cmd_base  -form RZ -snr 1 -ti 3 300 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 250 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 200 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 150 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 100 0.5f
$cmd_base  -form RZ -snr 1 -ti 3 50 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 0 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 -50 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 -100 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 -150 0.5f
$cmd_base  -form RZ -snr 1 -ti 3 -200 0.5f  
$cmd_base  -form RZ -snr 1 -ti 3 -250 0.5f
$cmd_base  -form RZ -snr 1 -ti 3 -300 0.5f

echo '######### Fin des simulations #########'
