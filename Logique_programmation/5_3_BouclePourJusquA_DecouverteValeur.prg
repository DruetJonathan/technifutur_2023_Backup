/***************************************************************
 * 5.3 Boucle Pour et jusqu’à ce que : Découverte d’une valeur *
 ***************************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur de découvrir une valeur 
 * entre 0 et 100.
 */

#  - Le programme choisira la valeur de manière aléatoire (*).
#  - L’utilisateur entre des valeurs tant qu’elles sont différentes de la 
#    valeur choisie.
#  - Après chaque entrée non valide le programme affiche si la valeur à 
#    découvrir est plus grande ou plus petite que celle entrée.

#  (*) Fonction permettant la récupération d’un nombre aléatoire
#        fonction aléatoire (max : N):N
#        Retourne un nombre entier aléatoire entre 0 et max


var nombreUser : N <- -1
var nombreAleat (100:N):N

afficher "Saisir un nombre: "
saisir nombreUser

tantque (nombreUser <> nombreAleat)
    affiche nombreUser < nombreAleat ? "nombreUser < nombreAleat" : "nombreUser > nombreAleat"
    afficher "Saisir un nombre: "
    saisir nombreUser
fintantque

affiche "Bonne réponse !"

**********************************************
var nombreUser : N <- -1
var nombreAleat aleatoire(100)
var nombreEssai : N <- 10

afficher "Saisir un nombre: "
saisir nombreUser

tantque (nombreUser <> nombreAleat et nombreEssai > 0)
    nombreEssai ++
    affiche nombreUser < nombreAleat ? "nombreUser < nombreAleat" : "nombreUser > nombreAleat"
    afficher "Saisir un nombre: "
    saisir nombreUser
fintantque

affiche "Bonne réponse !"