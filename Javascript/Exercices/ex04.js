console.log("Calcul TVA");

// • Calcul de la TVA
// Écrire un programme qui :
// 1. Demande à l’utilisateur un prix unitaire hors taxe d’un livre
let prix = parseFloat(prompt("Veuillez entrer le prix d'un livre HT : "));

// 2. Demande à l’utilisateur la quantité de livre
let quantity = parseInt(prompt("Veuillez entrer une quantité de livres"));

// 3. Calcule et affiche le prix total TTC de la commande, en utilisant une TVA de 21%
let prixUnitaireTVA = prix * 1.21;
let prixTotal = prixUnitaireTVA * quantity;

//façon2
const TVA = 1.21;
let prixTotal2 = (prix * TVA) * quantity;

//façon3
let prixTTC = (prix * quantity) + (prix * quantity) * 21/100;

alert(`Le prix de ${quantity} livres à ${prix} € sera de ${prixTotal.toFixed(2)} €`)

