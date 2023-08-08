// ? 1) Récupérer tout ce dont on a besoin
const INPUT_PRENOM = document.getElementById("firstname")
const SELECT_COUNTRY = document.getElementById("country")
const BTN_SEARCH = document.getElementById("search-age")
const P_RESULT = document.getElementById("result")

// ? 2) Ajouter un eventListener sur le button
BTN_SEARCH.addEventListener("click", /* pour pouvoir utiliser await →*/ async () => {
    // Récupérer les infos
    let prenom = INPUT_PRENOM.value;
    let country = SELECT_COUNTRY.value;

    // Vérifier si on peut lancer la requête
    if(prenom.trim() != "" && country != "") {
        console.log("PRENOM : ", prenom);
        console.log("COUNTRY : ", country);
        // Lancer la requête

        //#region AJAX
        // // Création de l'objet qui nous sert à faire une requête
        // let xhr = new XMLHttpRequest();

        // // Ecoute event onreadystatechange qui se déclenche chaque fois que readyState ou status change
        // xhr.onreadystatechange = () => {
        //     // console.log("READYSTATE : ", xhr.readyState); 
        //     // readyState : Etat de la requête
        //     // 0 : L'objet xhr a été crée mais il n'a pas été open
        //     // 1 : L'objet xhr a été crée, open mais pas encore envoyé
        //     // 2 : L'objet xhr a été envoyé (send)
        //     // 3 : La requête est en train de s'effectuer et on récupère des données
        //     // 4 : On a fini de récupérer toutes les données

        //     // console.log("STATUS :", xhr.status);
        //     // status : Status de la requête
        //     // 200 : Ok
        //     // 404 : Not Found
        //     // 500 : Error Server

        //     // On veut traiter les données uniquement si la requête s'est bien passée
        //     // On vérifie donc si le readyState est 4 (fini de récup les données) et si le status de la requête est 200 (tout est ok)
        //     if(xhr.readyState == 4 && xhr.status == 200) {
        //         console.log("FIN");
        //         // Si responseType pas précisé
        //         // ResponseText contient le résultat de la requête sous forme d'une chaine de caractères
        //         // console.log(xhr.responseText);
        //         // On doit donc la transformer en objet grâce à JSON.parse(chaine)
        //         // let data = JSON.parse(xhr.responseText);
        //         // console.log(data);

        //         //Si responseType précisé en json, on reçoit direct les données dans xhr.response
        //         console.log(xhr.response);
                
        //         // Afficher sur la page
        //         P_RESULT.innerHTML = `${xhr.response.name} a de fortes chances d'avoir environ ${xhr.response.age} ans basé sur ${xhr.response.count} résultats pour le code pays ${xhr.response.country_id} !`;
        //     }
        // }


        // // Lancement requête
        // // 1param : method
        //     // get : Récupérer des données
        //     // post : Envoyer des données
        //     // put/patch : Modifier données
        //     // delete : Supprimer des données
        // // 2param : url de la requête
        // // 3param : booleen pour savoir si la requête sera sync ou asynchrone (si true, async)
        // // sync : La requête est "bloquante" -> En attend la réponse pendant qu'elle s'effectue et plus aucune interaction n'est possible
        // // async : La requête se fait dans son coin et on peut continuer à en faire d'autres
        // xhr.responseType = "json";
        // xhr.open("GET", `https://api.agify.io/?name=${prenom}&country_id=${country}`, true );
        
        // // Envoi de la requête
        // xhr.send(); //En get pas de param puisqu'on n'envoie rien, on post, on fournit ce qu'on veut envoyer 
        //#endregion AJAX

        // FETCH
        // fetch(`https://api.agify.io/?name=${prenom}&country_id=${country}`)
        //     .then( (res) => { 
        //         console.log(res);
        //         // Si la requête s'est faite correctement
        //         if(res.ok) {
        //             res.json().then( (data) => {
        //                 P_RESULT.innerHTML = `${data.name} a de fortes chances d'avoir environ ${data.age} ans basé sur ${data.count} résultats pour le code pays ${data.country_id} !`;
        //             })
        //         }
        //      } )
            // .catch( (err) => { console.log(err) })
            // .finally( () => {})

        try {
            let res = await fetch(`https://api.agify.io/?name=${prenom}&country_id=${country}`);
            if(res.ok) {
                let data = await res.json();
                P_RESULT.innerHTML = `${data.name} a de fortes chances d'avoir environ ${data.age} ans basé sur ${data.count} résultats pour le code pays ${data.country_id} !`;
            }
        }
        catch(err) {
            console.log(err);
        }

    }

})