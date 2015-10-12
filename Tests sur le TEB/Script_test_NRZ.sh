#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 '

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
