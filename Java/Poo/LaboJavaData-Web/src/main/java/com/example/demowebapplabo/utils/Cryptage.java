package com.example.demowebapplabo.utils;

import org.mindrot.jbcrypt.BCrypt;

public class Cryptage {
    public static String cryptageMotDePasse(String password) {
        String salt = BCrypt.gensalt(); // Génération d'un sel aléatoire
        String hashedPassword = BCrypt.hashpw(password, salt); // Cryptage du mot de passe avec le sel
        return hashedPassword;
    }
}
