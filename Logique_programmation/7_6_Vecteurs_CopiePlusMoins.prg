/*************************************************
 * 7.6 Vecteurs : Copie plus ou moins            *
 *************************************************/

/* 
 * Soient 3 tableaux de même longueur : le premier contient des entiers, 
 * le deuxième des logiques et le troisième sera rempli par les valeurs 
 * du premier. 
 */

#  Quand dans le tableau 2 le booléen est vrai par la valeur du tableau 1.
#  Quand dans le tableau 2 le booléen est  faux par le négatif de la valeur du tableau 1.

# +------+------+------+------+------+------+------+------+------+------+  
# |  10  |  -5  |  -6  |  48  |  20  |  -6  |  13  |  56  |  -89 |  108 | 
# +------+------+------+------+------+------+------+------+------+------+  
# | Vrai | Faux | Faux | Vrai | Vrai | Faux | Faux | Vrai | Faux | Vrai | 
# +------+------+------+------+------+------+------+------+------+------+  
# |  10  |   5  |   6  |  48  |  20  |   6  | -13  |  56  |   89 |  108 | 
# +------+------+------+------+------+------+------+------+------+------+  

debut prgm
    
    const TAILLE : N <- 10
    var indice : N <- 1
    var tabValeur:N[taille]
    var tabBoolean:N[taille]
    var newTabValeur:N[taille]

    pour indice allant de 1 A TAILLE

        Si tabBoolean[indice]
            alors
                newTabValeur[indice] <- tabValeur[indice]
            sinon
                newTabValeur[indice] <- -tabValeur[indice]
        finsi

    indice suivant
fin prgm