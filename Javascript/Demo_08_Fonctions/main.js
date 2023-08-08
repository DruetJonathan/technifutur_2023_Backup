console.log("Fonctions");

// Les procédures // Ne renvoie rien (void)
console.log()

// Déclarer procédure
function nomProcedure(paramSiYEnA) {
    console.log(paramSiYEnA.toUpperCase());
}
// Appel
nomProcedure('oui');

// Les fonctions // Renvoie quelque chose
let truc = prompt()

function nomFonction(paramSiYenA) {
    return paramSiYenA + " ah ouais y'en a";
}
let res = nomFonction("oui");



function maSuperFonction(nombre) {
    nombre = 8;
    console.log("NOMBRE : ", nombre); //8
}

let X = 2;
maSuperFonction(X);
console.log("X : ", X); //2


// Attention tableaux et objets sont passés par référence et seront donc modifiés
function uneAutreSuperFonction(tab) {
    tab[1] = "Coucou";
    console.log("TAB : ", tab); // ["Oui", "Coucou", "Peut-être"]
}

let bahOui = ["Oui", "Non", "Peut-être"]
uneAutreSuperFonction(bahOui);
console.log("BAHOUI : ", bahOui); // ["Oui", "Coucou", "Peut-être"]

// TRY CATCH

let maSuperChaine = [1, 2, 3]

try {
    console.log(maSuperChaine.toUpperCase());
}
catch(e) {
    console.log(e);
}

function division(nombre1, nombre2) {
    if(nombre2 === 0) {
        throw new Error("Pas de division par 0 !");
    } else {
        console.log(nombre1 / nombre2);
    }
}

try {
    division(5, 0);
} 
catch(e) {
    console.log(e);
}

