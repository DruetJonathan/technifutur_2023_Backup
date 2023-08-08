/*************************************************
 * 4.2 boucle «tant que» : Moyenne               *
 *************************************************/

/*
 * Ecrire le programme qui calcule la moyenne d'une série de nombres entrés
 * au clavier.
 */

#  La fin de la série sera annoncée par un 100. 

var cpt,somme,nombre,nbrValeurs : N <- 0
var continue : B <- vrai

TANT QUE continue
    afficher "Saisir un nombre: "
    saisir nombre
    nbrValeurs ++
    Si nombre == 100
        continue = faux
        sinon
            somme += nombre
    fin de si
FIN TANT QUE

si nbrValeurs diff 0
    alors
        afficher "La moyenne est de ",(somme/100)
    sinon
        afficher "0 valeurs entrées"
fin de si