alert("\t\t\t\tBienvenue au jeu du ➕ ou ➖",);

let level;
let nbWin = 0;
let nbLose = 0;
let wantToPlay = true;

let max;
let nbTentative;
let nbToGuess;

while(wantToPlay) {
    menu();
    if(wantToPlay) {
        setUpGame(level);
        game(max, nbTentative)
    }
}


function menu() {
    do {
        level = parseInt(prompt(`Veuillez sélectionner un niveau :\n1) Facile (1-10)\n2) Moyen (1-100)\n3) Difficile (1-1000)\n4) Quitter\n\n\tNombre de parties gagnées : ${nbWin}\n\tNombre de parties perdues : ${nbLose}`))
    } while(isNaN(level) || level < 1 || level > 4)
    if(level == 4) {
        wantToPlay = false;
    }
}

function setUpGame(lvl) {
    switch(lvl) {
        case 1 :
            max = 10;
            nbTentative = 5;
            break;
        case 2 :
            max = 100;
            nbTentative = 15;
            break;
        case 3 :
            max = 1000;
            nbTentative = 25;
            break;            
        default :
            alert("Error");
            break;
    }
}

function game(max, nbTentative) {
    nbToGuess = generateRandom(max);
    let win = false;
    let nbUser;
    do {
        nbUser = parseInt(prompt(`Entrez un nombre entre 1 et ${max} :\n\n\tIl vous reste ${nbTentative} tentative${ nbTentative > 1 ? 's' : '' }`));
        switch(true){
            case isNaN(nbUser):
                alert("Vous n'avez pas entré un nombre")
                break;
            case nbUser < 1 || nbUser > max :
                alert(`Vous devez être entre les bornes 1 - ${max}`)
                break;
            case nbUser > nbToGuess :
                alert("C'est moins");
                nbTentative--;
                break;
            case nbUser < nbToGuess :
                alert("C'est plus");
                nbTentative--;
                break;
            case nbUser == nbToGuess :
                alert("GG WP");
                win = true;
                nbWin ++;
                break;
            default :
                alert("Wtf")
                break;
        }

    }while(!win && nbTentative > 0)
    if(nbTentative == 0) {
        alert(`Loseeeer ! Le nombre à deviner était ${nbToGuess} !`)
        nbLose++;
    }
}

function generateRandom(max) {
    return Math.floor(Math.random() * max) + 1;
}