#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 -test '

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument ar pour un signal NRZ #########'
$cmd_base  -form NRZ -snr 1 -ti 3 100 1.0f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.9f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.8f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.7f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.6f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.4f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.3f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.2f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.1f
$cmd_base  -form NRZ -snr 1 -ti 3 100 0.0f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.1f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.2f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.3f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.4f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.5f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.6f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.7f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.8f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -0.9f
$cmd_base  -form NRZ -snr 1 -ti 3 100 -1.0f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument ar pour un signal NRZT #########'
$cmd_base  -form NRZT -snr 1 -ti 3 100 1.0f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.9f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.8f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.7f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.6f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.5f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.4f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.3f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.2f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.1f
$cmd_base  -form NRZT -snr 1 -ti 3 100 0.0f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.1f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.2f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.3f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.4f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.5f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.6f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.7f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.8f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -0.9f
$cmd_base  -form NRZT -snr 1 -ti 3 100 -1.0f

echo '#########  Simulation permettant d obtenir le TEB en fonction de l argument ar pour un signal RZ #########'

$cmd_base  -form RZ -snr 1 -ti 3 100 1.0f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.9f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.8f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.7f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.6f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.5f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.4f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.3f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.2f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.1f
$cmd_base  -form RZ -snr 1 -ti 3 100 0.0f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.1f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.2f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.3f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.4f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.5f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.6f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.7f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.8f
$cmd_base  -form RZ -snr 1 -ti 3 100 -0.9f
$cmd_base  -form RZ -snr 1 -ti 3 100 -1.0f

echo '######### Fin des simulations #########'
