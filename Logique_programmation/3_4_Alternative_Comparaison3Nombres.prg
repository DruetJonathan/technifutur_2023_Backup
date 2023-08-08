/*************************************************
 * 3.4 Alternative : Comparaison de 3 nombres    *
 *************************************************/

/* 
 * Écrire le programme qui compare 3 nombres entre eux. 
 * Tenir compte d’une égalité possible des nombres.
 */

#  Attention : 
#     « 5 < 8 > 4 » n’indique pas la comparaison entre le 1er et le 3ème nombre.
#     On préférera par exemple « 4 < 5 < 8 ».

// ---------a------------b-------------->

// ---------b------------a-------------->

// ---------ab-------------->
------------------------------------------------------
8 5 6 -> 5 8 6 -> 5 6 8
3 4 1 -> 3 1 4 -> 1 3 4


var tempVar : N <- 0
var op1,op2 : char <- '<'
saisir a,b,c
si a > b
    alors 
        tempVar = a
        a = b
        b = tempVar
fin de si
si b > c
    alors
        tempVar = b
        b = c
        c = tempVar
        si a > b 
            alors 
                tempVar = a
                a = b
                b = tempVar
        fin de si
fin de si

si a == b
    alors 
        op1 = '='
fin de si
si b == c
    alors
        op2 = '='
fin de si

afficher a,op1,b,op2,c

