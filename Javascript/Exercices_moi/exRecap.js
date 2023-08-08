// ? Variables
let partieWin = 0;
let partiePerdue = 0;
let partieTotales = 0;
let random;
let nbrTentatives;
let phraseGame;
let rejouer = true;
let min = 1;
let max;
while (rejouer) {
    let statutGame = false;
    let choixDifficulte;
    let reponse;

    // ? Choix difficulté
    while (choixDifficulte == null || isNaN(choixDifficulte) || choixDifficulte < 0 || choixDifficulte > 4) {
        choixDifficulte = parseInt(prompt(`Choix difficulté:\n1.Facile\n2.Moyen\n3.Difficile${partieTotales != 0 ? "\n4.Quitter" : ""}`));
    }
    // ? Init des variables en fonction de la diff.
    switch (choixDifficulte) {
        case 1:
            max = 10;
            random = Math.floor(Math.random() * (11 - 1) + 1);
            nbrTentatives = 5;
            phraseGame = '1 et 10';
            break;
        case 2:
            max = 100;
            random = Math.floor(Math.random() * (101 - 1) + 1);
            nbrTentatives = 15;
            phraseGame = '1 et 100';
            break;
        case 3:
            max = 1000;
            random = Math.floor(Math.random() * (1001 - 1) + 1);
            nbrTentatives = 25;
            phraseGame = '1 et 1000';
            break;
        case 4:
            rejouer = false;
            nbrTentatives = 0;
            break;
        default:
            random = 0;
            nbrTentatives = 0;
            break;
    }
    //? Game
    if (rejouer) {
        while (nbrTentatives != 0 && !statutGame) {
            reponse = parseInt(prompt('Choisissez un nombre entre ' + phraseGame));
            while (reponse < min || reponse > max) {
                reponse = parseInt(prompt('! Error: Choisissez un nombre entre ' + phraseGame));
            }
            if (reponse == random) {
                statutGame = true;
                break;
            }
            else {
                reponse > random ? alert('Plus petit') : alert('Plus Grand');
                nbrTentatives--;
            }
            console.log(nbrTentatives);
        }

        partieTotales++;
        !statutGame ? partiePerdue++ : partieWin++;
        alert(`${statutGame ? "Win !" : "Loose !"}\n
    Nombre de tentatives restantes: ${nbrTentatives}\n
    Nombre de parties gagnées: ${partieWin}\n
    Nombre de parties perdues: ${partiePerdue}\n
    Nombre de parties totales: ${partieTotales}\n
    `)

    }
}



