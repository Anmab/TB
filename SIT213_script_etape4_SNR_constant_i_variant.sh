#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 -test '

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument i pour un signal NRZ #########'
$cmd_base  -form NRZ -snr 50 -ti 1 50 0.5f  
$cmd_base  -form NRZ -snr 50 -ti 2 50 0.5f  
$cmd_base  -form NRZ -snr 50 -ti 3 50 0.5f  
$cmd_base  -form NRZ -snr 50 -ti 4 50 0.5f  
$cmd_base  -form NRZ -snr 50 -ti 5 50 0.5f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument i pour un signal NRZT #########'
$cmd_base  -form NRZT -snr 50 -ti 1 50 0.5f  
$cmd_base  -form NRZT -snr 50 -ti 2 50 0.5f  
$cmd_base  -form NRZT -snr 50 -ti 3 50 0.5f  
$cmd_base  -form NRZT -snr 50 -ti 4 50 0.5f  
$cmd_base  -form NRZT -snr 50 -ti 5 50 0.5f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument i pour un signal RZ #########'
$cmd_base  -form RZ -snr 50 -ti 1 50 0.5f  
$cmd_base  -form RZ -snr 50 -ti 2 50 0.5f  
$cmd_base  -form RZ -snr 50 -ti 3 50 0.5f  
$cmd_base  -form RZ -snr 50 -ti 4 50 0.5f  
$cmd_base  -form RZ -snr 50 -ti 5 50 0.5f

echo '######### Fin des simulations #########'
