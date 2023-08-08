/*************************************************
 * 4.3 boucle «tant que» : Min max               *
 *************************************************/

/* 
 * Ecrire le programme qui calcule la plus grande et la plus petite valeur 
 * d'une série de nombres entrés au clavier.
 */

#  La fin de la série sera annoncée par un 100. 
#  Le programme affichera également :
#     - le plus grand;
#     - le plus petit des nombres;
#     - la position du premier maximum (optionnel);
#     - la position du dernier maximum (optionnel);
#     - le nombre d'occurrence du maximum (optionnel);
#     - Idem pour le minimum (optionnel).

var max,min,posMax,posMin,nombreOccurenceMax,nombreOccurenceMin,nombre,cpt : N <-0

afficher "saisir un nombre: "
saisir nombre
TANT QUE nombre diff 100
    cpt ++
    Alors
        Si nombre <= min 
            si nombre == min
            alors 
                nombreOccurenceMin ++
            sinon
                min = nombre
                nombreOccurenceMin = 1
            fin de si
            posMin = cpt
        fin de si
        Si nombre >= max
            si nombre == max
                alors 
                    nombreOccurenceMax ++
            sinon
                max = nombre
                nombreOccurenceMax = 1
            fin de si
                posMax = cpt
        fin de si
    afficher "saisir un nombre: "
    saisir nombre
FIN TANT QUE

afficher "Nombre maximum: ",max," nombreOccurenceMax: ",nombreOccurenceMax," posMax: ",posMax
afficher "Nombre minimum: ",max," nombreOccurencemin: ",nombreOccurenceMin," posMin: ",posMin