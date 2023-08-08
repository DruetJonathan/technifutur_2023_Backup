/*************************************************
 * 7.5 Vecteurs : Supprimer espaces              *
 *************************************************/

/* 
 * Ecrire le programme qui déplace les caractères espaces à la fin 
 * d’un vecteur de caractères.
 */  

# +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
# |'S'|'U'|'P'|'P'|'R'|'I'|'M'|'E'|'R'|' '|' '|'L'|'E'|'S'|' '|'E'|'S'|'P'|'A'|'C'|'E'|'S'|' '| 
# +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+

# +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+
# |'S'|'U'|'P'|'P'|'R'|'I'|'M'|'E'|'R'|'L'|'E'|'S'|'E'|'S'|'P'|'A'|'C'|'E'|'S'|' '|' '|' '|' '| 
# +---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+


debut prgm
    
    var indice : N <- 1
    var texte: N <-T
    var nombreEspaces: N <- 0
    var continuer : B <- vrai

    // saisie de la chaine de caractère
    afficher "saisir texte: "
    saisir texte
    const TAILLE : N <- longueur(texte)
    var valeur:N[taille]
    var newValeur:N[taille]

    // boucle de remplissage des caractère dans le tableau
    pour indice allant de 1 a TAILLE
        valeur[indice] <- caract(texte,indice)
    indice suivant

    // boucle de mouvements des espaces
    indice <- 1
    pour indice allant de 1 a TAILLE
        si  valeur[indice] == ' '
            alors 
                nombreEspaces <- nombreEspaces + 1
            sinon
                newValeur[indice-nombreEspaces] <- valeur[indice]
        finsi
    indice suivant
    fin tant que

    // boucle espace
    pour indice allant de taille-nombreEspaces a TAILLE
        newValeur[indice] <- ' '
    indice suivant

    fin tant que


fin prgm