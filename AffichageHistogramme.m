% Placer le document testBruit.csv dans le workspace Matlab

data =csvread('testBruit.csv');
nbInterval = 200;

figure(1)
hist(data, nbInterval);
ylabel('Nombre d''occurrence');
xlabel('Valeur du bruit');
title ('Histogramme d''occurrence');