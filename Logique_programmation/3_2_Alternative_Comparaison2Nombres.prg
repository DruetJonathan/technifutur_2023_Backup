/*************************************************
 * 3.2 Alternative : Comparaison de 2 nombres    *
 *************************************************/

/* 
 * Écrire le programme qui compare deux nombres et qui indique quel est le plus
 * grand ou s’ils sont égaux.
 */

debut programme
    variable locale
        var a : N <- 0
        var b : N <- 0
    fin variable locale
    si a > b
        affiche " a > b"
        sinonsi a < b
            affiche " a < b "
        sinon
            affiche "a = b"
    fin de si
fin programme
