/*************************************************
 * 8.2 Boucles imbriquées : Compteur digital     *
 *************************************************/

/* 
 * Ecrire le programme qui simule l’affichage d’un compteur digital à 3 chiffres
 */

#  000,
#  001,
#  ...,
#  009,
#  010,
#  ...,
#  099,
#  100,
#  ...,
#  999

Début pgm compteur

var c : N <- 0 
var b : N <- 0
var a : N <- 0

pour a allant de 0 a 9
    pour b allant de 0 a 9
        pour c allant de 0 a 9
            affiche a,b,c
        c suivant
    b suivant
a suivant
--------------------
pour cpt allant de 0 a 999
    centaine <- cpt div 100
    dizaine <- (cpt mod 100)div 10
    unite <- cpt mod 10
cpt suivant