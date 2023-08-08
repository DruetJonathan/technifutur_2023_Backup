/*************************************************************
 * 9.3 Tableau à 2 Dimensions : Moyenne, min, max, par ligne *
 *************************************************************/

/* 
 * Ecrire le programme  qui affiche la moyenne le maximum et le minimum 
 * de chaque ligne d’un tableau à deux dimensions.
 */

debut prgm
    const TAILLE : N <- 4
    VAR   tab:N[TAILLE][TAILLE]
    VAR   tab2:N[3][TAILLE]
    var l,c : N <- 1
    var s,min,max : N <- 0


    pour l allant de 1 à taille
        min <- tab[l,c]
        max <- tab[l,c]
        pour c allant de 1 à taille
            s <- s + tab[l,c]
            si tab[l,c] < min
                alors
                    min = tab[l,c]
            sinon
                max = tab[l,c]
            finsi
        cpt suivant
        tab2[l,1] <- s / TAILLE
        tab2[l,2] <- min
        tab2[l,3] <- max
        s <- 0

    cpt suivant

fin prgm
.