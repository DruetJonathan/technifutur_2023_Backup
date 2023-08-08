/*************************************************
 * 7.4 Vecteurs : Inversion vecteur              *
 *************************************************/

/* 
 * Ecrire le programme qui inverse un tableau de 10 nombres.
 */


debut prgm
    const TAILLE : N <- 10
    var valeur:N[taille]
    var indice : N <- 1
    var valeurTemporaire: N <-2

    pour indice allant de 1 a TAILLE
        afficher "Saisir une valeur: "
        saisir valeur[indice]
    indice suivant

    indice <- 1
    pour indice allant de 1 a TAILLE / 2
        valeurTemporaire <- valeur[indice]
        valeur[indice] <- valeur[TAILLE-indice+1]
        valeur[TAILLE-indice+1] <- valeurTemporaire
    indice suivant
fin prgm