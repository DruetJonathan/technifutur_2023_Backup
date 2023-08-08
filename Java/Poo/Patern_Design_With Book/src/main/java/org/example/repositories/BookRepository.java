package org.example.repositories;

import org.example.data.FakeDb;
import org.example.models.Book;
import org.example.models.forms.AddBookForm;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookRepository {
    public HashMap<Integer,Book> getMany(){
        return FakeDb.map;
    }
    // todo Ajouter getMany avec une interface fonctionnelle

    public Optional<Book> getOne(Integer id){
        return Optional.ofNullable(FakeDb.map.get(id));
    }

    public void add(Book b){
        FakeDb.map.put(b.getId(),b);
    }

    public boolean update(Integer id, AddBookForm form){
        Book oldBook = getOne(id).orElse(null);
        if (oldBook == null)
            return false;

        oldBook.setTitle(form.getTitle());
        oldBook.setDescription(form.getDescription());
        oldBook.setAuthor(form.getAuthor());

        return true;
    }
    public boolean delete(Integer id){
        Book oldBook = getOne(id).orElse(null);
        if (oldBook == null)
            return false;

        FakeDb.map.remove(id);

        return true;
    }

}
