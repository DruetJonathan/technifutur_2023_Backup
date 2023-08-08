console.log("Conditions");
// if
// if(condition){
//     //si vrai
// } else {
//     //si faux
// }

// if(condition1) {

// } else if(condition2) {

// } else {

// }

// switch(variableATester) {
//     case valeur1 :
//         break;
//     case valeur2 :
//         break;
//     case valeur3 :
//         break;
//     default :
//         break;
// }

// Switch
// let jourSemaine = parseInt(prompt("Entrez un jour de la semaine entre 1 et 7"))
// // Attention le switch fait un === entre jourSemaine et la valeur dans le case
// switch(jourSemaine) {
//     case 1 :
//     case 2 :
//     case 3 :
//     case 4 :
//         alert("Au boulot !");
//         break;
//     case 5 :
//         alert("Bientôt le weekend !");
//         break;
//     case 6 :
//     case 7 :
//         alert("LEEEEET'S GOOOOOOO 🥳");
//         break;
//     default : 
//         alert("Quoi ?")
//         break;
// }

// let nombre = parseInt(prompt("Entrez un nombre"));
// // if(nombre === nombre > 0)
// // if(nombre === true) //false

// // if(true === nombre > 0)
// // if(true === true) //true
// switch(true) {
//     case nombre > 0 :
//         alert("Positif");
//         break;
//     case nombre < 0 :
//         alert("Negatif")
//         break;
//     case nombre == 0:
//         alert("Egal à 0");
//         break;
//     default :
//         alert("Euh")
//         break;
// }

//Ternaire
// let quantiteBananes = parseInt(prompt("Entrez un nombre de bananes"))
// alert(`Voici ${quantiteBananes} banane${ (quantiteBananes <= 1) ? '': 's' }`);

// Coalesce
let chienGavin = "Skye";
let chienAude = false;
// ?? (coalesce) Si la variable est null ou undefined, affiche ce qu'il y a à droite
// || (opérateur falsy) Si la variable est null ou undefined ou false, affiche ce qu'il y a à droite
alert(`Le chien de Gavin s'appelle ${ chienGavin ?? 'Pas' }`)
alert(`Le chien de Aude s'appelle ${ chienAude ?? 'Pas' }`)
alert(`Le chien de Aude s'appelle ${ chienAude || 'Pas' }`)

// Les boucles
// while(condition) {

// }

// do {

// }while(condition)

// 
for(let i = 0; i <= 10; i++) {

}

let formateurs = [
    { nom : "Ly", prenom : "Khun", genre : "m"},
    { nom : "Beurive", prenom : "Aude", genre : "f"},
    { nom : "Chaineux", prenom : "Gavin", genre : "m"}
]

for(let formateur of formateurs){
    console.log(`${formateur.prenom} ${formateur.nom}`);
}

for(let indice in formateurs ) {
    console.log(indice);
}

formateurs.forEach((formateur, indice) => console.log(`${indice} - ${formateur.prenom} ${formateur.nom}`))
let formateursBis = formateurs.map(formateur => ( { nomComplet : formateur.prenom + " " + formateur.nom } ))
console.log(formateursBis);
let formateursH = formateurs.filter(f => f.genre === "m");
console.log(formateursH);
let formateursF = formateurs.filter(f => f.genre !== "m");
console.log(formateursF);




