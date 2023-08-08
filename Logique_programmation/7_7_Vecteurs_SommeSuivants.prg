/*************************************************
 * 7.7 Vecteurs : Somme des suivants             *
 *************************************************/

/* 
 * Soit un tableau de 10 éléments déjà initialisés, écrire un programme 
 * qui modifie le tableau de telle manière que chaque élément reçoive la 
 * somme de tous les éléments d'indice supérieur ou égal à lui-même.
 */

debut prgm
    const TAILLE <- 10
    var tabValeur:N[TAILLE]
    var indice : N <- TAILLE

    Pour indice allant de TAILLE-1 A 1
        tabValeur[indice] <- tabValeur[indice]  + tabValeur[indice+1]
    indice precedent

fin prgm