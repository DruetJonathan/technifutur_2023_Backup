/*************************************************
 * 8.4 Boucles imbriquées : Nombres premiers     *
 *************************************************/

/*
 * Écrire le programme qui affiche les 100 premiers nombres premiers.
 */


Dbt pgm ass var

Var n : N <- 1
Var a : 2
Var somme : N <-0

    Tant que a<101
        Tant que n<= racine carré de a
            Si a%n=0
                alors 
                si n != racine carré de a 
                    Alors s <-s+n+ a/n
                Sinon s <- s+n
                Fin si
            Fin si
            n++
        Fin Tant que
        Si a=somme
            afficher a
        Fin Si               
        somme<- 0
        cptr++
        n<-1
    Fin Tant que
Fin pgm

-------------------------
