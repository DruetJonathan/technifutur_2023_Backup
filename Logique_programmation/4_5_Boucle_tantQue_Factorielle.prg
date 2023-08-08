/*************************************************
 * 4.5 boucle «tant que» : Factorielle           *
 *************************************************/

/* 
 * Ecrire le programme qui permet de calculer la factorielle d'un nombre 
 * entré au clavier.
 */

Début pgm

Var nbr   :N ← 0     
Var somme:N ← 1      

Afficher "entrer un nombre: "     
saisir nbr      
tant que nbr mod 1 != 0 ou nbr < 0         
    Afficher "nombre incorrect , entrez un nombre entiers et positif"         
    saisir nbr     
fin tant que 

afficher " La factorielle de 0 est 1"         
tant que nbr != 1             
    somme  ← somme * nb             
    nbr --        
fin tant que      
afficher " la factorielle de ", nbr , " = " , somme

fin pgm 

