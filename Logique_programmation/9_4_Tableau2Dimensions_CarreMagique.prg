/*************************************************
 * 9.4 Tableau à 2 Dimensions : Carré magique    *
 *************************************************/

/* 
 * Ecrire le programme  qui vérifie que les sommes de chaque ligne, 
 * chaque colonne et des deux diagonales d’un tableau numérique carré
 * sont les mêmes.
 */

debut pgm tableau 2 dimensions

Var s: N<-0
Var tab = tableau [n] : N
Var sligne = Tableau [n] : N
Var scolonne = tableau [n]
var sDiagoG : N <-0
var sDiagoD : N <-0
var magique : boolean <- true

pour i allant de 1 à n
    pour j allant de 1 à n
        Afficher "Saisir les valeurs du tableau à double entrées: "
        saisir tab[i,j]
    j suivant
i suivant



pour i allant de 1 à n
    pour j allant de 1 à n
        sligne [i] == tab [i,j]
        scolonne [j] += tab [i,j]
       // s += tab[i,j]
        SI i = j
                sDiagoG += tab[i,j]
            FIN SI
            SI  i-j = n-1
                sDiagoD += tab[i,j]
            FIN SI
    j suivant
i suivant
var i : N <- 1

SI sDiagoD == sDiagoG
    TANT QUE i < n et magique
        SI sligne[i] != sDiagoD ou scolonne[i] != sDiagoD
            magique = false
        FIN SI
        i++
    FIN TANT QUE
Sinon
      magique = false
FIN SI

Si magique
    Afficher " carré magique "
    sinon
        Afficher "pas carré magique"
FIN SI

fin pgm


