console.log("Coucou");

// Pour compiler à la main le fichier :
// Dans la console, dans le bon dossier, taper tsc nomfichier.ts
// Un fichier js portant le même nom est ainsi créé

// Déclarer une variable
let maVariableJSaisPasCKoi : any = "frefer";
maVariableJSaisPasCKoi = 1;

// Types de base
let monNombre : number = 5;
//monNombre = "defe";
let maChaine : string = "ma super chaine";
let monBool : boolean = true;
let monNombre2 : number | undefined;


// Les tableaux
let monTab : number[] = [1, 2, 3];
let pouet : Array<number> = [1, 2 /*, "pouet"*/]; //Personne fait ça, on utilise souvent number[]
let monTableau : (number|string)[] = [1 , "fre", 3];
// cas qu'on retrouvera en Angular pour autorisé notre variable connectedUser à être soit un objet de type User, soit undefined si on n'a pas de user connecté
// let connectedUser : User | undefined;

// Les dates
let today : Date = new Date();


// Fonctions
function direBonjour( langue : string = "fr", prenom : string = "Roger") : string {
    switch(langue) {
        case "fr" :
            return `Bonjour ${prenom}`;
        case "en" :
            return `Hello ${prenom}`;
        case "it" :
            return `Ciao ${prenom}`;
        default : 
            return `J'ai rien compris ${prenom}`;
    }
}
console.log(direBonjour()); //Prend les valeurs par défaut puisque rien renseigné
console.log(direBonjour("it", undefined)); // Prend la valeur par défaut si undefined
console.log(direBonjour("en", "Timothée"));
console.log(direBonjour(",jfirfd"));

function horlogeParlante() : void {
    console.log(`Bonjour nous sommes le ${new Date().toLocaleDateString("fr-BE", { weekday : 'long', day : '2-digit', month : 'long' , year : "numeric"})} et il est ${new Date().toLocaleTimeString("fr-BE", { hour : '2-digit', minute : '2-digit'})}`);
    
}
horlogeParlante();

// LES CLASSES
class Person {
    // Propriétés
    firstname : string;
    lastname : string;
    private birthdate : Date;
    child : number;
    single : boolean;
    petName? : string;

    // Constructeur
    // constructor()
    // constructor(firstname : string)
    constructor(firstname : string, lastname : string, birthdate : Date, child : number = 0, single : boolean = true, petName? : string){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.child = child;
        this.single = single;
        this.petName = petName;
    }

    // Méthodes
    sePresenter() : void {
        console.log(`Bonjour je m'appelle ${this.firstname} ${this.lastname}`);        
    }
}

let seb : Person = new Person("Seb", "Bya", new Date(27, 2, 1991), 0, false);
seb.sePresenter();

class User extends Person {
    login : string;
    password : string;

    constructor(firstname : string, lastname : string, birthdate : Date, child : number, single : boolean, login : string, password : string, petName? : string) {
        super(firstname, lastname, birthdate, child, single, petName);
        this.login = login;
        this.password = password;
    }
}

let khun : User = new User("Khun", "Ly", new Date(1982, 4, 6), 0, true, 'khunly', 'test1234');


// Les interfaces
interface Chien {
    name : string;
    birthdate : Date;
    race : string;
    nbPaw : number;
    chipped : boolean;
}

let listChien : Chien[] = [
    { name : "Rantanplan", birthdate : new Date(), race : "Croisé", nbPaw : 3, chipped : true}
]

listChien.forEach(chien => { console.log(chien.name) })

// class Pouet implements Chien {
    
// }


