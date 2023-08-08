// ? Faire un p'tit programme qui demande à l'utilisateur
// Son nom
// Son prénom
// Son âge
let lastName = prompt("Entrez votre nom : ");
let firstName = prompt("Entrez votre prénom : ");
let age = parseInt(prompt("Entrez votre âge : "));

// let age = prompt("Entrez votre âge : ");
// age = parseInt(age);

// ? Afficher "Bonjour et bienvenue [Nom] [Prenom], vous aurez bientôt [Age + 1] ans, dur hein?"
alert(`Bonjour et bienvenue ${lastName} ${firstName}, vous aurez bientôt ${age + 1} ans, dur hein?`);

// alert(`Bonjour et bienvenue ${lastName} ${firstName}, vous aurez bientôt ${parseInt(age) + 1} ans, dur hein?`);