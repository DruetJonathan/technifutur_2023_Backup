/*************************************************
 * 3.5 Alternative : TVA                         *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l'utilisateur de choisir un taux de TVA et
 * d'entrer un prix(hors TVA). 
 * Le programme affiche 
 * - le taux choisi, 
 * - le montant de la TVA 
 * - et le prix TVA comprise.
 */

# Présentation à l'écran
#     Tva 6% (1) 
#     Tva 12% (2) 
#     Tva 21% (3) 
#     Tva 0 % (4) 
#     Sortie (0) 
#     Votre Choix :______
#     Prix (hors TVA) : ____ 
#     Le taux de TVA vaut : XXX
#     Le montant de la TVA est :  XXX
#     Le prix T.V.A.C vaut : XXX

```
var somme,choix,tvaCalc,tauxTva: N <- 0

afficher 'Votre choix: '
saisir choix
afficher 'Votre somme: '
saisir somme

Si choix <= 4 & choix >=0 & (choix % 1) == 0
    Alors saisir somme
    CAS OU choix    
        0:
            Afficher "Sortie de programme"
        1:
            tauxTva = 0.6
        2:
            tauxTva = 1.2
        3:
            tauxTva = 2.1
        4:
            tauxTva = 0
Sinon Afficher "Le nombre saisit en tant que choix est incorrect"
Fin Si

Afficher "Le taux de TVA vaut ",tauxTva
Afficher "Le montant de la TVA est de ", somme * tauxTva
Afficher "Le prix T.V.A.C vaut ", (somme * tauxTva) + somme
```