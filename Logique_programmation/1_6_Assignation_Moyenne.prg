/***********************************************
 * 1.5 Assignation : Circonférence             *
 ***********************************************/

/* 
 * Ecrire le programme qui affiche la circonférence d'un cercle. 
 * La valeur du rayon est rentrée au clavier (Circonférence = 2*PI*R).
 */
/************Essai 1************/
programme moyenne c'est
début
    début variables locales
        var nombreUn : N <- 0
        var nombreDeux : N <- 0
        var nombreTrois : N <- 0
    fin variable locales
    écrireEcran("Saisir la valeur une: ")
    saisir nombreUn
    écrireEcran("Saisir la valeur deux: ")
    saisir nombreDeux
    écrireEcran("Saisir la valeur trois: ")
    saisir nombreTrois
    écrireEcran("La moyenne des 3 nombres = ",(nombreUn+nombreDeux+nombreTrois)/3);
fin

/************Essai 2************/
programme moyenne c'est
début
    début variables locales
        var somme : N <- 0
        var valeur : N <- 0
    fin variable locales
    écrireEcran("Saisir la valeur une: ")
    somme += saisir valeur
    écrireEcran("Saisir la valeur deux: ")
    somme += saisir valeur
    écrireEcran("Saisir la valeur trois: ")
    somme += saisir valeur
    écrireEcran("La moyenne des 3 nombres = ",(somme)/3);
fin