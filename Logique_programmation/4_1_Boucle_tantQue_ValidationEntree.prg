/*************************************************
 * 4.1 boucle «tant que» : Validation d'entrée   *
 *************************************************/

/* 
 * Ecrire le programme qui limite le choix de l'utilisateur 
 * aux valeurs 0, 1, 2, 3, 4.
 * Si la valeur est différente, un nouveau choix sera demandé.
 */

var choix : N <- 0

TANT QUE (choix < 0 OU choix > 4 ) et choix mod 1 == 0
    Afficher "ERROR 404 / Entrez un des choix suivant 0,1,2,3,4"
    saisir choix
FIN TANT QUE

Afficher "Bravo"