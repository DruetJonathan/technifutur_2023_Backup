/*************************************************
 * 6.5 Caractère et Texte : Plus grand           *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur de rentrer deux textes.
 * Le programme affichera VRAI si le premier texte se situe après le deuxième 
 * dans l’ordre alphabétique sinon il affichera FAUX.
 */

#  Remarques :
#     - Les opérateurs de comparaison sur les textes ne peuvent pas être utilisés :).
#     - Algorithme au seul niveau primaire.

debut PLus grand
    var txt1: T <- ""
    var txt2: T <- ""
    var egal: B <- vrai
    var pos: N <- 1

    afficher "saisir texte 1: "
    saisir txt1
    afficher "saisir texte 2: "
    saisir txt2

    Tant egal et pos  <= longueur(txt1) et pos <= longueur(txt2)
        si caract(txt1,post) = caract(txt2,pos)
            alors
                pos <- pos +1
            sinon
                egal <- faux
        fin si
    fin tantque
si egal
    alors
        afficher longueur(txt1) > longueur(txt2)
    sinon
        afficher caract(txt1,pos) > caract(txt2,pos)
finsi

fin prgm