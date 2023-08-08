/*************************************************
 * 7.2 Vecteurs : Min max vecteur                *
 *************************************************/

/* 
 * Ecrire le programme qui affiche le maximum et le minimum des valeurs 
 * d’un vecteur de nombres, ainsi que leur position dans le tableau.
 */


debut prgm
    const TAILLE : N <- 10
    var valeur:N[taille]
    var indice : N <- 1
    var min,max,posMin,posMax : N <- 0

    afficher "Entrez les ",const,"nombre"
    pour indice allant de 1 a TAILLE
        saisir valeur[indice]
    indice suivant
    

    indice <- 1
    min <- valeur[indice]
    max <- valeur[indice]
    indice <- indice +1

    pour indice allant de 1 a TAILLE -1
        si valeur[indice] < min
            alors
                posMin = indice
            sinon
                posMax = indice
        finsi
    indice suivant
    
    min = valeur[posMin]
    max = valeur[posMax]
    
fin prgm