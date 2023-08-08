// ! Les petits tips :
// ? Les commentaires
// Commentaire sur une ligne
/* Commentaires
 multilignes */

// ? Les raccourcis
// Raccourcis pour mettre en commentaire ou décommenter si déjà commenté : Ctrl + : 
// Raccourcis pour le passage à la ligne automatique : ALT + z
// Raccourcis pour ouvrir le panel emoji + caractères spéciaux (sur Windows) : Windows + ;
// Votre ami : Ctrl + S

// ? Extensions
// Intellicode - Microsoft
// Better Comments - Aaron Bond
    // * Commentaire important
    // ! Code a dégager
    // ? Peut être que je devrais enlever ce code
    // TODO A faire : Enlever ce code
// Live Server - Ritwick Dey

// ? Extension navigateur
// Wappalizer → Voir quelles technos sont utilisées sur les sites

///////////////////////////////////

// Vu plus tard mais en gros, on récupère la div dont l'id est test et on écrit dedans
const DIV_TEST = document.getElementById('test');
DIV_TEST.innerText = 'Au revoir';


// Exercice_01_Alert
alert('Bienvenue sur mon site');
let entree = prompt("Tape un truc");
let confirmer = confirm("J'ai faim");
console.log(entree);
console.log(confirmer);
