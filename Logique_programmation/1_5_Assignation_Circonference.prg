/***********************************************
 * 1.5 Assignation : Circonférence             *
 ***********************************************/

/* 
 * Ecrire le programme qui affiche la circonférence d'un cercle. 
 * La valeur du rayon est rentrée au clavier (Circonférence = 2*PI*R).
 */

programme circonference c'est
début
    début variables locales
        const PI <- N : 3.14
        var rayon <- N : 0
    fin variable locales
    saisir rayon
    écrireEcran("Circonférence = ",(2 * PI * rayon))
fin
