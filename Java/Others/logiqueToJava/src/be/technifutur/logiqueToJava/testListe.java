package be.technifutur.logiqueToJava;

public class testListe implements Runnable{
    public void run(){
        Liste liste = null;
        liste = ajouterDebut(15,liste);
        liste = ajouterDebut(55,liste);
        System.out.println("Taille de ma liste: "+taille(liste));
        System.out.println("Valeur position 0: "+lire(liste,0));
        liste = remplacer(30,liste,0);
        System.out.println("New valeur: "+lire(liste,0));
        liste = ajouterFin(25,liste);
        System.out.println("Dernière valeur: "+lire(liste,taille(liste)-1));
        System.out.println("--------------------------");
        liste = supprimer(liste,0);
        liste = supprimer(liste,0);
        liste = supprimer(liste,0);
        System.out.println(toString(liste));
        liste = inserer(5,liste,0);
        liste = inserer(10,liste,1);
        liste = inserer(10,liste,2);
        liste = inserer(7,liste,0);
        System.out.println(toString(liste));
    }
    private String toString(Liste list) {
        String result="";
        while( list != null){
            result += " "+list.valeur;
            list = list.suivant;
        }
        return result;
    }
    public Liste sousListe(Liste l, int position){
        Liste result = l;
        for (int i = 0; i < position; i++) {
            result = result.suivant;
        }
        return result;
    }
    public int lire(Liste l, int position){
        return sousListe(l,position).valeur;
    }
    public Liste remplacer(int newValeur, Liste l,int position){
        Liste temp = (sousListe(l,position));
        temp.valeur = newValeur;
        return temp;
    }
    public Liste ajouterDebut(int newValeur,Liste l){
        Liste result = new Liste();
        result.valeur = newValeur;
        result.suivant = l;
        return result;
    }
    public Liste ajouterFin(int newValeur, Liste l){
        Liste result = l;
        if (l == null){
            result = ajouterDebut(newValeur,l);
        }else{
            while (l.suivant != null){
                l = l.suivant;
            }
            l.suivant = new Liste();
            l.suivant.valeur = newValeur;
        }
        return result;
    }
    public int taille(Liste l){
        Liste temp = l;
        int cpt = 0;
        while (temp != null){
            temp = temp.suivant;
            cpt ++;
        }
        return cpt;
    }
    public Liste supprimer(Liste l, int position){
        Liste temp = l;
        int cpt = 0;
       if (taille(l) == 1){
           return null;
       }
       else{
           while (cpt + 1 < position){
               temp = temp.suivant;
               cpt ++;
           }
           temp.suivant = temp.suivant.suivant;
           return l;
       }
    }
    public Liste inserer(int valeur,Liste l,int position){
        if (position == 0){
            l = ajouterDebut(valeur,l);
        }
        else {
            Liste temp = new Liste();
            temp.valeur = valeur;
            Liste parcourList = l;
            int cpt = 0;
            while (cpt < position - 1){
                parcourList = parcourList.suivant;
                cpt ++;
            }
            temp.suivant = parcourList.suivant;
            parcourList.suivant = temp;
        }
        return l;
    }
}
