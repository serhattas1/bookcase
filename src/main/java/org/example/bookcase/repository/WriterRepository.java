package org.example.bookcase.repository;

import org.example.bookcase.model.Book;
import org.example.bookcase.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRepository extends JpaRepository<Writer,Long> {
}
