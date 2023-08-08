package main.Controller;

import main.Exception.DateEndIsBeforDateStart;
import main.domains.Personne;

import java.util.ArrayList;

public interface Controller {
    Runnable ajouter();
    Runnable modifier();
    Runnable supprimer();
    Runnable afficher();
}
