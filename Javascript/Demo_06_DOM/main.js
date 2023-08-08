document.title = "Demo Dom";

// Pour récupérer des éléments
const DIV_POUET = document.getElementById("pouet");
const ALL_LI_BLUE = document.querySelectorAll("li.blue");
const IMG_POUET = document.getElementById("img-pouet");
console.log(DIV_POUET);
console.log(ALL_LI_BLUE);

// Pour modifier des éléments
// Contenu
// DIV_POUET.innerText = "<p> Ca fait pouet</p>"
DIV_POUET.innerHTML += `<p> <button> Pouet </button> </p>`;
// Attributs
// IMG_POUET.setAttribute('src', 'https://imagine.bayard.io/unsafe/560x0/bayard-static/edition/couvertures/9791036350535/9791036350535.jpg');
IMG_POUET.src = "https://imagine.bayard.io/unsafe/560x0/bayard-static/edition/couvertures/9791036350535/9791036350535.jpg";

// Pour ajouter des éléments

// Ajouter des évènements
