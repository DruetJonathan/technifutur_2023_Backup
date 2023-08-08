/*************************************************
 * 6.4 Caractère et Texte : Sous-chaine          *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur un texte, une position
 * de départ et une position de fin.
 */

#  Le programme affichera la sous-chaine composée des caractères se trouvant 
#  dans le texte entre la position de départ (comprise) et la position de fin 
#  (non comprise).
#  Si les positions ne sont pas valides, le programme affiche un message d’erreur.
#  
#  Remarque : 
#  Ceci sans utiliser la fonction sousChaine() :)

var firstposition,lastposition : N <- 0
var textUser,chaineExtraite : T <- ""


affiche "saisir un txt: "
saisir textUser
affiche "saisir pos depart: "
saisir firstposition
affiche "saisir pos final: "
saisir lastposition

