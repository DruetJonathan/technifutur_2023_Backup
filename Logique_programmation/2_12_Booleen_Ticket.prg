/*************************************************
 * 2.12 Booléen : Ticket                         *
 *************************************************/

/* 
 * Ecrire l'expression pour savoir si la personne peut entrer ou non. Sachant :
 */

#  Que les variables suivantes représentent les caractéristiques de la personne. 
#     - Var a : B // la personne a un ticket
#     - Var b : B // la personne a un ticket réduit
#     - Var age : N // âge de la personne. 
#  Qu'un enfant de moins de 6 ans peut entrer gratuitement, 
#  Qu'un enfant de moins de 12 ans peut entrer avec un ticket réduit, 
#  Qu'il faut un ticket à toute personne n'entrant dans aucune des deux catégories, 


(age < 12 et b) ou a ou (age < 6)