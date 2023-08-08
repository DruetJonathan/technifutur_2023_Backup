/************************************************************** 
 * 9.1 Tableau à 2 Dimensions : Diagonales d’un tableau carré *
 **************************************************************/

/* 
 * Ecrire le programme  qui initialise les cases de la diagonale principale 
 * d’un tableau carré avec la valeur 1 et les cases de la diagonale secondaire 
 * avec la valeur 2.
 */

#Exemple : 	
#  
#  +---+---+---+---+
#  | 1 |   |   | 2 |
#  +---+---+---+---+
#  |   | 1 | 2 |   |
#  +---+---+---+---+
#  |   | 2 | 1 |   |
#  +---+---+---+---+
#  | 2 |   |   | 1 |
#  +---+---+---+---+
1;4
2;3
3;2
4;1

debut prgm

    var iLigne,iColonne <- N: 1
    const TAILLE : N <- 4
    VAR   tab:N[TAILLE][TAILLE]
    pour iLigne allant de 1 à TAILLE
        pour iColonne allant de 1 à TAILLE
            si  iColonne = iLigne
                alors
                    tab[iLigne][iColonne] <- 1
            sinon si iColonne + iLigne == taille +1
                    tab[iLigne][iColonne] <- 2
                finsi
            fin si
        iColonne suivant
    iLigne suivant
fin prgm

------------------------------
const TAILLE : N <- 4
VAR   tab:N[TAILLE][TAILLE]
var compteurDeux : N <- taille
pour cpt allant de 1 à 4
    tab[cpt,cpt]<- 1
    tab[cpt,taille]<- 2
    compteurDeux --
cpt suivant
=======

