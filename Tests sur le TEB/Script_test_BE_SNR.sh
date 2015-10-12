#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 -test '

echo '#########  Simulation permettant d'obtenir le TEB en fonction d'un SNR pour un codage NRZ #########'

$cmd_base  -form NRZ -snr 100
$cmd_base  -form NRZ -snr 75
$cmd_base  -form NRZ -snr 50      
$cmd_base  -form NRZ -snr 25
$cmd_base  -form NRZ -snr 20
$cmd_base  -form NRZ -snr 15
$cmd_base  -form NRZ -snr 14
$cmd_base  -form NRZ -snr 13
$cmd_base  -form NRZ -snr 12    
$cmd_base  -form NRZ -snr 11
$cmd_base  -form NRZ -snr 10
$cmd_base  -form NRZ -snr 9
$cmd_base  -form NRZ -snr 8
$cmd_base  -form NRZ -snr 7
$cmd_base  -form NRZ -snr 6
$cmd_base  -form NRZ -snr 5
$cmd_base  -form NRZ -snr 4
$cmd_base  -form NRZ -snr 3
$cmd_base  -form NRZ -snr 2
$cmd_base  -form NRZ -snr 1
$cmd_base  -form NRZ -snr 0
$cmd_base  -form NRZ -snr -1
$cmd_base  -form NRZ -snr -2
$cmd_base  -form NRZ -snr -3
$cmd_base  -form NRZ -snr -4
$cmd_base  -form NRZ -snr -5
$cmd_base  -form NRZ -snr -6
$cmd_base  -form NRZ -snr -7
$cmd_base  -form NRZ -snr -8
$cmd_base  -form NRZ -snr -10
$cmd_base  -form NRZ -snr -15
$cmd_base  -form NRZ -snr -20
$cmd_base  -form NRZ -snr -25
$cmd_base  -form NRZ -snr -30
$cmd_base  -form NRZ -snr -35
$cmd_base  -form NRZ -snr -40
$cmd_base  -form NRZ -snr -50
$cmd_base  -form NRZ -snr -75
$cmd_base  -form NRZ -snr -100

echo '######### Simulation permettant d'obtenir le TEB en fonction d'un SNR pour un codage NRZT #########'

$cmd_base  -form NRZT -snr 100
$cmd_base  -form NRZT -snr 75
$cmd_base  -form NRZT -snr 50      
$cmd_base  -form NRZT -snr 25
$cmd_base  -form NRZT -snr 20
$cmd_base  -form NRZT -snr 15
$cmd_base  -form NRZT -snr 14
$cmd_base  -form NRZT -snr 13
$cmd_base  -form NRZT -snr 12    
$cmd_base  -form NRZT -snr 11
$cmd_base  -form NRZT -snr 10
$cmd_base  -form NRZT -snr 9
$cmd_base  -form NRZT -snr 8
$cmd_base  -form NRZT -snr 7
$cmd_base  -form NRZT -snr 6
$cmd_base  -form NRZT -snr 5
$cmd_base  -form NRZT -snr 4
$cmd_base  -form NRZT -snr 3
$cmd_base  -form NRZT -snr 2
$cmd_base  -form NRZT -snr 1
$cmd_base  -form NRZT -snr 0
$cmd_base  -form NRZT -snr -1
$cmd_base  -form NRZT -snr -2
$cmd_base  -form NRZT -snr -3
$cmd_base  -form NRZT -snr -4
$cmd_base  -form NRZT -snr -5
$cmd_base  -form NRZT -snr -6
$cmd_base  -form NRZT -snr -7
$cmd_base  -form NRZT -snr -8
$cmd_base  -form NRZT -snr -10
$cmd_base  -form NRZT -snr -15
$cmd_base  -form NRZT -snr -20
$cmd_base  -form NRZT -snr -25
$cmd_base  -form NRZT -snr -30
$cmd_base  -form NRZT -snr -35
$cmd_base  -form NRZT -snr -40
$cmd_base  -form NRZT -snr -50
$cmd_base  -form NRZT -snr -75
$cmd_base  -form NRZT -snr -100

echo '#########  Simulation permettant d'obtenir le TEB en fonction d'un SNR pour un codage RZ #########'

$cmd_base  -form RZ -snr 100
$cmd_base  -form RZ -snr 75
$cmd_base  -form RZ -snr 50      
$cmd_base  -form RZ -snr 25
$cmd_base  -form RZ -snr 20
$cmd_base  -form RZ -snr 15
$cmd_base  -form RZ -snr 14
$cmd_base  -form RZ -snr 13
$cmd_base  -form RZ -snr 12    
$cmd_base  -form RZ -snr 11
$cmd_base  -form RZ -snr 10
$cmd_base  -form RZ -snr 9
$cmd_base  -form RZ -snr 8
$cmd_base  -form RZ -snr 7
$cmd_base  -form RZ -snr 6
$cmd_base  -form RZ -snr 5
$cmd_base  -form RZ -snr 4
$cmd_base  -form RZ -snr 3
$cmd_base  -form RZ -snr 2
$cmd_base  -form RZ -snr 1
$cmd_base  -form RZ -snr 0
$cmd_base  -form RZ -snr -1
$cmd_base  -form RZ -snr -2
$cmd_base  -form RZ -snr -3
$cmd_base  -form RZ -snr -4
$cmd_base  -form RZ -snr -5
$cmd_base  -form RZ -snr -6
$cmd_base  -form RZ -snr -7
$cmd_base  -form RZ -snr -8
$cmd_base  -form RZ -snr -10
$cmd_base  -form RZ -snr -15
$cmd_base  -form RZ -snr -20
$cmd_base  -form RZ -snr -25
$cmd_base  -form RZ -snr -30
$cmd_base  -form RZ -snr -35
$cmd_base  -form RZ -snr -40
$cmd_base  -form RZ -snr -50
$cmd_base  -form RZ -snr -75
$cmd_base  -form RZ -snr -100

echo '######### Fin des simulations #########'
