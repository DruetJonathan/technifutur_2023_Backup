/*************************************************
 * 8.3 Boucles imbriquées : Nombres parfaits     *
 *************************************************/

/* 
 * Écrire le programme qui affiche les nombres parfaits inférieurs à 100. 
 */

# Un nombre parfait est un entier égal à la somme de ses diviseurs sauf lui-même.

Var div <- 1
Var somme <-0
Var n <- 1;

    Tant que n<100
        Tant que div<n
            Si n mod div=0
                Alors somme <- somme + div
            Fin de si
            div <- div+1
        Fintantque
        Si somme = n
            Alors afficher n "est un nombre parfait"
            Sinon afficher n "n'est pas un nombre parfait"
        Finsi
        div <- 1
        n <- n+1
        somme <- 0
    Fin de tant que

Fin de programme
------------------------------
soluce prof

pour nb allant de 2 a 100
    somme div i <- 1
    racine <- racine(nb)
    pour diviseur allant de 2 à racine - 1
        si nb mod diviseur = 0
            alors
                somme div i <- somme div i + nb / div
        Finsi
    diviseur suivant
    si racine mod 1 = 0
        alors 
            somme div i <- somme div i + racine
    si somme div i = nb
        alors
            afficher nb
    fin si
nb suivant