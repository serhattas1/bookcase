package org.example.bookcase.controller;

import org.example.bookcase.model.Book;
import org.example.bookcase.service.BookService;
import org.example.bookcase.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BookPageController {

    @Autowired
    BookService bookService;

    @Autowired
    WriterService writerService;

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
        modelAndView.addObject("writerList", writerService.fetchWriterList());
        return modelAndView;
    }
    @PostMapping("/book/save")
    public ModelAndView savePlayer(@ModelAttribute("book") Book book) throws Exception {
        bookService.saveBook(book);
        return showBookListPage();
    }

    @GetMapping("/book/cancel/{id}")
    public ModelAndView cancelBook(@PathVariable(value = "id") long id){
        bookService.setPassiveBook(id);
        return showBookListPage();
    }

    @GetMapping("/book/activate/{id}")
    public ModelAndView activate(@PathVariable(value = "id") long id) {
        bookService.setActivateBook(id);
        return  showBookListPage();
    }


    @GetMapping("/book/edit/{id}")
    public ModelAndView updateBookInfo(@PathVariable(value = "id") long id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getById(id);
        modelAndView.setViewName("bookEdit");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @GetMapping("/book/detail/{id}")
    public ModelAndView GetBookInfo(@PathVariable(value = "id") long id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.getBookDetail(id);
        modelAndView.setViewName("bookDetail");
        modelAndView.addObject("book", book);
        return modelAndView;
    }
}
