console.log("Exercice 3");
// Chaîne : « ma formation javascript »
let chaine = "ma formation javascript";
console.log(chaine);

// • Avec la chaîne ci-dessus :
// – Retourner la position de « ma »
console.log(` "ma" se trouve en position ${chaine.indexOf("ma") + 1}`);
console.log(` "ma" se trouve en position ${chaine.indexOf("ma", 1) + 1}`);
console.log(` "ma" se trouve en position ${chaine.lastIndexOf("ma") + 1}`);

// – Indiquer l’indice de la lettre « p »
console.log(`Indice de la lettre p : ${chaine.indexOf("p")}`);

// – Retrouver la lettre située à l’indice 21
console.log(`La lettre située à l'indice 21 : ${ chaine[21] }`);
console.log(`La lettre située à l'indice 21 : ${ chaine.charAt(21) }`);
console.log(`La lettre située à l'indice 21 : ${ chaine.at(21) }`);

// – Remplacer « javascript » par « Java »
let chaineReplace = chaine.replace("javascript", "Java");
console.log(chaineReplace);

// – Découper la chaîne avec le délimiteur «  » (espace)
let chaineTab = chaine.split(" ");
console.log(chaineTab);

// – Inverser la chaîne de caractères (+ difficile) :
// « ma formation javascript » → « tpircsavaj noitamrof am »
// let chaineInversee = chaine.reverse(); // dommage

let etape1 = chaine.split("");
console.log(etape1);
let etape2 = etape1.reverse();
console.log(etape2);
let etape3 = etape2.join("");
console.log(etape3);

console.log( chaine.split("").reverse().join("") );