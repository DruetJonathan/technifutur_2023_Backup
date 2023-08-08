console.log("Les dates");

// Créer une date
let dateDuJour = new Date(); // Vide date du jour
console.log(dateDuJour);
let dateRandom = new Date(1541645); // Date à partir du 1/1/1970 + 1541645ms
console.log(dateRandom);
let annivGavin = new Date(1993, 9, 18); // 3 nombres : Année / Mois - 1 / Jour
let annivAude = new Date(1989, 9, 16, 15, 25, 3); // 6(ou 7) nombres : Année / Mois - 1 / Jour / Heures / Minutes / Secondes (+1 : Millisecondes)
let annivAlex = new Date("1997-10-15"); // - ou / mais format annee/mois/jour
console.log(annivAlex);

// Récupérer des infos d'une date
dateDuJour.getFullYear(); // année
console.log(dateDuJour.getMonth()); // Mois de 0 à 11 , 0 étant Janvier
console.log(dateDuJour.getDate()); // Jour du mois entre 1 et 31 max
console.log(dateDuJour.getDay()); // Jour de la semaine entre 0 et 6, 0 étant dimanche
console.log(dateDuJour.getTime()); // Temps écoulé en ms entre votre date et le 1/1/1970

// Modifier des infos d'une date
dateDuJour.setDate( dateDuJour.getDate() + 25 );
console.log(dateDuJour);

// P'tit exemple avec la librairie dayjs (successeur de moment js)
let dateDuJourAvecLib = dayjs();
// console.log(dateDuJourAvecLib);
let test = dayjs().add(25, "day");
// console.log(test);

// Formater une date
console.log(new Date().toLocaleDateString()); // Locale du system

console.log(new Date().toLocaleDateString("en-US")); // Locale en particulier
console.log(new Date().toLocaleDateString("de-de"));

console.log(new Date().toLocaleDateString('fr-BE', { weekday : "long", day : '2-digit', month : "long", year : "numeric", hour : "2-digit" }));



