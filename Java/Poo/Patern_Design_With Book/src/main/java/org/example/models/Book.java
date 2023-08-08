package org.example.models;

import lombok.*;

public class Book {
    private  static Integer currentId = 1;

    @Getter
    private Integer id;
    @Getter @Setter
    private String title,description;
    @Getter @Setter
    private String author;

    public Book() {
        this.id = currentId ++;
    }

    public Book(String title, String description, String author) {
        this();
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public void setDescription(String description) {
        if(description.trim().equals(""))
            throw new RuntimeException();
        this.description = description;
    }

    @Override
    public String toString() {
        return "Livre n°"+id+ " : \n" +
                "\tid = " + id + "\n"+
                "\ttitle = '" + title + '\n' +
                "\tdescription = '" + description + '\n'+
                "\tauthor = '" + author + '\n'+
                "_______________________________________________________________";
    }
}
