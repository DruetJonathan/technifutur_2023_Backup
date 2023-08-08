let jour = prompt('Donnez le jour de la semaine en chiffre:')
let jourLettre;
switch (jour) {
    case '1':
        jourLettre = "Lundi"
        break;
    case '2':
        jourLettre = "Mardi"
        break;
    case '3':
        jourLettre = "Mercredi"
        break;
    case '4':
        jourLettre = "Jeudi"
        break;
    case '5':
        jourLettre = "Vendredi"
        break;
    case '6':
        jourLettre = "Samedi"
        break;
    case '7':
        jourLettre = "Dimanche"
        break;
    default:
        console.error('Error nombre entré')
        jourLettre = 'Error'
        break;
}
alert(`Nous sommes ${jourLettre}`)
//
const lettre = 'A'
let chaineLettre = lettre;
let tailleSapin = parseInt(prompt('Donnez une hauteur de sapin( nombre de lignes): '))
for (let index = 0; index < tailleSapin; index++) {
    console.log(`%c${chaineLettre}`, "color:cyan")
    chaineLettre += lettre
}
