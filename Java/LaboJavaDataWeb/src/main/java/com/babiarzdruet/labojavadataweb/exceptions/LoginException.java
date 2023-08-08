package com.babiarzdruet.labojavadataweb.exceptions;

public class LoginException extends RuntimeException{

    public LoginException(){super("Login doesn't exists !");}

    public LoginException(String message){super(message);}
}
