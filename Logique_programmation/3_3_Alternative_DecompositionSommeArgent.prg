/********************************************************
 * 3.3 Alternative : Décomposition d'une somme d'argent *
 ********************************************************/

/* 
 * Écrire le programme qui permet de décomposer une somme d’argent lue au clavier.
 */

#  Coupures disponibles : 
#     -  Billets : 100€, 50€, 20€, 5€
#     -  Pièces : 2€, 1€, 0,5€ , 0,2€
#  Contraintes :
#     -  Le total de la décomposition sera plus grand ou égale à la somme entrée
#     -  Le nombre de coupures de la décomposition sera le plus petite possible
#  Exemple:
#     254,18 € se décompose en : 
#        - 2 billets de 100 €,
#        - 1 billet de 50 €,
#        - 2 pièces de 2 €,
#        - 1 pièce de 0,2 €.

Début programme
Variable s: N <- 0
Variable p05: faux
Saisir s
    Si s % 0.1 != 0
        s += (0.10-s)
        Si s >= 0.5
            p05 <- vrai
            s <- s - 05
        sinon
            s <- s + 0.1
        Fin de si
    Fin de si

    Si s >= 100
        Afficher "Le nombre(s) de billet(s) de €100 est de:", s Div 100
        s=s%100
    fin de si     
    Si s >= 50
        Afficher "Le nombre(s) de billet(s) de €50 est de:", s Div /50
        s=s%50
    fin de si  
    Si s >= 20
        Afficher "Le nombre(s) de billet(s) de €20 est de:", s Div /20
        s=s%20
        fin de si  
    Si s >= 2
        Afficher "Le nombre(s) de pièce(s) de €2 est de:", s Div /2
        s=s%2
    fin de si  
    Si s >= 1
        Afficher "Le nombre(s) de pièce(s) de €1 est de:", s Div /1
        s=s%1
    fin de si   
    Si s >= 0.2
        Afficher "Le nombre(s) de pièce(s) de €0.20 est de:", s Div /0.2
        s=s%0.2
    fin de si
    si po05
        alors
            Affiche " une piece de 0.5€"
    fin de si                                                
Fin Prog.



