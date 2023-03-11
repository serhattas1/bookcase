package org.example.bookcase.controller;

import org.example.bookcase.model.Book;
import org.example.bookcase.model.Writer;
import org.example.bookcase.service.BookService;
import org.example.bookcase.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WriterPageController {

    @Autowired
    WriterService writerService;

    @GetMapping("/writers")
    public ModelAndView showWriterListPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Writer> writerList = writerService.fetchWriterList();
        modelAndView.setViewName("writerList");
        modelAndView.addObject("writers", writerList);
        return modelAndView;
    }

    @GetMapping("/writer/add")
    public ModelAndView addNewWriter() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("writerAdd");
        modelAndView.addObject("writer", new Writer());
        return modelAndView;
    }

    @PostMapping("/writer/save")
    public ModelAndView saveWriter(@ModelAttribute("writer") Writer writer) throws Exception {
        writerService.saveWriter(writer);
        return showWriterListPage();
    }
}
