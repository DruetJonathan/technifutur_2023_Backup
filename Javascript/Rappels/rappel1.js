console.log('Rappels');

// Constantes
// Ne peut plus être modifié, changé par une autre valeur
const MA_CONSTANTE = 8;

// Ne peut pas être changé par une autre valeur mais peut être modifié
const MON_OBJET = {}
const MON_TAB = []

// Variables
let lowerCamelCase = "Pas de caractères spéciaux sauf $ et _         Pas de chiffre au début mais dedans ou à la fin ok    Pas d'accents     Pas d'espaces     Noms cohérents et privilégier l'anglais"
// Types
// number
let monEntier = 4;
let monReel = 42.5;
// chaines - string
let maChaine = "ma super chaine";
let monCharactere = "o";
// booleen
let monBool = true;
// undefined // Quand la variable existe mais n'a pas de valeur
let truc;
// tableaux 
// Pas de types précisés donc on peut remplir avec n'importe quoi
// Sa taille n'est pas fixe
let monSuperTableau = []
// object / tableau associatif
let personne = {
    //clef (n'importe quel type mais unique) : valeur (n'importe quel type)
    nom : "Beurive",
    prenom : "Aude"
}
// null
let numeroDeTel = null; // Il y a une valeur dans notre variable mais on ne sait pas encore quoi ou symbolise le fait qu'une valeur soit "optionnelle"

// Les constantes prédéfinies
// Infinity
// NaN (number)

// Comment transformer n'importe quel type en string
let bool = true;
bool.toString();
let nombre = 5;
nombre.toString();
//... etc

// Comment transformer une chaine en number
let leNombreParse = parseInt("laChaine");
//parseFloat()
// Si conversion réussi on a notre nombre en retour
// Si conversion échoue on a NaN

// Les tableaux
let monTab = ["UneValeur", "Untruc"]
// Pour ajouter
monTab.push("MaValeur", "UneAutreValeur")
// Pour supprimer
monTab.splice(1, 1); // supprime l'élément en indice 1
// Accéder à une case en particulier
monTab[monTab.length - 1]; // Pour accéder à la dernière case 💤💤
monTab.at(-1); // Pour accéder à la dernière case 🥳

