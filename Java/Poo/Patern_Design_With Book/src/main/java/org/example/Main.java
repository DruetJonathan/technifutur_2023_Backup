package org.example;

import org.example.data.FakeDb;
import org.example.models.Book;
import org.example.models.forms.AddBookForm;
import org.example.repositories.BookRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        FakeDb.init();
        BookRepository bookRepository = new BookRepository();

        HashMap<Integer, Book> map = bookRepository.getMany();

        Book newBook = new Book("testADD","","");
        bookRepository.add(newBook);
        map = bookRepository.getMany();

        AddBookForm form = new AddBookForm("toto","a","aaa");

        bookRepository.update(7,form);

        bookRepository.delete(7);

        bookRepository.add(new Book("fffff","f","fff"));

        showMap(map);
    }
    public static void showMap(HashMap<Integer,Book> map){
        map.forEach((integer, book) -> System.out.println(book));
    }

}