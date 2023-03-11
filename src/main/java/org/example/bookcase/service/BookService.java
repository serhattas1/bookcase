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

    @Autowired
    WriterService writerService;

    Logger logger = LogManager.getLogger(BookService.class);

    @Transactional(readOnly = false)
    public Book saveBook(Book book) throws Exception {
        if (book == null) {
            throw new Exception("Entity not found");
        }
         if (book.getId() <= 0) {
             book.setActive(true);
         }

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

    public Book getById(long bookId) {
        if (bookId <= 0L) {
            logger.info("BookId cannot be less or equal than zero. BookId: " + bookId);
            return null;
        }
        return bookRepository.getReferenceById(bookId);
    }
    @Transactional(readOnly = false)
    public void setPassiveBook(long bookId) {
        if (bookId <= 0L) {
            logger.info("BookId cannot be less or equal than zero. BookId: " + bookId);
            return;
        }

        Book book = getById(bookId);
        if (book == null) {
            logger.info("Book not found for that BookId: " + bookId);
            return;
        }

        book.setActive(false);
        try {
            saveBook(book);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Transactional(readOnly = false)
    public void setActivateBook(long bookId) {
        if (bookId <= 0L) {
            logger.info("PlayerId cannot be less or equal than zero. PlayerId: " + bookId);
            return;
        }

        Book book = getById(bookId);
        if (book == null) {
            logger.info("Book not found for that BookId: " + bookId);
            return;
        }

        book.setActive(true);
        try {
            saveBook(book);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
