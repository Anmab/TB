#!/bin/bash

cd ./bin/
cmd_base='java simulateur.Simulateur -mess 1000 '
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
