package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book b where b.title = ?1")
    Book findByTitle(String title);
    @Query("select b from Book b where b.category = ?1")
    List<Book>findByCategory(String category);

}
