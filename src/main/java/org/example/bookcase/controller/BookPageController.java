package org.example.bookcase.controller;

import org.example.bookcase.model.Book;
import org.example.bookcase.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BookPageController {

    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public ModelAndView getEntryPage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }
    @GetMapping("/books")
    public ModelAndView showBookListPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Book> bookList = bookService.fetchBookList();
        modelAndView.setViewName("bookList");
        modelAndView.addObject("books", bookList);
        return modelAndView;
    }

    @GetMapping("/book/add")
    public ModelAndView addNewBook() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookAdd");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }
    @PostMapping("/book/save")
    public ModelAndView savePlayer(@ModelAttribute("book") Book book) throws Exception {
        bookService.saveBook(book);
        return showBookListPage();
    }
}
