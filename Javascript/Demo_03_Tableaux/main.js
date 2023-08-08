console.log("Les tableaux");

// On parcourt le tableau grâce à son index / indice
// Les indices des tableaux commencent à 0

let monTableau = [1, 2, 3, 4];
let monTableau2 = new Array(1, 2, 3, 4);

// attention, le typage étant dynamique, on peut mettre n'importe quoi dans nos tableaux !
let grosBordel = ["Du texte", 5, new Date(), { nom : "Chaineux", prenom : "Gavin"}, [ 2, 5, "Six"], true]

// Opérateur d'accès : []
console.log(monTableau);
console.log(monTableau[1])
monTableau[1] = "Pouet";
console.log(monTableau);
monTableau[125] = "Truc";
console.log(monTableau);
console.log(monTableau[111]);

// Récupérer la taille du tableau
console.log( monTableau.length );

// Tableau associatif // Objet
let anniversaires = {
    //clef (unique) : valeur,
    "Gavin" : new Date(1993, 9, 18),
    "Aude": new Date(1989, 9, 16),
    "Khun" : new Date(1982, 4, 6),
}
console.log(anniversaires["Gavin"]);
console.log(anniversaires.Gavin);

console.clear();
// Méthodes des tableaux
let formateurs = ["Seb", "Khun", "Gavin"]
console.log("Formateurs avant de recruter Alex : ", formateurs);
// Pour ajouter
formateurs.push("Alexandre"); //Ajoute toujours à la fin
console.log("Formateurs après avoir recruté Alex : ", formateurs);
formateurs.unshift("Aude"); // Ajoute toujours au début
console.log("Formateurs après avoir recruté Aude : ", formateurs);

// Pour enlever
formateurs.pop(); // Enlève toujours celui à la fin
console.log("Formateurs après avoir viré Alex : ", formateurs);
formateurs.shift(); // Enlève toujours celui au début
console.log("Formateurs après avoir viré Aude :'(  : ", formateurs);

// Pour trouver une valeur à un indice en particulier
console.log( formateurs[1] );
console.log( formateurs[formateurs.length -1]);
console.log( formateurs.at(-2) )
// Chiffre positif = indice en partant de gauche à droite (0 à taille-1) Comme les []
// Chiffre négatif = indice en partant de la fin -1 à -taille

// Pour trouver l'indice d'une valeur en particulier 
// Pour chaque formateur, trouve le formateur qui est égal à "Gavin"
console.log( formateurs.findIndex(f => f === "Gavin") );

// Afficher notre tableau
console.log( formateurs.toString() ); //Vous fait une chaine de caractères contenant toutes les valeurs du tableaux séparés par une virgule
console.log( formateurs.join(" x ")); //Fait un toString mais vous pouvez préciser le séparateur à la place de la virgule auto

// Concaténer 
let tab1 = [47, 85, 2];
let tab2 = [56, 8, 42];
let tab3 = tab1 + tab2; //Instinctivement on aimerait faire ça mais flop
let tab4 = tab1.concat(tab2)
console.log(tab3);
console.log(tab4);

// Les tris
let bordel = ["Java", 5, "Algo", 32, "Back-End", 53, "Json", "javascript", 1, 64];
console.log(bordel.sort());

let nombres = [5, 32, 53, 1, 64, 3347, 2];
console.log(nombres.sort());
// console.log(nombres.sort(function(a,b) { return b - a}));
console.log(nombres.sort((a,b) => b - a)); // Décroissant
// console.log(nombres.sort(function(a,b) { return a - b}));
console.log(nombres.sort((a,b) => a - b)); // Croissant

// Inverser
console.log(formateurs);
console.log(formateurs.reverse());

// Découper
console.clear();
let formateursV2 = ["Seb", "Khun", "Aude", "Gavin", "Alex", "Romain"];
console.log('Les formateurs :', formateursV2);

// slice : Selectionne une partie du tableau et renvoie la copie de cette partie dans un nouveau tableau (Le tableau de base n'est pas modifié)
// Premier param : indice de début
// Deuxième param : indice de fin (non compris)
let enSoiree = formateursV2.slice(2, 5);
console.log("Sont partis en soirée : ", enSoiree);
console.log("Sont toujours formateurs : ", formateursV2);

// splice : Découpe la partie du tableau renseignée et le renvoie TOUT EN MODIFIANT le tableau de base
// Premier param : indice de début
// Deuxième param : combien on veut en supprimer
let enSoiree2 = formateursV2.splice(2, 3);
console.log("Sont partis en soirée : ", enSoiree2);
console.log("Sont toujours formateurs : ", formateursV2);
