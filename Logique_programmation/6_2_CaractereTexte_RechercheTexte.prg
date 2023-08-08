/*************************************************
 * 6.2 Caractère et Texte : Recherche texte      *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur d’entrer un texte source 
 * et un texte à rechercher.
 */

#  Le programme affichera :
#     - La première position où le texte à rechercher se trouve dans le texte 
#       source.
#     - La dernière position.
#     - Le nombre de fois qu’il apparait.
#  Si le texte à rechercher ne se trouve pas dans le texte source, le programme
#  affichera un simple message.


var firstposition,lastposition : N <- 1
var nombreOccurence,tmpPosition : N <- 0
var textUser,textToSearch : T <- ""
var compteurSearchLoop : N

afficher "saisir un texte source: "
saisir textUser

afficher "saisir un texte à rechercher: 
saisir textToSearch"

pour currentPosition allant de 1 A longueur(textUser)
      compteurSearchLoop = 1
      tmpPosition = currentPosition
      Tant que caract(textUser,tmpPosition) == caract(textToSearch,compteurSearchLoop) et longueur(textUser) - currentPosition >= 0
         compteurSearchLoop ++
         si compteurSearchLoop == longueur(textToSearch)
            nombreOccurence ++
         finsi
         tmpPosition ++
      fintantque
   fin si
finpour

si nombreOccurence == 0
   afficher "0 occurence du texte à rechercher"
sinon
   afficher "nombreOccurence: ",nombreOccurence
finsi


