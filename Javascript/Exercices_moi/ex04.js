let prixHTVA = parseInt(prompt("Donnez un prix HTVA :"))
let nbrLivre = parseInt(prompt("Donnez un nombre de livre :"))

alert(`Prix HTVA → ${prixHTVA} €\nNombre de livre → ${nbrLivre}\nPrix TVAC → ${((prixHTVA * 0.21) + prixHTVA) * nbrLivre} €`)
