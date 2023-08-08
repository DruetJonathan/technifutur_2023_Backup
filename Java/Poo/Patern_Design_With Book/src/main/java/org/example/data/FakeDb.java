package org.example.data;

import org.example.models.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FakeDb {
    public static HashMap<Integer, Book> map = new HashMap<>();;


    public static void init(){
        map.put(1,new Book("toto1","super Livre1","jean mich1"));
        map.put(2,new Book("toto2","super Livre2","jean mich2"));
        map.put(3,new Book("toto3","super Livre3","jean mich3"));
        map.put(4,new Book("toto4","super Livre4","jean mich4"));
        map.put(5,new Book("toto5","super Livre5","jean mich5"));
        map.put(6,new Book("toto6","super Livre6","jean mich6"));
    }
}
