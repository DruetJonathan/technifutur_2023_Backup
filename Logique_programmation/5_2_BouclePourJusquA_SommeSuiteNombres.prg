/********************************************************************
 * 5.2 Boucle Pour et jusqu’à ce que : Somme d'une suite de nombres *
 ********************************************************************/

/* 
 * Écrire le programme qui affiche la somme des valeurs comprises entre deux 
 * nombres entrés au clavier.
 */

#  Les deux valeurs entrées font partie du total.
#  Si les deux valeurs sont identiques, le total est égal à cette valeur.

#  Exemple :
#     Valeur 1 = 5
#     Valeur 2 = 9
#     Total = 5 + 6 + 7 + 8 + 9 = 35

var valeur1,valeur2: N <-0


pour compteurBoucle allant de valeur1 A valeur2 // BORNE COMPRISES
    somme += compteurBoucle
finPour

afficher "La somme des valeurs entre ",valeur1," et ",valeur2," comprises est de ",somme