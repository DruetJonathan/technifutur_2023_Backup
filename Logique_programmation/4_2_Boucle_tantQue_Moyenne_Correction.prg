debut moyenne
   debut variables locales
      const STOP : N <- 100
      var valeur : N <- 0 // "la dernière saisie de l'utilisateur"
      var somme  : N <- 0 // "la somme des valeurs valides"
      var nbValeurs : N <- 0 // "le nombre de valeurs valides"
      var max : N <- 0 // "le maximum des valeurs valides"
      var maxOccur : N <- 0 // " le nombre de fois que la valeurs max est apparue"
      var pos1max : N <- 0 // "la position de la première occurence de max"
      var posDerMax : N <- 0 // "la position de la dernière occurence de max"
      var min : N <- 0 // "le minimum des valeurs valides"
      var minOccur : N <- 0 // " le nombre de fois que la valeurs min est apparue"
      var pos1min : N <- 0 // "la position de la première occurence de min"
      var posDerMin : N <- 0 // "la position de la dernière occurence de min"
    fin variables locales
   
   afficher "Entrez une suite de valeurs terminée par 100 : "
   saisir valeur
   si valeur != STOP
      alors
         // "première valeur valide"
         somme <- valeur
         nbValeurs <- 1
         max <- valeur
         min <- valeur
         maxOccur <- 1
         minOccur <- 1
         pos1max <- 1
         posDerMax <- 1
         pos1min <- 1
         posDerMin <- 1
         afficher "valeur : "
         saisir valeur
         tant que valeur != STOP
            // "valeurs suivantes"
            somme <- somme + valeur
            nbValeurs <- nbValeurs + 1
            si valeur >= max
               alors
                  si valeur > max
                     alors
                        max <- valeur
                        maxOccur <- 1
                        pos1max <- nbValeurs
                     sinon
                        maxOccur <- maxOccur + 1
                  finsi
                  posDerMax <- nbValeurs
           finsi
            si valeur <= min
               alors
                  si valeur < min
                     alors
                        min <- valeur
                        minOccur <- 1
                        pos1min <- nbValeurs
                     sinon 
                        minOccur <- minOccur + 1
                  finsi
                  posDerMin <- nbValeurs
            finsi
            
            afficher "valeur : "
            saisir valeur
         fin tant que
   
         afficher "moyenne : " , somme / nbValeurs
         afficher "max : " , max
         afficher "occurence de max  : " , maxOccur
         afficher "première occurence de max en : " , pos1max
         afficher "dernière occurence de max en : " , posDerMax
         afficher "min : " , min
         afficher "occurence de min  : " , minOccur
         afficher "première occurence de min en : " , pos1min
         afficher "dernière occurence de min en : " , posDerMin
         afficher "Pas de valeurs entrées"
   finsi
   
   
   
   
fin moyenne