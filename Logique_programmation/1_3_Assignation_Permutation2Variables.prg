/***********************************************
 * 1.3 Assignation : Permutation 2 variables   *
 ***********************************************/

/* 
 * Ecrire le programme qui permet de permuter les valeurs de X et de Y.  
 * La valeur de X vaut 3 et la valeur de Y vaut 5.
 */


début prgm
    debut Variables locale
        var x : N <- 3
        var y : N <- 5
        var tempVar : N <- x
    fin Variables locale
    tempVar = x
    x = y
    y = tempVar
fin prgm