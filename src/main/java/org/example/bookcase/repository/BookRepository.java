package org.example.bookcase.repository;

import org.example.bookcase.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book,Long> {

    @Query(value="select b.id,b.book_name ,b.book_year ,b.is_active ,b.writer_id  from book b order by b.book_name asc",nativeQuery = true)
    public List<Book> GetBookList();

    @Query(value = "select b.id,b.book_name ,b.book_year ,b.is_active ,b.writer_id  from book b where b.id =:id",nativeQuery = true)
    public Book GetBookDetail(@Param("id") long id);

    //@Query(value = "select b1_0.id,b1_0.book_name,b1_0.book_year,b1_0.is_active,w1_0.id as writer_id,w1_0.writer_name,w1_0.writer_surname from book b1_0 left join writer w1_0 on w1_0.id=b1_0.writer_id where b1_0.id=:id",nativeQuery = true)
    //public Book GetBookDetail(@Param("id") long id);

}
