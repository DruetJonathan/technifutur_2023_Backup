/*************************************************
 * 3.1 Alternative : Equation 1er degré          *
 *************************************************/

/* 
 * Écrire le programme qui résout l’équation du 1er degré: ax + b = 0
 * Le programme demande à l'utilisateur une valeur pour a et pour b et donne 
 * si possible la valeur de x.
 */

programme EquationPremierDegre c'est
début
    début variables locales
        var a : N <- 0
        var b : N <- 0
    fin variable locales

    écrireEcran("saisir a: ");
    saisir a    
    écrireEcran("saisir b: ");
    saisir b

    si b == 0  && a == 0
        écrireEcran("Indeterminé");
    sinonsi a == 0 alors
        écrireEcran("Impossible");
    sinon
        écrireEcran(-b/a);
    fin si
fin

