/*************************************************
 * 9.2 Tableau à 2 Dimensions : Copie tableau    *
 *************************************************/

/* 
 * Ecrire le programme  qui copie les éléments d’un tableau à 2 dimensions
 * dans un tableau à une dimension du même nombre de cases.
 */

#  1. Faire l’exercice en utilisant 3 variables d’indice
#  2. Faire l’exercice en utilisant 2 variables d’indice
#  3. Faire l’exercice en utilisant 1 variable d’indice

debut prgm
    const TAILLE : N <- 4
    VAR   tab:N[TAILLE][TAILLE]
    VAR   tab2:N[TAILLE][TAILLE]
    var l,c : N <- 1

    pour l allant de 1 à taille
        pour c allant de 1 à taille
            tab2[l,c] = tab[l,c]
        cpt suivant
    cpt suivant

fin prgm