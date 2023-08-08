document.title = "Demo Dom";

// Pour récupérer des éléments
const DIV_POUET = document.getElementById("pouet");
const ALL_LI_BLUE = document.querySelectorAll("li.blue");
const IMG_POUET = document.getElementById("img-pouet");
console.log(DIV_POUET);
console.log(ALL_LI_BLUE);

// ? Pour modifier des éléments

// Contenu
// DIV_POUET.innerText = "<p> Ca fait pouet</p>"
DIV_POUET.innerHTML += `<p> <button id="btn-pouet"> Pouet </button> </p>`;

// Attributs
// IMG_POUET.setAttribute('src', 'https://imagine.bayard.io/unsafe/560x0/bayard-static/edition/couvertures/9791036350535/9791036350535.jpg');
IMG_POUET.src = "https://imagine.bayard.io/unsafe/560x0/bayard-static/edition/couvertures/9791036350535/9791036350535.jpg";
// IMG_POUET.removeAttribute('src'); //Pour enlever un attribut

// Pour ajouter des éléments
const TBODY = document.getElementById("tab-content");

let row = document.createElement("tr");
let td1 = document.createElement("td");
let td2 = document.createElement("td");
let td3 = document.createElement("td");

td1.innerHTML = "Lundi";
td2.innerHTML = "Chou-fleur polonais";
td3.innerHTML = "Tartines + Soupe de restes de chou-fleur";

row.appendChild(td1) // Ajouter un enfant
row.append(td2, td3) // Ajouter plusieurs enfants

TBODY.appendChild(row);

// La version rapide :
TBODY.innerHTML += `
    <tr>
        <td>Mardi</td>
        <td>Beau Vivier</td>
        <td>Couscous Merguez</td>
    </tr>
`

// Ajouter des évènements
//1ère façon relier onclick côté html à une fonction côté js
function afficherPouet() {
    console.log("Pouet");
}


const BTN_POUET = document.getElementById("btn-pouet");
const DIV_POTIBLAGUEUR = document.getElementById("poti-blagueur");

const BLAGUE = document.getElementById("blague");
const NB_BLAGUE = document.getElementById("nb-blague");
const COLORS = ["red", "orange", "yellow", "green", "blue"];
let currentColor = 0;
let timer;

//2ème façon
BTN_POUET.onclick = afficherPouet;

//3ème façon : A privilégier

// Pour ouvrir la popup potiblagueur
BTN_POUET.addEventListener('click', () => {
    DIV_POTIBLAGUEUR.classList.remove("hidden");
    timer = setInterval(() => {
        BLAGUE.classList.remove(COLORS[currentColor]);
        currentColor++;
        // Si on dépasse la taille du tableau de couleurs, on retourne au début
        if(currentColor > COLORS.length - 1) {
            currentColor = 0;
        }
        BLAGUE.classList.add(COLORS[currentColor]);

        
    }, 1000)
    NB_BLAGUE.innerText = parseInt(NB_BLAGUE.innerHTML) + 1;
    
})

// Pour fermer la popup potiblagueur
const BTN_CLOSE = document.getElementById("close");
BTN_CLOSE.addEventListener("click", () => {
    DIV_POTIBLAGUEUR.classList.add("hidden");
    clearInterval(timer);
})

// Fermer la popup en appuyant sur Echap
window.addEventListener("keyup", (e) => {
    console.log(e);
    if((e.target == BTN_POUET || e.target== document.body ) && e.key == "Escape" ){
        DIV_POTIBLAGUEUR.classList.add("hidden");
        clearInterval(timer);
    }
})

// Fermer la popup en cliquant dans la modal
window.addEventListener('click', (e) => { 
    if(e.target == DIV_POTIBLAGUEUR ){
        DIV_POTIBLAGUEUR.classList.add("hidden");
        clearInterval(timer);
    }
})

