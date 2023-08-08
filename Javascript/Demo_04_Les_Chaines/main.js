console.log("Les chaines");

let guillemetsDouble = "Bah c'est des guillemets double";
let guillemetsSimple = 'Bah c\'est des guillemets simples';
//   \ → Caractère d'échappement
// Pas de différence entre les deux, soyez juste constants

// L'interpolation
let interpolation = `C'est pour écrire du code ${ 'genre comme ça' } dedans sans faire de la concaténation : ${ 4 + 48571 }`;


let bienvenue = "Bonjour, aujourd'hui nous sommes mardi";
// On peut accéder à chacune des lettres comme dans un tableau puisqu'elles ont chacunes un indice 0 -> taille chaine - 1
console.log( bienvenue[2] );
console.log( bienvenue.length );
// Par contre elle est immutable -> On ne peut pas la modifier
bienvenue[2] = "J"
console.log( bienvenue ); // Y'aura pas le J

// Les méthodes
// Formatage
let bienvenueEnMaj = bienvenue.toUpperCase();
console.log(bienvenueEnMaj);
let bienvenueEnMin = bienvenue.toLowerCase();
console.log(bienvenueEnMin);

// Enlever tous les espaces qui ne servent à rien
// Souvent utilisé pour faire le ménage après une entrée utilisateur
let uneChaineEspace = "                     Oui et non                   ";
console.log(uneChaineEspace);
let uneChaineSansEspace = uneChaineEspace.trim();
console.log(uneChaineSansEspace);

// Pour accéder à un caractère en particulier
console.log(bienvenue[12]);
console.log(bienvenue.charAt(12)); // 0 -> taille-1 (négatifs interdits)
console.log(bienvenue.charCodeAt(12)); // Renvoie le caractère en unicode
console.log(bienvenue.at(12)); // négatifs autorisés

// Pour avoir l'indice d'un caractère ou d'une chaine
console.log(bienvenue);
console.log( bienvenue.indexOf("ou") ); //Renvoie la première occurance trouvée
console.log( bienvenue.lastIndexOf("ou") ); //Renvoie la dernière occurance trouvée
console.log( bienvenue.indexOf("graou")); // Renvoie -1 si ne trouve rien

console.log( bienvenue.indexOf("ou", 5)); // Renvoie la première occurance en partant de l'indice 5

// Pour remplacer un caractère ou une chaine
let bienvenueReplace = bienvenue.replace("ou", "OU"); // Remplace la première occurance de "ou" par "OU"
let bienvenueReplace2 = bienvenue.replaceAll("ou", "OU"); //Remplace toutes les occurances de "ou" par "OU"
console.log(bienvenueReplace);
console.log(bienvenueReplace2);

// Pour découper la chaine
// let bonjour = bienvenue.substring(0, 7);
let bonjour = bienvenue.substring(7, 0);
console.log(bonjour);
let bonjour2 = bienvenue.slice(0, 7); //Bah ça fait pareil
let mardi = bienvenue.slice(-5); //Partir de la fin
console.log(mardi);
console.log(bonjour2); 

// Pour découper la chaine dans un tableau
let bienvenueTab = bienvenue.split(" ");
console.log(bienvenueTab);
let monFichier = "monSuperNomDeFichier.pdf"
let monFichierSplit = monFichier.split('.')
console.log(monFichierSplit);

// ! includes
let maChaine = "Une chaine qui contient pouet";
console.log(maChaine);
console.log("Pouet présent ? " + maChaine.includes("pouet") );
console.log("Truc présent ? " + maChaine.includes("truc") );

// Existe aussi sur les tableaux
let formateurs = ["Gavin", "Seb", "Aude", "Khun"];
console.log(formateurs);
console.log(formateurs.includes("Seb"));
console.log(formateurs.includes("Alex"));

