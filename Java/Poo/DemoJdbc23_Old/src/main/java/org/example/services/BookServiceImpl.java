package org.example.services;

import org.example.exceptions.BookNotFoundException;
import org.example.models.entities.Book;
import org.example.repositories.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl {
    private BookRepositoryImpl bookRepository;
    String book = "BOOK";
    public BookServiceImpl() {
        this.bookRepository = new BookRepositoryImpl();
    }
    public Book getOne(Integer id,String idName){
        return bookRepository.getOne(id,book,idName);
    }
    public List<Book> getMany(){

        return bookRepository.getMany(book);
    }
    public Book add(Book book){
        return bookRepository.add(book);
    }
    public boolean delete(Integer id,String idName){
        if (!bookRepository.delete(id,book,idName))
            throw new BookNotFoundException();
        return bookRepository.delete(id,book,idName);
    }
    public boolean update(Integer id,Book book){
        if (!bookRepository.update(book,id))
            throw new BookNotFoundException();
        return bookRepository.update(book,id);
    }
}
