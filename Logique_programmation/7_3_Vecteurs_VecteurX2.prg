/*************************************************
 * 7.3 Vecteurs : Vecteur X 2                    *
 *************************************************/

/* 
 * Ecrire le programme qui complète le tableau de 16 éléments 
 * en doublant
 * l'élément précédent. Le premier élément vaut 1.
 */

debut prgm
    const TAILLE : N <- 16
    var valeur:N[taille]
    var indice : N <- 1

    valeur[indice] <- 1

    pour indice allant de 2 a TAILLE
        valeur[indice] <- valeur[indice-1]*2
    indice suivant
fin prgm