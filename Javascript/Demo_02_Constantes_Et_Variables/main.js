console.log('Variables et constantes');

// ? Les constantes prédéfinies
// NaN → Souvent rencontré quand une conversion échoue ou une opération mathématiques
let operationNulle = 'truc' * 6;
console.log('operationNulle : ' + operationNulle);
console.log(operationNulle == NaN);
console.log(isNaN(operationNulle)); // Pour tester si une variable contient NaN

// Infinity → utilisé en mathématiques, représente l'infini mathématiques
console.log(500 / 0);

// ! undefined → Beaucoup rencontré ! Quand une variable a été créée, elle existe mais sa valeur n'a jamais été définie
let uneBoiteVide;
console.log(uneBoiteVide);
// uneBoiteVide.toUpperCase();
console.log(uneBoiteVide == undefined);

// ? Les constantes
const MON_PRENOM = "Aude";
console.log(MON_PRENOM);
// Attention votre IDE ne vous montrera pas d'erreur si vous essayez de réaffecter une valeur
// MON_PRENOM = "Thomas";
// console.log(MON_PRENOM);
// Et pourtant ça fera bien une erreur, visible dans la console

// Petit apparté pour les tableaux et les objets : On ne pourra pas remplacer l'objet ou le tableau par autre chose mais on pourra modifier toutes les propriétés de l'objet ou cases du tableau
// objet
const PERSONNE1 = {
    nom : "Beurive",
    prenom : "Aude",
    dateDeNaissance : new Date(1989, 9, 16)
}
//PERSONNE1 = "Oui" ; // Impossible, je ne peux pas remplacer mon objet par autre chose
PERSONNE1.nom = "Beurive Chatelain";
console.log(PERSONNE1);

// tableau
const CHANSON = ["Pier", "Paul", "Jacques"];
//CHANSON = "Oui";
CHANSON[0] = "Pierre";
console.log(CHANSON);


// ? Les Variables
let monChiffrePref = 8;
monChiffrePref = "Choucroute";
// Attention en JS, le typage est dynamique et peut changer au cours du programme, il faudra être vigilant à ce que vous mettez dedans

// ! Conventions de nommage :
// - Convention utilisée : le lowerCamelCase (exception pour les const en UPPERCASE avec _ pour séparer les mots)
// - Pas d'accents, pas de caractères spéciaux (sauf $ et _ qui sont autorisés mais qui ont une significatin particulière)
// - Les chiffres sont autorisés MAIS pas en premier caractère
// - On utilise des noms de variable clairs, parlants et on essaie d'utiliser l'anglais au max (on évite les pouet, bidules, machin, les test1, test2, test3, les lettres a, b, c, d)

// * Les types
// ? Les number (pas de distinction entier, reel)

let monEntier = 45;
let monReel = 45.2;

// ? Les string (pas de distinction string, char)

let maChaine1 = "Aujourd'hui nous sommes lundi";
let maChaine2 = 'Aujourd\'hui nous sommes lundi';
// Vous pouvez utiliser celui de votre choix, attention juste à être consistant

let prenomGavin = "Gavin";
let birthdayGavin = new Date(1993, 9, 18)
let chienGavin = 'Skye';
let presentationGavin = "Nous vous présentons " + prenomGavin + " né(e) le " + birthdayGavin + " et son chien s'appelle " + chienGavin;
// C'est long 💤
// L'interpolation `` -> ALTGR + µ
let presentationGavin2 = `Nous vous présentons ${prenomGavin} né(e) le ${birthdayGavin} et son chien s'appelle ${chienGavin}`;

// ? Les booléens

let oui = true;
let non = false;

// ! Différence de portée entre le var et le let
console.clear();

var x = 5;
function maSuperFonction() {
    var y = 8;
    if(y === 8) {
        var z = 12;
        console.log("1) z : ", z);  // 12
    }
    console.log("2) y : ", y); // 8
    console.log("3) z : ", z); // ! 12 avec le mot-clef var, la variable dans les blocs if, for, while est global au bloc supérieur 
}

maSuperFonction();
console.log("4) x : ", x); // 5
//console.log("5) y : ", y); // undefined
//console.log("6) z : ", z); // undefined


let x2 = 5;
function maSuperFonction2() {
    let y2 = 8;
    if(y2 === 8) {
        let z2 = 12;
        console.log("1) z : ", z2);  // 12
    }
    console.log("2) y : ", y2); // 8
    //console.log("3) z : ", z2); // ! undefined avec le mot clef let, la variable est locale à chaque bloc, même les if, for, while etc...
}

maSuperFonction2();
console.log("4) x : ", x2); // 5
//console.log("5) y : ", y2); // undefined
//console.log("6) z : ", z2); // undefined

// ! Dans tous les cas, prenez l'habitude d'utiliser le let et le const uniquement

console.clear();
console.log(typeof prenomGavin);

// ToString() conversion de n'importe quel type vers chaine
let bool = true;
console.log(bool);
console.log(bool.toString());
let monNombre = 14578;
console.log(monNombre.toString());
console.log(monNombre.toString(2)); //Nombre converti en binaire
console.log(monNombre.toString(16)); //Nombre converti en hexa
let maChaine = "Oui salut"
console.log(maChaine.toString());

// parse conversion de n'importe quelle chaine vers number
console.log(parseInt("1578"))
console.log(parseInt("15.78")) //Récupèrera juste la partie entière sans arrondir
console.log(parseFloat("15.78")) //Fonctionne uniquement avec le . et pas la ,
console.log(parseInt("fadc")) //NaN
console.log(parseInt("fadc", 16)) //Conversion en hexa
console.log(parseInt("1000101011111", 2)); //Conversion binaire

// Attention on aurait tendance à vouloir utiliser le parseInt pour arrondir
// NOPE
console.log("FLOOR 12.6 : ", Math.floor(12.6) ) // Arrondi à l'entier inférieur
console.log("ROUND 12.6 : ", Math.round(12.6) ) // Arrondi à l'entier le plus proche
console.log("ROUND 12.4 : ", Math.round(12.4) ) // Arrondi à l'entier le plus proche
console.log("CEIL 12.4 : ", Math.ceil(12.4) ) // Arrondi à l'entier supérieur

