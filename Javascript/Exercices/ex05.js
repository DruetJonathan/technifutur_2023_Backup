// Utilisez l’objet Date et des structures conditionnelles,
// écrivez un programme qui affiche le jour de la semaine.
// Exemple : « Bonjour, nous sommes lundi! »
let today = new Date();
let dayOfWeek = today.getDay();
switch(dayOfWeek) {
    case 0 :
        console.log("C'est dimanche");
        break;
    case 1 :
        console.log("C'est lundi");
        break;
    case 2 : 
        console.log("C'est mardi");
        break;
    case 3 :
        console.log("C'est mercredi");
        break;
    case 4 : 
        console.log("C'est jeudi");
        break;
    case 5 :
        console.log("C'est vendredi");
        break;
    case 6 :
        console.log("C'est samedi");
        break;
    default :
        console.log("????");
        break;
}

// Version smart
let jours = ["dimanche", "lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi"];
console.log(`C'est ${ jours[dayOfWeek]} !`);

// Réalisez un programme qui permet d’afficher, dans la console, la structure 
// suivante à l’aide d’une boucle  console.log('%cpouet', "color: red") 
// A
// AA
// AAA
// AAAA
// AAAAA
// AAAAAA
// AAAAAAA
// AAAAAAAA
// AAAAAAAAA

const NB_ETAGES = 9;

let epines = "A";
let espaces = "";

const LARGEUR_TRONC = NB_ETAGES - 2;
let tronc = "";

for(let i = 0; i < NB_ETAGES ; i++) {
    for(let j=0; j< NB_ETAGES - i - 1; j++) {
        espaces += " ";
    }

    console.log('%c' + espaces + epines, 'color : darkgreen');
    epines += "AA";
    espaces = "";
}

let whiteSpace = "";
for(let i = 0; i < NB_ETAGES/3; i++ ) {
    tronc = "";
    for(let j=0; j < LARGEUR_TRONC; j++) {
        tronc+= " ";

    }
    whiteSpace += " "
    console.log('%c'+tronc + '|||' + whiteSpace ,  'color : brown');
}