package org.example.bookcase.service;

import org.example.bookcase.model.Book;
import org.example.bookcase.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    Logger logger = LogManager.getLogger(BookService.class);

    @Transactional(readOnly = false)
    public Book saveBook(Book book) throws Exception {
        if (book == null) {
            throw new Exception("Entity not found");
        }
//        if (book.getId() <= 0) {
//            //book.setIsActive(true);
//
//            //book.setCreated(LocalDateTime.now());
//
//        }
        //player.setUpdated(LocalDateTime.now());
        return bookRepository.save(book);
    }
    public List<Book> fetchBookList()
    {
        logger.info("INFO Getting books from database");

        List<Book> books =
                bookRepository.findAll();
        logger.info(books);
        return books;
    }
}
