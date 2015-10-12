% Placer le document testBruit.csv dans le workspace Matlab
clear all;
close all;


data =csvread('testBruit.csv');
nbInterval = 200;
[occurrences, valeurs] = hist(data, nbInterval);
occurrences = transpose(occurrences);
valeurs = transpose(valeurs);
matrice = cat(2, occurrences, valeurs);

moyenneValeur = mean(valeurs);

% Calcul de la moyenne de l'histogramme

hist(data, nbInterval);

H=findobj('Type','Patch');
X=get(H,'XData'); 
X=mean(X,1); 

Y=get(H,'YData');
Y=Y(2,:);

OUT=[];
for ii=1:length(Y)
    OUT=[OUT,repmat(X(ii),1,Y(ii))];
end

moyenneHist=mean(OUT);

% Affiche si le processus est centre
if((moyenneValeur < 0.3) && (moyenneValeur > -0.3))
    fprintf('\n\n-------------------\nCentre en 0 ...\n-------------------\n\n');
else
    fprintf('\n\n-------------------\nN''est pas centre en 0 ...\n-------------------\n\n');
end

% Affichage des graphiques
figure(1)
subplot(1,2,1);
hist(data, nbInterval);
ylabel('Nombre d''occurrence');
xlabel('Valeurs du bruit');
title ('Histogramme d''occurrence');

subplot(1,2,2);
hold on;
plot(valeurs, occurrences);
plot([moyenneHist,moyenneHist],ylim,'g--','linewidth',2)
ylabel('Nombre d''occurrence');
xlabel('Valeurs du bruit');
title ('Occurrence en fonction des valeurs du bruit');
hold off;


