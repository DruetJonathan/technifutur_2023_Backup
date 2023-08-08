/*************************************************
 * 6.6 Caractère et Texte : Inversion caractères *
 *************************************************/

/* 
 * Ecrire un programme qui demande à l’utilisateur d’entrer un texte.
 * Le programme affichera le texte en ayant inversé les caractères.
 */

debut prgm
    var source: T <- ""
    var result: T <- ""
    var position : N <- 1

    afficher "saisir texte source: "
    saisir source

    pour pos allant de 1 a longueur(source)
        si caract(source,pos) = ' '
            alors
                result <- result + mot + ' '
                mot <- ""
            sinon 
                mot <- carcat(soure,pos)(+)mot
        finso
        pos suivant
    result <- result + mot
    afficher result
fin prgm