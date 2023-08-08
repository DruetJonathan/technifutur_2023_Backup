package bstorm.demoSpring.repositories;

import bstorm.demoSpring.entities.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE LOWER(a.name) LIKE %:keyword% ORDER BY a.name")
    List<Author> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
