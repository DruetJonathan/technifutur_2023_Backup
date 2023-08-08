package org.example;

import org.example.models.entities.Book;
import org.example.models.entities.Customiser;
import org.example.models.forms.BookForm;
import org.example.services.BookServiceImpl;
import org.example.services.CustomiserServiceImpl;

public class Main {
    public static void main(String[] args) {
//        BookServiceImpl bookService = new BookServiceImpl();
//        List<Book> books = bookService.getMany();
//        books.forEach(System.out::println);
//        Book book = bookService.getOne(1);
//        System.out.println(book);
//        BookForm bookForm = new BookForm("Babiarz au pays des Polonais","Kevin: Shamrock > Dundalk");
//        Book book =  bookService.add(bookForm.toEntity());
//        System.out.println(book);
//        System.out.println(bookService.delete(-1));
//        System.out.println(bookService.delete(6));
//        System.out.println(bookService.update(6,new Book("Toto","Toto va à la plage")));
        // Login mdp role


        CustomiserServiceImpl customiserService = new CustomiserServiceImpl();
        Customiser customiser = customiserService.add(new Customiser("test","testtest"));
        customiserService.getMany().forEach(System.out::println);
        System.out.println(customiserService.getOne(2, "CUSTOMISER_ID"));
        customiserService.add(new Customiser("jona","coucou"));
    }

}