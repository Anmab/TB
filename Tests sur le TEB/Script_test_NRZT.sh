#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 '

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

echo '######### Fin des simulations #########'
