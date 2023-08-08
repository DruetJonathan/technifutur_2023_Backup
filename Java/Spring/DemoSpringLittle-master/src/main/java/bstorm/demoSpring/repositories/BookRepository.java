package bstorm.demoSpring.repositories;

import bstorm.demoSpring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT count(b) FROM Book b WHERE b.isbn = :isbn")
    Integer countByIsbn(@Param("isbn") String isbn);

    @Query("SELECT b, a FROM Book b LEFT JOIN Author a WHERE b.id = :id")
    Optional<Book> findWithAuthorById(@Param("id") Long id);
}
