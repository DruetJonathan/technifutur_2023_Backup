/*****************************************************
 * 8.1 Boucles imbriquées : Tables de multiplication *
 *****************************************************/

/* 
 * Écrire le programme qui affiche les tables de multiplication de 1 à 10. 
 */

#  ( 1 X 1 = 1  à  10 X 10 = 100)

var indice1,indice2: N <- 1

pour indice1 allant de 1 A 10
    pour indice2 allant de 1 A 10
         affiche indice1," x ",indice2," = ",(indice1*indice2)
    indice2 suivant
indice1 suivant