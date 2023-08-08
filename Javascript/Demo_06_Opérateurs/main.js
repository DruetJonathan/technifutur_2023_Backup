console.log("Opérateurs");

// Opérateurs arithmétiques
let x = 2;
let y = 6;

let addition = x + y;
let soustraction = x - y;
let multiplication = x * y;
let division = x / y; // Pas de division entière, il faudra arrondir vous même
let divisionLongue = 10 / 3;
console.log(divisionLongue.toFixed(2)); //Pour choisir le nombre de chiffres après la virgule
let modulo = x % y;
let puissance = x ** y;

// Opérateurs d'incrémentation
x++
++x
y--
--y

// Raccourcis opérateurs arit
x += 5
y -= 1
x *= 2
y /= 3
x %= 2
x **= 2

// Opérateurs de comparaison
// < <=
// > >=
// ==  !=          "5" == 5   vrai
// ===  !==        "5" === 5  false   (égalité stricte)


// Opérateurs logiques
// ! négation
// && ET 
// || OU 

let nomVariable
console.log(typeof nomVariable)

let person = {
    nom : "Beurive",
    prenom : "Aude"
}
// Je peux créer des propriétés à la volée sur mes objets 
person.age = 33;
console.log(person.age);

// Si je veux supprimer une prop
delete person.prenom;
console.log(person.prenom);


// Js dans toute sa splendeur : 
console.log(0 == false); //true    false est converti en 0 et true en 1
console.log(1 > true); //false

console.log(0 == []); //true

console.log(null > 0); //false
console.log(null == 0); //false
console.log(null >= 0 ); //true

console.log(NaN == NaN);
console.log(NaN > 0);
console.log(NaN < 0);
console.log(NaN == 0);
