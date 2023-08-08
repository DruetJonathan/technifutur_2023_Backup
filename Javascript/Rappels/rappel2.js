// ? 1) Récupérer tous les éléments dont on aura besoin
// Images
const IMG_GALERY = document.querySelectorAll(".galery img");
// Popup
const DIV_POPUP = document.getElementById("popup");
// Image dans la popup
const IMG_POPUP = document.getElementById("img-popup")

// ? 2) Ajouter un listener sur chacune des images qui va ouvrir la popup
// Pour chaque image de la galery, on va aller ajouter un eventListener
IMG_GALERY.forEach( image => { 
    // console.log(image);
    image.addEventListener("click", (event) => {
        console.log(event);
        // 1 - Récupérer la source de l'image sur laquelle on vient de cliquer pour la mettre dans la source de l'image qui se trouve dans la popup
        // event : objet qui contient plein d'infos sur l'évènement qui vient d'être déclenché
        // event.target : La cible qui a déclenché l'event
        IMG_POPUP.src = event.target.src;

        // 2 - Afficher la popup
        DIV_POPUP.classList.remove("hidden");
    })
})

// ? 3) Ajouter un listener pour fermer la popup
// Au click n'importe où dans la fenêtre
window.addEventListener("click", (event) => {
    // Uniquement si on est dans la popup
    if(event.target == DIV_POPUP) {
        DIV_POPUP.classList.add("hidden");
        console.log(DIV_POPUP.classList); //Liste contenant toutes les classes actuellement appliquées à l'élément
    }
})