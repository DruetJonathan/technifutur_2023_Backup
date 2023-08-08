/**************************************************************
 * 9.5 Tableau à 2 Dimensions : Rotation d’une matrice carrée *
 **************************************************************/

/* 
 * Ecrire le programme  qui déplace les valeurs d’un tableau carré d’un quart
 * de tour dans le sens horlogique. 
 */

#  - Version 1 : utilisation d’un tableau intermédiaire de même taille
#  - Version 2 : utilisation d’une seul variable intermédiaire. 

#  Exemple : 
#   +---+---+---+     +---+---+---+
#   | A | B | C |     | G | D | A | 
#   +---+---+---+     +---+---+---+
#   | D | E | F |     | H | E | B | 
#   +---+---+---+     +---+---+---+
#   | G | H | I |     | I | F | C | 
#   +---+---+---+     +---+---+---+


debut prgm



fin prgm

1,1 -> 1,3
1,2 -> 2,3
1,3 -> 3,3

------------> i = 1,2,3 et J = la taille max

2,1 -> 1,2
2,2 -> 2,2
2,3 -> 3,2

-----------> i = 1,2,3 et j = taille max-1

3,1 -> 1,1
3,2 -> 2,1
3,3 -> 3,1

pour i allant de 1 à taille
    pour j allant de 1 a taille
        newTab[i,j] <- [taille - j + 1,i]
    j suivant
i suivant