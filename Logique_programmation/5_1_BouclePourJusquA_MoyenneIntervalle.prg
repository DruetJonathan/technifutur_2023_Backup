/******************************************************************
 * 5.1 Boucle Pour et jusqu’à ce que : Moyenne dans un intervalle *
 ******************************************************************/

/* 
 * Ecrire un programme qui lit 30 nombres et affiche la moyenne des nombres
 * compris entre 10 et 20.
 */

var nombre,diviseurMoyenne : N <- 0
Pour a allant de 0 a 29
    affiche "saisir un nombre: "
    saisir nombre
    si nombre >=10 && nombre <= 20
        moyenne += nombre
        diviseurMoyenne ++
    finsi
a suivant

si diviseurMoyenne <> 0
    afficher "La moyenne des nombres compris entre 10 et 20 est de: ",(moyenne/diviseurMoyenne)
finsi