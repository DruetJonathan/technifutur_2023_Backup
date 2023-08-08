/*************************************************
 * 6.1 Caractère et Texte : Recherche caractère  *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur d’entrer un texte et 
 * un caractère.
 */

#  Le programme affichera :
#     -  La première position où le caractère se trouve dans le texte.
#     -  La dernière position.
#     -  Le nombre de fois qu’il apparait.
#  Si le caractère ne se trouve pas dans le texte, le programme affichera 
#  un simple message.

// declaration variable
var firstposition,lastposition,currentPosition : N <- 1
var nombreOccurenceCaractere : N <- 0
var caractèreUser : C <- ''
var textUser : T <- ""

// saisie user
afficher "Saisir un texte: "
Saisir textUser
afficher "Saisir un caractère: "
Saisir caractèreUser

// boucle principale
Tant que longueur(textUser) >= currentPosition 
    si caract(textUser,currentPosition) == caractèreUser
        nombreOccurenceCaractere ++
        si nombreOccurenceCaractere == 1
            firstposition == currentPosition
        finsi
        lastposition = currentPosition
    finsi
    currentPosition ++
fin tant que

si nombreOccurenceCaractere == 0
    afficher "Auncune occurence de ce caractere"
    sinon
        afficher ...
finsi