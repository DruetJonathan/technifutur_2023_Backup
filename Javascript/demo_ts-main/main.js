var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
console.log("Coucou");
// Pour compiler à la main le fichier :
// Dans la console, dans le bon dossier, taper tsc nomfichier.ts
// Un fichier js portant le même nom est ainsi créé
// Déclarer une variable
var maVariableJSaisPasCKoi = "frefer";
maVariableJSaisPasCKoi = 1;
// Types de base
var monNombre = 5;
//monNombre = "defe";
var maChaine = "ma super chaine";
var monBool = true;
var monNombre2;
// Les tableaux
var monTab = [1, 2, 3];
var pouet = [1, 2 /*, "pouet"*/]; //Personne fait ça, on utilise souvent number[]
var monTableau = [1, "fre", 3];
// cas qu'on retrouvera en Angular pour autorisé notre variable connectedUser à être soit un objet de type User, soit undefined si on n'a pas de user connecté
// let connectedUser : User | undefined;
// Les dates
var today = new Date();
// Fonctions
function direBonjour(langue, prenom) {
    if (langue === void 0) { langue = "fr"; }
    if (prenom === void 0) { prenom = "Roger"; }
    switch (langue) {
        case "fr":
            return "Bonjour ".concat(prenom);
        case "en":
            return "Hello ".concat(prenom);
        case "it":
            return "Ciao ".concat(prenom);
        default:
            return "J'ai rien compris ".concat(prenom);
    }
}
console.log(direBonjour()); //Prend les valeurs par défaut puisque rien renseigné
console.log(direBonjour("it", undefined)); // Prend la valeur par défaut si undefined
console.log(direBonjour("en", "Timothée"));
console.log(direBonjour(",jfirfd"));
function horlogeParlante() {
    console.log("Bonjour nous sommes le ".concat(new Date().toLocaleDateString("fr-BE", { weekday: 'long', day: '2-digit', month: 'long', year: "numeric" }), " et il est ").concat(new Date().toLocaleTimeString("fr-BE", { hour: '2-digit', minute: '2-digit' })));
}
horlogeParlante();
// LES CLASSES
var Person = /** @class */ (function () {
    // Constructeur
    // constructor()
    // constructor(firstname : string)
    function Person(firstname, lastname, birthdate, child, single, petName) {
        if (child === void 0) { child = 0; }
        if (single === void 0) { single = true; }
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.child = child;
        this.single = single;
        this.petName = petName;
    }
    // Méthodes
    Person.prototype.sePresenter = function () {
        console.log("Bonjour je m'appelle ".concat(this.firstname, " ").concat(this.lastname));
    };
    return Person;
}());
var seb = new Person("Seb", "Bya", new Date(27, 2, 1991), 0, false);
seb.sePresenter();
var User = /** @class */ (function (_super) {
    __extends(User, _super);
    function User(firstname, lastname, birthdate, child, single, login, password, petName) {
        var _this = _super.call(this, firstname, lastname, birthdate, child, single, petName) || this;
        _this.login = login;
        _this.password = password;
        return _this;
    }
    return User;
}(Person));
var khun = new User("Khun", "Ly", new Date(1982, 4, 6), 0, true, 'khunly', 'test1234');
var listChien = [
    { name: "Rantanplan", birthdate: new Date(), race: "Croisé", nbPaw: 3, chipped: true }
];
listChien.forEach(function (chien) { console.log(chien.name); });
// class Pouet implements Chien {
// }
